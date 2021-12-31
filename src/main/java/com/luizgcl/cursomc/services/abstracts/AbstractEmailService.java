package com.luizgcl.cursomc.services.abstracts;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.luizgcl.cursomc.domain.Pedido;
import com.luizgcl.cursomc.services.EmailService;

public abstract class AbstractEmailService implements EmailService {
	
	@Override
	public void sendOrderConfirmationEmail(Pedido pedido) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(pedido);
		sendEmail(sm);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido pedido) {
		try {
			MimeMessage msg = prepareMimeMessageFromPedido(pedido);
			sendHtmlEmail(msg);
		} catch(MessagingException exception) {
			sendOrderConfirmationEmail(pedido);
		}
	}
	
	@Value("${default.sender}")
	private String sender;

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido pedido) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(pedido.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + pedido.getId() + ".");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(pedido.toString());
		return sm;
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	protected MimeMessage prepareMimeMessageFromPedido(Pedido pedido) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true);
		
		msgHelper.setTo(pedido.getCliente().getEmail());
		msgHelper.setFrom(sender);
		msgHelper.setSubject("Pedido confirmado! Código: " + pedido.getId() + ".");
		msgHelper.setSentDate(new Date(System.currentTimeMillis()));
		msgHelper.setText(htmlFromTemplatePedido(pedido), true);
		
		return msg;
	}
	
	@Autowired
	private TemplateEngine templateEngine;
	
	protected String htmlFromTemplatePedido(Pedido pedido) {
		Context context = new Context();
		context.setVariable("pedido", pedido);
		
		return templateEngine.process("email/confirmacaoPedido", context);
	}

}
