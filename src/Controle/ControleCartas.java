package Controle;

import java.applet.Applet;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Visualização.TelaCartas;
import Visualização.TelaMenu;
import Visualização.TelaPergunta;
import Visualização.TelaResultado;

public class ControleCartas implements ActionListener {

	TelaCartas telaCartas;
	
	public ControleCartas(TelaCartas telaCartas) {
		// TODO Auto-generated constructor stub
		this.telaCartas = telaCartas;
	}
	
	public void sorteiaCartas() {
		if(telaCartas.perguntas.size() == 0)
		{
			Random random = new Random();
			int id;
			for(int i = 0; i < 10; i++)
			{			
				do
				{
					id = random.nextInt(30) + 1;
				}while(telaCartas.perguntas.contains(String.valueOf(id)));
								
				telaCartas.perguntas.add(String.valueOf(id));
			}
		}
	}
	
	public void verificaModoJogo() {
		if(TelaMenu.modo_jogo == "1")
		{
			if(TelaCartas.feitas.size() == TelaCartas.total_perguntas)
			{
				TelaResultado resultado = new TelaResultado("Venceu", TelaCartas.nome_jogador1, String.valueOf(TelaCartas.score1));
				telaCartas.setVisible(false);
			}
				
			telaCartas.lbl_jogador.setText("Jogador: ");
			telaCartas.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 30)); 
			telaCartas.lbl_nome1.setSize(1000, 35);
			
			telaCartas.bg.add(telaCartas.lbl_pulo);
			telaCartas.bg.add(telaCartas.img_pulo1);
			telaCartas.bg.add(telaCartas.img_pulo2);			
			telaCartas.bg.add(telaCartas.lbl_vida);			
			telaCartas.bg.add(telaCartas.img_vida1);
			telaCartas.bg.add(telaCartas.img_vida2);
			telaCartas.bg.add(telaCartas.img_vida3);
			
			telaCartas.lbl_pulo.setLocation(100, 5);			
			telaCartas.img_pulo1.setLocation(90, 30);
			telaCartas.img_pulo2.setLocation(115, 30);			
			telaCartas.lbl_vida.setLocation(205, 5);			
			telaCartas.img_vida1.setLocation(180, 30);
			telaCartas.img_vida2.setLocation(205, 30);
			telaCartas.img_vida3.setLocation(230, 30);
			
			telaCartas.lbl_pulo.setFont(new Font("Arial", Font.ITALIC, 20)); 
			telaCartas.lbl_pulo.setSize(100, 20);			
			telaCartas.img_pulo1.setSize(50, 50);
			telaCartas.img_pulo2.setSize(50, 50);						
			telaCartas.lbl_vida.setFont(new Font("Arial", Font.ITALIC, 20)); 
			telaCartas.lbl_vida.setSize(100, 20);				
			telaCartas.img_vida1.setSize(50, 50);
			telaCartas.img_vida2.setSize(50, 50);
			telaCartas.img_vida3.setSize(50, 50);
			
			switch(TelaCartas.pulos)
			{
				case 0:
					telaCartas.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaCartas.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaCartas.img_pulo1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaCartas.img_pulo2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
			
			switch(TelaCartas.vidas)
			{
				case 0:
					telaCartas.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					break;
				case 1:
					telaCartas.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 2:
					telaCartas.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/morto.fw.png")));
					telaCartas.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaCartas.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
				case 3:
					telaCartas.img_vida1.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaCartas.img_vida2.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					telaCartas.img_vida3.setIcon(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
					break;
			}
		}
		else if (TelaMenu.modo_jogo == "2")
		{
			telaCartas.lbl_jogador.setText("Jogadores: ");
			telaCartas.bg.add(telaCartas.lbl_nome2);
			telaCartas.bg.add(telaCartas.lbl_vez1);
			telaCartas.bg.add(telaCartas.lbl_vez2);			
			telaCartas.lbl_vez1.setLocation(185, 5);
			telaCartas.lbl_nome1.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaCartas.lbl_nome1.setSize(1000, 30);
			telaCartas.lbl_nome2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaCartas.lbl_nome2.setSize(1000, 30);
			telaCartas.lbl_vez1.setFont(new Font("Arial", Font.ITALIC, 20)); 	
			telaCartas.lbl_vez1.setSize(100, 20);
			telaCartas.lbl_vez2.setFont(new Font("Arial", Font.ITALIC, 25)); 	
			telaCartas.lbl_vez2.setSize(1000, 30);			
		}
	}
		
	public void controlaCartas()
    {
        for (int i = 0; i < telaCartas.feitas.size(); i++)
        {
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(0)))
        		telaCartas.btn_carta1.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(1)))
        		telaCartas.btn_carta2.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(2)))
        		telaCartas.btn_carta3.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(3)))
        		telaCartas.btn_carta4.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(4)))
        		telaCartas.btn_carta5.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(5)))
        		telaCartas.btn_carta6.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(6)))
        		telaCartas.btn_carta7.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(7)))
        		telaCartas.btn_carta8.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(8)))
        		telaCartas.btn_carta9.setEnabled(false);
        	
        	if((String)telaCartas.feitas.get(i) == ((String)telaCartas.perguntas.get(9)))
        		telaCartas.btn_carta10.setEnabled(false);        		
        }
    }
			
	public void cadastraJogador()
    {
        String nome1 = "";

        if(TelaMenu.modo_jogo == "1")
        {
	        while(nome1 == null || nome1.isEmpty() || nome1.length() > 12)
	        	nome1 = JOptionPane.showInputDialog("Digite seu nome: ");
	            
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.nome_jogador1 = nome1;        
			telaCartas.lbl_nome1.setText(nome1);
	        int x_lbl_nome1 = nome1.length() * 8;
	        telaCartas.lbl_nome1.setLocation(705 - x_lbl_nome1, 30);	
        }
        else if(TelaMenu.modo_jogo == "2")
        {
        	while(nome1 == null || nome1.isEmpty() || nome1.length() > 12)
        		nome1 = JOptionPane.showInputDialog("Jogador 1, digite seu nome: ");
	            
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.nome_jogador1 = nome1;        
			//telaCartas.lbl_nome1.setText(nome1 + " - " + telaCartas.score1 + "/" + telaCartas.total_perguntas);
			telaCartas.lbl_nome1.setText(nome1);
			int x_lbl_nome1 = nome1.length() * 6;
	        //telaCartas.lbl_nome1.setLocation(675 - x_lbl_nome1, 35);
			telaCartas.lbl_nome1.setLocation(715 - x_lbl_nome1, 35);	
	        
	        String nome2 = "";
	        
	        while(nome2 == null || nome2.isEmpty() || nome2.length() > 12 || nome2.equals(nome1))
	        	nome2 = JOptionPane.showInputDialog("Jogador 2, digite seu nome: ");

			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.nome_jogador2 = nome2;        
			//telaCartas.lbl_nome2.setText(nome2 + " - " + telaCartas.score2 + "/" + telaCartas.total_perguntas);
			telaCartas.lbl_nome2.setText(nome2);
			int x_lbl_nome2 = nome2.length() * 6;
	        //telaCartas.lbl_nome2.setLocation(675 - x_lbl_nome2, 65);
	        telaCartas.lbl_nome2.setLocation(715 - x_lbl_nome2, 65);
	        
	        telaCartas.lbl_vez2.setText(nome1);	        
	        int x_lbl_vez2 = nome1.length() * 7;
	        telaCartas.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
        }
    }

	public void bindNome()
    {  	
		if(telaCartas.nome_jogador1 == "")
			cadastraJogador();
		else
		{			
	    	if(TelaMenu.modo_jogo == "1")
	    	{
	    		telaCartas.lbl_nome1.setText(telaCartas.nome_jogador1);
	    		int x_lbl_nome1 = telaCartas.nome_jogador1.length() * 8;
		        telaCartas.lbl_nome1.setLocation(705 - x_lbl_nome1, 30);	        
	    	}
	    	else if(TelaMenu.modo_jogo == "2")
	    	{
	    		//telaCartas.lbl_nome1.setText(telaCartas.nome_jogador1 + " - " + telaCartas.score1 + "/" + telaCartas.total_perguntas);
	    		telaCartas.lbl_nome1.setText(telaCartas.nome_jogador1);
	    		int x_lbl_nome1 = telaCartas.nome_jogador1.length() * 6;
				//telaCartas.lbl_nome1.setLocation(675 - x_lbl_nome1, 35);
	    		telaCartas.lbl_nome1.setLocation(715 - x_lbl_nome1, 35);	
				//telaCartas.lbl_nome2.setText(telaCartas.nome_jogador2 + " - " + telaCartas.score2 + "/" + telaCartas.total_perguntas);
				telaCartas.lbl_nome2.setText(telaCartas.nome_jogador2);
				int x_lbl_nome2 = telaCartas.nome_jogador2.length() * 6;
				//telaCartas.lbl_nome2.setLocation(675 - x_lbl_nome2, 65);
				telaCartas.lbl_nome2.setLocation(715 - x_lbl_nome2, 65);
				
	    		if(telaCartas.vez_jogador == "1")		
	    		{
	    			telaCartas.lbl_vez2.setText(telaCartas.nome_jogador1);
	    			int x_lbl_vez2 = telaCartas.nome_jogador1.length() * 7;
	    		    telaCartas.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
	    		}
	    		else if(telaCartas.vez_jogador == "2")
	    		{
	    			telaCartas.lbl_vez2.setText(telaCartas.nome_jogador2);
	    			int x_lbl_vez2 = telaCartas.nome_jogador2.length() * 7;
	    		    telaCartas.lbl_vez2.setLocation(200 - x_lbl_vez2, 35);
	    		}
	    	}
		}
    }
    
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(telaCartas.btn_menu)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			int ret = JOptionPane.showConfirmDialog(null, "Este jogo será perdido. Deseja realmente voltar?", "Confirmação", JOptionPane.YES_NO_OPTION);
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			if(ret == JOptionPane.YES_NO_OPTION)
			{
				telaCartas.setVisible(false);
				TelaMenu menu = new TelaMenu();
			}
		}
		else if (e.getSource().equals(telaCartas.btn_carta1)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(0);
			telaCartas.feitas.add(telaCartas.perguntas.get(0));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta2)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(1);
			telaCartas.feitas.add(telaCartas.perguntas.get(1));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta3)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(2);
			telaCartas.feitas.add(telaCartas.perguntas.get(2));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta4)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(3);
			telaCartas.feitas.add(telaCartas.perguntas.get(3));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta5)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(4);
			telaCartas.feitas.add(telaCartas.perguntas.get(4));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta6)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(5);
			telaCartas.feitas.add(telaCartas.perguntas.get(5));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta7)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(6);
			telaCartas.feitas.add(telaCartas.perguntas.get(6));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta8)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(7);
			telaCartas.feitas.add(telaCartas.perguntas.get(7));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta9)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(8);
			telaCartas.feitas.add(telaCartas.perguntas.get(8));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}		
		else if (e.getSource().equals(telaCartas.btn_carta10)) {
			TelaMenu.som = Applet.newAudioClip(telaCartas.som_click);
			TelaMenu.som.play();
			telaCartas.escolhida = telaCartas.perguntas.get(9);
			telaCartas.feitas.add(telaCartas.perguntas.get(9));
			telaCartas.setVisible(false);
			TelaPergunta pergunta = new TelaPergunta();
		}
	}

}
