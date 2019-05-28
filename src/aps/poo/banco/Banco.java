package aps.poo.banco;

import aps.poo.banco.conta.ContaBancaria;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Banco {

	// ATRIBUTOS
	private static List<ContaBancaria> contas = new ArrayList<ContaBancaria>();

	// MÉTODOS GETTERS AND SETTERS

	public static List<ContaBancaria> getContas() {
		return contas;
	}

	public static void setContas(List<ContaBancaria> contas) {
		Banco.contas = contas;
	}

	// MÉTODOS DA CLASSE

	/**
	 * Insere um objeto conta na lista de contas
	 * 
	 * @param conta
	 */
	public static boolean inserir(ContaBancaria contaBancaria) {
		for (ContaBancaria conta : contas) {
			if (conta.getNumeroConta() == contaBancaria.getNumeroConta()) {
				return false;
			}
		}
		contas.add(contaBancaria);
		return true;

	}

	/**
	 * Remove um objeto conta da lista de contas a partir do numero da conta
	 * 
	 * @param numConta
	 */
	public static Boolean remover(long numConta) {
		for (ContaBancaria conta : contas) {
			if (conta.getNumeroConta() == numConta) {
				contas.remove(conta);
				return true;
			}
		}

		return false;
	}

	/**
	 * Procura uma conta na lista de contas a partir do numero da conta
	 * 
	 * @param numConta
	 * @return
	 */
	public static ContaBancaria procurarConta(long numConta) {

		for (ContaBancaria contaBancaria : contas) {
			if (contaBancaria.getNumeroConta() == numConta) {
				return contaBancaria;
			}
		}
		return null;
	}

	/**
	 * Adiciona uma mensagem para o usuario
	 * 
	 * @param labelMensagem
	 * @param mensagem
	 * @param backGround
	 * @param foreGround
	 */

	public static void addMensagem(JLabel labelMensagem, String mensagem,
			String backGround, String foreGround) {
		labelMensagem.setBackground(Color.decode(backGround));
		labelMensagem.setForeground(Color.decode(foreGround));
		labelMensagem.setText(mensagem);

	}

	/**
	 * Verifica se o valor passado contém os chars d ou f no final
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean valueIsString(String valor) {
		valor = valor.toLowerCase();
		
		if (valor.endsWith("d") || valor.endsWith("f")) {
			return true;
		}
		return false;

	}

	/**
	 * Verifica se os valores passados contém os chars d ou f no final
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean valueIsString(String valor1, String valor2) {
		valor1 = valor1.toLowerCase();
		valor2 = valor2.toLowerCase();

		if (valor1.endsWith("d") || valor1.endsWith("f")
				|| valor2.endsWith("d") || valor2.endsWith("f")) {
			return true;
		}
		return false;

	}
}
