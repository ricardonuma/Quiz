package Controle;

import java.applet.Applet;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.Jogador;
import Modelo.JogadorDAO;
import Visualização.TelaMenu;
import Visualização.TelaRanking;
import Visualização.TelaResultado;

public class ControleResultado implements ActionListener {

	String id_jogador = "";	
	JogadorDAO dao = new JogadorDAO();
	Jogador jogador = new Jogador();
	TelaResultado telaResultado;
	
	public ControleResultado(TelaResultado telaResultado) {
		// TODO Auto-generated constructor stub
		this.telaResultado = telaResultado;
	}
	
	public void getTela(String resultado, String nome, String score){
		if(resultado.equals("Venceu"))
		{
			TelaMenu.som = Applet.newAudioClip(telaResultado.som_venceu);
			TelaMenu.som.play();
			telaResultado.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/vencedor.fw.png")));			
			InsereJogador(nome, score);
		}
		else if (resultado.equals("Perdeu"))
		{
			TelaMenu.som = Applet.newAudioClip(telaResultado.som_perdeu);
			TelaMenu.som.play();
			telaResultado.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/perdedor.fw.png")));
			InsereJogador(nome, score);
		}
		else if(resultado.equals("Empate"))
		{
			TelaMenu.som = Applet.newAudioClip(telaResultado.som_empate);
			TelaMenu.som.play();
			telaResultado.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/inicial.fw.png")));
			telaResultado.lbl_resultado.setText(resultado);
			telaResultado.lbl_resultado.setFont(new Font("Arial", Font.ITALIC, 50)); 
			telaResultado.bg.add(telaResultado.lbl_resultado);
			telaResultado.lbl_resultado.setLocation(350, 200);
			telaResultado.lbl_resultado.setSize(1000, 100);
		}
		else
		{
			TelaMenu.som = Applet.newAudioClip(telaResultado.som_venceu);
			TelaMenu.som.play();
			telaResultado.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/inicial.fw.png")));
			telaResultado.lbl_resultado.setText("Parabéns " + resultado + "!");
			telaResultado.lbl_resultado.setFont(new Font("Arial", Font.ITALIC, 50)); 
			telaResultado.bg.add(telaResultado.lbl_resultado);
			telaResultado.lbl_resultado.setLocation(200, 150);
			telaResultado.lbl_resultado.setSize(1000, 100);
			telaResultado.lbl_resultado2.setText("Você venceu!!");
			telaResultado.lbl_resultado2.setFont(new Font("Arial", Font.ITALIC, 50)); 
			telaResultado.bg.add(telaResultado.lbl_resultado2);
			telaResultado.lbl_resultado2.setLocation(275, 275);
			telaResultado.lbl_resultado2.setSize(1000, 100);
		}
	}
	
	private void InsereJogador(String nome, String score)
	{		
		if(nome != "" && score != "")
		{			
			jogador.setNome(nome);
			jogador.setScore(score);
			
			id_jogador = dao.inserir(jogador);
					
			if(id_jogador == "")
				JOptionPane.showMessageDialog(null, "Erro ao inserir o jogador no ranking");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == telaResultado.btn_menu){
			TelaMenu.som = Applet.newAudioClip(telaResultado.som_click);
			TelaMenu.som.play();
			if(TelaMenu.modo_jogo == "1")
			{
				telaResultado.setVisible(false);
				TelaRanking ranking = new TelaRanking(id_jogador);
			}
			else if(TelaMenu.modo_jogo == "2")
			{
				telaResultado.setVisible(false);
				TelaMenu menu = new TelaMenu();
			}
		}
	}

}
