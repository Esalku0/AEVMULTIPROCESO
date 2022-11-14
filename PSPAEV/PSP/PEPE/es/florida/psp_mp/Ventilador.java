package es.florida.psp_mp;

public class Ventilador {

	boolean encendido = true;
	int tiempoFuncionamiento = 500;

	public void encenderVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (!encendido)
						wait();
					System.err.println("Ventilador encendido durante " + tiempoFuncionamiento + " milisegundos");
					Thread.sleep(tiempoFuncionamiento);
					encendido = false;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void apagarVentilador() {
		while (true) {
			synchronized (this) {
				try {
					while (encendido)
						wait();
					System.err.println("Ventilador apagado durante " + tiempoFuncionamiento + " milisegundos");
					Thread.sleep(tiempoFuncionamiento);
					encendido = true;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
