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
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {
	int left,right,top,bottom;     //定义四条边界
	Graphics g;
	Point[] p = new Point[6];      //定义对象数组，大小为多边形点数加一
	int i;
	//int controll;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setTitle("\u5B9E\u9A8C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button裁剪 = new JButton("\u5F00\u59CB\u88C1\u526A");
		button裁剪.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controll = 1;
				//System.out.println(controll);
				//Test frame = new Test();
				Polygon frameP = new Polygon();
				Test frameT = new Test();
				frameT.setVisible(true);
				frameP.setVisible(false);
			}
		});
		button裁剪.setBounds(379, 353, 130, 37);
		contentPane.add(button裁剪);
		
		JButton button返回 = new JButton("\u8FD4\u56DE\u539F\u591A\u8FB9\u5F62");
		button返回.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controll = 0;
				//System.out.println(controll);
				//Polygon frame = new Polygon();
				Polygon frameP = new Polygon();
				Test frameT = new Test();
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
		p[3].setY(320);
		
		p[4] = new Point();
		p[4].setX(100);
		p[4].setY(250);
		
		p[5] = new Point();         //创建最后一个数组避免计算时出现空数组而出错
		p[5].setX(p[0].getX());     //第一个数组的x、y赋给最后一个数组
		p[5].setY(p[0].getY());
		//p[5].setK(p[0].getK());
		//p[5].setMark(p[0].getMark());
		//p[5].point = p[0].point;
	}
	
	/*public void formulary(){     //求出多边形各边的方程式		
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //通过两点式计算出直线斜率
			
		//开始判断在哪条边界有交点
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();     //算出y的值
		if(p[i-1].yLeft>=top&&p[i-1].yLeft<=bottom){
			p[i-1].point = p[i-1].point + 1;        //标记交点的值加一
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				System.out.println("Left:x的值："+p[i-1].getX1());
				System.out.println("Left:y的值："+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				System.out.println("Left:x的值："+p[i-1].getX2());
				System.out.println("Left:y的值："+p[i-1].getY2());
			}
		}
			
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();
		if(p[i-1].yRight>=top&&p[i-1].yRight<=bottom){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				System.out.println("Right:x的值："+p[i-1].getX1());
				System.out.println("Right:y的值："+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				System.out.println("Right:x的值："+p[i-1].getX2());
				System.out.println("Right:y的值："+p[i-1].getY2());
			}
		}
			
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();     //算出x的值
		if(p[i-1].xTop>=left&&p[i-1].xTop<=right){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				System.out.println("Top:x的值："+p[i-1].getX1());
				System.out.println("Top:y的值："+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				System.out.println("Top:x的值："+p[i-1].getX2());
				System.out.println("Top:y的值："+p[i-1].getY2());
			}
		}
			
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xBottom>=left&&p[i-1].xBottom<=right){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				System.out.println("Bottom:x的值："+p[i-1].getX1());
				System.out.println("Bottom:y的值："+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				System.out.println("Bottom:x的值："+p[i-1].getX2());
				System.out.println("Bottom:y的值："+p[i-1].getY2());
			}
		}
			
		System.out.println();
		//System.out.println("i的值："+(i-1));
		System.out.println(" k的值："+p[i-1].k);
		//System.out.println("y的值："+y);
		//System.out.println("x的值："+x);
		System.out.println("left:"+left);
		System.out.println("right:"+right);
		System.out.println("top:"+top);
		System.out.println("bottom:"+bottom);
		System.out.println("数组"+(i-1)+"中y1的值："+p[i-1].getY1());
		System.out.println("数组"+(i-1)+"中x1的值："+p[i-1].getX1());
		System.out.println("数组"+(i-1)+"中y2的值："+p[i-1].getY2());
		System.out.println("数组"+(i-1)+"中x2的值："+p[i-1].getX2());			
		System.out.println("交点多少个："+p[i-1].point);	
	}*/
	
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
		System.out.println("方法judge");
		for(i=0;i<p.length;i++){
			System.out.println("i的值"+i);
			if(p[i].getX()>left&&p[i].getX()<right             //判断点是否在窗口内，然后进行标记
					&&p[i].getY()>top&&p[i].getY()<bottom){
				p[i].mark = 0;    //若点在内标记为0
			}else {
				p[i].mark = 1;    //若点在外标记为1
			}
			
			if(i>=1){
				System.out.println("数组"+(i-1)+"mark为："+p[i-1].mark);
				System.out.println("数组"+i+"mark为："+p[i].mark);
				if(p[i-1].mark==0&&p[i].mark==0){     //该情况下两点均在窗口内
					p[i-1].setY1(p[i-1].getY());
					p[i-1].setX1(p[i-1].getX());
					p[i-1].setY2(p[i].getY());
					p[i-1].setX2(p[i].getX());
					System.out.println("x1的值："+p[i-1].getX1());
					System.out.println("y1的值："+p[i-1].getY1());
					System.out.println("x2的值："+p[i-1].getX2());
					System.out.println("y2的值："+p[i-1].getY2());				
					System.out.println("该情况下两点均在窗口内");
					System.out.println();
				}else if(p[i-1].mark==0&&p[i].mark==1||p[i-1].mark==1&&p[i].mark==0){     //该情况下一点在内，一点在外
					//需判断哪点在内，哪点在外
					if(p[i-1].mark==0){      //该情况下前一点在内
						p[i-1].setX1(p[i-1].getX());
						p[i-1].setY1(p[i-1].getY());
						System.out.println("该情况下前一点在内");
						System.out.println("x1的值："+p[i-1].getX1());
						System.out.println("y1的值："+p[i-1].getY1());
					}else{      //否则后一点在内
						p[i-1].setX2(p[i].getX());
						p[i-1].setY2(p[i].getY());
						System.out.println("该情况下后一点在内");
						System.out.println("x2的值："+p[i-1].getX2());
						System.out.println("y2的值："+p[i-1].getY2());
					}
					intersect();
					execute();
					
					System.out.println("该情况下一点在内，一点在外");
					System.out.println();
				}else if(p[i-1].mark==1&&p[i].mark==1){     //该情况下两点均在外
					intersect();               //先计算出交点值
					if(p[i-1].point==2){       //该情况下有两交点
						//需判断交点在哪条边界上
						execute();
						
						System.out.println("该情况下有两交点");
						System.out.println();
					}else if(p[i-1].point==0){     //该情况下无交点
						//无须操作
						
						System.out.println("该情况下无交点");
						System.out.println();
					}
				}
			}
		}	
	}
	
	public void intersect(){         //用于计算交点的数量
		System.out.println("方法intersect");
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //通过两点式计算出直线斜率
		
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();     //x代入左边界值算出y的值
		if(p[i-1].yLeft>=p[i-1].getY()&&p[i-1].yLeft<=p[i].getY()
				||p[i-1].yLeft<=p[i-1].getY()&&p[i-1].yLeft>=p[i].getY()){  //此处判断的条件为y值是否在两点的区间内，若是这说明有交点，若无这说明无交点
			p[i-1].point = p[i-1].point + 1;        //标记交点的值加一
			p[i-1].signal1 = 1;
			System.out.println("intersect:Left已执行");
		}
		
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();   //x代入右边界值算出y值
		if(p[i-1].yRight>=p[i-1].getY()&&p[i-1].yRight<=p[i].getY()
				||p[i-1].yRight<=p[i-1].getY()&&p[i-1].yRight>=p[i].getY()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1){
				p[i-1].signal2 = 2;
			}else{
				p[i-1].signal1 = 2;
			}
			System.out.println("intersect:Right已执行");
		}
		
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();     //y代入上边界值算出x的值
		if(p[i-1].xTop>=p[i-1].getX()&&p[i-1].xTop<=p[i].getX()
				||p[i-1].xTop<=p[i-1].getX()&&p[i-1].xTop>=p[i].getX()){    //此处判断的条件为x值是否在两点的区间内
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2){
				p[i-1].signal2 = 3;
			}else{
				p[i-1].signal1 = 3;
			}
			System.out.println("intersect:Top已执行");
		}
		
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX(); //y代入下边界值算出x值
		if(p[i-1].xBottom>=p[i-1].getX()&&p[i-1].xBottom<=p[i].getX()
				||p[i-1].xBottom<=p[i-1].getX()&&p[i-1].xBottom>=p[i].getX()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2||p[i-1].signal1==3){
				p[i-1].signal2 = 4;
			}else{
				p[i-1].signal1 = 4;
			}
			System.out.println("intersect:Bottom已执行");
		}
		
		System.out.println("斜率k的值："+p[i-1].k);
		System.out.println("交点多少个："+p[i-1].point);
		System.out.println("signal1为："+p[i-1].signal1);
		System.out.println("signal2为："+p[i-1].signal2);
	}
	
	public void execute(){         //intersect()算完交点后用于赋值
		System.out.println("方法execute");
		if(p[i-1].point==1){
			switch(p[i-1].signal1){
			case 1 :                  //左边界时赋值
				System.out.println("数组x2的值："+p[4].getX2());
				System.out.println("数组y2的值："+p[4].getY2());
				assign(1);
				System.out.println("assgin1已执行");
				System.out.println("数组x2的值："+p[4].getX2());
				System.out.println("数组y2的值："+p[4].getY2());
				break;
			case 2 :                  //右边界时赋值
				assign(2);
				System.out.println("assgin2已执行");
				break;
			case 3 :                  //上边界时赋值
				assign(3);
				System.out.println("assgin3已执行");
				break;
			case 4 :                   //下边界时赋值
				assign(4);
				System.out.println("assgin4已执行");
				System.out.println("数组x2的值："+p[4].getX2());
				System.out.println("数组y2的值："+p[4].getY2());
				break;
			}
			System.out.println("signal1!");
			System.out.println("数组"+(i-1)+"中x1的值："+p[i-1].getX1());
			System.out.println("数组"+(i-1)+"中y1的值："+p[i-1].getY1());
			System.out.println("数组"+(i-1)+"中x2的值："+p[i-1].getX2());
			System.out.println("数组"+(i-1)+"中y2的值："+p[i-1].getY2());
		}else if(p[i-1].point==2){
			switch(p[i-1].signal1){
			case 1 :
				assign(1);
				System.out.println("assgin1已执行");
				break;
			case 2 :
				assign(2);
				System.out.println("assgin2已执行");
				break;
			case 3 :
				assign(3);
				System.out.println("assgin3已执行");
				break;
			case 4 :
				assign(4);
				System.out.println("assgin4已执行");
				break;
			}
			System.out.println("signal 1,2:signal 1!");
			System.out.println("数组"+(i-1)+"中x1的值："+p[i-1].getX1());
			System.out.println("数组"+(i-1)+"中y1的值："+p[i-1].getY1());
			System.out.println("数组"+(i-1)+"中x2的值："+p[i-1].getX2());
			System.out.println("数组"+(i-1)+"中y2的值："+p[i-1].getY2());
			
			switch(p[i-1].signal2){
			case 1 :
				assign(1);
				System.out.println("assgin1已执行");
				break;
			case 2 :
				assign(2);
				System.out.println("assgin2已执行");
				break;
			case 3 :
				assign(3);
				System.out.println("assgin3已执行");
				break;
			case 4 :
				assign(4);
				System.out.println("assgin4已执行");
				break;
			}
			System.out.println("signal 1,2:signal 2!");
			System.out.println("数组"+(i-1)+"中x1的值："+p[i-1].getX1());
			System.out.println("数组"+(i-1)+"中y1的值："+p[i-1].getY1());
			System.out.println("数组"+(i-1)+"中x2的值："+p[i-1].getX2());
			System.out.println("数组"+(i-1)+"中y2的值："+p[i-1].getY2());
		}
		/*System.out.println("边界left:"+left);
		System.out.println("边界right:"+right);
		System.out.println("边界top:"+top);
		System.out.println("边界bottom:"+bottom);*/
		/*System.out.println("数组"+(i-1)+"中x1的值："+p[i-1].getX1());
		System.out.println("数组"+(i-1)+"中y1的值："+p[i-1].getY1());
		System.out.println("数组"+(i-1)+"中x2的值："+p[i-1].getX2());
		System.out.println("数组"+(i-1)+"中y2的值："+p[i-1].getY2());*/
	}
	
	public void assign(int a){        //用于赋值
		System.out.println("方法assgin");
		switch(a){
		case 1 :                  //左边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				System.out.println("Left:x的值："+p[i-1].getX1());
				System.out.println("Left:y的值："+p[i-1].getY1());
				System.out.println("x2的值："+p[4].getX2());
				System.out.println("y2的值："+p[4].getY2());
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				System.out.println("Left:x的值："+p[i-1].getX2());
				System.out.println("Left:y的值："+p[i-1].getY2());
				System.out.println("x2的值："+p[4].getX2());
				System.out.println("y2的值："+p[4].getY2());
				break;
			}
		case 2 :                  //右边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				System.out.println("Right:x的值："+p[i-1].getX1());
				System.out.println("Right:y的值："+p[i-1].getY1());
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				System.out.println("Right:x的值："+p[i-1].getX2());
				System.out.println("Right:y的值："+p[i-1].getY2());
				break;
			}
		case 3 :                  //上边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				System.out.println("Top:x的值："+p[i-1].getX1());
				System.out.println("Top:y的值："+p[i-1].getY1());
				break;
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				System.out.println("Top:x的值："+p[i-1].getX2());
				System.out.println("Top:y的值："+p[i-1].getY2());
				break;
			}
		case 4 :                   //下边界时赋值
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				System.out.println("Bottom:x的值："+p[i-1].getX1());
				System.out.println("Bottom:y的值："+p[i-1].getY1());
				System.out.println("x2的值："+p[4].getX2());
				System.out.println("y2的值："+p[4].getY2());
				break;
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				System.out.println("Bottom:x的值："+p[i-1].getX2());
				System.out.println("Bottom:y的值："+p[i-1].getY2());
				System.out.println("x2的值："+p[4].getX2());
				System.out.println("y2的值："+p[4].getY2());
				break;
			}
		}
	}
	
	public void paint(Graphics g){    //画点和线段
		super.paint(g);
		paintComponents(g);
		/* 
		//画出窗口		
		g.drawLine(left,top,left,bottom);    //画出窗口的四条边
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		
		switch(controll){
		case 0 :
			//画出多边形
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //要把float型转换为int型
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		case 1 :
			//形成交点并形成新的线段
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
				g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
				g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
						(int)p[i].getX2(), (int)p[i].getY2());
			}
		}
		
		if(controll==0){
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //要把float型转换为int型
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		}else{
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //要把float型转换为int型
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		}*/
	}
	
	public void paintComponents(Graphics g) {
		//super.paintComponents(g);
		
		//画出窗口		
		g.drawLine(left,top,left,bottom);    //画出窗口的四条边
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		
		/*switch(controll){
		case 0 :
			//画出多边形
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //要把float型转换为int型
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
			break;
		case 1 :
			//形成交点并形成新的线段，完成裁剪
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
				g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
				g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
						(int)p[i].getX2(), (int)p[i].getY2());
			}
			break;
		}*/
		
		//形成交点并形成新的线段，完成裁剪
		for(int i=0;i<p.length-1;i++){
			g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
			g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
			g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
					(int)p[i].getX2(), (int)p[i].getY2());
		}
	}
}
