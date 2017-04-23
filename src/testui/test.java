package testui;


import javax.swing.JOptionPane;


import java.sql.*;
import java.util.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import cr.ac.ucenfotec.sistemajudicial.datamanagment.Gestor;


public class test {
	//ShellFrame GUI
	private static ShellFrame ShellFrame;
	

	/**===========================================================**
	 * 
	 * Other forms
	 * 
	 **===========================================================**/
	private static test2 test2 = new test2();
	
	
	//Initialization
	public static void main(String[] args) throws Exception {
		try {
			//Initialize shell frame
			ShellFrame = new ShellFrame(800,600,"Prueba");		
			//Content charge
			contentCharge ();
			//ShellFrame standby
			ShellFrame.StandBy();
		} catch (Exception e) {
			throw e;//JOptionPane.showMessageDialog(null, "Error. GUI initialization failure", "Java Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//content initialization
	public static void contentCharge () throws SQLException, Exception {
		/** ShellFrame object **/
		Shell shell = ShellFrame.getShell();
		/**===========================================================**
		 * 
		 * Items list - Start
		 * 
		 **===========================================================**/
		Table table;
		/**===========================================================**
		 * Items list - end
		 **===========================================================**/
	    
		/**===========================================================**
		 * 
		 * Retrieve data - start
		 * 
		 **===========================================================**/
		Vector<TreeMap<String, String>> casos = (new Gestor()).listarCasosPorJuez(1);
		/**===========================================================**
		 * Retrieve data - end
		 **===========================================================**/
	    
	    
	    table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
	    table.setBounds(10, 10, 764, 542);
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    table.addListener(SWT.Selection, new Listener() {
		    public void handleEvent(Event e) {
		    	String string = "";
		    	TableItem[] selection = table.getSelection();
		    	TreeMap<String,String> tree = new TreeMap<String,String>();
		    	int i;
		    	
		    	
		    	for (i = 0; i < selection.length; i++) {
		    		string = selection[i].getText(0);
		    		tree.put("ID", string);
		    		string = selection[i].getText(1);
		    		tree.put("Descripcion", string);
		    		string = selection[i].getText(2);
		    		tree.put("Estado", string);
		    		string = selection[i].getText(3);
		    		tree.put("Fecha", string);
		    		
		    		test2.open(tree);
		    	}
		    }
	    
	    });
	    
	    TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn.setWidth(100);
	    tblclmnNewColumn.setText("ID");
	    
	    TableColumn tblclmnNewColumn1 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn1.setWidth(100);
	    tblclmnNewColumn1.setText("Descripcion");
	    
	    TableColumn tblclmnNewColumn2 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn2.setWidth(100);
	    tblclmnNewColumn2.setText("Estado");
	    
	    TableColumn tblclmnNewColumn3 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn3.setWidth(100);
	    tblclmnNewColumn3.setText("Fecha");
	    
	    TableColumn tblclmnNewColumn4 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn4.setWidth(100);
	    tblclmnNewColumn4.setText("Juez");
	    
	    TableColumn tblclmnNewColumn5 = new TableColumn(table, SWT.NONE);
	    tblclmnNewColumn5.setWidth(100);
	    tblclmnNewColumn5.setText("Querellante");
	    
	    
	    
	    for (TreeMap<String, String> caso : casos) {
		    TableItem item1 = new TableItem(table, SWT.NONE);
		    item1.setText(new String[] {caso.get("id"),caso.get("descripcion"),caso.get("estado"),caso.get("fecha"),caso.get("id_juez"),caso.get("id_querellante")});	    	
	    }		
	}
	
	
}
