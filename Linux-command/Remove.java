import java.io.*;
public class Remove{
public static void main(String []args) {
		File f = new File(args[0]);
		String arr[] = f.list();
		if 
;
(arr.length > 0)
			System.out.println("Cannot be Deleted,it contains some files");
		else {
			f.delete();
			System.out.println("File deleted successfull");
		}
	}
}
