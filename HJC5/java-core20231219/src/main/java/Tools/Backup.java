package Tools; 
 
import java.io.*; 
import java.nio.file.*; 
 
public class Backup { 
    public static void backupFiles(String directoryPath) { 
        Path dirPath = Paths.get(directoryPath);
        File directory = dirPath.toFile(); 
        File[] files = directory.listFiles(File::isFile); 
        if (files == null) { 
            System.out.println("Ошибка. Файлы не найдены."); 
            return; 
        } 
 
        Path backupDir = dirPath.resolve("backup");
        if (!Files.exists(backupDir)) { 
            try {
                Files.createDirectory(backupDir);
            } catch (IOException e) {
                System.out.println("Резервного копирования не удалось.");
                return;
            }
        } 
 
        for (File file : files) { 
            Path source = file.toPath(); 
            Path destination = backupDir.resolve(file.getName()); 
            try { 
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING); 
                System.out.println("Создана резервная копия для: " + file.getName()); 
            } catch (IOException e) { 
                System.out.println("Не удалось создать резервную копию для: " + file.getName()); 
            } 
        } 
    } 
}