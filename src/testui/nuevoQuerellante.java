package testui;

import java.sql.SQLException;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class nuevoQuerellante {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	//Initialization
	public void open (String Params, Shell shell) {
		try {
			shell.dispose();
			//Initialize shell frame
			ShellFrame = new ShellFrame(330,350,"Registrar Querellante",new GridLayout(1, false));		
			//Content charge
			contentCharge (Params);
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge (String Params) throws SQLException, Exception {


		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		new Label(shell, SWT.NONE);
		Label lblCdula = new Label(shell, SWT.NONE);
		Text text = new Text(shell, SWT.BORDER);
		Label lblNombre = new Label(shell, SWT.NONE);
		Text text_1 = new Text(shell, SWT.BORDER);
		Label lblApellidos = new Label(shell, SWT.NONE);
		Text text_2 = new Text(shell, SWT.BORDER);
		Label lblTelfono = new Label(shell, SWT.NONE);
		Text text_3 = new Text(shell, SWT.BORDER);
		Label lblDireccin = new Label(shell, SWT.NONE);
		Text text_4 = new Text(shell, SWT.BORDER);
		new Label(shell, SWT.NONE);
		Button btnRegistrarUsuario = new Button(shell, SWT.NONE);
		
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
		lblCdula.setText("C\u00E9dula");
		
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.setText(Params);
		
		lblNombre.setText("Nombre");
		
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblApellidos.setText("Apellidos");
		
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblTelfono.setText("Tel\u00E9fono");
		
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblDireccin.setText("Direcci\u00F3n");
		
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		GridData gd_btnRegistrarUsuario = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnRegistrarUsuario.widthHint = 200;
		btnRegistrarUsuario.setLayoutData(gd_btnRegistrarUsuario);
		btnRegistrarUsuario.setText("Registrar usuario");
		btnRegistrarUsuario.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
			    	case SWT.Selection:
			    		try {
			    			
			    		} catch (Exception e1) {
			    			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
			    		}
						break;
				}
			}
		});
	}
}
