package org.serratec.trabalho.poo.modelos;

import java.time.LocalDate;

public class Avaliacao {
	private Aluno aluno;
	private LocalDate data;
	private Personal personal;
	private String descricao;
	
	public Avaliacao(Aluno aluno, LocalDate data, Personal personal, String descricao) {
		super();
		this.aluno = aluno;
		this.data = data;
		this.personal = personal;
		this.descricao = descricao;
	}

	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void exibirDados() {
        System.out.println("Aluno: " + getAluno() +  " | Data: " + getData() + " | Personal: " + getPersonal() + " | Descrição: " + getDescricao());
		
	}
	
	
	
}
