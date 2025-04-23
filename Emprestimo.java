package control;

public class Emprestimo {

	private Usuario usuario;
	private Livro livro;

	public Emprestimo(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
		if (livro.quantidadeDisponivel > 0) {
			livro.quantidadeDisponivel--;
			System.out.println("Livro emprestado com sucesso!");
		} else if(livro.quantidadeDisponivel < 0) {
			System.out.println("Livro indisponível para empréstimo!");
		}
	}

	void devolverLivr(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
		if (livro.quantidadeDisponivel > 0) {
			livro.quantidadeDisponivel++;
			System.out.println("Livro dovolvido com sucesso!");
		} else {
			System.out.println("Livro não encontrado!");
		}
	}

	public void mostrarEmprestimo() {
		System.out.println("\n" + usuario.Nome + " pegou o livro \"" + livro.Titulo + "\" do autor " + livro.autor);
	}

}
