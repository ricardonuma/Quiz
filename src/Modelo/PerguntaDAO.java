package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class PerguntaDAO{

	private final String LISTBYID = "SELECT * FROM PERGUNTA WHERE ID_PERGUNTA=?";
			
	public Pergunta getPerguntaById(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Pergunta pergunta = new Pergunta();
		
		try {
			conn = Conexao.getConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if (rs.next()) { 
				pergunta.setId(rs.getInt("ID_PERGUNTA"));
				pergunta.setPergunta(rs.getString("PERGUNTA"));
			}
			Conexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Pergunta" + e.getMessage());
		}
		
		return pergunta;
	}
				
}