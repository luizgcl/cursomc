package com.luizgcl.cursomc.domain.enums;

public enum TipoCliente {
	
	PF(1, "Pessoa Física"),
	PJ(2, "Pessoa Jurídica");
	
	private Integer id;
	private String nome;
	
	private TipoCliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static TipoCliente toEnum(Integer id) {
		if (id == null) return null;
		
		for (TipoCliente x : values()) {
			if (id.equals(x.getId()))
				return x;
		}
		
		throw new IllegalArgumentException("Id invalido: " + id);
	}

}
