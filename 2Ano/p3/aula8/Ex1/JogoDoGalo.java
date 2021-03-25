package aula8.Ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JogoDoGalo {
	
	private String play;
	private JFrame frame;
	
	
	public JogoDoGalo() {
		criaJogo();
	}
	
	
	
	public void criaJogo(){
		
		char jogador1 = 'x';
		char jogador2 = 'o';
		Tabuleiro jogo = new Tabuleiro(jogador1, jogador2);
		
		JFrame frame=new JFrame("Galo");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBackground(Color.gray);
		
		JPanel panel=new JPanel();
		play="x";
		GridLayout grid= new GridLayout(3,3);
		panel.setLayout(grid);
		
		JButton[] buttons = new JButton[9];
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i]=new JButton();
			buttons[i].setForeground(Color.gray);
			panel.add(buttons[i]);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				JButton a = (JButton) e.getSource();
				if(a.equals(buttons[0])) {
					jogo.jogada(1,1);
					}
				if(a.equals(buttons[1])) {
					jogo.jogada(1,2);
					}
				if(a.equals(buttons[2])) {
					jogo.jogada(1,3);
					}
				if(a.equals(buttons[3])) {
					jogo.jogada(2,1);
					}
				if(a.equals(buttons[4])) {
					jogo.jogada(2,2);
					}
				if(a.equals(buttons[5])) {
					jogo.jogada(2,3);
					}
				if(a.equals(buttons[6])) {
					jogo.jogada(3,1);
					}
				if(a.equals(buttons[7])) {
					jogo.jogada(3,2);
					}
				if(a.equals(buttons[8])) {
					jogo.jogada(3,3);
					}
				a.setText(""+jogo.lastPlayer());
				a.setFont(new Font("Arial", Font.BOLD, 100));
				a.setEnabled(false);
				if(jogo.end()) {
					if (jogo.lastPlayerWon()) {
						JOptionPane.showMessageDialog(panel, "Jogador "+jogo.lastPlayer()+" ganhou!");
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(panel, "Jogo Empatado");
						System.exit(0);
					}
				}
			}});
	
		}

		frame.setContentPane(panel);
		frame.setVisible(true);
		
	}
	

}
