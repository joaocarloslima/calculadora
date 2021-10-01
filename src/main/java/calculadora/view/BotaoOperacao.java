package calculadora.view;

import java.awt.event.ActionListener;

import calculadora.model.Operacao;

public class BotaoOperacao extends Botao {

	private static final long serialVersionUID = 1L;
	
	private Operacao operacao;
	private boolean unaria = false;

	public BotaoOperacao(String text, ActionListener listener, Operacao operacao) {
		super(text);
		this.setOperacao(operacao);
		addActionListener(listener);
	}
	
	public BotaoOperacao(String text, ActionListener listener, Operacao operacao, boolean unaria) {
		super(text);
		this.setUnaria(unaria);
		this.setOperacao(operacao);
		addActionListener(listener);
	}


	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public boolean isUnaria() {
		return unaria;
	}

	public void setUnaria(boolean unaria) {
		this.unaria = unaria;
	}



	
}
