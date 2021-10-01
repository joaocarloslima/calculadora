package calculadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import calculadora.model.Operacao;

public class Dao {

	public void salvar(double valor1, double valor2, Operacao operacao, double resultado) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/calc";
		String usuario = "root";
		String senha = "";
		
		Connection con = DriverManager.getConnection(url, usuario, senha);
		
		String sql = "INSERT INTO log (valor1, valor2, operacao, resultado) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1, valor1);
		ps.setDouble(2, valor2);
		ps.setString(3, operacao.toString());
		ps.setDouble(4, resultado);
		
		int linhas = ps.executeUpdate();
		
		if (linhas < 1) throw new RuntimeException("Nenhum registro inserido");
		
		con.close();
	}

}
