	package co.edu.unbosque.model;
	
	import java.io.File;
	import java.util.Properties;
	import java.util.Random;
	
	import javax.swing.JFileChooser;
	
	import co.edu.unbosque.model.persistence.LeerFile;
	import co.edu.unbosque.model.persistence.Propiedades;
	
	public class Tulio {
	    private String[] LetraOne;
	    private String[] LetraTwo;
	    private String[] LetraThree;
	    private String[] LetraFour;
	    private String[] LetraFive;
	    private String[] LetraSix;
	
	    public Tulio() {
	        LetraOne = new String[]{"MAMI", "BEBE", "PRINCESS", "MOR"};
	        LetraTwo = new String[]{"YO QUIERO", "YO PUEDO", "YO VENGO A", "VOY A"};
	        LetraThree = new String[]{"ENCENDERTE", "AMARTE", "LIGAR", "JUGAR"};
	        LetraFour = new String[]{"SUAVE", "AMARTE", "LIGAR", "JUGAR"};
	        LetraFive = new String[]{"HASTA QUE SALGA EL SOL", "TODA LA NOCHE", "HASTA EL AMANECER", "TODO EL DIA"};
	        LetraSix = new String[]{"SIN ANESTESIAR", "SIN COMPROMISO", "FEIS TO FEIS", "SIN MIEDO"};
	    }
	
	    public String lyrics() {
	        Random rand = new Random();
	        String letraOneWord = LetraOne[rand.nextInt(LetraOne.length)];
	        String letraTwoWord = LetraTwo[rand.nextInt(LetraTwo.length)];
	        String letraThreeWord = LetraThree[rand.nextInt(LetraThree.length)];
	        String letraFourWord = LetraFour[rand.nextInt(LetraFour.length)];
	        String letraFiveWord = LetraFive[rand.nextInt(LetraFive.length)];
	        String letraSixWord = LetraSix[rand.nextInt(LetraSix.length)];
	
	        return letraOneWord + " " + letraTwoWord + " " + letraThreeWord + " " + letraFourWord + " " + letraFiveWord + " " + letraSixWord;
	    }
	
	    public String generarSong(int nEstrofas, int nFrases) {
	        StringBuilder cancion = new StringBuilder();
	        for (int i = 0; i < nEstrofas; i++) {
	            for (int e = 0; e < nFrases; e++) {
	                String generarFrase = lyrics();
	                cancion.append(generarFrase).append("\n");
	            }
	            cancion.append("\n");
	        }
	        return cancion.toString();
	    }
	
	    public String gestionarArchivoCadena(int numEstrofas, int numFrasesPorEstrofa) {
	        LeerFile archivo = new LeerFile("c:\\data\\cancionRegueton.txt");
	        String cancion = generarSong(numEstrofas, numFrasesPorEstrofa);
	        archivo.escribirCancionEnArchivo(cancion);
	
	        return archivo.leerCancionDesdeArchivo();
	    }
	
	    public void gestionarPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
	        Propiedades prop = new Propiedades();
	        prop.escribirPropiedades(numEstrofas, numFrasesPorEstrofa);
	    }
	
	    public String seleccionarCancionYMostrar() {
	        JFileChooser fileChooser = new JFileChooser();
	        int seleccion = fileChooser.showOpenDialog(null);
	
	        if (seleccion == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            LeerFile archivo = new LeerFile(file.getAbsolutePath());
	            return archivo.leerCancionDesdeArchivo();
	        }
	        return null;
	    }
	
	    public void guardarCancionEnArchivo(String cancion) {
	        JFileChooser fileChooser = new JFileChooser();
	        int seleccion = fileChooser.showSaveDialog(null);
	
	        if (seleccion == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            LeerFile archivo = new LeerFile(file.getAbsolutePath());
	            archivo.escribirCancionEnArchivo(cancion);
	        }
	    }
	
	    public String crearCancionYGuardarConParametros() {
	        Propiedades propiedades = new Propiedades();
	        Properties props = propiedades.cargarPropiedades();
	
	        if (props != null) {
	            int numEstrofas = Integer.parseInt(props.getProperty("Numero de Estrofas"));
	            int numFrasesPorEstrofa = Integer.parseInt(props.getProperty("Numero de Frases por Estrofa"));
	
	            String cancion = gestionarArchivoCadena(numEstrofas, numFrasesPorEstrofa);
	            return cancion;
	        } else {
	            return "Error al cargar los parámetros. Asegúrate de definir los parámetros primero.";
	        }
	    }
}