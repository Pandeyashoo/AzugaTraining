package training.azuga.com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class unzip{

    public static void main(String[] args) throws Exception {
        String zipFileName = "/Users/azuga/desktop/Newfolder.zip";
        String destDirectory = "/Users/azuga/desktop/New";
        File destDirectoryFolder = new File(destDirectory);
        if (!destDirectoryFolder.exists()) {
            destDirectoryFolder.mkdir();
        }
        byte[] buffer = new byte[1024];
        ZipInputStream zis= new ZipInputStream(new FileInputStream(zipFileName));
        ZipEntry zipEntry = zis.getNextEntry();
        while(zipEntry !=null) {
            String filePath = destDirectory + File.separator + zipEntry.getName();
            System.out.println("Unzipping "+filePath);
            if(!zipEntry.isDirectory()) {
                FileOutputStream fos = new FileOutputStream(filePath);
                int len;
                while ((len = zis.read(buffer)) >0){
                    fos.write(buffer,0,len);
                }
                fos.close();
            }
            else {
                File dir = new File(filePath);
                dir.mkdir();
            }
            zis.closeEntry();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        System.out.println("Unzipping complete");

    }

}
