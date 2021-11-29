package com.luizgcl.cursomc.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.Cliente;
import com.luizgcl.cursomc.domain.Pedido;
import com.luizgcl.cursomc.repositories.PedidoRepository;
import com.luizgcl.cursomc.services.PedidoService;
import com.luizgcl.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	@Override
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Cliente.class.getName()));
	}

}
