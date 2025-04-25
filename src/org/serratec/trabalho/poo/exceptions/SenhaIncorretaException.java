package org.serratec.trabalho.poo.exceptions;

//Essa classe serve para dar uma mensagem personalizada quando for a senha incorreta ,puxando da biblioteca da java
public class SenhaIncorretaException extends Exception {
	public SenhaIncorretaException(String mensagem) {
		super(mensagem);
	}
}

