import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;




public class csvtoExcel {

    public static void main(String[] args){
        try(FileWriter fw = new FileWriter("/Users/azuga/Desktop/weather.XLSX")){
            fw.write(Files.readString(Path.of("/Users/azuga/Desktop/weather1.csv")));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
