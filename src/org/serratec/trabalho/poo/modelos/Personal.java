package org.serratec.trabalho.poo.modelos;
									//Achei desnecessário
public class Personal extends Pessoa /**implements GerarRelatorio**/ {
	private String especialidade;
	private String cref;
	
	
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
		this.cref = cref;
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
