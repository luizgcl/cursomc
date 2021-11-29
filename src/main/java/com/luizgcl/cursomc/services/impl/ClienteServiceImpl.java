package com.luizgcl.cursomc.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.Cliente;
import com.luizgcl.cursomc.repositories.ClienteRepository;
import com.luizgcl.cursomc.services.ClienteService;
import com.luizgcl.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Cliente.class.getName()));
	}

}
