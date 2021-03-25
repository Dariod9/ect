package aula8.Ex3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Framework {

	private JToggleButton[] helpButtons;
	private JRadioButton[]  answerButtons;
	private static int amount=0;
	private static boolean correct=false;
	
	
	Framework(Question questions, int win){
		ImageIcon image = questions.getImage(); 
		String qst = questions.getPergunta();
		String [] ans = questions.getResp(); 
		String sol = questions.getSolu�ao();

		JFrame frame=new JFrame("Milion�rio");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBackground(Color.gray);
		
		JPanel panel= new JPanel();
		

		JLabel fig = new JLabel();
		fig.setIcon(image);
		panel.add(fig);
		JLabel w= new JLabel(Integer.toString(win));
		panel.add(w);
		JLabel q = new JLabel(qst);
		panel.add(q);
		
		answerButtons = new JRadioButton[4];
		
		ButtonGroup group = new ButtonGroup();
		
		for(int k = 0; k<4; k++) {
			
			JRadioButton b = new JRadioButton();
			b.setText(ans[k]);
			panel.add(b);
			
			answerButtons[k] = b;
			group.add(b);			
			
			final int j = k;
			
			answerButtons[k].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					while(!group.isSelected(answerButtons[j].getModel())) {
							try {
								this.wait(200);							//ATEN�AO; POSSO TIRAR
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}	}
			});
		}
		
		JToggleButton set = new JToggleButton();
		set.setText("confirmar");
		panel.add(set);
		
		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(correct) { 
					amount += win;
				}
				else {
					JOptionPane.showMessageDialog(frame, "Paran�ns! Arrecadou" + amount+" euros");
					System.exit(0);
					}
				}
			});
		
	
		JToggleButton giveUp = new JToggleButton();
		giveUp.setText("Desistir");
		panel.add(giveUp);
		
		giveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame, "Obrigado pela participa��o! Arrecadou" + amount+" euros");
					System.exit(0);	
				}
			});
		
		
		
		
		
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		
	}
}
