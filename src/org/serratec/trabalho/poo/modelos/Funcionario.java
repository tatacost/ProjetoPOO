package org.serratec.trabalho.poo.modelos;

import java.util.List;

public class Funcionario extends Pessoa implements GerarRelatorio{
	private String cargo;


	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public void exibirDados() {
		System.out.println("Funcionário: " + getNome() + " | Cpf:  "+ getCpf() + " | Cargo: " + cargo);

	}


	//INSTANCIANDO E CHAMANDO CADA RELATÓRIO

	@Override
	public void gerarRelatorioAlunos(List<Aluno> alunos) {
		RelatorioConsole relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioAlunos(alunos);

	}


	@Override
	public void gerarRelatorioPersonais(List<Personal> personais) {
		RelatorioConsole relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioPersonais(personais);

	}


	@Override
	public void gerarRelatorioFuncionarios(List<Funcionario> funcionarios) {
		RelatorioConsole relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioFuncionarios(funcionarios);

	}


	@Override
	public void gerarRelatorioPessoas(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios) {
		RelatorioConsole relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioPessoas(alunos, personais, funcionarios);

	}


	@Override
	public void gerarRelatorioPlanos(List<Planos> planos) {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioPlanos(planos);


	}

	@Override
	public void gerarRelatorioAvaliacao(List<Avaliacao> avaliacoes) {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioAvaliacao(avaliacoes);


	}


	@Override
	public void gerarRelatorioGeral(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios,
			List<Planos> planos, List<Avaliacao> avaliacoes) {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioGeral(alunos, personais, funcionarios, planos, avaliacoes);


	}



}
