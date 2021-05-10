package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import classes.Vendedor;
import gerenciadores.GerenciadorDeVendedores;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CadastroVendedor {
	
	//Nossas Variáveis
	private Calendar cal = Calendar.getInstance(); //Inicializa calendário para pegar valores
	private static int idBase = 1; //Id inicial
	private String idGerado; //Id para o Vendedor
	private List<Vendedor> lista; //Variavel para receber a lista
	private boolean permissao;
	
	//Instanciar Objetos
	private GerenciadorDeVendedores gv = new GerenciadorDeVendedores();
	//Gerenciador para receber a lista
	
	//WindowBuilder Variáveis
	
	protected Shell shlCadastroDeVendedores;
	private Text textNomeVend;
	private Text textCpfVend;
	private Text textIdVend;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CadastroVendedor window = new CadastroVendedor();
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
		shlCadastroDeVendedores.open();
		shlCadastroDeVendedores.layout();
		while (!shlCadastroDeVendedores.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlCadastroDeVendedores = new Shell();
		shlCadastroDeVendedores.setSize(464, 190);
		shlCadastroDeVendedores.setText("Cadastro de Vendedores");
		shlCadastroDeVendedores.setLayout(new GridLayout(13, false));
		
		Label lblNome = new Label(shlCadastroDeVendedores, SWT.NONE);
		lblNome.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNome.setText("Nome:");
		
		textNomeVend = new Text(shlCadastroDeVendedores, SWT.BORDER);
		textNomeVend.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 12, 1));
		
		Label lblCpf = new Label(shlCadastroDeVendedores, SWT.NONE);
		lblCpf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCpf.setText("CPF:");
		
		textCpfVend = new Text(shlCadastroDeVendedores, SWT.BORDER);
		textCpfVend.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 12, 1));
		
		Label lblId = new Label(shlCadastroDeVendedores, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("ID:");
		
		textIdVend = new Text(shlCadastroDeVendedores, SWT.BORDER);
		textIdVend.setEditable(false);
		textIdVend.setEnabled(false);
		GridData gd_textIdVend = new GridData(SWT.FILL, SWT.CENTER, true, false, 12, 1);
		gd_textIdVend.widthHint = 353;
		textIdVend.setLayoutData(gd_textIdVend);
		
		idGerado = Integer.toString(cal.get(Calendar.YEAR)) + idBase; //GerandoID ANO+NUMERO
		textIdVend.setText(idGerado); //ID Gerado aparece na interface
		
		Label lblAutorizao = new Label(shlCadastroDeVendedores, SWT.NONE);
		lblAutorizao.setText("Autoriza\u00E7\u00E3o");
		
		Button btnSim = new Button(shlCadastroDeVendedores, SWT.RADIO);
		btnSim.setText("Sim");
		
		Button btnNo = new Button(shlCadastroDeVendedores, SWT.RADIO);
		btnNo.setText("N\u00E3o");
		btnNo.setSelection(true); //Botao "nao" inicia marcado
		
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		
		Button btnCancelar = new Button(shlCadastroDeVendedores, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao Cancelar
				shlCadastroDeVendedores.close(); //Quando clicar fecha a tela 
			}
		});
		btnCancelar.setText("Cancelar");
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		new Label(shlCadastroDeVendedores, SWT.NONE);
		
		
		
		Button btnConfirmar = new Button(shlCadastroDeVendedores, SWT.NONE);
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { // Quando clicar em confirmar vai chamar a funçao addVendedor
				//Botao confirma
				
				if(textNomeVend.getText() != "" && textCpfVend.getText() != "") { //verifica se os campos estão preenchidos
					permissao = btnSim.getSelection(); //Verifica se tem permissao
					lista = gv.getListaDeVendedores(); //recebe a lista
					
					boolean listaVazia = lista.isEmpty();
					boolean jaExiste;
					
					jaExiste = false;
					
					if(!listaVazia) { //se a lista nao estiver vazia é feita a comparacao
						for(int i=0; i<lista.size(); i++) {
							if(textCpfVend.getText().equals(lista.get(i).getCpfVend())) jaExiste = true;
						}	
					}
					
					if(!jaExiste) { //se nao encontrar cadastra normalmente
						gv.addVendedor(textNomeVend.getText(), textCpfVend.getText(), idGerado, permissao);	
						idBase++; //aumenta +1 na qtd geral
						shlCadastroDeVendedores.close(); //fecha a tela
					}else { //se encontrar avisa erro
						JOptionPane.showMessageDialog(null, "Vendedor já cadastrado");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
				
			}
		});
		btnConfirmar.setText("Confirmar");

	}
	
	public List<Vendedor> getList(){
		return lista;
		//retorna a lista recebida
	}
}
