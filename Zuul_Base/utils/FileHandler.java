package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandler {
    private String basePath;

    public FileHandler(String baseFolder){
        this.basePath = (!baseFolder.equals(""))? String.format("./%s/", baseFolder): "./";
    }

    public ArrayList<String> readFile(String fileName) {
        ArrayList<String> content = new ArrayList<>();

        try {
            File file = new File(String.format("%s%s", basePath, fileName));
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null){
                content.add(line);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Archivo " + fileName + " no encontrado");
        }

        return content;
    }

    public void writeFile(String fileName, ArrayList<String> content) {
        
        try {
            if (content.size() > 0) {
                File file = new File(String.format("%s%s", basePath, fileName));
                FileWriter writer = new FileWriter(file);

                for (String line : content) {
                    writer.write(line + "\n");
                }

                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Archivo " + fileName + " no pudo ser guardado");
        }
    }
}