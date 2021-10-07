package fr.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtilisateurWriter {

    private final static String CIVILITE_MR = "Mr";
    private final static String CIVILITE_MME = "Mme";
    private final static String SEPARATEUR = ";";

    /**
     * Methode qui ecrit un utilisateur dans un fichier
     *
     * @param unNomDeFichier : String
     * @param desNoms : List<String>
     * @param desPrenoms : List<String>
     * @param combien : int
     *
     * @throws IOException
     */
    public static void writeUtilisateur(
            String unNomDeFichier, List<String> desNoms, List<String> desPrenoms, int combien
    ) throws IOException {

        /* Instanciation du flux d ecriture a null */
        BufferedWriter writer = null;

        try{
            /* Instanciation du flux d ecriture en BufferedWriter */
            writer = new BufferedWriter(new FileWriter(unNomDeFichier));

            /* Determine le numero de ligne, la civilite, le nom, le prenom et l ecrit dans le fichier resultat au format csv */
            for (int numeroDeLigne = 0; numeroDeLigne < combien; numeroDeLigne++){

                String civilite = UtilisateurWriter.getRandomCivilite();
                String nom = UtilisateurWriter.getRandomStringInList(desNoms);
                String prenom = UtilisateurWriter.getRandomStringInList(desPrenoms);
                writer.write(UtilisateurWriter.formatCSV(String.valueOf(numeroDeLigne),civilite,nom,prenom));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    /**
     * Methode qui determine la civilite
     *
     * @return : String
     */
    private static String getRandomCivilite(){
        return Math.random() >= 0.5 ? UtilisateurWriter.CIVILITE_MR : UtilisateurWriter.CIVILITE_MME;
    }

    /**
     * Methode qui recupere une string au hasard dans un tableau
     *
     * @param list : List<String>
     *
     * @return : String
     */
    private static String getRandomStringInList(List<String> list){
        return list.get(UtilisateurWriter.getRandomIndex(list.size()));
    }

    /**
     * Recupere un index au hasard a partir d un maximum
     *
     * @param max : int
     *
     * @return : int
     */
    private static int getRandomIndex(int max){
        Random r = new Random();
        return r.nextInt((max - 0) + 1) + 0;
    }

    /**
     * Methode qui format en CSV
     *
     * @param listStrings : String
     *
     * @return : String
     */
    private static String formatCSV(String... listStrings){

        /* Initialisation de la string formatee */
        StringBuilder formatedString = new StringBuilder();

        /* Ajout d une string a la string formatee avec son separateur */
        for (String str : listStrings)
            formatedString.append(str).append(UtilisateurWriter.SEPARATEUR);

        /* Retourne la string formatee en supprimant le dernier separateur inutile */
        return formatedString.substring(0, formatedString.length() - 1);
    }
}
