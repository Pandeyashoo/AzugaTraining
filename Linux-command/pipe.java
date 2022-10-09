import java.io.*;
import java.nio.file.*;
import java.nio.file.Files; 
import java.util.*;

public class pipe{
		public static String cat(String path) {
			try {
				return  Files.readString(Path.of(path));//-used to read the text in the given path
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
                 public static void wc(String str) {
			String[] lines = str.split("\n\r|\r|\n");//split()nis splitting the given string
			System.out.print(lines.length+"\t");
			int j=0,k=0;
			while(j<lines.length){
			for(String ignored :lines[j].split(" ")) {
				k++;
			}
				j++;
			}
			System.out.print(k+"\t");
			int i=0;
			for(char ignored :str.toCharArray()) {
				i++;
			}
			System.out.println(i+"\t");
			
		}

		public static void sort(String str) {
			String[] lines = str.split("\n\r|\r|\n");
			List<String> ls = new ArrayList<>(Arrays.asList(lines));
			Collections.sort(ls);
			ls.forEach(System.out::println);
		}

		public static void main(String[] args) {
			String str = args[0];
			String []s = str.split(" ");
			if(s.length<=1) {
				System.out.println(cat(s[0]));
			}
			else if(s.length>=3){
			 if(s[0].equals("cat")&&s[2].equals("|")){
			switch(s[3]) {
			case "wc":
				wc(Objects.requireNonNull(cat(s[1])));
				break;
			case "sort":
				sort(Objects.requireNonNull(cat(s[1])));
				break;
			default:
				System.out.println("option does not match");
			}
			}
			else
			System.out.println("| is not used");
			}
			else
			System.out.println("arguments are not sufficient");
	}
}