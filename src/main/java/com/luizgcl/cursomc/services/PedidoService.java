package com.luizgcl.cursomc.services;

import java.util.List;

import com.luizgcl.cursomc.domain.Pedido;

public interface PedidoService {

	Pedido find(Integer id);
	
	Pedido insert(Pedido obj);

	Pedido update(Pedido obj);

	void delete(Integer id);
	
	List<Pedido> findAll();
	
}
