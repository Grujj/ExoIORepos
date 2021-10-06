package fr.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NomPrenomReader {

    public NomPrenomReader() {
    }

    private static List<String> readFichier(String unNomDeFichier) throws IOException {

        BufferedReader reader = null;
        List<String> list = new ArrayList<>();

        try{
            System.out.println();
            reader = new BufferedReader(new FileReader(unNomDeFichier));
            String ligne = null;
            while ((ligne = reader.readLine()) != null){
                list.add(ligne);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public static List<String> readNom() throws IOException {

        return NomPrenomReader.readFichier("ExoIO/src/resources/nom.txt");
    }

    public static List<String> readPrenom() throws IOException {

        return NomPrenomReader.readFichier("ExoIO/src/resources/prenom.txt");
    }
}
