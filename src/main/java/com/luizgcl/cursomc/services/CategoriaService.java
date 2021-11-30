package com.luizgcl.cursomc.services;

import com.luizgcl.cursomc.domain.Categoria;

public interface CategoriaService {
	
	Categoria find(Integer id);

	Categoria insert(Categoria obj);

	Categoria update(Categoria obj);

	void delete(Integer id);
	
}
