package com.luizgcl.cursomc.services;

import java.util.Date;

import com.luizgcl.cursomc.domain.PagamentoComBoleto;

public interface BoletoService {

	void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPagto);
	
}
