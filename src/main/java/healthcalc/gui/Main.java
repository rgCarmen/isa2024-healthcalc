package healthcalc.gui;

import java.awt.EventQueue;


import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = new HealthCalcImpl();
					Vista vista = new Vista();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}