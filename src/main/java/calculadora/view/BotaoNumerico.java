package calculadora.view;

import java.awt.event.ActionListener;

public class BotaoNumerico extends Botao {
	private static final long serialVersionUID = 1L;

	public BotaoNumerico(String text, ActionListener listener) {
		super(text);
		addActionListener(listener);
	}


}
