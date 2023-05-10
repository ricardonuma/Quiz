package Main;

import java.sql.Connection;
import java.sql.SQLException;

import Modelo.Conexao;
import Visualização.TelaMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection cnx = Conexao.getConexao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TelaMenu telaMenu = new TelaMenu();		
	}

}
