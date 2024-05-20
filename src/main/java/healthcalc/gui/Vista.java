package healthcalc.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.border.LineBorder;

import healthcalc.Gender;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;



public class Vista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField resultPesoIdeal;
	private JTextField resultBMR;
	private JSpinner sEdad;
	private JSpinner sAltura;
	private JSpinner sPeso;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JButton btnPesoIdeal;
	private JButton btnCalcularBmr;
	
	public Vista() {
		setTitle("Health Calc\r\n");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 10));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(192, 192, 192));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        panel.add(panelHeader, BorderLayout.NORTH);
        
            
		JLabel lblNewLabel = new JLabel("CALCULADORA DE SALUD");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD, 45));
		panelHeader.add(lblNewLabel);
		
		
		
		JPanel centralpanel = new JPanel();
		centralpanel.setLayout(new GridLayout(1,2));
		panel.add(centralpanel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		centralpanel.add(panel1);
		panel1.setLayout(new GridLayout(4,1));
		
		JPanel pGenero=new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 5,10));
		panel1.add(pGenero);
		
		JLabel lblGenero = new JLabel("Género");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Dubai Medium", Font.PLAIN, 20));

		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMujer.setSelected(true);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rdbtnHombre);
		grupoGenero.add(rdbtnMujer);
		
		pGenero.add(lblGenero);
		pGenero.add(rdbtnMujer);
		pGenero.add(rdbtnHombre);
		
		
		JPanel pAltura= new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20,10));
		panel1.add(pAltura);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setFont(new Font("Dubai Medium", Font.PLAIN, 20));

		
		
		sAltura = new JSpinner();
		sAltura.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		sAltura.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		sAltura.setPreferredSize(new Dimension(60, sAltura.getPreferredSize().height));
		
		pAltura.add(lblAltura);
		pAltura.add(sAltura);
		
		JPanel pEdad= new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20,10));
		panel1.add(pEdad);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Dubai Medium", Font.PLAIN, 20));

		
		sEdad = new JSpinner();
		sEdad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		sEdad.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		sEdad.setPreferredSize(new Dimension(60, sEdad.getPreferredSize().height));

		
		pEdad.add(lblEdad);
		pEdad.add(sEdad);
		
		
		JPanel pPeso= new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 20,10));
		panel1.add(pPeso);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setFont(new Font("Dubai Medium", Font.PLAIN, 20));

		

		SpinnerNumberModel model = new SpinnerNumberModel(0.1, 0.00001, null, 0.1); // Inicio, mínimo, máximo, paso
		sPeso = new JSpinner(model);
		sPeso.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		sPeso.setPreferredSize(new Dimension(60, sPeso.getPreferredSize().height));

		
		pPeso.add(lblPeso);
		pPeso.add(sPeso);

		
		
		
		
		
		JPanel panel2 = new JPanel();
		centralpanel.add(panel2);
		panel2.setLayout(new GridLayout(2,1));
		
		JPanel pPi= new JPanel();
		pPi.setLayout(new BoxLayout(pPi, BoxLayout.Y_AXIS));
		pPi.setBackground(new Color(0, 0, 160));
		pPi.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panel2.add(pPi);
		
		JPanel pBmr= new JPanel();
		pBmr.setBackground(new Color(0, 0, 160));
		pBmr.setLayout(new BoxLayout(pBmr, BoxLayout.Y_AXIS));
		pBmr.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		panel2.add(pBmr);
		
		btnCalcularBmr = new JButton("Calcular BMR");
		btnCalcularBmr.setBackground(new Color(255, 255, 255));
		btnCalcularBmr.setAlignmentX(Component.CENTER_ALIGNMENT);	
		btnCalcularBmr.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		
		
		
		btnPesoIdeal = new JButton("Calcular Peso Ideal");
		btnPesoIdeal.setBackground(new Color(255, 255, 255));
		btnPesoIdeal.setAlignmentX(Component.CENTER_ALIGNMENT);		
		btnPesoIdeal.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		
		
		resultPesoIdeal = new JTextField();
		resultPesoIdeal.setHorizontalAlignment(SwingConstants.CENTER);
		resultPesoIdeal.setFont(new Font("Dubai Medium", Font.PLAIN, 15));

		
		resultBMR = new JTextField();
		resultBMR.setHorizontalAlignment(SwingConstants.CENTER);
		resultBMR.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		
		JLabel l1= new JLabel();
		l1.setForeground(new Color(192, 192, 192));
		l1.setFont(new Font("Dubai", Font.PLAIN, 13));
		l1.setText("(Se necesita introducir género y altura)");
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		JLabel l2= new JLabel();
		l2.setForeground(new Color(192, 192, 192));
		l2.setFont(new Font("Dubai", Font.PLAIN, 13));
		l2.setText("(Se necesitan introducir todos los parámetros)");
		l2.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		pPi.add(Box.createVerticalStrut(20));
		pPi.add(btnPesoIdeal);
		pPi.add(l1);
		pPi.add(Box.createVerticalStrut(15));
		pPi.add(resultPesoIdeal);
		pPi.add(Box.createVerticalStrut(20));
		pBmr.add(Box.createVerticalStrut(20));
		pBmr.add(btnCalcularBmr);
		pBmr.add(l2);
		pBmr.add(Box.createVerticalStrut(15));
		pBmr.add(resultBMR);
		pBmr.add(Box.createVerticalStrut(20));
		

		
		pack();
		setVisible(true);
		
	}
	
	
	public void setResultBMR(double resultado) {
		resultBMR.setText(String.valueOf(resultado)+" cal/día");
	}
	
	public void setResultPI(double resultado){
		resultPesoIdeal.setText(String.valueOf(resultado)+" kg");
	}
	
	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	

	public int getEdad() {
		return (Integer)sEdad.getValue();	
	}
	public int getAltura() {
		return (Integer)sAltura.getValue();	

	}
	
	public float getPeso() {
			return ((Double) sPeso.getValue()).floatValue();	

	}
	
	public Gender getGenero() {
		if(rdbtnMujer.isSelected()) {
			return Gender.FEMALE;
		}else{
			return Gender.MALE;
		}
	}
	

	public void registrarControlador(ActionListener controlador) {
		btnPesoIdeal.addActionListener(controlador);
		btnPesoIdeal.setActionCommand("Calcular Peso Ideal");
		

		btnCalcularBmr.addActionListener(controlador);
		btnCalcularBmr.setActionCommand("Calcular BMR");
		
		
	}
}
