package geektrust.family.crown;

import geektrust.family.crown.api.FileCommandProcessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileCommandProcessor fileCommandProcessor =
                new FileCommandProcessor(args[0]);
        System.out.println(fileCommandProcessor.processFile());
    }
}
