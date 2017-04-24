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
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

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
		shell.setSize(330, 350);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(1, false));
		new Label(shell, SWT.NONE);
		
		Label lblCdula = new Label(shell, SWT.NONE);
		lblCdula.setText("C\u00E9dula");
		
		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setText("Nombre");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblApellidos = new Label(shell, SWT.NONE);
		lblApellidos.setText("Apellidos");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTelfono = new Label(shell, SWT.NONE);
		lblTelfono.setText("Tel\u00E9fono");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDireccin = new Label(shell, SWT.NONE);
		lblDireccin.setText("Direcci\u00F3n");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Button btnRegistrarUsuario = new Button(shell, SWT.NONE);
		GridData gd_btnRegistrarUsuario = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnRegistrarUsuario.widthHint = 200;
		btnRegistrarUsuario.setLayoutData(gd_btnRegistrarUsuario);
		btnRegistrarUsuario.setText("Registrar usuario");
		
		
		

	}

}
