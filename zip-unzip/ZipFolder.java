package training.azuga.com;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Source code to create a zip file from a given folder
// This example program recursively adds all files in the folder
public class ZipFolder {
    public static void main(String[] args) throws Exception {
        ZipFolder zf = new ZipFolder();
        String folderToZip = "/Users/azuga/desktop/Newfolder";
        String zipName = "/Users/azuga/desktop/Newfolder.zip";
        zf.zipFolder(Paths.get(folderToZip), Paths.get(zipName));
    }

    // Uses java.util.zip to create zip file
    private void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
                Files.copy(file, zos);
                zos.closeEntry();
                return FileVisitResult.CONTINUE;
            }
        });
        zos.close();
    }
}