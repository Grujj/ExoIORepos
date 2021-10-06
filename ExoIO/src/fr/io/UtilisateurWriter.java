package fr.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtilisateurWriter {

    public UtilisateurWriter() {
    }

    public static void writeUtilisateur(
            String unNomDeFichier, List<String> desNoms, List<String> desPrenoms, int combien
    ) throws IOException {

        BufferedWriter writer = null;

        try{
            /* Instanciation du writer */
            writer = new BufferedWriter(new FileWriter(unNomDeFichier));

            /* On melange la liste */
            Collections.shuffle(desNoms);
            Collections.shuffle(desPrenoms);

            for (int i = 0; i < combien; i++){
                String civilite = Math.random() >= 0.5 ? "Mr" : "Mme";
                String prenom = desPrenoms.get(getRandomIndex(desPrenoms.size()));
                String nom = desNoms.get(getRandomIndex(desNoms.size()));
                writer.write(i + ";" + civilite + ";" + nom + ";" + prenom);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }






    }

    private static int getRandomIndex(int listSize){
        Random r = new Random();
        return r.nextInt((listSize - 0) + 1) + 0;
    }
}
