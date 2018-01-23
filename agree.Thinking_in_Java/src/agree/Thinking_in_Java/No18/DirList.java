package agree.Thinking_in_Java.No18;

import java.io.*;
import java.util.*;
import java.util.regex.*;
//{Args:"E"}
public class DirList {
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
class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}
