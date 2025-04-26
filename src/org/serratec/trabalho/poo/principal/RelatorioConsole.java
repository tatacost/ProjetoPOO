package org.serratec.trabalho.poo.principal;

import java.time.format.DateTimeFormatter;

import java.util.List;


import org.serratec.trabalho.poo.modelos.*;


public class RelatorioConsole implements GerarRelatorio{

	@Override
	public void gerarRelatorioAlunos(List<Aluno> alunos) {
		if(alunos.isEmpty()) {
			System.out.println("\nNenhum aluno no arquivo.");
			return;
		}
		System.out.println("\n=== Relatório dos Alunos ===");
		for( Aluno aluno : alunos) {
			System.out.println("Nome: "+ aluno.getNome());
			System.out.println("CPF: "+ aluno.getCpf());
			System.out.println("Plano: "+(aluno.getPlano() !=null ? aluno.getPlano().getTipoPlano() : "Nenhum"));
		}

	}

	@Override
	public void gerarRelatorioPersonais(List<Personal> personais) {
		if(personais.isEmpty()) {
			System.out.println("\nNenhum personal no arquivo.");
			return;
		}
		System.out.println("\n=== Relatórios dos Personais ===");
		for(Personal personal : personais) {
			System.out.println("Nome: " + personal.getNome());
			System.out.println("CPF: "+personal.getCpf());
			System.out.println("Especialidade: " + personal.getEspecialidade());
			System.out.println("CREF: "+ personal.getCref());
		}

	}

	@Override
	public void gerarRelatorioFuncionarios(List<Funcionario> funcionarios) {
		if(funcionarios.isEmpty()) {
			System.out.println("\nNenhum funcionário no arquivo.");
			return;
		}
		System.out.println("\n=== Relatórios dos Funcionários ===");
		for(Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Cargo: "+ funcionario.getCargo());
		}

	}

	@Override
	public void gerarRelatorioPessoas(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios) {
		System.out.println("\n=== Relatório de todos os cadastrados ===");
		if(alunos.isEmpty()) {
			System.out.println("\nNenhum aluno no arquivo.");
			return;
		}
		System.out.println("\n=== Alunos ===");
		for( Aluno aluno : alunos) {
			System.out.println("Nome: "+ aluno.getNome());
			System.out.println("CPF: "+ aluno.getCpf());
			System.out.println("Plano: "+(aluno.getPlano() !=null ? aluno.getPlano().getTipoPlano() : "Nenhum"));
		}
		if(personais.isEmpty()) {
			System.out.println("\nNenhum personal no arquivo.");
			return;
		}
		System.out.println("\n=== Personais ===");
		for(Personal personal : personais) {
			System.out.println("Nome: " + personal.getNome());
			System.out.println("CPF: "+personal.getCpf());
			System.out.println("Especialidade: " + personal.getEspecialidade());
			System.out.println("CREF: "+ personal.getCref());
		}
		if(funcionarios.isEmpty()) {
			System.out.println("\nNenhum funcionario cadastrado no arquivo.");
			return;
		}
		System.out.println("\n=== Funcionários ===");
		for(Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Cargo: "+ funcionario.getCargo());
		}

	}

	@Override
	public void gerarRelatorioPlanos(List<Planos> planos) {
		if(planos.isEmpty()) {
			System.out.println("\nNenhum plano cadastrado no arquivo.");
			return;
		}
		System.out.println("\n=== Relatórios dos Planos ===");
		for(Planos plano: planos) {
			System.out.println("Nome: " + plano.getNomePlano());
			System.out.println("Tipo: " + plano.getTipoPlano());
			System.out.println("Valor:  R$ " + plano.getValorPlano() + "\n ");
		}

	}

	@Override
	public void gerarRelatorioAvaliacao(List<Avaliacao> avaliacoes) {
		MenuAcademiaNovo.avaliacoes.forEach(a -> a.exibirDados());
		
		
		
		
//		if(avaliacoes.isEmpty()) {
//			System.out.println("\nNenhuma avaliação no arquivo.");
//			return;
//		}
//		System.out.println("\n=== Relatório de Avalições Físicas ===");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
//
//		for(Avaliacao avaliacao : avaliacoes ) {
//			System.out.println("Aluno: " + avaliacao.getAluno().getNome());
//			System.out.println("CPF: "+ avaliacao.getAluno().getCpf());
//			System.out.println("Data da Avaliação: " + avaliacao.getData().format(formatter));
//			System.out.println("Personal responsável: " + avaliacao.getPersonal().getNome());
//			System.out.println("Descrição: " + avaliacao.getDescricao());
//		}


	}

	//Com tudo
	@Override
	public void gerarRelatorioGeral(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios,List<Planos> planos,List<Avaliacao>avaliacoes) {
		
		
		System.out.println("\n=== Relatório de todos os cadastrados ===");
		if(alunos.isEmpty()) {
			System.out.println("\nNenhum aluno no arquivo.");
			return;
		}
		System.out.println("\n=== Alunos ===");
		for( Aluno aluno : alunos) {
			System.out.println("Nome: "+ aluno.getNome());
			System.out.println("CPF: "+ aluno.getCpf());
			System.out.println("Plano: "+(aluno.getPlano() !=null ? aluno.getPlano().getTipoPlano() : "Nenhum"));
		}
		if(personais.isEmpty()) {
			System.out.println("\nNenhum personal  no arquivo.");
			return;
		}
		System.out.println("\n=== Personais ===");
		for(Personal personal : personais) {
			System.out.println("Nome: " + personal.getNome());
			System.out.println("CPF: "+personal.getCpf());
			System.out.println("Especialidade: " + personal.getEspecialidade());
			System.out.println("CREF: "+ personal.getCref());
		}
		if(funcionarios.isEmpty()) {
			System.out.println("\nNenhum funcionário no arquivo.");
			return;
		}
		System.out.println("\n=== Funcionários ===");
		for(Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Cargo: "+ funcionario.getCargo());
		}
		if(planos.isEmpty()) {
			System.out.println("\nNenhum plano cadastrado.");
			return;
		}
		System.out.println("\n=== Planos ===");
		for(Planos plano: planos) {
			System.out.println("Nome: " + plano.getNomePlano());
			System.out.println("Tipo: " + plano.getTipoPlano());
			System.out.println("Valor: R$ %.2f\n " + plano.getValorPlano());
		}
		if(avaliacoes.isEmpty()) {
			System.out.println("\nNenhuma avaliação  cadastrado.");
			return;
		}
		System.out.println("\n=== Avalições Físicas ===");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

		for(Avaliacao avaliacao : avaliacoes ) {
			System.out.println("Aluno: " + avaliacao.getAluno().getNome());
			System.out.println("CPF: "+ avaliacao.getAluno().getCpf());
			System.out.println("Data da Avaliação: " + avaliacao.getData().format(formatter));
			System.out.println("Personal responsável: " + avaliacao.getPersonal().getNome());
			System.out.println("Descrição: " + avaliacao.getDescricao());
		}

	}







}
