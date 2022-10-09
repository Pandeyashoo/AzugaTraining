import java.io.File;
import java.nio.file.Files;
 public class cpcommand{
   public static void main(String[] args){
    File org=new File(args[0]);
    File dup=new File(args[1]);
  try{
     Files.copy(org.toPath(),dup.toPath());
     System.out.println("contents copied successfully");
 }
 catch(Exception e){
  //System.out.println("There is Error");
}
}
}