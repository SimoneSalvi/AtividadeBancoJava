package atividadeBanco;

import java.util.Scanner;


public class Cliente {

	Scanner leia = new Scanner(System.in);

	// Atributos
	private String nomeCliente;
	private String nomeBanco;
	private int tipoConta; // 1=corrente, 2=poupança, 3=conjunta, 4=conta encerrada
	private int numeroConta;
	private int numeroAgencia;
	private double saldoCliente;

	// *****************
	// Menu
	// *****************

	public void menuBanco() {
		System.out.println("Bem vindo ao Banco SS\n Você já é cliente?" + "\n [S]im   [N]ão");
		String op = leia.next();
		if (op.equalsIgnoreCase("s")) {
			menuClientes();
		} else if (op.equalsIgnoreCase("n")) {
			System.out.println("Deseja abrir conta conosco? [s]im  [n]ão");
			op = leia.next();
			if (op.equalsIgnoreCase("s")) {
				abrir();
				menuClientes();
			} else if (op.equalsIgnoreCase("n")) {
				System.out.println("Obrigado pela visita, espamos que retorne e inicie uma jornada conosco!");
			}
		}
	}

	public void menuClientes() {
		// opcões para clientes:
		System.out.println("Selecione a opção desejada:" + "\n [1] encerrar" + "\n [2] consultar saldo"
				+ "\n [3] creditar" + "\n [4] debitar" + "\n [5] mostrar dados do cliente" +"\n [6]sair");
		switch (leia.nextInt()) {
		case 1: {

			encerrar();
			break;
		}
		case 2: {

			consultarSaldo();
			break;
		}
		case 3: {

			creditar();
			break;
		}
		case 4: {

			debitar();
			break;
		}
		case 5: {

			mostrar();
			break;
		}
		case 6: {

			System.out.println("Saindo do sistema!");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + leia.nextInt());
		}
	}

	// abrir conta:
	public void abrir() {
		this.saldoCliente = 0;
		this.setNomeBanco("Banco SS");
		leia.nextLine();
		System.out.println("Qual o seu nome?");
		this.setNomeCliente(leia.nextLine());
		this.setNumeroAgencia(01);
		this.setNumeroConta(2020);
		System.out.println("Digite o tipo de conta que você deseja abrir:\n" + "[1] corrente \n" + "[2] poupança\n"
				+ "[3] conjunta");
		this.setTipoConta(leia.nextInt());
		mostrar();
		menuClientes();
	}

	// encerrar conta{
	public void encerrar() {
		if (this.getSaldoCliente() >= 0) {
			this.tipoConta = 4;
			System.out.println("No momento do encerramento o saldo é de: R$" + this.getSaldoCliente());
			this.saldoCliente = 0;
			System.out.println("Esperamos que tenha tido uma boa jornada conosco e que retorne!");

		} else if (this.getSaldoCliente() < 0) {
			System.out
					.println("No momento não é possível encerrar a conta, saldo negativo: R$" + this.getSaldoCliente());
			menuClientes();
		}
		
	}

	// consultar saldo
	public void consultarSaldo() {
		System.out.println("Seu  saldo atual é: R$" + this.getSaldoCliente());
		menuClientes();
	}

	// creditar
	public void creditar() {
		if (this.getTipoConta() != 4) {
			System.out.println("Qual valor a ser creditado?");
			this.saldoCliente = (this.getSaldoCliente() + leia.nextDouble());
			System.out.println("Seu saldo atual é R$" + this.getSaldoCliente());
			menuClientes();
		}
	}

	// debitar
	public void debitar() {
		if (this.getTipoConta() != 4) {
			leia.nextLine();
			System.out.println("Qual valor a ser debitado?");
			double valorD = leia.nextDouble();
			double valorS = this.getSaldoCliente();
			if (valorD <= this.getSaldoCliente()) {
				this.saldoCliente = (valorS-valorD);
				System.out.println("Seu saldo atual é: R$" + this.getSaldoCliente());
				menuClientes();
			}else if(valorD > this.getSaldoCliente()) {
				System.out.println("Saldo insuficiente");
				menuClientes();
			}

		}
	}

	// Construtor
	public Cliente(String nomeCliente, String nomeBanco, int tipoConta, int numeroConta, int numeroAgencia,
			double saldoCliente) {
		this.nomeCliente = nomeCliente;
		this.nomeBanco = nomeBanco;
		this.tipoConta = tipoConta;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.saldoCliente = saldoCliente;
	}

	public void mostrar() {
		System.out.println("Seja bem vindo, seus dados são: Cliente [nomeCliente=" + this.getNomeCliente()
				+ ", nomeBanco=" + this.getNomeBanco() + ", tipoConta=" + this.getTipoConta() + ", numeroConta="
				+ this.getNumeroConta() + ", numeroAgencia=" + this.getNumeroAgencia() + ", saldoCliente="
				+ this.getSaldoCliente() + "]");
		menuClientes();
	}

	// Get e Set
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public double getSaldoCliente() {
		return saldoCliente;
	}

	public void setSaldoCliente(double saldoCliente) {
		this.saldoCliente = saldoCliente;
	}

}
