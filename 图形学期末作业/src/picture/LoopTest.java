package picture;

public class LoopTest {
	int i;
	
	public LoopTest(){
		for(i=1;i<=10;i++){
			System.out.println(i);
			if(i == 4){
				System.out.println(i+1);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new LoopTest();
	}
}
