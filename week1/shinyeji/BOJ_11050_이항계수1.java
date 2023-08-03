import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 0;
		int value[] = {1,1,1}; 
		for(int i=1;i<=a;i++) {
			value[0] *= i;
			if(i <= b) {
				value[1] *= i;
			}	
			if((a-b)!=0 && i<=a-b) {
				value[2]*=i;
			}
		}
		result = value[0] / (value[1] * value[2]);
		System.out.println(result);
		
	}

}