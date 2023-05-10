package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

public class RespostaDAO{

	private final String LIST = "SELECT * FROM RESPOSTA WHERE ID_PERGUNTA = ? ORDER BY ID_RESPOSTA";
	private final String GETRESPOSTACERTA = "SELECT RESPOSTA FROM RESPOSTA" +
	" WHERE ID_PERGUNTA=? AND RESPOSTA_CERTA = TRUE";
			
	public String getRespostaCertaByIdPergunta(String id_pergunta) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String resposta = "";
		
		try {
			conn = Conexao.getConexao();
			pstm = conn.prepareStatement(GETRESPOSTACERTA);
			pstm.setString(1, id_pergunta);
			rs = pstm.executeQuery();
			
			if (rs.next())
				resposta = rs.getString("RESPOSTA");
				
			Conexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pegar Resposta" + e.getMessage());
		}
		
		return resposta;
	}
		
	public ArrayList<String> getRespostas(String id_pergunta) {
		ArrayList<String> al = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = Conexao.getConexao();
			pstm = conn.prepareStatement(LIST);
			pstm.setString(1, id_pergunta);
			rs = pstm.executeQuery();
			
			while (rs.next())
				al.add(rs.getString("RESPOSTA"));
			
			Conexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Resposta" + e.getMessage());
		}
		
		return al;
	}
		
}