package com.luizgcl.cursomc.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.luizgcl.cursomc.domain.Produto;

public interface ProdutoService {

	Produto find(Integer id);
	
	Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction);
	
}
