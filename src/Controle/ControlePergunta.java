package Controle;

import java.applet.Applet;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Modelo.Pergunta;
import Modelo.PerguntaDAO;
import Modelo.RespostaDAO;
import Visualização.TelaCartas;
import Visualização.TelaMenu;
import Visualização.TelaPergunta;
import Visualização.TelaResposta;
import Visualização.TelaResultado;

public class ControlePergunta implements ActionListener {
	
	public Timer timer = new Timer(1000, new TimerListener());
	TelaPergunta telaPergunta;
	
	public ControlePergunta(TelaPergunta telaPergunta) {
		// TODO Auto-generated constructor stub
		this.telaPergunta = telaPergunta;
	}
	
	public void verificaModoJogo() {
		if(TelaMenu.modo_jogo == "1")
		{
			telaPergunta.lbl_jogador.setText("Jogador: ");
			telaPergunta.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 30)); 
			telaPergunta.lbl_nome1.setSize(1000, 35);
			
			telaPergunta.bg.add(TelaCartas.lbl_pulo);			
			telaPergunta.bg.add(telaPergunta.img_pulo1);
			telaPergunta.bg.add(telaPergunta.img_pulo2);			
			telaPergunta.bg.add(TelaCartas.lbl_vida);			
			telaPergunta.bg.add(telaPergunta.img_vida1);
			telaPergunta.bg.add(telaPergunta.img_vida2);
			telaPergunta.bg.add(telaPergunta.img_vida3);			
			telaPergunta.bg.add(telaPergunta.btn_pular);
					
			telaPergunta.img_pulo1.setLocation(90, 30);
			telaPergunta.img_pulo2.setLocation(115, 30);			
			telaPergunta.img_vida1.setLocation(180, 30);
			telaPergunta.img_vida2.setLocation(205, 30);
			telaPergunta.img_vida3.setLocation(230, 30);
					
			telaPergunta.img_pulo1.setSize(50, 50);
			telaPergunta.img_pulo2.setSize(50, 50);					
			telaPergunta.img_vida1.setSize(50, 50);
			telaPergunta.img_vida2.setSize(50, 50);
			telaPergunta.img_vida3.setSize(50, 50);
			
			telaPergunta.btn_responder.setLocation(312, 425);
			telaPergunta.btn_pular.setLocation(462, 425);
			
			telaPergunta.btn_pular.setSize(100, 50);	
			
			telaPergunta.btn_pular.setToolTipText("Pular");
			
			telaPergunta.btn_pular.addActionListener(this);
			
			telaPergunta.btn_pular.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	telaPergunta.btn_pular.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    	telaPergunta.btn_pular.setIcon(new ImageIcon(getClass().getResource("/imagem/pular.fw - Copy.png")));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	telaPergunta.btn_pular.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			    	telaPergunta.btn_pular.setIcon(new ImageIcon(getClass().getResource("/imagem/pular.fw.png")));
			    }
			});
			
			if(TelaCartas.pulos > 0)		
				telaPergunta.btn_pular.setEnabled(true);
			else
				telaPergunta.btn_pular.setEnabled(false);
						
			switch(TelaCartas.pulos)
			{
				case 0:
					telaPergunta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaPergunta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaPergunta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaPergunta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
			
			switch(TelaCartas.vidas)
			{
				case 0:
					telaPergunta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaPergunta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaPergunta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaPergunta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaPergunta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 3:
					telaPergunta.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaPergunta.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaPergunta.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
		}
		else if (TelaMenu.modo_jogo == "2")
		{
			telaPergunta.bg.add(telaPergunta.lbl_nome2);
			telaPergunta.bg.add(telaPergunta.lbl_vez1);
			telaPergunta.bg.add(telaPergunta.lbl_vez2);			
			telaPergunta.lbl_vez1.setLocation(185, 5);
			telaPergunta.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaPergunta.lbl_nome1.setSize(1000, 30);
			telaPergunta.lbl_nome2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaPergunta.lbl_nome2.setSize(1000, 30);
			telaPergunta.lbl_vez1.setFont(new Font("Arial", Font.ITALIC, 20)); 	
			telaPergunta.lbl_vez1.setSize(100, 20);
			telaPergunta.lbl_vez2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaPergunta.lbl_vez2.setSize(1000, 30);			
			telaPergunta.btn_responder.setLocation(387, 425);
		}
	}
	
	public void bindNome()
    {
		if(TelaMenu.modo_jogo == "1")
		{
			telaPergunta.lbl_nome1.setText(TelaCartas.nome_jogador1);
    		int x_lbl_nome1 = TelaCartas.nome_jogador1.length() * 8;
	        telaPergunta.lbl_nome1.setLocation(705 - x_lbl_nome1, 30);
		}
    	else if(TelaMenu.modo_jogo == "2")
    	{
    		//telaPergunta.lbl_nome1.setText(TelaCartas.nome_jogador1 + " - " + TelaCartas.score1 + "/" + TelaCartas.total_perguntas);
    		telaPergunta.lbl_nome1.setText(TelaCartas.nome_jogador1);
    		int x_lbl_nome1 = TelaCartas.nome_jogador1.length() * 6;
			//telaPergunta.lbl_nome1.setLocation(675 - x_lbl_nome1, 35);		
    		telaPergunta.lbl_nome1.setLocation(715 - x_lbl_nome1, 35);	
    		//telaPergunta.lbl_nome2.setText(TelaCartas.nome_jogador2 + " - " + TelaCartas.score2 + "/" + TelaCartas.total_perguntas);
			telaPergunta.lbl_nome2.setText(TelaCartas.nome_jogador2);
			int x_lbl_nome2 = TelaCartas.nome_jogador2.length() * 6;
			//telaPergunta.lbl_nome2.setLocation(675 - x_lbl_nome2, 65);
			telaPergunta.lbl_nome2.setLocation(715 - x_lbl_nome2, 65);
			
    		if(TelaCartas.vez_jogador == "1")		
    		{
    			telaPergunta.lbl_vez2.setText(TelaCartas.nome_jogador1);
    			int x_lbl_vez2 = TelaCartas.nome_jogador1.length() * 7;
    		    telaPergunta.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
    		}
    		else if(TelaCartas.vez_jogador == "2")
    		{
    			telaPergunta.lbl_vez2.setText(TelaCartas.nome_jogador2);
    			int x_lbl_vez2 = TelaCartas.nome_jogador2.length() * 7;
    		    telaPergunta.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
    		}
    	}
    }
	
	public void bindPergunta()
    {
		Pergunta pergunta = new Pergunta();
		PerguntaDAO dao = new PerguntaDAO();
		pergunta = dao.getPerguntaById(TelaCartas.escolhida);		
		
		telaPergunta.lbl_pergunta.setText(TelaCartas.escolhida + " - " + pergunta.getPergunta());    
		
		
		int x_lbl_pergunta = telaPergunta.lbl_pergunta.getText().length() * 3;
		if(380 - x_lbl_pergunta <= 100)
			x_lbl_pergunta = 100;
		else
			x_lbl_pergunta = 380 - x_lbl_pergunta;
		telaPergunta.lbl_pergunta.setLocation(x_lbl_pergunta, 175);
    }
	
	public void bindRespostas()
    {
		RespostaDAO dao = new RespostaDAO();
		ArrayList<String> respostas = dao.getRespostas(TelaCartas.escolhida);	
				
		telaPergunta.rb_1.setText(respostas.get(0));
		telaPergunta.rb_2.setText(respostas.get(1));
		telaPergunta.rb_3.setText(respostas.get(2));
		telaPergunta.rb_4.setText(respostas.get(3));
		
		int x_rb = 0;
		if(telaPergunta.rb_1.getText().length() > telaPergunta.rb_2.getText().length() &&
				telaPergunta.rb_1.getText().length() > telaPergunta.rb_3.getText().length() &&
				telaPergunta.rb_1.getText().length() > telaPergunta.rb_4.getText().length())
			x_rb = telaPergunta.rb_1.getText().length() * 2;
		else if(telaPergunta.rb_2.getText().length() > telaPergunta.rb_1.getText().length() &&
				telaPergunta.rb_2.getText().length() > telaPergunta.rb_3.getText().length() &&
				telaPergunta.rb_2.getText().length() > telaPergunta.rb_4.getText().length())
			x_rb = telaPergunta.rb_2.getText().length() * 2;
		else if(telaPergunta.rb_3.getText().length() > telaPergunta.rb_1.getText().length() &&
				telaPergunta.rb_3.getText().length() > telaPergunta.rb_2.getText().length() &&
				telaPergunta.rb_3.getText().length() > telaPergunta.rb_4.getText().length())
			x_rb = telaPergunta.rb_3.getText().length() * 2;
		else if(telaPergunta.rb_4.getText().length() > telaPergunta.rb_1.getText().length() &&
				telaPergunta.rb_4.getText().length() > telaPergunta.rb_2.getText().length() &&
				telaPergunta.rb_4.getText().length() > telaPergunta.rb_3.getText().length())
			x_rb = telaPergunta.rb_4.getText().length() * 2;
		
		if(380 - x_rb <= 100)
			x_rb = 100;
		else
			x_rb = 360 - x_rb;
		telaPergunta.rb_1.setLocation(x_rb, 245);
		telaPergunta.rb_2.setLocation(x_rb, 285);
		telaPergunta.rb_3.setLocation(x_rb, 325);
		telaPergunta.rb_4.setLocation(x_rb, 365);	
		
		if(TelaMenu.modo_jogo == "2")
		{
			if(telaPergunta.rb_escolhido != "")
			{
				switch (telaPergunta.rb_escolhido) {
				case "1":
					telaPergunta.rb_1.setEnabled(false);
					break;
				case "2":
					telaPergunta.rb_2.setEnabled(false);
					break;
				case "3":
					telaPergunta.rb_3.setEnabled(false);
					break;
				case "4":
					telaPergunta.rb_4.setEnabled(false);
					break;
				default:
					break;
				}			
			}
		}
    }
	
	public boolean Validar()
	{
		boolean ret = true;
		
		if(!telaPergunta.rb_1.isSelected() && !telaPergunta.rb_2.isSelected() && !telaPergunta.rb_3.isSelected() && !telaPergunta.rb_4.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Selecione uma resposta.");
			ret = false;
		}
		
		return ret;
	}
	
	public boolean VerificaResposta()
	{		
		boolean ret = false;
		telaPergunta.rb_escolhido = "";
		String resposta = "";
		RespostaDAO dao = new RespostaDAO();
		resposta = dao.getRespostaCertaByIdPergunta(TelaCartas.escolhida);
				
		if(telaPergunta.rb_1.isSelected())
        {
            if (telaPergunta.rb_1.getText().equals(resposta))
                ret = true;
            else
            {
            	telaPergunta.rb_escolhido = "1";
            	telaPergunta.erros++;
            }
        }
        else if (telaPergunta.rb_2.isSelected())
        {
            if (telaPergunta.rb_2.getText().equals(resposta))
            	ret = true;
            else
            {
            	telaPergunta.rb_escolhido = "2";
            	telaPergunta.erros++;
            }
        }
        else if (telaPergunta.rb_3.isSelected())
        {
            if (telaPergunta.rb_3.getText().equals(resposta))
            	ret = true;
            else
            {
            	telaPergunta.rb_escolhido = "3";
            	telaPergunta.erros++;
            }
        }
        else if (telaPergunta.rb_4.isSelected())
        {
            if (telaPergunta.rb_4.getText().equals(resposta))
            	ret = true;
            else
            {
            	telaPergunta.rb_escolhido = "4";
            	telaPergunta.erros++;
            }
        }
		
		return ret;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == telaPergunta.btn_menu){
			TelaMenu.som = Applet.newAudioClip(telaPergunta.som_click);
			TelaMenu.som.play();
			int ret = JOptionPane.showConfirmDialog(null, "Este jogo será perdido. Deseja realmente voltar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			TelaMenu.som = Applet.newAudioClip(telaPergunta.som_click);
			TelaMenu.som.play();
			if(ret == JOptionPane.YES_NO_OPTION)
			{
				telaPergunta.setVisible(false);
				TelaMenu menu = new TelaMenu();
			}
		}
		else if (e.getSource() == telaPergunta.btn_responder){	
			TelaMenu.som = Applet.newAudioClip(telaPergunta.som_click);
			TelaMenu.som.play();		
			timer.stop();
			if(Validar())
			{
				telaPergunta.setVisible(false);
				TelaResposta resposta = new TelaResposta(VerificaResposta());
			}
		}	
		else if (e.getSource() == telaPergunta.btn_pular){	
			TelaMenu.som = Applet.newAudioClip(telaPergunta.som_click);
			TelaMenu.som.play();			
			timer.stop();
			TelaCartas.pulos--;
			
			if(TelaCartas.pulos == 1)
				telaPergunta.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
			else if(TelaCartas.pulos == 0)
				telaPergunta.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));

			telaPergunta.setVisible(false);
			TelaCartas cartas = new TelaCartas();
		}
	}
	
	public void controlaTimer() {
		telaPergunta.bg.add(telaPergunta.lbl_tempo2);
		telaPergunta.lbl_tempo2.setLocation(415, 120);
		telaPergunta.lbl_tempo2.setFont(new Font("Arial", Font.ITALIC, 40)); 
		telaPergunta.lbl_tempo2.setSize(100, 30);
		timer.start();
	}
	
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    if (--telaPergunta.timeRemaining > 0) {
		    	telaPergunta.lbl_tempo2.setText(String.valueOf(telaPergunta.timeRemaining));
		    } else {
		    	if(TelaMenu.modo_jogo == "1")
				{
		    		TelaCartas.vidas--;
					if(TelaCartas.vidas == 0)
					{
						telaPergunta.setVisible(false);
						TelaResultado resultado = new TelaResultado("Perdeu", TelaCartas.nome_jogador1, String.valueOf(TelaCartas.score1));
					}
					else
					{
						if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
						{
							telaPergunta.setVisible(false);
							TelaResultado resultado = new TelaResultado("Venceu", TelaCartas.nome_jogador1, String.valueOf(TelaCartas.score1));
						}
						else
						{
							telaPergunta.setVisible(false);
							TelaCartas cartas = new TelaCartas();
						}
					}
				}
				else if (TelaMenu.modo_jogo == "2")
				{
					TelaPergunta.erros++;
					
					if(TelaCartas.vez_jogador == "1")
						TelaCartas.vez_jogador = "2";
					else if(TelaCartas.vez_jogador == "2")
						TelaCartas.vez_jogador = "1";

					if(TelaPergunta.erros < 2)						
					{
						telaPergunta.setVisible(false);
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

							telaPergunta.setVisible(false);
							TelaResultado resultado = new TelaResultado(vencedor, "", "");
						}
						else
						{							
							telaPergunta.setVisible(false);
							TelaCartas cartas = new TelaCartas();
						}
					}
				}
					
		    	timer.stop();
		    }
	    }
	}

}
