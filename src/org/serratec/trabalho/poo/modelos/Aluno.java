package org.serratec.trabalho.poo.modelos;

import java.time.LocalDate;
//Achei desnecessário 
public class Aluno extends Pessoa /**implements GerarRelatorio**/ {
	private LocalDate dtMatricula;
	private Planos plano;
	private String personalContratado;





	public Aluno(String nome, String cpf, String senha, LocalDate dtMatricula, Planos plano) {
		super(nome, cpf, senha);
		this.dtMatricula = dtMatricula;
		this.plano = plano;
	}



	public LocalDate getDtMatricula() {
		return dtMatricula;
	}



	public void setDtMatricula(LocalDate dtMatricula) {
		this.dtMatricula = dtMatricula;
	}



	public Planos getPlano() {
		return plano;
	}



	public void setPlano(Planos plano) {
		this.plano = plano;
	}



	public String getPersonalContratado() {
		return personalContratado;
	}



	public void setPersonalContratado(String personalContratado) {
		this.personalContratado = personalContratado;
	}


	public void exibirDados() {
		System.out.println("Aluno: " + getNome() +  " | Cpf: " + getCpf() + " | Plano: " + plano + " | Personal Contratado: " + personalContratado);

	}


	//
	//	@Override
	//	public String gerarAluno() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//
	//
	//	@Override
	//	public String gerarFuncionario() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	
	//	
	//




}
