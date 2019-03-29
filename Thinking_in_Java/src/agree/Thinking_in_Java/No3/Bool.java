package agree.Thinking_in_Java.No3;

import java.util.Random;

public class Bool {
	public static void main(String[] args) {
		Random rand = new Random(47);
		int i = rand.nextInt(100);
		int j = rand.nextInt(100);
		System.out.println("i = "+ i);
		System.out.println("j = "+ j);
		System.out.println(" i > j is "+(i>j));
		System.out.println(" i < j is "+(i<j));
		System.out.println(" i >= j is "+(i>=j));
		System.out.println(" i <= j is "+(i<=j));
		System.out.println(" i == j is "+(i==j));
		System.out.println(" i != j is "+(i!=j));
//!	System.out.println(" i && j is "+(i&&j));
//!	System.out.println(" i || j is "+(i||j));
//!	System.out.println("!i is "+(!i));
		System.out.println("(i<10)&&(j<10) is "+((i<10)&&(j<10)));
		System.out.println("(i<10)||(j<10) is "+((i<10)||(j<10)));
	}
}
