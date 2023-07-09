package org.example;

import java.util.regex.*;

public class Verlag {


    public double berechneHonorar(String text) {
        if (text == null)
            throw new IllegalArgumentException("Es wurde kein Text uebergeben");

        return (double) text.length()/10;
    }

    public double zaehleBilder(String text) {
        if (text == null)
            throw new IllegalArgumentException("Es wurde kein Bild übergeben");

        // count "picture" in string using regex
        int countPicture = 0;
        Pattern regex = Pattern.compile("picture", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(text);
        while (matcher.find()) {
            countPicture++;
        }

        return countPicture;
    }



}
