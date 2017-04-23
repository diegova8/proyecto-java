package testui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

public class GUI {

	protected Shell shell;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(210, 350);
		shell.setText("SWT Application");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(10, 73, 174, 23);
		
		Label lblDescripcion = new Label(shell, SWT.NONE);
		lblDescripcion.setBounds(10, 31, 55, 15);
		lblDescripcion.setText("Descripcion");
		
		Label lblFecha = new Label(shell, SWT.NONE);
		lblFecha.setBounds(10, 52, 55, 15);
		lblFecha.setText("Fecha");
		
		Label lblHistorial = new Label(shell, SWT.NONE);
		lblHistorial.setBounds(10, 102, 174, 200);
		lblHistorial.setText("Historial");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 55, 15);
		lblNewLabel.setText("ID:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(129, 10, 55, 15);
		lblNewLabel_1.setText("ID#");

	}
}
