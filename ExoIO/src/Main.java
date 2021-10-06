import fr.io.NomPrenomReader;
import fr.io.UtilisateurWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        UtilisateurWriter.writeUtilisateur("ExoIO/src/resources/resulat.txt", NomPrenomReader.readNom(), NomPrenomReader.readPrenom(), 5);
    }
}
