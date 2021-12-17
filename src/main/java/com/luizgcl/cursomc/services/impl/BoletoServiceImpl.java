package com.luizgcl.cursomc.services.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.PagamentoComBoleto;
import com.luizgcl.cursomc.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService {

	@Override
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPagto) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instanteDoPagto);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(calendar.getTime());
	}

}
