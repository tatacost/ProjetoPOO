package org.serratec.trabalho.poo.principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.serratec.trabalho.poo.modelos.Aluno;
import org.serratec.trabalho.poo.modelos.Personal;
import org.serratec.trabalho.poo.modelos.Planos;

public class MenuAluno {
	
    static Scanner leitura = new Scanner(System.in);
	//static List<Personal> personais = new ArrayList<>();
	//static List<Aluno> alunos = new ArrayList<>();
	//static Set<String> cpfsCadastrados = new HashSet<>();
//	//Atualização
//	public static void main(String[] args) {
//		
//		
//		
//	Aluno alunoExemplo = alunos.get(0);
//	menuAluno(alunoExemplo);
//		
	
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
    private  static void contratarPersonal() {
    	if(MenuAcademiaNovo.personais.isEmpty()) {
    		System.out.println("Nenhum Personal disponível");
            return;
         }

         System.out.println("Lista de Personais Disponíveis:");
         for (int i = 0; i < MenuAcademiaNovo.personais.size(); i++) {
             System.out.println((i + 1) + ". " + MenuAcademiaNovo.personais.get(i).getNome());
         }

         System.out.println("Digite o número de acordo com o personal desejado: ");
         int escolha = leitura.nextInt();

         if (escolha > 0 && escolha <= MenuAcademiaNovo.personais.size()) {
             System.out.println("Personal contratado com sucesso: " + MenuAcademiaNovo.personais.get(escolha).getNome());
         } else {
             System.out.println("Opção inválida.");
         }
	}
    private static  void mensalidade(Aluno aluno) {
    	 if (aluno.getPlano() != null) {
    	        System.out.printf("Sua mensalidade é: R$ %.2f  \n", aluno.getPlano().getValorPlano());
    	    } else {
    	        System.out.println("Nenhum plano contratado no momento.");
    	        }
    	    }
    	
    private static void marcarAvaliacao() {
    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	for (int i = 0; i < MenuAcademiaNovo.personais.size(); i++) {
			System.out.println((i+1) + " - " + MenuAcademiaNovo.personais.get(i).getNome());
		}     
		int indice = - 1;
		while(indice < 0 || indice >= MenuAcademiaNovo.personais.size()) {
			//MenuAcademiaNovo.personais.forEach(System.out::println);
			System.out.println("Qual o Personal que deseja? ");
			indice = leitura.nextInt() -1;
		}

		Personal personalEscolhido = MenuAcademiaNovo.personais.get(indice);
		
		
		System.out.println("Digite a data que deseja (dd/MM/yyyy):");
		//System.err.println("cheguei aqui");
		String data = leitura.next();
		//	LocalDate dtMatricula = LocalDate.parse(data);
    			
    	System.out.println("Marcação de avaliação realizada com sucesso!");
    	System.out.println(data);
    	personalEscolhido.exibirDados();
	}
    }

