package fr.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NomPrenomReader {

    private static final String FICHIER_NOM = "ExoIO/src/resources/nom.txt";
    private static final String FICHIER_PRENOM = "ExoIO/src/resources/prenom.txt";

    /**
     * Methode qui lit un fichier et retourne ses lignes
     *
     * @param unNomDeFichier : String
     *
     * @return : List<String>
     */
    private static List<String> readFichier(String unNomDeFichier) {

        /* Instanciation des variables de list et du liseur de fichier */
        List<String> list = null;

        /* Essai la lecture de fichier */
        try{
            list = NomPrenomReader.getFileLines(unNomDeFichier);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Retourne la liste de ligne du fichier */
        return list;
    }

    /**
     * Methode qui recupere les lignes d un fichier
     *
     * @param unNomDeFichier : String
     *
     * @return : List<String>
     *
     * @throws IOException
     */
    private static List<String> getFileLines(String unNomDeFichier) throws IOException {

        /* Instanciation de la list de ligne, du lecteur de fichier et d une ligne */
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(unNomDeFichier));
        String ligne = null;

        /* Boucle dans le fichier et ajoute les lignes dans la liste */
        while ((ligne = reader.readLine()) != null){
            list.add(ligne);
        }

        /* Fermeture du flux du reader */
        NomPrenomReader.closeReader(reader);

        /* Retourne la liste de lignes */
        return list;
    }

    /**
     * Methode qui ferme le flux du reader
     *
     * @param reader : BufferedReader
     */
    private static void closeReader(BufferedReader reader){

        /* Si le reader est non null, on essaye de le fermer */
        try{
            if(reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode qui lit le fichier de nom
     *
     * @return : List<String>
     *
     * @throws IOException
     */
    public static List<String> readNom() throws IOException {
        return NomPrenomReader.readFichier(NomPrenomReader.FICHIER_NOM);
    }

    /**
     * Methode qui lit le fichier de prenom
     *
     * @return : List<String>
     *
     * @throws IOException
     */
    public static List<String> readPrenom() throws IOException {

        return NomPrenomReader.readFichier(NomPrenomReader.FICHIER_PRENOM);
    }
}
