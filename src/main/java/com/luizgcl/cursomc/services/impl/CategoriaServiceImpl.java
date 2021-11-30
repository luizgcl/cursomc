
package com.luizgcl.cursomc.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.Categoria;
import com.luizgcl.cursomc.repositories.CategoriaRepository;
import com.luizgcl.cursomc.services.CategoriaService;
import com.luizgcl.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Categoria.class.getName()));
	}
	
	@Override
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	@Override
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}
	
}
