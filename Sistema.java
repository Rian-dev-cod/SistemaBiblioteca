package control;

import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Adicionar Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Buscar Livro por ID");
            System.out.println("8. Remover Livro");
            System.out.println("9. Remover Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    Livro novoLivro = new Livro();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    novoLivro.getLivro(titulo, autor, ano, quantidade);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    if (!Livro.livrosDisponiveis.isEmpty()) {
                        Livro listar = new Livro();
                        listar.listaLivros();
                    } else {
                        System.out.println("Nenhum livro disponível.");
                    }
                    break;

                case 3:
                    Usuario novoUsuario = new Usuario();
                    System.out.print("Nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Tipo (Aluno, Professor, etc.): ");
                    String tipo = scanner.nextLine();
                    novoUsuario.getUsuario(nome, tipo);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 4:
                    Usuario u = new Usuario();
                    u.listUsuario();
                    break;

                case 5:
                    System.out.print("ID do Usuário: ");
                    int idUsuarioEmp = scanner.nextInt();
                    System.out.print("ID do Livro: ");
                    int idLivroEmp = scanner.nextInt();
                    Usuario usuarioEmp = null;
                    Livro livroEmp = null;

                    for (Usuario user : Usuario.listaUsuarios) {
                        if (user.ID == idUsuarioEmp) {
                            usuarioEmp = user;
                            break;
                        }
                    }

                    for (Livro livro : Livro.livrosDisponiveis) {
                        if (livro.ID == idLivroEmp) {
                            livroEmp = livro;
                            break;
                        }
                    }

                    if (usuarioEmp != null && livroEmp != null) {
                        Emprestimo emprestimo = new Emprestimo(usuarioEmp, livroEmp);
                        emprestimo.mostrarEmprestimo();
                    } else {
                        System.out.println("Usuário ou livro não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("ID do Usuário: ");
                    int idUsuarioDev = scanner.nextInt();
                    System.out.print("ID do Livro: ");
                    int idLivroDev = scanner.nextInt();
                    Usuario usuarioDev = null;
                    Livro livroDev = null;

                    for (Usuario user : Usuario.listaUsuarios) {
                        if (user.ID == idUsuarioDev) {
                            usuarioDev = user;
                            break;
                        }
                    }

                    for (Livro livro : Livro.livrosDisponiveis) {
                        if (livro.ID == idLivroDev) {
                            livroDev = livro;
                            break;
                        }
                    }

                    if (usuarioDev != null && livroDev != null) {
                        Emprestimo devolucao = new Emprestimo(usuarioDev, livroDev);
                        devolucao.devolverLivr(usuarioDev, livroDev);
                    } else {
                        System.out.println("Usuário ou livro não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o ID do livro: ");
                    int idBusca = scanner.nextInt();
                    Livro buscaLivro = new Livro();
                    buscaLivro.buscaLivro(idBusca);
                    break;

                case 8:
                    System.out.print("Digite o ID do livro a remover: ");
                    int idRemoverLivro = scanner.nextInt();
                    Livro removerLivro = new Livro();
                    removerLivro.removlivro(idRemoverLivro);
                    break;

                case 9:
                    System.out.print("Digite o ID do usuário a remover: ");
                    int idRemoverUsuario = scanner.nextInt();
                    Usuario removerUsuario = new Usuario();
                    removerUsuario.removUsuario(idRemoverUsuario);
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

}
