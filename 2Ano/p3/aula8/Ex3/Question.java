package aula8.Ex3;

import javax.swing.ImageIcon;

public class Question { //questions and answers
	private ImageIcon image;
	private String question;
	private String [] answer;
	private String corAnswer;
	
	public Question(ImageIcon image, String question, String [] answer, String corAnswer) {
		this.image = image;
		this.question = question;
		this.answer = answer;
		this.corAnswer = corAnswer;
	}

	public String getPergunta() { return question;	}

	public String [] getResp()  { return answer;	}

	public String getSoluçao() 	{ return corAnswer;	}

	public ImageIcon getImage() { return image;		}
}