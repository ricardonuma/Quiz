package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;


public class JogadorDAO{

	private final String INSERT = "INSERT INTO JOGADOR (NOME, SCORE) VALUES (?,?)";
	private final String LIST = "SELECT * FROM JOGADOR ORDER BY SCORE DESC, NOME ASC";
	private final String SELECT = "SELECT IDENTITY_VAL_LOCAL() AS ID FROM JOGADOR";
			
	public String inserir(Jogador jogador) {
		if (jogador != null) {
			Connection conn = null;
			ResultSet rs = null;

			try {
				conn = Conexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1, jogador.getNome());
				pstm.setString(2, jogador.getScore());

				pstm.execute();

				pstm = conn.prepareStatement(SELECT);
				rs = pstm.executeQuery();

				if (rs.next())
					jogador.setId(rs.getString("ID"));

				Conexao.fechaConexao(conn, pstm);
				return jogador.getId();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir Jogador no banco de dados " + e.getMessage());
				return "";
			}
		} else {
			System.out.println("O Jogador enviado por parâmetro está vazio");
			return "";
		}
	}
			
	public List<Jogador> getJogadores() {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = Conexao.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			int i = 1;
			
			while (rs.next()) { 
				Jogador jogador = new Jogador();
				jogador.setId(rs.getString("ID_JOGADOR"));
				jogador.setNome(rs.getString("NOME"));
				jogador.setScore(rs.getString("SCORE"));
				jogador.setPosicao(i + "º");
				jogadores.add(jogador);
				i++;
			}
			Conexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Jogador" + e.getMessage());
		}
		
		return jogadores;
	}  
	
}