package org.serratec.trabalho.poo.principal;

import org.serratec.trabalho.poo.exceptions.SenhaIncorretaException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.serratec.trabalho.poo.modelos.Aluno;
import org.serratec.trabalho.poo.modelos.Avaliacao;
import org.serratec.trabalho.poo.modelos.Funcionario;
import org.serratec.trabalho.poo.modelos.Personal;
import org.serratec.trabalho.poo.modelos.Pessoa;
import org.serratec.trabalho.poo.modelos.Planos;
import org.serratec.trabalho.poo.modelos.TipoPlano;


public class MenuAcademiaNovo {
	Scanner leitura = new Scanner(System.in);
	 public static List<Aluno> alunos = new ArrayList<>();
	 public static List<Personal> personais = new ArrayList<>();
	 public static List<Funcionario> funcionarios = new ArrayList<>();
	 public static List<Avaliacao> avaliacoes = new ArrayList<>();
	 public static List<Planos> planos = new ArrayList<>();
	 public static Map<String, Pessoa> usuarios = new HashMap<>();
	 public static Set<String> cpfsCadastrados = new HashSet<>();
	
	public void iniciar() {
		planos.add(new Planos("Boxe", TipoPlano.LUTAS, 80));
		planos.add(new Planos("Zumba", TipoPlano.DANCA, 70));
		planos.add(new Planos("Musculaçao", TipoPlano.MUSCULACAO, 100));
		

		// Para ler os usuarios.csv



		Path path = Paths.get(".\\src\\org\\serratec\\trabalho\\poo\\arquivos\\alunos.csv");



		try (BufferedReader reader = Files.newBufferedReader(path)){
			String linha = reader.readLine();//ignora o cabeçalho
			linha = reader.readLine();
			while((linha = reader.readLine()) != null) {
				String [] campos = linha.split(",");
				String nome = campos[0];
				String cpf = campos[1];				
				String senha = campos[2];
				LocalDate dtMatricula  =  LocalDate.parse(campos[3]);
				int indice = Integer.parseInt(campos[4])-1;				
				Planos plano = planos.get(indice);						
				alunos.add(new Aluno(nome,cpf,senha,dtMatricula,plano));
				usuarios.put(cpf, new Aluno(nome,cpf,senha,dtMatricula,plano));
				cpfsCadastrados.add(cpf);


			}
			//alunos.forEach(a -> a.exibirDados());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Para ler os funcionarios.csv	
		path = Paths.get(".\\src\\org\\serratec\\trabalho\\poo\\arquivos\\funcionarios.csv");



		try (BufferedReader reader = Files.newBufferedReader(path)){
			String linha = reader.readLine();//ignora o cabeçalho
			linha = reader.readLine();

			while((linha = reader.readLine()) != null) {
				String [] campos = linha.split(",");
				String nome = campos[0];
				String cpf = campos[1];			
				String senha = campos[2];
				String cargo = campos[3];
				funcionarios.add(new Funcionario(nome,cpf,senha,cargo));
				usuarios.put(cpf, new Funcionario(nome,cpf,senha,cargo));
				cpfsCadastrados.add(cpf);

			}
			//funcionarios.forEach(f -> f.exibirDados());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Para ler os Personal.csv



		path = Paths.get(".\\src\\org\\serratec\\trabalho\\poo\\arquivos\\Personal.csv");



		try (BufferedReader reader = Files.newBufferedReader(path)){
			String linha = reader.readLine();//ignora o cabeçalho
			linha = reader.readLine();

			while((linha = reader.readLine()) != null) {
				String [] campos = linha.split(",");
				String nome = campos[0];
				String cpf = campos[1];			
				String senha = campos[2];
				String especialidade = campos[3];
				String cref = campos[4];
				personais.add(new Personal(nome,cpf,senha,especialidade,cref));
				usuarios.put(cpf, new Personal(nome,cpf,senha,especialidade,cref));
				cpfsCadastrados.add(cpf);

			}
			//personais.forEach(p -> p.exibirDados());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		path = Paths.get(".\\src\\org\\serratec\\trabalho\\poo\\arquivos\\avaliacoes.csv");


        try (BufferedReader reader = Files.newBufferedReader(path)){
            String linha = reader.readLine();//ignora o cabeçalho

            while((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                String nome = campos[0];
                LocalDate dtMatricula  =  LocalDate.parse(campos[1]);
                String personal = campos[2];
                String descricao = campos[3];

                Aluno alunoEncontrado = null;
                for (Aluno a : alunos) {
                    if (a.getNome().equalsIgnoreCase(nome)) {
                        alunoEncontrado = a;
                        break;
                     }
                }

                Personal personalEncontrado = null;
                for (Personal p : personais) {
                    if (p.getNome().equalsIgnoreCase(personal)) {
                        personalEncontrado = p;
                        break;
                    }
                }

                avaliacoes.add(new Avaliacao(alunoEncontrado, dtMatricula, personalEncontrado, descricao));
            } 
            //avaliacoes.forEach(a -> a.exibirDados());
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	
		System.out.println("Usuários lidos do arquivo csv!!!");

		//System.out.println(usuarios);
		
		
	/*	for(int i = 0;i< usuarios.size();i++) {
			System.out.println(i  + ": " + usuarios.get(i));
		}
		usuarios.forEach( System.out::println);
		*/
		
		
		int opcao;
		do {
			String menu = """
					\n === ACADEMIA SERRATEC ===
					1. Login 
					2. Sair
					""";
			System.out.println(menu);
			opcao = leitura.nextInt();
			leitura.nextLine();

			switch (opcao) {
			case 1 -> login();
			case 2 -> System.out.println("Saindo do sistema...");
			default -> System.err.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 2);
	}

	private Pessoa autenticarUsuario(String cpf, String senha)throws SenhaIncorretaException  {
		Pessoa pessoa = usuarios.get(cpf);

		if (pessoa == null) {
			System.err.println("Usuário não encontrado.");
			return null;
		}
		//Mensagem a ser exibida no SenhaIncorretaException
		if (!pessoa.getSenha().equals(senha)) {
			throw new SenhaIncorretaException("Senha incorreta.");
		}

		return pessoa;
	}

	private  void login() {
		System.out.println("\n=== LOGIN ===");
		System.out.print("Digite seu CPF: ");
		String cpf = leitura.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = leitura.nextLine();


		//Para fazer a validação da Senha e se ocorrer erro dar a mensagem
		try {
			Pessoa usuario = autenticarUsuario(cpf, senha);

			if (usuario != null) {
				if (usuario instanceof Aluno aluno) {
					MenuAluno.menuAluno(aluno);;
				} else if (usuario instanceof Personal personal) {
					MenuPersonal menuPersonal = new MenuPersonal();					
					menuPersonal.menuPersonal((Personal) usuario);
				} else if (usuario instanceof Funcionario funcionario) {
					MenuFuncionarios menuFuncionarios = new MenuFuncionarios();
					menuFuncionarios.menuFuncionario((Funcionario) usuario, usuarios);
				}
			}
		} catch (SenhaIncorretaException e) {
			System.err.println(e.getMessage());
		}

	}

	
}
