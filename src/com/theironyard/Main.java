package com.theironyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String FILE_NAME = "People.txt";

    static ArrayList<Person> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(f);
        fileScanner.nextLine();

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
            list.add(person);
        }


    }
}
