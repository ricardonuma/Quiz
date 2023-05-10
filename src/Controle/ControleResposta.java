package Controle;

import java.applet.Applet;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Visualização.TelaCartas;
import Visualização.TelaMenu;
import Visualização.TelaPergunta;
import Visualização.TelaResposta;
import Visualização.TelaResultado;

public class ControleResposta implements ActionListener {

	TelaResposta telaResposta;
	
	public ControleResposta(TelaResposta telaResposta) {
		// TODO Auto-generated constructor stub
		this.telaResposta = telaResposta;
	}
	
	public void verificaModoJogo() {
		if(TelaMenu.modo_jogo == "1")
		{
			telaResposta.lbl_jogador.setText("Jogador: ");
			telaResposta.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 30)); 
			telaResposta.lbl_nome1.setSize(1000, 35);
			
			telaResposta.bg.add(TelaCartas.lbl_pulo);
			telaResposta.bg.add(telaResposta.img_pulo1);
			telaResposta.bg.add(telaResposta.img_pulo2);			
			telaResposta.bg.add(TelaCartas.lbl_vida);			
			telaResposta.bg.add(telaResposta.img_vida1);
			telaResposta.bg.add(telaResposta.img_vida2);
			telaResposta.bg.add(telaResposta.img_vida3);
			
			telaResposta.img_pulo1.setLocation(90, 30);
			telaResposta.img_pulo2.setLocation(115, 30);			
			telaResposta.img_vida1.setLocation(180, 30);
			telaResposta.img_vida2.setLocation(205, 30);
			telaResposta.img_vida3.setLocation(230, 30);
					
			telaResposta.img_pulo1.setSize(50, 50);
			telaResposta.img_pulo2.setSize(50, 50);					
			telaResposta.img_vida1.setSize(50, 50);
			telaResposta.img_vida2.setSize(50, 50);
			telaResposta.img_vida3.setSize(50, 50);
						
			if(TelaCartas.vidas == 0)
				telaResposta.btn_cartas.setToolTipText("Você Perdeu");	
			else if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
				telaResposta.btn_cartas.setToolTipText("Você Venceu");	
			
			switch(TelaCartas.pulos)
			{
				case 0:
					telaResposta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaResposta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaResposta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaResposta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
			
			switch(TelaCartas.vidas)
			{
				case 0:
					telaResposta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaResposta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaResposta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaResposta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaResposta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 3:
					telaResposta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaResposta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaResposta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
		}
		else if (TelaMenu.modo_jogo == "2")
		{
			telaResposta.bg.add(telaResposta.lbl_nome2);
			telaResposta.bg.add(telaResposta.lbl_vez1);
			telaResposta.bg.add(telaResposta.lbl_vez2);			
			telaResposta.lbl_vez1.setLocation(185, 5);
			telaResposta.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaResposta.lbl_nome1.setSize(1000, 30);
			telaResposta.lbl_nome2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaResposta.lbl_nome2.setSize(1000, 30);
			telaResposta.lbl_vez1.setFont(new Font("Arial", Font.ITALIC, 20)); 	
			telaResposta.lbl_vez1.setSize(100, 20);
			telaResposta.lbl_vez2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaResposta.lbl_vez2.setSize(1000, 30);	
			
			telaResposta.btn_cartas.setToolTipText("Fim de Jogo");
		}
	}
	
	public void bindNome()
    {
		if(TelaMenu.modo_jogo == "1")
		{
			telaResposta.lbl_nome1.setText(TelaCartas.nome_jogador1);
    		int x_lbl_nome1 = TelaCartas.nome_jogador1.length() * 8;
	        telaResposta.lbl_nome1.setLocation(705 - x_lbl_nome1, 30);	
		}
    	else if(TelaMenu.modo_jogo == "2")
    	{
    		//telaResposta.lbl_nome1.setText(TelaCartas.nome_jogador1 + " - " + TelaCartas.score1 + "/" + TelaCartas.total_perguntas);
    		telaResposta.lbl_nome1.setText(TelaCartas.nome_jogador1);
    		int x_lbl_nome1 = TelaCartas.nome_jogador1.length() * 6;
			//telaResposta.lbl_nome1.setLocation(675 - x_lbl_nome1, 35);		
    		telaResposta.lbl_nome1.setLocation(715 - x_lbl_nome1, 35);	
    		//telaResposta.lbl_nome2.setText(TelaCartas.nome_jogador2 + " - " + TelaCartas.score2 + "/" + TelaCartas.total_perguntas);
			telaResposta.lbl_nome2.setText(TelaCartas.nome_jogador2);
			int x_lbl_nome2 = TelaCartas.nome_jogador2.length() * 6;
			//telaResposta.lbl_nome2.setLocation(675 - x_lbl_nome2, 65);
			telaResposta.lbl_nome2.setLocation(715 - x_lbl_nome2, 65);
			
    		if(TelaCartas.vez_jogador == "1")		
    		{
    			telaResposta.lbl_vez2.setText(TelaCartas.nome_jogador1);
    			int x_lbl_vez2 = TelaCartas.nome_jogador1.length() * 7;
    		    telaResposta.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
    		}
    		else if(TelaCartas.vez_jogador == "2")
    		{
    			telaResposta.lbl_vez2.setText(TelaCartas.nome_jogador2);
    			int x_lbl_vez2 = TelaCartas.nome_jogador2.length() * 7;
    		    telaResposta.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
    		}
    	}
    }
		
	public void mostraResposta(boolean acertou) {
		if(acertou)
		{			
			TelaMenu.som = Applet.newAudioClip(telaResposta.som_acertou);
			TelaMenu.som.play();
			telaResposta.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/certa.fw.png")));
			
			if(TelaCartas.vez_jogador == "1")
				TelaCartas.score1++;
			else if(TelaCartas.vez_jogador == "2")
				TelaCartas.score2++;
		}
		else		
		{			
			TelaMenu.som = Applet.newAudioClip(telaResposta.som_errou);
			TelaMenu.som.play();
			telaResposta.bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/errada.fw.png")));
			
			if(TelaMenu.modo_jogo == "1")
			{
				TelaCartas.vidas--;
				if(TelaCartas.vidas == 2)
					telaResposta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
				else if(TelaCartas.vidas == 1)
					telaResposta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
				else if(TelaCartas.vidas == 0)
					telaResposta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
			}			
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == telaResposta.btn_menu){
			TelaMenu.som = Applet.newAudioClip(telaResposta.som_click);
			TelaMenu.som.play();
			int ret = JOptionPane.showConfirmDialog(null, "Este jogo será perdido. Deseja realmente voltar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			TelaMenu.som = Applet.newAudioClip(telaResposta.som_click);
			TelaMenu.som.play();
			if(ret == JOptionPane.YES_NO_OPTION)
			{
				telaResposta.setVisible(false);
				TelaMenu menu = new TelaMenu();
			}
		}
		else if (e.getSource() == telaResposta.btn_cartas)
		{
			TelaMenu.som = Applet.newAudioClip(telaResposta.som_click);
			TelaMenu.som.play();
			if(TelaMenu.modo_jogo == "1")
			{
				if(TelaCartas.vidas == 0)
				{
					telaResposta.setVisible(false);
					TelaResultado resultado = new TelaResultado("Perdeu", TelaCartas.nome_jogador1, String.valueOf(TelaCartas.score1));
				}
				else
				{
					if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
					{
						telaResposta.setVisible(false);
						TelaResultado resultado = new TelaResultado("Venceu", TelaCartas.nome_jogador1, String.valueOf(TelaCartas.score1));
					}
					else
					{
						telaResposta.setVisible(false);
						TelaCartas cartas = new TelaCartas();
					}
				}
			}
			else if (TelaMenu.modo_jogo == "2")
			{
				if(TelaPergunta.rb_escolhido != "")
				{
					if(TelaCartas.vez_jogador == "1")
						TelaCartas.vez_jogador = "2";
					else if(TelaCartas.vez_jogador == "2")
						TelaCartas.vez_jogador = "1";

					if(TelaPergunta.erros < 2)						
					{
						telaResposta.setVisible(false);
						TelaPergunta pergunta = new TelaPergunta();
					}
					else if(TelaPergunta.erros == 2)
					{					
						TelaPergunta.erros = 0;
						TelaPergunta.rb_escolhido = "";

						if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
						{
							String vencedor = "";
							if(TelaCartas.score1 > TelaCartas.score2)
								vencedor = TelaCartas.nome_jogador1;
							else if(TelaCartas.score2 > TelaCartas.score1)
								vencedor = TelaCartas.nome_jogador2;
							else
								vencedor = "Empate";								

							telaResposta.setVisible(false);
							TelaResultado resultado = new TelaResultado(vencedor, "", "");
						}
						else
						{												
							telaResposta.setVisible(false);
							TelaCartas cartas = new TelaCartas();
						}
					}
				}
				else
				{
					TelaPergunta.erros = 0;
					TelaPergunta.rb_escolhido = "";

					if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
					{
						String vencedor = "";
						if(TelaCartas.score1 > TelaCartas.score2)
							vencedor = TelaCartas.nome_jogador1;
						else if(TelaCartas.score2 > TelaCartas.score1)
							vencedor = TelaCartas.nome_jogador2;
						else
							vencedor = "Empate";								

						telaResposta.setVisible(false);
						TelaResultado resultado = new TelaResultado(vencedor, "", "");
					}
					else
					{												
						telaResposta.setVisible(false);
						TelaCartas cartas = new TelaCartas();
					}
				}
			}
		}
	}

}
