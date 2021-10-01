package calculadora.model;

public class Model {

	public double calcular(double valor1, double valor2, Operacao operacao) {
		double resultado = 0;

		if (operacao == Operacao.QUADRADO) resultado = valor1 * valor1; 
		if (operacao == Operacao.RAIZ) resultado = Math.sqrt(valor1);
		if (operacao == Operacao.SOMA) resultado = valor1 + valor2; 
		if (operacao == Operacao.SUBTRACAO) resultado = valor1 - valor2; 
		if (operacao == Operacao.MULTIPLICACAO) resultado = valor1 * valor2; 
		if (operacao == Operacao.DIVISAO) resultado = valor1 / valor2; 
		
		return resultado;
	}

}
