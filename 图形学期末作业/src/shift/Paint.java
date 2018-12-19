package shift;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paint extends JPanel{
	int a;
	
	public void paint(Graphics g){
		super.paint(g);
		//g.setColor(Color.yellow);
		//g.fillRect(20, 50, 100, 100);
		paintComponents(g);
	}
	
	public void paintComponents(Graphics g){
		set(1);
		if(a==0){
			g.setColor(Color.yellow);
		}else{
			g.setColor(Color.WHITE);
		}
		g.fillRect(20, 50, 100, 100);
	}
	
	public void set(int a){
		this.a = a;
	}
	public void see() {
		
	}
	
	public void seeNothing() {}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		Paint panel = new Paint();
		JLabel label = new JLabel("aaa");
		panel.setBackground(Color.green);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		//set(1);
	}
}
