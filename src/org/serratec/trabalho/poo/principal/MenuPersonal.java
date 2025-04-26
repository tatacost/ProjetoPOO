package org.serratec.trabalho.poo.principal;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalho.poo.modelos.Aluno;
import org.serratec.trabalho.poo.modelos.Personal;

public class MenuPersonal {
	static Scanner leitura = new Scanner(System.in);
	//List<Aluno> alunos = new ArrayList<>();

//	public  void carregarAlunos(List<Aluno> listaAlunos) {
//		MenuAcademiaNovo.alunos = listaAlunos;
//	}

	public  void menuPersonal(Personal usuario2) {
		int opcao;
		do {
			String menu = """
					\n=== MENU PERSONAL ===
					1. Visualizar alunos.
					2. Registrar avaliações físicas dos alunos
					3. Visualizar lista de avaliações realizadas
					4. Voltar ao menu principal
					""";
			System.out.println("Bem-vindo, personal " + usuario2.getNome());
			System.out.println(menu);
			opcao = leitura.nextInt();
			leitura.nextLine();

			switch (opcao) {
			case 1 -> visualizarAlunos();
			case 2 -> registrarAvaliacao(usuario2);//Esse usuario2 e a mesma coisa que o Personal
			case 3 -> avaliacoesRealizadas();
			case 4 -> System.out.println("Voltando ao menu principal....");
			default -> System.err.println("Opção inválida.");
			}
		}while(opcao !=4);
	}

	private  void visualizarAlunos() {
		if (MenuAcademiaNovo.alunos.isEmpty()) {
			System.out.println("Nenhum aluno cadastrado.");
			return;
		}
		System.out.println("\n--- Lista de Alunos ---");
		for (Aluno aluno : MenuAcademiaNovo.alunos) {
			System.out.println("Nome: " + aluno.getNome() + " | CPF: " + aluno.getCpf());
		}
	}


	private  void avaliacoesRealizadas() {
		System.out.print("Digite o CPF do aluno para ver as avaliações: ");
		String cpfBusca = leitura.nextLine();
		Aluno alunoEncontrado = null;
		for (Aluno aluno : MenuAcademiaNovo.alunos) {
			if (aluno.getCpf().equals(cpfBusca)) {
				alunoEncontrado = aluno;
				break;
			}
		}

		if (alunoEncontrado == null) {
			System.out.println("Aluno não encontrado.");
			return;
		}

		List<String> avaliacoes = alunoEncontrado.getAvaliacoesFisicas();
		if (avaliacoes.isEmpty()) {
			System.out.println("Nenhuma avaliação registrada para este aluno.");
		} else {
			System.out.println("Avaliações de " + alunoEncontrado.getNome() + ":");
			for (String a : avaliacoes) {
				System.out.println("- " + a);
			}
		}




	}
	private  void registrarAvaliacao(Personal usuario2) { //passei o usuario2 como o Personal
		System.out.print("Digite o CPF do aluno: ");
		String cpfBusca = leitura.nextLine();
		Aluno alunoEncontrado = null;
		for (Aluno aluno : MenuAcademiaNovo.alunos) {
			if (aluno.getCpf().equals(cpfBusca)) {
				alunoEncontrado = aluno;
				break;
			}
		}
		if (alunoEncontrado != null) {
			System.out.print("Digite a avaliação física (ex: Peso: 70kg, Altura: 1.75m): ");
			String avaliacao = leitura.nextLine();
			alunoEncontrado.adicionarAvaliacaoFisica(avaliacao);

			if (!usuario2.getAlunosAtendidos().contains(alunoEncontrado)) {
				usuario2.adicionarAluno(alunoEncontrado);
			}



			System.out.println("Avaliação registrada com sucesso.");
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}
}


