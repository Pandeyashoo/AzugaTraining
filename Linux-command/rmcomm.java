import java.io.*;
import java.nio.file.Files;


public class rmcomm{
public static void main(String []args) {
		File f = new File(args[0]);
		if (f.delete())
			System.out.println("File removed successfully");
		else
			System.out.println("Error in removing file or File doesnot exist");
	}
}
