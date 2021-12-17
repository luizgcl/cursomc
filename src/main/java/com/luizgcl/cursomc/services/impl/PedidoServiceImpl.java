package com.luizgcl.cursomc.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgcl.cursomc.domain.Cliente;
import com.luizgcl.cursomc.domain.ItemPedido;
import com.luizgcl.cursomc.domain.PagamentoComBoleto;
import com.luizgcl.cursomc.domain.Pedido;
import com.luizgcl.cursomc.domain.enums.EstadoPagamento;
import com.luizgcl.cursomc.repositories.ItemPedidoRepository;
import com.luizgcl.cursomc.repositories.PagamentoRepository;
import com.luizgcl.cursomc.repositories.PedidoRepository;
import com.luizgcl.cursomc.services.BoletoService;
import com.luizgcl.cursomc.services.PedidoService;
import com.luizgcl.cursomc.services.ProdutoService;
import com.luizgcl.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Cliente.class.getName()));
	}

	@Override
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		
		
		if (obj.getPagamento() instanceof PagamentoComBoleto ) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
			
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		return obj;
	}

	@Override
	public Pedido update(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
