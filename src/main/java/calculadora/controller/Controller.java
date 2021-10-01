package calculadora.controller;

import java.sql.SQLException;

import calculadora.dao.Dao;
import calculadora.model.Model;
import calculadora.model.Operacao;
import calculadora.view.App;

public class Controller {
	
	private App view;
	private Model model = new Model();
	private Dao dao = new Dao();
	
	public Controller(App view) {
		this.view = view;
	}
	
	public void executar(double valor1, Operacao operacao) throws SQLException {
		executar(valor1, operacao, 0);
	}

	public void executar(double valor1, Operacao operacao,  double valor2 ) throws SQLException {
		double resultado = model.calcular(valor1, valor2, operacao);
		dao.salvar(valor1, valor2, operacao, resultado);
		view.setDisplay(resultado);
	}

}
