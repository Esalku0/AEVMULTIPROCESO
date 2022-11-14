package es.florida.psp_mp;

public class Minero implements Runnable {

	String nombre;
	private int bolsa, tiempoExtraccion;
	private Mina minaAsignada;

	Minero(String nombre, int bolsa, int tiempoExtraccion, Mina minaAsignada) {
		this.nombre = nombre;
		this.bolsa = bolsa;
		this.tiempoExtraccion = tiempoExtraccion;
		this.minaAsignada = minaAsignada;
	}

	void extraerRecurso() {
		boolean hayTrabajo = true;
		while (hayTrabajo) {
			synchronized (minaAsignada) {
				if (minaAsignada.getStock() > 0) {
					try {
						Thread.sleep(tiempoExtraccion);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					minaAsignada.setStock(minaAsignada.getStock() - 1);
					bolsa = bolsa + 1;
					System.out.println("Minero " + nombre + ": valor bolsa " + bolsa + " (quedan " + minaAsignada.getStock() + " oros)");
				} else {
					System.out.println("Minero " + nombre + " abandona la mina por falta de trabajo.");
					hayTrabajo = false;
				}
			}
		}
	}

	public int getBolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}

	@Override
	public void run() {
		extraerRecurso();
	}
}