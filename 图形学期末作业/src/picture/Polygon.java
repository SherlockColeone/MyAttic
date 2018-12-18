package picture;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Polygon extends JFrame {
	int left,right,top,bottom;     //定义四条边界
	Graphics g;
	Point[] p = new Point[6];      //定义对象数组，大小为多边形点数加一
	int i;
	float a,b;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Polygon frame = new Polygon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Polygon() {
		setTitle("\u591A\u8FB9\u5F62");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Polygon frameP = new Polygon();
		//Test frameT = new Test();
		setWindow(140,550,100,300);
		setPolygon();
		//intersect();
		draw();
	}
	
	public void setWindow(int l,int r,int t,int b){
		left = l;    //设置边界值
		right = r;
		top = t;
		bottom = b;
	}
	
	public void setPolygon(){     //给多边形的点赋值，形成多边形
		p[0] = new Point();
		p[0].setX(200);    //赋X的值
		p[0].setY(150);    //赋Y的值
		
		p[1] = new Point();
		p[1].setX(470);
		p[1].setY(200);
		
		p[2] = new Point();
		p[2].setX(400);
		p[2].setY(350);
		
		p[3] = new Point();
		p[3].setX(250);
		p[3].setY(350);
		
		p[4] = new Point();
		p[4].setX(100);
		p[4].setY(310);
		
		p[5] = new Point();         //创建最后一个数组避免计算时出现空数组而出错
		p[5].setX(p[0].getX());     //第一个数组的x、y赋给最后一个数组
		p[5].setY(p[0].getY());
	}
	
	public void intersect(){         //用于计算交点的数量
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //通过两点式计算出直线斜率k
		//x代入左边界值算出y的值
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();
		if(p[i-1].yLeft>=p[i-1].getY()&&p[i-1].yLeft<=p[i].getY()
				||p[i-1].yLeft<=p[i-1].getY()&&p[i-1].yLeft>=p[i].getY()){  //此处判断的条件为y值是否在两点y值的区间内，若是这说明有交点，若无这说明无交点
			p[i-1].point = p[i-1].point + 1;        //标记交点的值加一
			p[i-1].signal1 = 1;
		}
		//x代入右边界值算出y值
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();
		if(p[i-1].yRight>=p[i-1].getY()&&p[i-1].yRight<=p[i].getY()
				||p[i-1].yRight<=p[i-1].getY()&&p[i-1].yRight>=p[i].getY()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1){
				p[i-1].signal2 = 2;
			}else{
				p[i-1].signal1 = 2;
			}
		}
		//y代入上边界值算出x的值
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xTop>=p[i-1].getX()&&p[i-1].xTop<=p[i].getX()
				||p[i-1].xTop<=p[i-1].getX()&&p[i-1].xTop>=p[i].getX()){    //此处判断的条件为x值是否在两点的x值的区间内
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2){
				p[i-1].signal2 = 3;
			}else{
				p[i-1].signal1 = 3;
			}
		}
		//y代入下边界值算出x值
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xBottom>=p[i-1].getX()&&p[i-1].xBottom<=p[i].getX()
				||p[i-1].xBottom<=p[i-1].getX()&&p[i-1].xBottom>=p[i].getX()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2||p[i-1].signal1==3){
				p[i-1].signal2 = 4;
			}else{
				p[i-1].signal1 = 4;
			}
		}
	}
	
	public void draw(){
		p[3].k = (p[4].getY()-p[3].getY())/
				(p[4].getX()-p[3].getX());    //通过两点式计算出直线斜率k
		//x代入左边界值算出y的值
		b = p[3].k * (left-p[3].getX()) + p[3].getY();
	}

	public void paint(Graphics g){    //画点和线段
		super.paint(g);
		paintComponents(g);
	}
	
	public void paintComponents(Graphics g) {
		//super.paintComponents(g);
		//set(controll);
		
		//画出窗口		
		g.drawLine(left,top,left,400);    //画出窗口的四条边
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		
		g.fillOval((int)p[3].getX(), (int)p[3].getY(), 10, 10);   
		g.fillOval((int)p[4].getX(), (int)p[4].getY(), 10, 10);      //要把float型转换为int型
		g.fillOval(left, (int)b, 10, 10);
		g.drawLine((int)p[3].getX(), (int)p[3].getY(), (int)p[4].getX(), (int)p[4].getY());
	}
}
