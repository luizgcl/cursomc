package com.luizgcl.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> fieldList = new ArrayList<>();

	public ValidationError(Integer status, String message, Long timeStamp) {
		super(status, message, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return fieldList;
	}

	public void addError(String field, String message) {
		fieldList.add(new FieldMessage(field, message));
	}

}
