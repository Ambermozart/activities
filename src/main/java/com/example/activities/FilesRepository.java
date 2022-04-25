package com.example.activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesRepository {

    Path filePath;
    File bad = new File("bad.txt");
    File moderate = new File("moderate.txt");
    File good = new File("good.txt");


    public FilesRepository() throws IOException {
        if (!bad.exists()) {
            bad.createNewFile();
        }
        if (!moderate.exists()) {
            moderate.createNewFile();
        }
        if (!good.exists()) {
            good.createNewFile();
        }
    }

    public List<String> loadBad() throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(String.valueOf(bad)))) {
            result = lines.collect(Collectors.toList());
            }
        return result;
    }
    public List<String> loadGood() throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(String.valueOf(good)))) {
            result = lines.collect(Collectors.toList());
            }
        return result;
    }
    public List<String> loadModerate() throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(String.valueOf(moderate)))) {
            result = lines.collect(Collectors.toList());
            }
        return result;
    }

    public void addBadLine(String string) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("dodaj linijke do bad");
//        String string = System.lineSeparator() + scanner.nextLine();
        try{
            Files.write(Path.of("bad.txt"), string.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addGoodLine(String string) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("dodaj linijke do bad");
//        String string = System.lineSeparator() + scanner.nextLine();
        try{
            Files.write(Path.of("good.txt"), string.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addModerateLine(String string) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("dodaj linijke do bad");
//        String string = System.lineSeparator() + scanner.nextLine();
        try{
            Files.write(Path.of("moderate.txt"), string.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
