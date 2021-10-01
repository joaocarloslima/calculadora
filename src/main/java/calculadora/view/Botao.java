package calculadora.view;

import java.awt.Font;

import javax.swing.JButton;

public abstract class Botao extends JButton {

	private static final long serialVersionUID = 1L;

	public Botao(String text) {
		super(text);
		setFont(new Font(null, Font.BOLD, 24 ));
	}
	
	

}
