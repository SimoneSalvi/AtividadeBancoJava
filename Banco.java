package atividadeBanco;

public class Banco {

	public static void main(String[] args) {
		
		
		
//		 1=corrente, 2=poupança, 3=conjunta, 4=conta encerrada
// 	(String nomeCliente, String nomeBanco, int tipoConta, int numeroConta, int numeroAgencia, double saldoCliente)
		
		Cliente c1 = new Cliente(" ", " ", 0, 0, 0,	0);
		Cliente c2 = new Cliente("José da Silva", "Banco SS", 1, 4040, 025,	600.0);
	
//		c1.menuBanco();
		c2.menuBanco();
	
	
	}

}
