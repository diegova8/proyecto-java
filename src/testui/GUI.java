package testui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;

public class GUI {

	protected Shell shell;
	private Text cedula;

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
		shell.setSize(350, 200);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(1, false));
		new Label(shell, SWT.NONE);
		
		Label lblCdula = new Label(shell, SWT.NONE);
		lblCdula.setText("C\u00E9dula");
		
		cedula = new Text(shell, SWT.BORDER);
		cedula.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Button btnIngresar = new Button(shell, SWT.NONE);
		GridData gd_btnIngresar = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnIngresar.widthHint = 200;
		btnIngresar.setLayoutData(gd_btnIngresar);
		btnIngresar.setText("Ingresar");
		
		
		
		

	}

}
