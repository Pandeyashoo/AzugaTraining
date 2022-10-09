import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
 
public class moveex
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter source  address");
        String source = sc.nextLine();
        System.out.println("Enter destination address");
        String destination = sc.nextLine();
        Path temp = Files.move
        (Paths.get(source),
        Paths.get(destination));
 
        if(temp != null)
        {
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
}
