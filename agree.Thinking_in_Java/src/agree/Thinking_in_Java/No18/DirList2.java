package agree.Thinking_in_Java.No18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir,String name){
				return pattern.matcher(name).matches();
			}
		};
	}
	public static void main(String[] args) {
		File path = new File("./src/agree/Thinking_in_Java/No18");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
