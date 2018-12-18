package shift;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shift extends JFrame {
	public int left,right,top,bottom;     //定义四条边界
	Graphics g;
	Point[] p = new Point[6];      //定义对象数组，大小为多边形点数加一
	int i;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shift frame = new Shift();
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
	public Shift() {
		setTitle("\u591A\u8FB9\u5F62\u88C1\u526A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button裁剪 = new JButton("\u5F00\u59CB\u88C1\u526A");
		button裁剪.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShiftP frameP = new ShiftP();
				Shift frameT = new Shift();
				frameT.setVisible(true);
				frameP.setVisible(false);
			}
		});
		button裁剪.setBounds(379, 353, 130, 37);
		contentPane.add(button裁剪);
		
		JButton button返回 = new JButton("\u8FD4\u56DE\u539F\u591A\u8FB9\u5F62");
		button返回.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShiftP frameP = new ShiftP();
				Shift frameT = new Shift();
				frameP.setVisible(true);
				frameT.setVisible(false);
			}
		});
		button返回.setBounds(172, 353, 130, 37);
		contentPane.add(button返回);
		setWindow(140,550,100,300);
		setPolygon();
		judge();	
	}
	
	public void setWindow(int l,int r,int t,int b){    //用于设置边界值
		left = l;       //左边界
		right = r;      //右边界
		top = t;        //上边界
		bottom = b;     //下边界
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
		p[3].setY(320);
		
		p[4] = new Point();
		p[4].setX(100);
		p[4].setY(250);
		
		p[5] = new Point();         //创建最后一个数组避免计算时出现空数组而出错
		p[5].setX(p[0].getX());     //第一个数组的x、y赋给最后一个数组
		p[5].setY(p[0].getY());
	}
	
	/*
	* 一线段与窗口有四种情况：
	* 1、线段两点均在窗口内，此时无交点
	* 新的线段通过两点连接起来
	* 2、线段一点在窗口内，一点在外，此时仅有一个交点
    * 新的线段通过窗口内的点与交点连接起来
	* 3、线段两点均在窗口外且无交点
	* 无需画出新的线段
	* 4、线段两点均在窗口外且有两交点
	* 新的线段通过两交点连接起来
	*/	
	
	public void judge(){    //判断多边形哪些点在窗口内，哪些在窗口外，并计算出交点
		for(i=0;i<p.length;i++){
			if(p[i].getX()>left&&p[i].getX()<right             //判断点是否在窗口内，然后进行标记
					&&p[i].getY()>top&&p[i].getY()<bottom){
				p[i].mark = 0;    //若点在内标记为0
			}else {
				p[i].mark = 1;    //若点在外标记为1
			}			
			if(i>=1){
				if(p[i-1].mark==0&&p[i].mark==0){     //该情况下两点均在窗口内
					p[i-1].setY1(p[i-1].getY());
					p[i-1].setX1(p[i-1].getX());
					p[i-1].setY2(p[i].getY());
					p[i-1].setX2(p[i].getX());
				}else if(p[i-1].mark==0&&p[i].mark==1||p[i-1].mark==1&&p[i].mark==0){     //该情况下一点在内，一点在外
					//需判断哪点在内，哪点在外
					if(p[i-1].mark==0){      //该情况下前一点在内
						p[i-1].setX1(p[i-1].getX());
						p[i-1].setY1(p[i-1].getY());
					}else{                   //否则后一点在内
						p[i-1].setX2(p[i].getX());
						p[i-1].setY2(p[i].getY());
					}
					intersect();
					execute();
				}else if(p[i-1].mark==1&&p[i].mark==1){     //该情况下两点均在外
					intersect();                 //先计算出交点值
					if(p[i-1].point==2){         //该情况下有两交点
						execute();               //需判断交点在哪条边界上
					}                            //否则无交点，无须操作
				}
			}
		}	
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
	
	public void execute(){         //intersect()算完交点后用于赋值
		if(p[i-1].point==1){
			switch(p[i-1].signal1){
			case 1 :                  //左边界时赋值
				assign(1);
				break;
			case 2 :                  //右边界时赋值
				assign(2);
				break;
			case 3 :                  //上边界时赋值
				assign(3);
				break;
			case 4 :                   //下边界时赋值
				assign(4);
				break;
			}
		}else if(p[i-1].point==2){
			switch(p[i-1].signal1){
			case 1 :
				assign(1);
				break;
			case 2 :
				assign(2);
				break;
			case 3 :
				assign(3);
				break;
			case 4 :
				assign(4);
				break;
			}
			switch(p[i-1].signal2){
			case 1 :
				assign(1);
				break;
			case 2 :
				assign(2);
				break;
			case 3 :
				assign(3);
				break;
			case 4 :
				assign(4);
				break;
			}
		}
	}
	
	public void assign(int a){        //用于赋值
		switch(a){
		case 1 :                  //左边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				break;
			}
		case 2 :                  //右边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				break;
			}
		case 3 :                  //上边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				break;
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				break;
			}
		case 4 :                   //下边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				break;
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				break;
			}
		}
	}
	
	public void paint(Graphics g){           //画点和线段
	    //画出窗口
		g.drawLine(left,top,left,bottom);    //画出窗口的四条边
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		//画出多边形
		/*for(int i=0;i<p.length-1;i++){
			g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);    //要把float型转换为int型
			g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
					(int)p[i+1].getX(), (int)p[i+1].getY());
		}*/		
		//形成交点并形成新的线段，裁剪完成
		for(int i=0;i<p.length-1;i++){
			g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
			g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
			g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
					(int)p[i].getX2(), (int)p[i].getY2());
		}
	}	
}
