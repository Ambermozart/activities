package com.example.activities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ActionRandomizer {
    //  public static void main(String[] args) {

    ArrayList<String> addBad() throws IOException {
        ArrayList<String> newList = (ArrayList<String>) new FilesRepository().loadBad();
        return newList;
    }
 ArrayList<String> addGood() throws IOException {
        ArrayList<String> newList = (ArrayList<String>) new FilesRepository().loadGood();
        return newList;
    }
 ArrayList<String> addModerate() throws IOException {
        ArrayList<String> newList = (ArrayList<String>) new FilesRepository().loadModerate();
        return newList;
    }

    public static String actions(String mood) throws IOException {


        ArrayList<String> bad = new ActionRandomizer().addBad();
        ArrayList<String> moderate = new ActionRandomizer().addModerate();
        ArrayList<String> good = new ActionRandomizer().addGood();
        {
            bad.add("Watch Star Trek");
            bad.add("Play with Cat");
            bad.add("Play a game for fun");

            moderate.add("Tidy up your room");
            moderate.add("Do homework");
            moderate.add("Play with daughter");

            good.add("Do homework");
            good.add("Play with daughter");
            good.add("P;ay with a Cat");
        }

        Random random = new Random();
        random.nextInt();

        String action;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("choose bad, moderate or good");
//
//        String mood = scanner.nextLine();
//        System.out.println();

        switch (mood) {
            case "bad":
                int randomInt = random.nextInt(bad.size());
                action = bad.get(randomInt);
                //   System.out.println(bad.get(randomInt));
                break;
            case "moderate":
                int randomInt2 = random.nextInt(moderate.size());
                action = moderate.get(randomInt2);
                //  System.out.println(moderate.get(randomInt2));
                break;
            case "good":
                int randomInt3 = random.nextInt(good.size());
                action = good.get(randomInt3);
                //  System.out.println(good.get(randomInt3));
                break;
            default:
                action = "none";
                //System.out.println("Źle");
        }
        return action;
    }
}
