package testui;


import javax.swing.JOptionPane;


import java.sql.*;
import java.util.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;


public class test2 {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	//Initialization
	public void open (TreeMap<String,String> Params) {
		try {
			//Initialize shell frame
			ShellFrame = new ShellFrame(210,350,"Prueba");		
			//Content charge
			contentCharge (Params);
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge (TreeMap<String,String> Params) throws SQLException, Exception {
		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		Combo combo 			= new Combo(shell, SWT.NONE);
		Label lblDescripcion 	= new Label(shell, SWT.NONE);
		Label lblFecha 			= new Label(shell, SWT.NONE);
		Label lblHistorial 		= new Label(shell, SWT.NONE);
		Label lblIDLabel = new Label(shell, SWT.NONE);
		Label lblIDVal = new Label(shell, SWT.NONE);
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
	    
		/**===========================================================**
		 * 
		 * Retrieve data - start
		 * 
		 **===========================================================**/
		
		/**===========================================================**
		 * Retrieve data - end
		 **===========================================================**/
	    
		combo.setBounds(10, 73, 174, 23);
		
		lblDescripcion.setBounds(10, 31, 174, 15);
		lblDescripcion.setText(Params.get("Descripcion"));
		
		lblFecha.setBounds(10, 52, 174, 15);
		lblFecha.setText(Params.get("Fecha"));
		
		lblHistorial.setBounds(10, 102, 174, 200);
		lblHistorial.setText("Historial");
		
		lblIDLabel.setBounds(10, 10, 55, 15);
		lblIDLabel.setText("ID:");
		
		lblIDVal.setBounds(129, 10, 55, 15);
		lblIDVal.setText(Params.get("ID"));
	    	
	}
	
	
}
