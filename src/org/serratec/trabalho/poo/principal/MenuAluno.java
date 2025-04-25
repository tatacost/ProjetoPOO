package org.serratec.trabalho.poo.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalho.poo.modelos.Aluno;
import org.serratec.trabalho.poo.modelos.Personal;

public class MenuAluno {
	static Scanner leitura = new Scanner(System.in);
	static List<Personal> personais = new ArrayList<>();
	static List<Aluno> alunos = new ArrayList<>();
    public static void menuAluno(Aluno usuario2) {
        int opcao;
        do {
            String menu = """
                \n === Menu Aluno ===
                1. Marcar avaliação
                2. Ver mensalidade
                3. Contratar Personal
                4. Sair para menu principal
                """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1 -> marcarAvaliacao();
                case 2 -> mensalidade(usuario2);
                case 3 -> contratarPersonal();
                case 4 -> System.out.println("Voltando ao menu principal....");
                default -> System.err.println("Opção inválida.");
            }
        } while (opcao != 4);
    }
    private static void contratarPersonal() {
    	personais.forEach(System.out::println);
    	System.out.println("Digite o numero de acordo com o personal desejado: ");
    	
    	System.out.println("Personal contratado com sucesso!");
	}
    private static void mensalidade(Aluno aluno) {
    	 if (aluno.getPlano() != null) {
    	        System.out.printf("Sua mensalidade é: R$ %.2f\n", aluno.getPlano().getValorPlano());
    	    } else {
    	        System.out.println("Nenhum plano contratado no momento.");
    	        }
    	    }
    	
    private static void marcarAvaliacao() {
    	System.out.println("Marcação de avaliação realizada com sucesso!");
	}
}
