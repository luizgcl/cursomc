package com.luizgcl.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.luizgcl.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);

}
