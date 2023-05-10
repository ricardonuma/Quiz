package Visualiza��o;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Controle.ControleRegras;


public class TelaRegras extends Tela {

	public JButton btn_jogar1 = new JButton(new ImageIcon(getClass().getResource("/imagem/jog1.fw.png")));
	public JButton btn_jogar2 = new JButton(new ImageIcon(getClass().getResource("/imagem/jog2.fw.png")));
	public JLabel lbl_modoJogo = new JLabel("1 Jogador:");
	public JTextArea lbl_regra1 = new JTextArea("- O jogador ir� colocar o seu nome e o tempo ira come�ar guando clicar na primeira pergunta, cata carta ter� seu tempo para se respondido, caso o tempo acabe o jogador perder� a carta e o ponto que iria conseguir com ela.\n" +
"- Ap�s come�ar o jogo, o jogador ir� escolher uma carta a onde ela n�o pode ser devolvida sem ser respondida corretamente ou ter errado.\n" +
"- O jogador pode pular at� duas perguntas, anulando as mesmas.\n" +
"- A carta que foi respondida n�o ser� habilitada novamente assim sendo ela ser� respondida apena uma vez, mas isso n�o impedir� de aparecer � mesma pergunta em outra rodada, pelo motivo que a quantidade de perguntas � limitada.\n" +
"- A pontua��o ser� definida pela quantidade de perguntas certas. Cada pergunta que foi acertada fale um ponto.");
	public JTextArea lbl_regra2 = new JTextArea("- Cada jogador ir� colocar seu nome na lista, independente da ordem, sempre ir� come�ar pelo primeiro jogador.\n" +
"- Cada jogador ir� escolher uma carta que aparece na tela, caso o primeiro jogador erre a pergunta o segundo jogador ter� a chance de responder a mesma pergunta e caso o segundo jogador tamb�m erre, n�o haver� ponto pra nenhum jogador e a pergunta ser� anulada.\n" +
"- O jogador que acertar a pergunta continuar� respondendo at� todas as cartas terem sido viradas ou respondidas corretamente.\n" +
"- O jogador que acertar mais perguntas ir� ganhar o jogo.\n");
		   	
	public TelaRegras(){
		super("EcoQuiz");
		
		bg.add(btn_jogar1);
		bg.add(btn_jogar2);
		bg.add(lbl_modoJogo);
		bg.add(lbl_regra1);
		bg.add(lbl_regra2);	
		
		btn_jogar1.setLocation(200, 75);
		btn_jogar2.setLocation(475, 75);
		lbl_modoJogo.setLocation(100, 280);
		lbl_regra1.setLocation(100, 310);
		lbl_regra2.setLocation(100, 310);
		
		btn_jogar1.setSize(200, 200);		
		btn_jogar2.setSize(200, 200);		
		lbl_modoJogo.setSize(150, 25);
		lbl_modoJogo.setFont(new Font("Arial Black", Font.LAYOUT_LEFT_TO_RIGHT, 17)); 
		lbl_regra1.setSize(675, 220);
		lbl_regra1.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 17)); 
		lbl_regra2.setSize(675, 220);
		lbl_regra2.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 17)); 
		
		btn_jogar1.setToolTipText("1 Jogador");
		btn_jogar2.setToolTipText("2 Jogadores");
				
		btn_jogar1.setBorderPainted(false);		
		btn_jogar1.setContentAreaFilled(false);
		btn_jogar2.setBorderPainted(false);		
		btn_jogar2.setContentAreaFilled(false);
		
		lbl_regra1.setWrapStyleWord(true);
		lbl_regra1.setLineWrap(true);
		lbl_regra1.setEditable(false);
		lbl_regra2.setWrapStyleWord(true);
		lbl_regra2.setLineWrap(true);
		lbl_regra2.setEditable(false);
				
		btn_jogar1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_jogar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_jogar1.setIcon(new ImageIcon(getClass().getResource("/imagem/jog1.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_jogar1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_jogar1.setIcon(new ImageIcon(getClass().getResource("/imagem/jog1.fw.png")));
		    }
		});
		
		btn_jogar2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_jogar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_jogar2.setIcon(new ImageIcon(getClass().getResource("/imagem/jog2.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_jogar2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_jogar2.setIcon(new ImageIcon(getClass().getResource("/imagem/jog2.fw.png")));
		    }
		});
			
		ControleRegras controleRegras = new ControleRegras(this);
		btn_menu.addActionListener(controleRegras);
		btn_jogar1.addActionListener(controleRegras);	
		btn_jogar2.addActionListener(controleRegras);	
				
		lbl_regra2.setVisible(false);
	}
		
}
