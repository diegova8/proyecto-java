package uijpane;



import java.util.TreeMap;

import javax.swing.JOptionPane;
import cr.ac.ucenfotec.sistemajudicial.datamanagment.*;

public class UI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			String menu = "";
			menu +=	"Bienvenido al sistema de prueba\n";
			menu +=	"1. Ingresar como un Juez\n";
			menu +=	"2. Ingresar como un querellante\n";
			menu += "-1. Salir";
			
			String opcion = "";
			
			do {
				try {				
					//Se imprime el menu y se solicita la opcion
					opcion = JOptionPane.showInputDialog(null, menu);
					switch (opcion) {
						case "1":
							//
							String user = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
							String pass	= JOptionPane.showInputDialog("Ingrese la contraseña");
							//Login de juez
							TreeMap <String,String> juez = null;
							try {
								juez = (new Gestor()).loginJuez(user, pass);
								JOptionPane.showMessageDialog(null, "Log In");	
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage() , "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
							}
							break;
						case "2":
							//Login de querellante
							String cedula = JOptionPane.showInputDialog("Ingrese la cedula");
							
							if (!cedula.equals("")) {
								//Login de juez
								TreeMap <String,String> querellante = null;
								try {
									querellante = (new Gestor()).loginQuerellante(cedula);
									if (querellante == null) {
										JOptionPane.showMessageDialog(null, "Insert new");
									} else {
										JOptionPane.showMessageDialog(null, "Log In");									
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e.getMessage() , "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Error. Cedula invalida", "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);									
							}
							break;
						case "3":
							break;
						case "-1":
							JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema. Adios","Cerrar", JOptionPane.INFORMATION_MESSAGE);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opcion invalida, intentelo de nuevo","Error", JOptionPane.ERROR_MESSAGE);
							break;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema. Adios" ,"Cerrar", JOptionPane.INFORMATION_MESSAGE);
					opcion = "-1";
				}
				
				
			} while (!opcion.equals("-1"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "DataBase Connection Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	/**======================================================================
	 * 
	 * 	is Number - Know if a string is a number - returns a boolean value
	 * 
	 **===================================================================**/
	public static boolean isNumber (String pNum) {
		boolean res = true;
		try {
			Integer.parseInt(pNum);
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

}
