package org.serratec.trabalho.poo.principal;

import java.util.Scanner;

import org.serratec.trabalho.poo.modelos.Personal;

public class MenuPersonal {
	static Scanner leitura = new Scanner(System.in);
    public static void menuPersonal(Personal usuario2) {
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
                case 2 -> registrarAvaliacao();
                case 3 -> avaliacoesRealizadas();
                case 4 -> System.out.println("Voltando ao menu principal....");
                default -> System.err.println("Opção inválida.");
            }
    	}while(opcao !=4);
    }
	private static void avaliacoesRealizadas() {

	}
	private static void registrarAvaliacao() {

	}
	private static void visualizarAlunos() {

	}
}
