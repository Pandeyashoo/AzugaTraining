import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class catcommand
{
    public static void main(String[] args) 
    {
        try
        {            
            File f=new File(args[0]);
            BufferedReader reader=new BufferedReader(new FileReader(f));
          String line;
       while((line=reader.readLine())!= null){
             System.out.println(line);
		}
        } 
        catch(IOException e)
        {
                
        }

    }
}