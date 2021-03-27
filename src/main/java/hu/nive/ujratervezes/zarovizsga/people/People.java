package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people = new ArrayList<>();

    public int getNumberOfMales(String path) {
        return readFile(path);
    }

    private int readFile(String fileName) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            int numberOfMales = 0;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[4].equals("Male")) {
                    numberOfMales++;
                }
            }
            return numberOfMales;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int getNumberOfMalesOther(String fileName) {
        readFromFile(fileName);
        int counter = 0;
        for (Person p : people) {
            if (p.getGender().equals("Male")) {
                counter++;
            }
        }
        return counter;
    }


    private Person processLine(String line) {
        String[] parts = line.split(",");
        return new Person(Long.parseLong(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
    }

    private void readFromFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Person p = processLine(line);
                people.add(p);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
