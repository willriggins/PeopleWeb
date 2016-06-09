package com.theironyard;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
        Spark.staticFileLocation("public");
        Spark.init();
        Spark.get(
                "/",
                (request, response) -> {
                    HashMap m = new HashMap();

                    int offset = 0;
                    String offStr = request.queryParams("offset");

                    if (offStr != null) {
                        offset = Integer.valueOf(offStr);
                    }

                    ArrayList<Person> arr = new ArrayList<>(list.subList(offset, offset + 20));

                    int offsetDown = offset - 20;
                    int offsetUp = offset + 20;
                    int offsetMax = list.size() - 20;

                    m.put("list", arr);
                    m.put("offsetDown", offsetDown);
                    m.put("offsetUp", offsetUp);
                    m.put("prev", offset > 0);
                    m.put("next", offset < offsetMax);

                    return new ModelAndView(m, "home.html");
                },
                new MustacheTemplateEngine()
        );
        Spark.get(
                "/person",
                (request, response) -> {
                    int id = Integer.valueOf(request.queryParams("id"));
                    Person person = list.get(id - 1);

                    return new ModelAndView(person, "person.html");
                },
                new MustacheTemplateEngine()
        );
    }
}
