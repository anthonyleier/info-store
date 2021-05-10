package telas;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TemCerteza extends Dialog {

	protected Object result; //Resultado do Dialog
	protected Shell shlConfirmarCompra;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TemCerteza(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlConfirmarCompra.open();
		shlConfirmarCompra.layout();
		Display display = getParent().getDisplay();
		while (!shlConfirmarCompra.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlConfirmarCompra = new Shell(getParent(), getStyle());
		shlConfirmarCompra.setSize(450, 198);
		shlConfirmarCompra.setText("Confirmar Compra");
		shlConfirmarCompra.setLayout(null);
		
		Label lblConfirmarCompra = new Label(shlConfirmarCompra, SWT.NONE);
		lblConfirmarCompra.setBounds(159, 65, 105, 15);
		lblConfirmarCompra.setText("Confirmar Compra?");
		
		Button btnNao = new Button(shlConfirmarCompra, SWT.NONE);
		btnNao.setBounds(97, 105, 34, 25);
		btnNao.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//NAO = FALSE
				result = false;
				shlConfirmarCompra.close();
			}
		});
		btnNao.setText("N\u00E3o");
		
		Button btnSim = new Button(shlConfirmarCompra, SWT.NONE);
		btnSim.setBounds(292, 105, 32, 25);
		btnSim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//SIM = TRUE
				result = true;
				shlConfirmarCompra.close();
			}
		});
		btnSim.setText("Sim");

	}

}
