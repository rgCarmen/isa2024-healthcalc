package healthcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import healthcalc.HealthCalcImpl;

public class Controlador implements ActionListener {
	
	private HealthCalcImpl modelo;
	private Vista vista;

	public Controlador(HealthCalcImpl modelo, Vista vista) {
		this.modelo=modelo;
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Calcular Peso Ideal")) {
			// idealWeight
			int altura = vista.getAltura();
			char genero= vista.getGenero();
			try {
				float resultado = modelo.idealWeight(altura, genero);	
				vista.setResultPI(resultado);
			} catch (Exception error) {
				String msg= comando+": "+error.getMessage();
				vista.error(msg);
			}
			
		}else if(comando.equals("Calcular BMR")) {
			int altura = vista.getAltura();
			char genero= vista.getGenero();
			int edad= vista.getEdad();
			float peso= vista.getPeso();
			try {
				float resultado = modelo.basalMetabolicRate(peso, altura, genero, edad);	
				vista.setResultBMR(resultado);
			} catch (Exception error) {
				String msg= comando+": "+error.getMessage();
				vista.error(msg);
			}
		}
		
	}

}
