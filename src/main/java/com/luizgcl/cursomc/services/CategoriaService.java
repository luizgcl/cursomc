package com.luizgcl.cursomc.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luizgcl.cursomc.domain.Categoria;

public interface CategoriaService {
	
	Categoria find(Integer id);

	Categoria insert(Categoria obj);

	Categoria update(Categoria obj);

	void delete(Integer id);
	
	List<Categoria> findAll();
	
	Page<Categoria> findPage(Integer page, Integer linesPerPage, String oderBy, String direction);
	
}
