package picture;

import java.awt.Graphics;
import javax.swing.*;
public class TestPaint extends JFrame {
	public TestPaint(){
		add(new NewLabel("Banner"));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPaint frame = new TestPaint();
		frame.setTitle("TestPaintCompinent");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
	}
	
	class NewLabel extends JLabel {
		public NewLabel(String text){
			super(text);
		
		}
		protected void painComponent(Graphics g){
			super.paintComponent(g);
			g.drawLine(0, 0, 50, 50);
		}
	}