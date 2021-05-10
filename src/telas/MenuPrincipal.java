package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import classes.Produto;
import classes.Vendedor;
import gerenciadores.GerenciadorDeArquivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class MenuPrincipal {

	/*
	 * Sistema para Loja de Informática - Trabalho Final v1.8
	 * Anthony Cruz & Lucas Mattos
	 * Sistemas de Informação - 3º Fase
	 * Programação Orientada a Objetos
	 */
	
	
	
	//Nossas Variáveis
	
	private boolean arquivoLido = false;
	private List<Produto> listaProd = new ArrayList<Produto>();
	private List<Vendedor> listaVend = new ArrayList<Vendedor>();
	
	//Instanciar Objetos e Telas
	GerenciadorDeArquivos gd = new GerenciadorDeArquivos();
	CadastroVendedor cv = new CadastroVendedor();
	Equipe equipe1 = new Equipe();
	Estoque estoque1 = new Estoque();

	//WindowBuilder Variáveis
	
	protected Shell shlMenuprincipal; 
		Produto[] dadosEstoque;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MenuPrincipal window = new MenuPrincipal();
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
		shlMenuprincipal.open();
		shlMenuprincipal.layout();
		while (!shlMenuprincipal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlMenuprincipal = new Shell();
		shlMenuprincipal.setSize(450, 300);
		shlMenuprincipal.setText("MenuPrincipal");
		shlMenuprincipal.setLayout(null);
		
		Menu menu = new Menu(shlMenuprincipal, SWT.BAR);
		shlMenuprincipal.setMenuBar(menu);
		
		MenuItem mntmArquivo = new MenuItem(menu, SWT.CASCADE);
		mntmArquivo.setText("Arquivo");
		
		Menu menu_1 = new Menu(mntmArquivo);
		mntmArquivo.setMenu(menu_1);
		
		MenuItem mntmAbrirArquivo = new MenuItem(menu_1, SWT.NONE);
		
		//Arquivo>Abrir Arquivo (Botao carregará todas as informações contidas no arquivo)
		mntmAbrirArquivo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					arquivoLido = gd.leituraDeArquivos(); //verifica se o arquivo foi realmente lido
					listaProd = gd.getListaDeProdutos(); //recebe a lista gerada a partir do arquivo
					if(arquivoLido) {
						JOptionPane.showMessageDialog(null, "Arquivo de estoque lido com sucesso");
					}else {
						JOptionPane.showMessageDialog(null, "Arquivo de estoque não encontrado");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmAbrirArquivo.setText("Abrir Arquivo...");
		
		MenuItem mntmExibir = new MenuItem(menu, SWT.CASCADE);
		mntmExibir.setText("Exibir");
		
		Menu menu_2 = new Menu(mntmExibir);
		mntmExibir.setMenu(menu_2);
		
		MenuItem mntmExibirEstoque = new MenuItem(menu_2, SWT.NONE);
		
		//Exibir>Exibir Estoque... (Botao abrirá janela de estoque com todos os dados contidos)
		mntmExibirEstoque.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(arquivoLido) { //caso arquivo lido
						estoque1.setListaProd(listaProd); //envia a lista obtida do arquivo para a tela de estoque
						estoque1.open();
					}else {
						JOptionPane.showMessageDialog(null, "Arquivo de estoque não carregado");
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mntmExibirEstoque.setText("Exibir Estoque");
		
		MenuItem mntmExibirVendedoresCadastrados = new MenuItem(menu_2, SWT.NONE);
		mntmExibirVendedoresCadastrados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao abrir equipe
				if(!listaVend.isEmpty()) { //Somente abre se a lista nao estiver vazia
					equipe1.setLista(listaVend); //Envia a lista de vendedores para a tela da equipe
					equipe1.open();
				}else {
					JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado");
				}
			}
		});
		mntmExibirVendedoresCadastrados.setText("Exibir Vendedores Cadastrados");
		
		MenuItem mntmCadastrar = new MenuItem(menu, SWT.CASCADE);
		mntmCadastrar.setText("Cadastrar");
		
		Menu menu_3 = new Menu(mntmCadastrar);
		mntmCadastrar.setMenu(menu_3);
		
		MenuItem mntmCadastroDeVendedores = new MenuItem(menu_3, SWT.NONE);
		mntmCadastroDeVendedores.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//botao cadastrar usuario
				cv.open(); //Abre tela cadastro
				listaVend = cv.getList(); //recebe a lista atualizada
			}
		});
		mntmCadastroDeVendedores.setText("Cadastro de Vendedores");
		
		MenuItem mntmRealizar = new MenuItem(menu, SWT.CASCADE);
		mntmRealizar.setText("Realizar");
		
		Menu menu_4 = new Menu(mntmRealizar);
		mntmRealizar.setMenu(menu_4);
		
		MenuItem mntmRealizarVenda = new MenuItem(menu_4, SWT.NONE);
		mntmRealizarVenda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao Realizar Venda
				if(arquivoLido) { //caso arquivo lido
					Venda venda = new Venda();
					venda.setListProdutos(listaProd); //envia lista de produtos
					venda.setListVendedores(listaVend); //envia lista de vendedores
					venda.open();
				}else {
					JOptionPane.showMessageDialog(null, "Arquivo de estoque não carregado");
				}

			}
		});
		mntmRealizarVenda.setText("Realizar Venda");
		
		MenuItem mntmSair = new MenuItem(menu, SWT.NONE);
		mntmSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlMenuprincipal.close(); //Botao sair sai
			}
		});
		mntmSair.setText("Sair");
		
		Label lblProgramaDeVenda = new Label(shlMenuprincipal, SWT.NONE);
		lblProgramaDeVenda.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblProgramaDeVenda.setAlignment(SWT.CENTER);
		lblProgramaDeVenda.setBounds(10, 10, 394, 76);
		lblProgramaDeVenda.setText("Programa de Venda Para Loja de Inform\u00E1tica");
	}
}
