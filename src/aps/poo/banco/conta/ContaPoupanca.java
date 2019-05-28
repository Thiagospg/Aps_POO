package aps.poo.banco.conta;

import aps.poo.banco.util.Imprimivel;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {

	// ATRIBUTOS

	private double limite;

	// MÉTODOS GETTERS AND SETTERS

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	// MÉTODOS DA SUPER CLASSE
	/**
	 * Saca um determinado valor da conta, levando em conta o saldo e o limite
	 */
	@Override
	public boolean sacar(double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			return true;
		} else if (valor <= limite) {
			setSaldo(getSaldo() - valor);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deposita um determinado valor na conta
	 */
	@Override
	public boolean depositar(double valor) {
		setSaldo(getSaldo() + valor);
		return true;
	}

	/**
	 * Mostra os dados
	 */
	@Override
	public String mostrarDados() {
		return "_____________________________________________"
				+ "\nNúmero da conta: " + this.getNumeroConta() + "\nSaldo: "
				+ this.getSaldo() + "\nLimite: " + this.getLimite() + "\n";
	}

}
