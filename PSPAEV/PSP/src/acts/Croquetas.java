package acts;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Croquetas implements Runnable {

	private int limiteCroquetas = 0;
	private String tipo;
	private int tiempo;
	private static int tiempoTotal;
	private int jamon;
	private int pollo;
	private int queso;
	private int bacalao;

	public Croquetas(String tipo) {
		this.tipo = tipo;
	}

	public void run() {
		try {
		
			prepararCroqueta(tipo);
			Thread.sleep(tiempo);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Croqueta acabada!!!");
	}

	synchronized private void prepararCroqueta(String tipo) {

//		do {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			tiempoTotal += 3000;
//			JOptionPane.showMessageDialog(null, "HAS SUPERADO EL LIMITE, EL PROCESO VA A TARDAR");
//		} while (limiteCroquetas<100);

			if (tipo.equals("jamon")) {
				jamon++;
				limiteCroquetas++;
				tiempo = 5000;
				tiempoTotal += 5000;

			} else if (tipo.equals("pollo")) {
				pollo++;
				limiteCroquetas++;
				tiempo = 6000;
				tiempoTotal += 6000;
			} else if (tipo.equals("bacalao")) {
				bacalao++;
				limiteCroquetas++;
				tiempo = 7000;
				tiempoTotal += 7000;
			} else if (tipo.equals("queso")) {
				queso++;
				limiteCroquetas++;
				tiempo = 8000;
				tiempoTotal += 8000;
			}
		}
	


	public static int getTiempoTotal() {
		return tiempoTotal;
	}

}