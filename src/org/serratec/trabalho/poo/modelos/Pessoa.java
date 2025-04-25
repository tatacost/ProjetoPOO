package org.serratec.trabalho.poo.modelos;

public abstract class Pessoa {
	private  String nome;
	private  String cpf;
	private  String senha;
	
	
	public Pessoa(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	
	
	
	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public String getCpf() {
		return cpf;
	}






	public void setCpf(String cpf) {
		this.cpf = cpf;
	}






	public String getSenha() {
		return senha;
	}






	public void setSenha(String senha) {
		this.senha = senha;
	}






	@Override
	public String toString() {
		return "Nome: " + nome + 
			" | Cpf: " + cpf + 
			" | Senha: " + senha;
	}


	/**public void exibirDados() {
		// TODO Auto-generated method stub
		
	}**/ //comentei pois achei redundante.
	
	
	
}
