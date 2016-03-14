package ua.stqa.java_testtry.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sikretSSD on 15.03.2016.
 */
public class Collections {
    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";
// langs == langs1
        String[] langs1 = {"Java", "C#", "Python", "PHP"};
        for (int i = 0; i < langs1.length; i++) {
            System.out.println("Я хочу выучить " + langs1[i]);
        }
        for (String l : langs1) {
            System.out.println("Я хочу выучить " + l);
        }
        // langs == langs1 == languages
        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");
        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
// langs == langs1 == languages == languages1
        List<String> languages1 = Arrays.asList("Java", "C#", "Python", "PHP");
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");
        for (String l : languages1) {
            System.out.println("Я хочу выучить " + l);
        }

// langs == langs1 == languages == languages1 == languages2
        List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : languages2) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}