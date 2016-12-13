package ee_t07_generador_datos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * 
 * @author Martinez Hernanadez Gabriela
 *
 */
public class Interfaz extends JFrame implements ActionListener, ChangeListener{
	private static final long serialVersionUID = 1L;
	JCheckBox nombres = new JCheckBox("Nombres"), apellidoPat = new JCheckBox("Apellidos Paternos"), apellidoMat = new JCheckBox("Apellidos Maternos"); 
	JCheckBox email = new JCheckBox("Email"), direcciones = new JCheckBox("Direcciones");
	JButton aceptar;
	JPanel jpanel = (JPanel) this.getContentPane(), jpanel2 = (JPanel) this.getContentPane(), jpanel3 = (JPanel) this.getContentPane(), jpanel4 = (JPanel) this.getContentPane();
	JLabel jlabel = new JLabel(), jlabel2 = new JLabel();
	Generar g = new Generar();
	String[] nom, ap, correo, dir,combinacion;
	JTextField jtextfield = new JTextField();
	
	public Interfaz(){
		setTitle("Generador de Datos");
		setLayout(null);
        setBounds(60,100,280,350);
        setResizable(false);
        jpanel.setLayout(null);
		jpanel2.setLayout(null);
		jpanel3.setLayout(null);
		jpanel4.setLayout(null);
        
        jlabel.setBounds(new Rectangle(5, 5, 300, 21));
		jlabel.setText("Seleccione la combinación de datos a generar");
    	jpanel.add(jlabel, null);
    	
//    	jpanel2.setLayout(new GridLayout(9,1));
//    	pack();
//		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));			
        setVisible(true);
        setLayout(null);
        nombres.setBounds(10,30,150,30);
        nombres.addChangeListener((ChangeListener) this);
        apellidoPat.setBounds(10,55, 150,30);
        apellidoPat.addChangeListener(this);        
        apellidoMat.setBounds(10,80,150,30);
        apellidoMat.addChangeListener(this); 
        
        email.setBounds(10,155,150,30);
        email.addChangeListener(this);
        jpanel2.add(nombres);
        jpanel2.add(apellidoPat);
        jpanel2.add(apellidoMat);
        jpanel2.add(email);
        
        jlabel2.setBounds(new Rectangle(5, 265, 300, 21));
		jlabel2.setText("Número de datos a generar:");
		jtextfield.setBounds(new Rectangle(165, 265, 80, 21));
    	jpanel3.add(jlabel2, null);
    	jpanel3.add(jtextfield, null);
    	
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        aceptar.setBounds(10,300,80,21);
		jpanel4.add(aceptar,null);
	}
	
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == aceptar){
        	g.generar(Integer.parseInt(jtextfield.getText()));
        	System.exit(0);
        }
    }

	@Override
	public void stateChanged(ChangeEvent change) {
		if(nombres.isSelected() == true)
			nom = g.leerNombres();
		else
			if(apellidoPat.isSelected() == true)
				ap = g.leerApellidos();
			else
				if(apellidoMat.isSelected() == true)
					ap = g.leerApellidos();
				else 
					if(email.isSelected() == true)
							correo = g.leerEmail();
	}
	
	public static void main(String[] args) {
		Interfaz ventana = new Interfaz();
		ventana.setVisible(true);
	}
}
