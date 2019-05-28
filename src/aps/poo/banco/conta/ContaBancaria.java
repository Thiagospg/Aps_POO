package aps.poo.banco.conta;

public abstract class ContaBancaria {

	// ATRIBUTOS

	private long numeroConta;
	private double saldo;

	// MÉTODOS ABSTRATOS

	public abstract boolean sacar(double valor);

	public abstract boolean depositar(double valor);

	// MÉTODOS NÃO ABSTRATOS

	/**
	 * Transfere um determinado valor de uma conta para outra
	 * 
	 * @param valor
	 * @param contaDe
	 * @param contaPara
	 */
	public boolean transferir(double valor, ContaBancaria contaDe,
			ContaBancaria contaPara) {
		if (valor <= contaDe.getSaldo()) {
			contaDe.setSaldo(contaDe.getSaldo() - valor);
			contaPara.setSaldo(contaPara.getSaldo() + valor);
			return true;
		}
		return false;
	}

	// GETTERS E SETTERS

	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
