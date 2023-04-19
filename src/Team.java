import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

//Which team are you on?,Name,What is your weight (lbs)?,Experience level (time in months)
public class Team {
    private static ArrayList<Competitor> allCompetitors;
    private static ArrayList<Competitor> gatech;
    private static ArrayList<Competitor> emory;
    private static  ArrayList<Competitor> gsu;
    private static ArrayList<Competitor[]> matchups;

    private static File f;
    private static Scanner fileScan;
    public static void main(String [] args) throws FileNotFoundException{
        configFileScanner("/Users/arielsauer/Downloads/competitors.csv");
        getCompetitors();
        splitTeams();
        printTeams();
        sortTeams();
        printTeams();
    }
    private static void configFileScanner(String fileName) throws FileNotFoundException {
        f = new File(fileName);
        fileScan = new Scanner(f);
    }
    public static void getCompetitors() {
        allCompetitors = new ArrayList<>();
//
        String[] line;

        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine().split(",");
            allCompetitors.add(new Competitor(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3])));
        }
    }
    public static void splitTeams() {
        gatech = new ArrayList<>();
        emory = new ArrayList<>();
        gsu = new ArrayList<>();

        //makes shallow copies
        for(Competitor c : allCompetitors) {
            switch (c.getTeamNumber()) {
                case 1:
                    gatech.add(c);
                    break;
                case 2: emory.add(c);
                    break;
                case 3: gsu.add(c);
                    break;
            }
        }
    }

    public static void printTeams() {
        System.out.println("Georgia Tech's Team\n");
        for (Competitor c : gatech) {
            System.out.println(c);
        }

        System.out.println("\nEmory's Team\n");
        for (Competitor c : emory) {
            System.out.println(c);
        }

        System.out.println("\nGeorgia State's Team\n");
        for (Competitor c : gsu) {
            System.out.println(c);
        }

    }
    public static void sortTeams() {
        int minIndex;
        Competitor temp;
        for (int i = 0; i < gatech.size() - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < gatech.size(); j++) {
                if (gatech.get(j).getPowerLevel() < gatech.get(minIndex).getPowerLevel()) {
                    minIndex = j;
                }
            }
            temp = gatech.get(i);
            gatech.set(i, gatech.get(minIndex));
            gatech.set(minIndex, temp);
        }

        for (int i = 0; i < gatech.size() - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < gatech.size(); j++) {
                if (gatech.get(j).getPowerLevel() < gatech.get(minIndex).getPowerLevel()) {
                    minIndex = j;
                }
            }
            temp = gatech.get(i);
            gatech.set(i, gatech.get(minIndex));
            gatech.set(minIndex, temp);
        }
    }
    public static void getMatchtups() {
        matchups = new ArrayList<>();

    }

}