package Modelo;
import java.util.ArrayList;

public class Resposta {

	private int id_resposta;
	private String resposta;
	private boolean resposta_certa;
	private int id_pergunta;
	private ArrayList<String> al;

	public Resposta() {
	}

	public int getIdResposta() {
		return id_resposta;
	}

	public void setIdResposta(int id_resposta) {
		this.id_resposta = id_resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean getRespostaCerta() {
		return resposta_certa;
	}

	public void setRespostaCerta(boolean resposta_certa) {
		this.resposta_certa = resposta_certa;
	}

	public int getIdPergunta() {
		return id_pergunta;
	}

	public void setIdPergunta(int id_pergunta) {
		this.id_pergunta = id_pergunta;
	}
	
	public ArrayList<String> getLstRespostas() {
		return al;
	}

	public void setLstRespostas(ArrayList<String> lst_respostas) {
		this.al = al;
	}

}


