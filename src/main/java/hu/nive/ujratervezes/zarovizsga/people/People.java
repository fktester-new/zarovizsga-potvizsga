package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

   public int getNumberOfMales(String path){
        return readFilw(path);
   }

   private int readFilw(String fileName){

       try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
           String line;
           int numberOfMales = 0;
           while ((line = reader.readLine())  != null) {
               String[] parts = line.split(",");
               if (parts[4].equals("Male")){
                   numberOfMales++;
               }
           }
           return numberOfMales;
       } catch (IOException ioe) {
           throw new IllegalStateException("Can not read file", ioe);
       }
   }
}
