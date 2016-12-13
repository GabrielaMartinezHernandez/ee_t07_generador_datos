package ee_t07_generador_datos;
import java.io.*;
import javax.swing.*;
/**
 * 
 * @author Martinez Hernandez Gabriela
 *
 */
public class Generar {
	Integer aleatorio;
	String[] nombres, apellidos, email, direcciones,combinacion;
	BufferedReader br;
	
	public Integer aleatorio(){
        aleatorio = (int)(Math.random()*1000);
        return aleatorio;
    }
	
	public String[] leerNombres(){
		nombres = new String[1000];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Nombres.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 1000){
	    		  nombres[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
	      return nombres;
	}
	
	public String[] leerApellidos(){
		apellidos = new String[1000];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Apellidos.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 1000){
	    		  apellidos[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
	      return apellidos;
	}
	
	public String[] leerEmail(){
		email = new String[1000];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Email.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 1000){
	    		  email[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
    	  return email;
	}
	

	
	public String[] leerDirecciones(){
		direcciones = new String[1000];
		String cadena;
		Integer contador = 0;
	      try{
	    	  BufferedReader br = new BufferedReader(new FileReader("Direcciones.txt"));
	    	  while((cadena = br.readLine()) != null && contador < 1000){
	    		  direcciones[contador] = cadena;
	    		  contador++;
	    	  }
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
    	  return direcciones;
	}
	
		
	public void generar(Integer cant, String... elementos){
		String dato = null;
		combinacion = new String[cant];
		leerNombres();
		leerApellidos();
		leerEmail();
		leerDirecciones();
        Integer cont = 0;
        
        try{
            File archivoSalida = new File("Datos.txt");
            PrintWriter out = new PrintWriter(new PrintWriter(archivoSalida));
        
           while(cont < cant){
        	   dato = nombres[aleatorio()] + " " + apellidos[aleatorio()] + " " + email[aleatorio()] + direcciones[aleatorio()];
        	   cont++;
        	   out.println(dato);
           }
            out.close();
        }catch (IOException ioe) {
        	System.out.println("Error al intentar abrir el archivo.");
        }
	}
	
//	public static void main(String[] args) {
//		Generar g = new Generar();
//		String[] nom, ap, id;
//		nom = g.leerNombres();
//		ap = g.leerApellidos();
//		id = g.leerId();
//	}
}
