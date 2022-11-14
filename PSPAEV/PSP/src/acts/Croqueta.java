package acts;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Croqueta implements Runnable {

	private String tipo;
	private int cantidad;
	private static int contador = 0;

	public Croqueta(int numero1, String tipo) {
		this.cantidad = numero1;
		this.tipo = tipo;
	}

	//Runnable que nos va a ejecutar el metodo de preparar croqueta, en este caso aumentamos
	//Y decrementamos al empezar y acabar una croqueta para la variable contador.
	public void run() {
		contador++;
		prepararCroquetilla(cantidad, tipo);
		contador--;
	}

	/**
	 * Este metodo nos va a permitir fabricar una croqueta informandonos cuando esta
	 * ha finalizado y haciendo la pausa para dicha croqueta
	 * 
	 * @param cantidad es el parametro que le pasamos para comprobar si el argumento es mayor que 0, en el caso que no lo sea no hara la croqueta
	 * @param tipo     es el nombre del tipo de croqueta que buscamos realizar
	 */
	synchronized private void prepararCroquetilla(int cantidad, String tipo) {
		try {
			// Comprobamos el tipo de croqueta...
			if (tipo == "jamon") {
				if (cantidad > 0) {
					Thread.sleep(5000);
					System.out.println("Croqueta acabada de Jamon!!!");
				}
			}
			// Comprobamos el tipo de croqueta...
			if (tipo == "pollo") {
				if (cantidad > 0) {
					Thread.sleep(6000);
					System.out.println("Croqueta acabada de Pollo!!!");
				}
			}
			// Comprobamos el tipo de croqueta...
			if (tipo == "bacalao") {
				if (cantidad > 0) {
					Thread.sleep(7000);
					System.out.println("Croqueta acabada de Bacalao!!!");
				}
			}
			// Comprobamos el tipo de croqueta...
			if (tipo == "queso") {
				if (cantidad > 0) {
					Thread.sleep(8000);
					System.out.println("Croqueta acabada de Queso!!!");
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Get de un metodo que utilizamos para comprobar el limite de croquetas
	//Esta parte no la vamos a utilizar ya que no sabia como implementarla, saludossssss!!!
	public static int getContador() {
		return contador;
	}

}