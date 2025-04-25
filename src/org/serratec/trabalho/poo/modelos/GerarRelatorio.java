package org.serratec.trabalho.poo.modelos;

import java.util.List;

import org.serratec.trabalho.poo.modelos.*;

public interface GerarRelatorio  {

	void gerarRelatorioAlunos(List<Aluno> alunos);

	void gerarRelatorioPersonais(List<Personal>personais);

	void gerarRelatorioFuncionarios(List<Funcionario> funcionarios);
	//Relatorio de todos os cadastrados
	void gerarRelatorioPessoas(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios);
	
	
	void gerarRelatorioPlanos(List<Planos> planos); 
	
	void gerarRelatorioAvaliacao(List<Avaliacao> avaliacoes);
		
	void gerarRelatorioGeral(List<Aluno> alunos, List<Personal> personais, List<Funcionario> funcionarios,List<Planos> planos,List<Avaliacao>avaliacoes);
	
	}
	

