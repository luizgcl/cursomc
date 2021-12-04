
package com.luizgcl.cursomc.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.Categoria;
import com.luizgcl.cursomc.dto.CategoriaDTO;
import com.luizgcl.cursomc.repositories.CategoriaRepository;
import com.luizgcl.cursomc.services.CategoriaService;
import com.luizgcl.cursomc.services.exceptions.DataIntegrityException;
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
	
	@Override
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException exception) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	@Override
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest request = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(request);
	}
	
	public Categoria fromDto(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
}
