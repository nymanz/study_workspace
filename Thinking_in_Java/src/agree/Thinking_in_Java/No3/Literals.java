package agree.Thinking_in_Java.No3;

public class Literals {
	public static void main(String[] args) {
		int i1 = 0x2f;
		System.out.println("i1: "+Integer.toBinaryString(i1));
		int i2 = 0X2F;
		System.out.println("i2: "+Integer.toBinaryString(i2));
		int i3 = 0177;
		System.out.println("i3: "+Integer.toBinaryString(i3));
		char c = 0xffff;
		System.out.println("c: "+Integer.toBinaryString(c));
		byte b = 0x7f;
		System.out.println("b: "+Integer.toBinaryString(b));
		short s = 0x7fff;
		System.out.println("s: "+Integer.toBinaryString(s));
		Long n1=200L;
		Long n2=200l;
		//Long n3=200;
		float f1=1;
		float f2=1F;
		float f3=1f;
		double d1=1d;
		double d2=1D;
		
	}
}
