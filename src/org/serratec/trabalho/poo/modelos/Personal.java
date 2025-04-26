package org.serratec.trabalho.poo.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Achei desnecessário
public class Personal extends Pessoa /**implements GerarRelatorio**/ {
	private String especialidade;
	private String cref;
	private List<Aluno> alunosAtendidos = new ArrayList<>();
	
	Scanner leitura = new Scanner(System.in);
	
	public Personal(String nome, String cpf, String senha, String especialidade, String cref) {
		super(nome, cpf, senha);
		this.especialidade = especialidade;
		this.cref = cref;
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
	    if (cref.matches("CREF\\d{4}")) { // Exemplo: CREF1234
	        this.cref = cref;
	    } else {
	        System.out.println("CREF inválido! O formato correto é CREF seguido de 4 dígitos (ex: CREF1234).");
	    }
	}
	
	
	
	public void adicionarAluno(Aluno aluno) {
	    alunosAtendidos.add(aluno);
	}

	public List<Aluno> getAlunosAtendidos() {
	    return alunosAtendidos;
	}
	

	public void exibirDados() {
		 System.out.println("Personal: " + getNome() +  " | Cpf: " + getCpf() + " | CREF: " + cref + " | Especialidade: " + especialidade);

	}



//	@Override
//	public String gerarAluno() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public String gerarFuncionario() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
}
