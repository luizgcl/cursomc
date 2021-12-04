package com.luizgcl.cursomc.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {}
	
	public FieldMessage(String field, String message) {
		super();
		this.fieldName = field;
		this.message = message;
	}

	public String getField() {
		return fieldName;
	}

	public void setField(String field) {
		this.fieldName = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
