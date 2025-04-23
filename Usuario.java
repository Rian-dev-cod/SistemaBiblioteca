package control;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private static int contadorId = 1;
	static List<Usuario> listaUsuarios = new ArrayList<>();
	int ID;
	String Nome;
	String tipo;

	void getUsuario(String nome, String tipo) {
		this.ID = contadorId++;
		this.Nome = nome;
		this.tipo = tipo;
		listaUsuarios.add(this);

	}

	void imprimirUsuario() {
		System.out.println("\n ID: " + this.ID + "\n Usuario: " + this.Nome + "\n Tipo: " + this.tipo);
	}

	void listUsuario() {
		System.out.println("\n Usuarios Cadastrado: \n");
		for (Usuario u : listaUsuarios) {
			u.imprimirUsuario();
		}
	}

	public static String buscarPorId(int id) {
		for (Usuario u : listaUsuarios) {
			if (u.ID == id) {
				return " ID: " + u.ID + "\n Usuario: " + u.Nome + "\n Tipo: " + u.tipo;
			}
		}
		return "Usuario não encontrado: ";
	}

	void removUsuario(int id) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).ID == id) {
				listaUsuarios.remove(i);
				break;
			} else {
				System.out.println("Usuario não encontrado");
			}
		}
	}

}
