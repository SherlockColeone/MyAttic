package shift;

public class Point {
	float x;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	float y;
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	float x1;
	public float getX1() {
		return x1;
	}
	public void setX1(float x1) {
		this.x1 = x1;
	}
	
	float y1;
	public float getY1() {
		return y1;
	}
	public void setY1(float y1) {
		this.y1 = y1;
	}
	
	float x2;	
	public float getX2() {
		return x2;
	}
	public void setX2(float x2) {
		this.x2 = x2;
	}
	
	float y2;
	public float getY2() {
		return y2;
	}
	public void setY2(float y2) {
		this.y2 = y2;
	}

	float k;     //直线的斜率
	public float getK() {
		return k;
	}
	public void setK(float k) {
		this.k = k;
	}
	
	int mark;    //标记是否在窗口内
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	int point = 0;   //标记交点数量	
	float yLeft,yRight;   //代入左或右边界时y的值
	float xTop,xBottom;   //代入上或下边界时x的值
	int signal1;
	int signal2;
}
