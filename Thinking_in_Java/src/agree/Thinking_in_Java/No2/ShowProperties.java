package agree.Thinking_in_Java.No2;

public class ShowProperties {
	public static void main(String[] args) {
		//从运行程序的系统中获取所有“属性”
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}
}
