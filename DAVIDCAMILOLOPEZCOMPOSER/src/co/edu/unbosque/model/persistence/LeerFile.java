package co.edu.unbosque.model.persistence;

import java.io.*;

public class LeerFile {
    private String filePath;

    public LeerFile(String filePath) {
        this.filePath = filePath;
    }

    public boolean escribirCancionEnArchivo(String cancion) {
        File file = new File(this.filePath);

        try (FileWriter fileWriter = new FileWriter(file);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(cancion);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String leerCancionDesdeArchivo() {
        String cancion = "";
        String linea = "";

        File file = new File(this.filePath);

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            linea = bufferedReader.readLine();
            while (linea != null) {
                cancion += linea + "\n";
                linea = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return cancion;
    }
}