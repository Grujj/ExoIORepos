import fr.io.NomPrenomReader;
import fr.io.UtilisateurWriter;

import java.io.IOException;

public class Main {

    public static final String FILE = "ExoIO/src/resources/resultat.txt";

    public static void main(String[] args) {

        try{
            UtilisateurWriter.writeUtilisateur(Main.FILE, NomPrenomReader.readNom(), NomPrenomReader.readPrenom(), 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
