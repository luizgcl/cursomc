package com.luizgcl.cursomc.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luizgcl.cursomc.domain.Cliente;
import com.luizgcl.cursomc.dto.ClienteDTO;
import com.luizgcl.cursomc.dto.ClienteNewDTO;

public interface ClienteService {
	
	Cliente find(Integer id);
	
	Cliente insert(Cliente obj);

	Cliente update(Cliente obj);

	void delete(Integer id);
	
	List<Cliente> findAll();
	
	Page<Cliente> findPage(Integer page, Integer linesPerPage, String oderBy, String direction);
	
	Cliente fromDto(ClienteDTO objDto);
	
	Cliente fromDto(ClienteNewDTO objDto);

}
