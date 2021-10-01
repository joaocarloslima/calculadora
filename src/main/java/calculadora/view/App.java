package calculadora.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import calculadora.controller.Controller;
import calculadora.model.Operacao;

public class App extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Controller controller;
	
	private JTextField display = new JTextField("0");
	private JPanel teclado = new JPanel();
	
	private Botao numero0 = new BotaoNumerico("0", this);
	private Botao numero1 = new BotaoNumerico("1", this);
	private Botao numero2 = new BotaoNumerico("2", this);
	private Botao numero3 = new BotaoNumerico("3", this);
	private Botao numero4 = new BotaoNumerico("4", this);
	private Botao numero5 = new BotaoNumerico("5", this);
	private Botao numero6 = new BotaoNumerico("6", this);
	private Botao numero7 = new BotaoNumerico("7", this);
	private Botao numero8 = new BotaoNumerico("8", this);
	private Botao numero9 = new BotaoNumerico("9", this);
	        
	private Botao soma = new BotaoOperacao("+", this, Operacao.SOMA);
	private Botao subt = new BotaoOperacao("-", this, Operacao.SUBTRACAO);
	private Botao mult = new BotaoOperacao("*", this, Operacao.MULTIPLICACAO);
	private Botao div = new BotaoOperacao("/", this, Operacao.DIVISAO);
	private Botao raiz = new BotaoOperacao("raiz", this, Operacao.RAIZ, true);
	private Botao quad = new BotaoOperacao("quad", this, Operacao.QUADRADO, true);
	private Botao igual = new BotaoOperacao("=", this, Operacao.IGUAL);

	private double operando;
	private Operacao operacao;
	private boolean deveResetar = true;

	public App() {
		controller = new Controller(this);
		display.setFont(new Font(null, Font.BOLD, 50));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setEditable(false);
		
		add(display, BorderLayout.NORTH);
		configurarTeclado();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculadora");
		setSize(400, 500);
		setVisible(true);
	}

	private void configurarTeclado() {
		add(teclado, BorderLayout.CENTER);
		
		teclado.setLayout(new GridLayout(4,4));
		
		teclado.add(numero7);
		teclado.add(numero8);
		teclado.add(numero9);
		teclado.add(div);

		teclado.add(numero4);
		teclado.add(numero5);
		teclado.add(numero6);
		teclado.add(mult);

		teclado.add(numero1);
		teclado.add(numero2);
		teclado.add(numero3);
		teclado.add(raiz);

		teclado.add(soma);
		teclado.add(numero0);
		teclado.add(subt);
		teclado.add(quad);

		add(igual, BorderLayout.SOUTH);
		
	}

	public void actionPerformed(ActionEvent e) {
		double valor = Double.valueOf(display.getText());
		Botao botao = (Botao) e.getSource();
		
		try {
			
			if(botao instanceof BotaoOperacao) {
				
				BotaoOperacao botaoOperacao = (BotaoOperacao) botao;
				
				if (botaoOperacao.isUnaria()) {
					controller.executar(valor, botaoOperacao.getOperacao());
					return;
				}

				if (botaoOperacao == igual) {
					controller.executar(operando, operacao, valor);
					return;
				}
				
				operando = valor;
				operacao = botaoOperacao.getOperacao();
				deveResetar = true;
				
				
			}
			
			if(botao instanceof BotaoNumerico) {
				digitarNumero(botao.getText());
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(this, "Um erro aconteceu: " + erro.getMessage());
			erro.printStackTrace();
		}
		
	}

	private void digitarNumero(String numero) {
		if (deveResetar) {
			display.setText( numero);
			deveResetar = false;
		}else {
			display.setText( display.getText() + numero);
		}
	}

	public void setDisplay(double resultado) {
		display.setText(String.valueOf(resultado));
	}
	
}
