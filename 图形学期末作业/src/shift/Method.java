package shift;

public class Method {
	float x,y;
	int sum;
	int s1 = 1;
	int s2 = 2;
	
	public void a(){
		switch(s1){
		case 1 :
			System.out.println(1);
			break;
		case 2 :
			System.out.println(2);
			break;
		case 3 :
			System.out.println(3);
			break;
		}
		switch(s2){
		case 1 :
			System.out.println(1);
			break;
		case 2 :
			System.out.println(2);
			break;
		case 3 :
			System.out.println(3);
			break;
		}
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	float k;
	public void cal(float x1,float y1,float x2,float y2){
		k = (y2-y1) / (x2-x1);
		System.out.println("k="+k);
		//x = (y-y2) / k + x2;
		y = (x-x2) * k + y2;
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
	
	public Method(){
		a();
		setX(140);
		//setY(300);
		cal(200,150,100,250);
	}
	
	public static void main(String[] args) {
		new Method();
	}
}
