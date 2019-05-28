package aps.poo.banco.conta;

import aps.poo.banco.util.Imprimivel;

public class ContaCorrente extends ContaBancaria implements Imprimivel {

	// ATRIBUTOS

	private double taxaDeOperacao;

	// MÉTODOS GETTERS AND SETTERS

	public double getTaxaDeOperacao() {
		return taxaDeOperacao;
	}

	public void setTaxaDeOperacao(double taxaDeOperacao) {
		this.taxaDeOperacao = taxaDeOperacao;
	}

	// MÉTODOS DA SUPER CLASSE

	/**
	 * Saca um determinado valor da conta, levando em conta o saldo e a taxa
	 */
	@Override
	public boolean sacar(double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor - taxaDeOperacao);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Deposita um determinado valor na conta, levando em conta a taxa
	 */
	@Override
	public boolean depositar(double valor) {
		setSaldo(getSaldo() + valor - taxaDeOperacao);
		return true;
	}

	/**
	 * Mostra os dados
	 */
	@Override
	public String mostrarDados() {
		return "_____________________________________________"
				+ "\nNúmero da conta: " + this.getNumeroConta() + "\nSaldo: "
				+ this.getSaldo() + "\nTaxa de Operação: "
				+ this.getTaxaDeOperacao() + "\n";

	}
}
