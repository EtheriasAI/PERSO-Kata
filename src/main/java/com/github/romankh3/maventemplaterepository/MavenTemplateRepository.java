package com.github.romankh3.maventemplaterepository;

import java.io.*;
import java.util.Arrays;

/**
 * Main class for Java Repository Template.
 */
public class MavenTemplateRepository {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            // The first line is the lawn boundary
            String line = br.readLine();

            // I could use Integer.parseInt(String.valueOf(line.charAt(0))) but that would take longer
            String[] split = line.split(" ");
            // Lawn limits
            int X = Integer.parseInt(split[0]);
            int Y = Integer.parseInt(split[1]);

            // every two lines will now be a single mower
            while ((line = br.readLine()) != null) {

                // Coordinates of the mower
                split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                char d = split[2].charAt(0);
                Mower mower = new Mower(x,y,d,X,Y);

                // Trip of the mower
                line = br.readLine();
                // I retrieve each movement and for each I move the mower
                Arrays.stream(line.split("")).forEach(c ->
                        mower.move(Control.valueOf(c)));

                System.out.println(mower.x + " " + mower.y + " " + mower.d);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
