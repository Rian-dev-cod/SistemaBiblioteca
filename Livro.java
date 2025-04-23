package control;

import java.util.ArrayList;
import java.util.List;

public class Livro {

	static List<Livro> livrosDisponiveis = new ArrayList<>();
	private static int contadorId = 1;
	int ID;
	String Titulo;
	String autor;
	int ano;
	int quantidadeDisponivel;

	void getLivro(String titulo, String autor, int ano, int estoque) {
		this.ID = this.contadorId++;
		this.Titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.quantidadeDisponivel = estoque;
		livrosDisponiveis.add(this);
	}

	void imprimirLivro() {
		System.out.println("\n ID: " + this.ID + "\n Titulo: " + this.Titulo + "\n Autor: " + this.autor
				+ "\n Ano Publicado: " + this.ano + "\n Estoque: " + this.quantidadeDisponivel);
	}

	void listaLivros() {
		for (int i = 0; i < livrosDisponiveis.size(); i++) {
			System.out.println("\n Livros Disponiveis:");
			for (Livro livros : livrosDisponiveis) {
				livros.imprimirLivro();
			}
		}
	}

	void removlivro(int id) {
		boolean removido = false;
		for (int i = 0; i < livrosDisponiveis.size(); i++) {
			if (livrosDisponiveis.get(i).ID == id) {
				livrosDisponiveis.remove(i);
				removido = true;
				System.out.println("Livro removido com sucesso.");
				break;
			} else {
				System.out.println("Livro não encontrado");
			}
		}

	}

	void buscaLivro(int id) {
		
		boolean resultado = false;
		for (Livro livro : livrosDisponiveis) {
			if (livro.ID == id) {
				System.out.println("\nLivro: ");
				livro.imprimirLivro();
				resultado = true;
				break;
			} else {
				System.out.println("\n Livro não encontrado!");
			}
		}

	}

	
	public String getTitulo() {
	    return this.Titulo;
	}
	
	public String getAltor() {
	    return this.autor;
	}
}
