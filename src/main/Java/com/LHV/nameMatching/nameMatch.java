package com.LHV.nameMatching;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class nameMatch {
    public static String userEntry = "Osama bin Laden";
    public static ArrayList<Person> matches = new ArrayList<Person>();

    public static void main(String[] args) {
        String givenName = removeNoise(userEntry);
        readFile();
        matchScore(givenName);
    }
    public static void readFile(){
        File file = new File("src/main/Resources/com.LHV.nameMatching/names.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String personName = scanner.nextLine();
                if(personName != null && !personName.trim().isEmpty()) {
                    matches.add(new Person(personName, 0));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void matchScore(String givenName) {
        if(givenName != null && !givenName.trim().isEmpty()) {
            for (int i = 0; i < matches.size(); i++) {
                String blackListname = removeNoise(matches.get(i).getName());
                matches.get(i).setScore(partialMatch(givenName, blackListname));
                matches.get(i).setScore((matches.get(i).getScore() + LevenshteinDistance(givenName, blackListname))/2);
            }
            printScore();
        } else {
            System.out.println("Please insert name!");
        }
    }
    private static void printScore() {
        int topResults = 15;
        if(matches.size() < topResults){
            topResults = matches.size();
        }
        System.out.println("Top " + topResults + " best matches:");
        Collections.sort(matches, Comparator.comparing(Person::getScore));
        Collections.reverse(matches);
        for(int i = 0; i < topResults; i++) {
            System.out.println(matches.get(i));
        }
    }

    public static int partialMatch(String givenName, String blacklistName) {
        int score = 0;
        String[] listName = givenName.split("[, -]+");
        String[] listBlacklisted = blacklistName.split("[, -]+");

        for(int i = 0; i<listName.length;i++){
            for(int x =0; x<listBlacklisted.length;x++){
                if (listName[i].equals(listBlacklisted[x])){
                    score += 1;
                }
            }
        }
        int partialMatchScore;
        if (listName.length > listBlacklisted.length){
            partialMatchScore =  score*100/(listName.length);
            return partialMatchScore;
        } else {
            partialMatchScore =  score*100/(listBlacklisted.length);
            return partialMatchScore;
        }
    }

    public static int LevenshteinDistance(String givenName, String blacklistName) {
        int distance = new LevenshteinDistance().apply(givenName,blacklistName);
        if (distance == 0){
            return 100;
        } if (distance <= 3 && distance > 0){
            return 80;
        } if (distance > 3 && distance <= 7 ){
            return 60;
        } if (distance > 7 && distance <= 10) {
            return 20;
        } if (distance > 10 && distance <= 15) {
        return 10;
        } else {
            return 0;
        }
    }


    public static String removeNoise(String name){
        File fileNoise = new File("src/main/Resources/com.LHV.nameMatching/noise_words.txt");
        ArrayList<String> listName = new ArrayList<String>(Arrays.asList(name.toLowerCase().split("[, ]+")));
        try {
            Scanner scanner = new Scanner(fileNoise);
            while(scanner.hasNextLine()){
                String noiseWord = scanner.nextLine().toLowerCase();
                for (int i=0; i<listName.size();i++){
                    if ((listName.get(i)).equals(noiseWord)){
                        listName.remove(i);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String listString = String.join(" ", listName);
        return listString.toLowerCase();
    }
}