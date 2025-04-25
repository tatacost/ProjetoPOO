package org.serratec.trabalho.poo.principal;

import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.serratec.trabalho.poo.modelos.Aluno;
import org.serratec.trabalho.poo.modelos.Avaliacao;
import org.serratec.trabalho.poo.modelos.Funcionario;
import org.serratec.trabalho.poo.modelos.GerarRelatorio;
import org.serratec.trabalho.poo.modelos.Personal;
import org.serratec.trabalho.poo.modelos.Pessoa;
import org.serratec.trabalho.poo.modelos.Planos;
import org.serratec.trabalho.poo.modelos.RelatorioConsole;
import org.serratec.trabalho.poo.modelos.TipoPlano;

public class  MenuFuncionarios {
	 Scanner leitura = new Scanner(System.in);
	//Lista separadas para cada tipo de pessoa e plano
	static List<Aluno> alunos = new ArrayList<>();
	static List<Personal> personais = new ArrayList<>();
	static List<Funcionario> funcionarios = new ArrayList<>();
	static List<Planos> planos = new ArrayList<>();
	static Map<String, Pessoa> usuarios = new HashMap<>();

	//Set para rastrear todos os CPFs usados
	static Set<String> cpfsCadastrados = new HashSet<>();

	//Para gerar os relatorios 
	GerarRelatorio relatorio = new RelatorioConsole();
	static List<Avaliacao> avaliacoes = new ArrayList();


	public  void menuFuncionario(Funcionario usuario2, Map<String, Pessoa> usuarios) {
		planos.add(new Planos("Boxe", TipoPlano.LUTAS, 80));
		planos.add(new Planos("Zumba", TipoPlano.DANCA, 70));
		planos.add(new Planos("Musculaçao", TipoPlano.MUSCULACAO, 100));
		int opcaoCadastro;
		do {
			String menu = """
					\n=== MENU FUNCIONÁRIO ===
					1. Cadastrar Aluno
					2. Cadastrar Funcionário
					3. Cadastrar Personal Trainer
					4. Cadastrar Plano
					5. Emitir relatório
					6. Valor total a receber
					7. Voltar ao menu principal
					""";
			System.out.println(menu);
			opcaoCadastro = leitura.nextInt();
			leitura.nextLine();

			switch (opcaoCadastro) {
			case 1 -> cadastrarAluno(usuarios);
			case 2 -> cadastrarFuncionario(usuarios);
			case 3 -> cadastrarPersonal(usuarios);
			case 4 -> cadastrarPlano();
			case 5 -> emitirRelatorio();
			case 6 -> valorAhReceber();
			case 7 -> System.out.println("Voltando ao menu principal....");
			default -> System.err.println("Opção inválida.");
			}

		} while (opcaoCadastro != 7);
	}
	private  void cadastrarAluno(Map<String, Pessoa> usuarios) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Digite seu nome:");
		String nome = leitura.nextLine();
		System.out.println("Digite seu CPF:");
		String cpf = leitura.nextLine();
		//verificacao do cof se foi cadastrado e coloquei ERR. para aparecer em vermelho.
		if(cpfsCadastrados.contains(cpf)) {
			System.err.println("ERRO: CPF já cadastrado no sistema.");
			return;
		}

		System.out.println("Digite sua senha:");
		String senha = leitura.nextLine();
		System.out.println("Digite a data da matrícula (dd/MM/yyyy):");
		String data = leitura.nextLine();
		LocalDate dtMatricula = LocalDate.parse(data, formatter);
		System.out.println("Escolha um plano:");
		for (int i = 0; i < planos.size(); i++) {
			System.out.println((i+1) + " - " + planos.get(i).getNomePlano());
		}     
		int indice = - 1;
		while(indice < 0 || indice >= planos.size()) {
			System.out.println("Qual o plano que deseja: ");
			indice = leitura.nextInt() -1;
		}

		Planos planosEscolhido = planos.get(indice);


		alunos.add(new Aluno(nome,cpf,senha,dtMatricula, planosEscolhido));
		usuarios.put(cpf, new Aluno(nome,cpf,senha,dtMatricula,planosEscolhido));
		cpfsCadastrados.add(cpf);

		System.out.println("Aluno cadastrado com sucesso!");
	}
	private void cadastrarFuncionario(Map<String, Pessoa> usuarios) {
		System.out.println("Digite seu nome:");
		String nome = leitura.nextLine();
		System.out.println("Digite seu CPF:");
		String cpf = leitura.nextLine();
		System.out.println("Digite sua senha:");
		String senha = leitura.nextLine();
		System.out.println("Digite seu cargo dentro da academia:");
		String cargo = leitura.nextLine();

		Funcionario novoFuncionario = new Funcionario(nome, cpf, senha, cargo);
		funcionarios.add(novoFuncionario);
		usuarios.put(cpf, novoFuncionario);

		System.out.println("Funcionário cadastrado com sucesso!");
	}
	private  void cadastrarPersonal(Map<String, Pessoa> usuarios) {
		System.out.println("Digite seu nome:");
		String nome = leitura.nextLine();
		System.out.println("Digite seu CPF:");
		String cpf = leitura.nextLine();
		System.out.println("Digite sua senha:");
		String senha = leitura.nextLine();
		System.out.println("Digite sua especialidade:");
		String especialidade = leitura.nextLine();
		System.out.println("Digite seu CREF:");
		String cref = leitura.nextLine();

		Personal novoPersonal = new Personal(nome, cpf, senha, especialidade, cref);
		personais.add(novoPersonal);
		usuarios.put(cpf, novoPersonal);

		System.out.println("Personal cadastrado com sucesso!");
	}
	private  void cadastrarPlano() {
		System.out.println("Qual tipo do plano: ");
		String nome = leitura.nextLine();
		System.out.println("Qual o perido do plano: mensal/semestral/anual");
		String tipoPlano = leitura.nextLine().toUpperCase();
		//TipoPlano plano = TipoPlano.fromDescricao(tipoPlano);
		System.out.println("Valor do pacote: ");
		double valor = leitura.nextDouble();
		leitura.nextLine();
		//planos.add(new Planos(nome, plano, valor));
		System.out.println("Funcionalidade de cadastro de plano ainda não implementada.");
	}
	private  Double valorAhReceber() {		
		Double total = planos.stream().mapToDouble(Planos::getValorPlano).sum();
	    		

	    System.out.println("\nTotal a receber pelos planos: R$ " + total);
	    return total;
	}
	private void emitirRelatorio() {
		int opcaoCadastro;
		do {
			String menu = """
					   \n=== MENU FUNCIONÁRIO ===
					   1. Gerar relatório de planos
					   2. Gerar relatório de Pessoas
					   3. Gerar relação de avaliações físicas por período
					   4. Voltar ao menu principal
					   """;
			System.out.println(menu);
			opcaoCadastro = leitura.nextInt();
			leitura.nextLine();

			switch (opcaoCadastro) {
			case 1 -> relatorioPlanos();
			case 2 -> relatorioPessoas();
			case 3 -> relatorioAvaliacoes();			
			case 4 -> System.out.println("Voltando ao menu principal....");
			default -> System.err.println("Opção inválida.");
			}

		} while (opcaoCadastro != 4);

	}
	private  void relatorioPlanos() {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioPlanos(planos);


	}
	private  void relatorioPessoas() {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioPessoas(alunos, personais, funcionarios);


	}




	private  void relatorioAvaliacoes() {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioAvaliacao(avaliacoes);


	}	

	private  void relatorioGeral() {
		RelatorioConsole  relatorio = new RelatorioConsole();
		relatorio.gerarRelatorioGeral(alunos, personais, funcionarios, planos, avaliacoes);


	}

}


