package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

    private Properties properties = new Properties();
    private String archivoProperties = "C:\\data\\regueton.properties";

    public void escribirPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
        try (FileOutputStream output = new FileOutputStream(archivoProperties)) {
            properties.setProperty("Numero de Estrofas", String.valueOf(numEstrofas));
            properties.setProperty("Numero de Frases por Estrofa", String.valueOf(numFrasesPorEstrofa));
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Properties cargarPropiedades() {
        try (FileInputStream input = new FileInputStream(archivoProperties)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return properties;
    }
}