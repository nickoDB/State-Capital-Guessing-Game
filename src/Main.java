

//Import for array and scanner package.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //2-d array to store the cities and capitals.
        String[][] stateCapital = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
        };

        //Opening program statement to introduce user to the program.
        System.out.println("********WELCOME TO THE CAPITAL GUESSING GAME********");
        System.out.println("You will attempt to guess the Capital City of every state.\n");

        //initialize scanner.
        Scanner scanner = new Scanner(System.in);

        //variable to store the users right answers
        int rightAnswer = 0;


        //iterates through the states array (k)
        for (int k = 0; k < 50; k++) {
            System.out.println("What is the capital of: " + stateCapital[0][k] + "?");
            //reads users answer
            String userAnswer = scanner.nextLine();

            //iterates through capitals array (m)
            for (int m = 0; m < 50 ; m++) {
                //case for if user gets the correct capital
                if (stateCapital[1][k].equalsIgnoreCase(userAnswer)) {
                    System.out.println("That's right!");
                    rightAnswer++;
                }
                //case for if user gets the wrong capital
                else {
                    System.out.println("Nope, wrong answer.....Try again!");
                }
                break;
            }
        }

        //shows user how many they got out of 50
        System.out.println("This is the number of cities you got correct out of 50:" + rightAnswer + ".\n");
        System.out.println("Now I'll show you all 50 states and their corresponding capitals.\n");

        //prints out the array
        for (int k = 0; k < 50; k++) {
            System.out.println("The city of " + stateCapital[0][k] + " is " + stateCapital[1][k] + ".\n");
        }

        System.out.println("HERE IS THE BUBBLE SORT PORTION.");
        System.out.println("Now what I'm going to do is sort them alphabetically by capital.");
        System.out.println("Who knows, it might make it easier to memorize.\n");

        //bubble sort to sort capitals in the array alphabetically
        //for loops iterate the array to compare them and sort alphabetically
        for (int k = 0; k < stateCapital[0].length; k++) {
            for (int m = k + 1; m < stateCapital[0].length; m++) {
                //temporarily store variables for the bubble sort
                String tCapital;
                String tState;
                // if capital (m) is less than capital (k)
                // then the following will swap the values and place
                // that capital into temporary value tCapital
                if (stateCapital[1][m].compareTo(stateCapital[1][k]) < 0) {
                    tCapital = stateCapital[1][k];
                    stateCapital[1][k] = stateCapital[1][m];
                    stateCapital[1][m] = tCapital;
                //Same as above but for the states instead
                    tState = stateCapital[0][k];
                    stateCapital[0][k] = stateCapital[0][m];
                    stateCapital[0][m] = tState;
                }
            }
        }
        //Prints out the bubble sorted array
        for (int k = 0; k < 50; k++) {
            System.out.println("The capital of " + stateCapital[1][k] + " is located in the state: " + stateCapital[0][k] + ".\n");
        }

        //Lets the user know how many they got correct
        System.out.println("You got " + rightAnswer + " of the correct capitals!");
        System.out.println("Let's move on to the next portion of the assignment...\n");

        //*********PART 2 OF ASSIGNMENT WITH THE HASHMAP***********

        //HASHMAP PORTION will have key-value pairings
        //states will be keys and capitals will be values

        System.out.println("It's time to switch it up again!");
        System.out.println("What I'm going to do is put everything into a hashmap.");
        System.out.println("It will be unordered at first and everything will be in a key-value pairing,");

        HashMap<String, String> stateCityMap = new HashMap<>(stateCapital[0].length);

        for (int k = 0; k < stateCapital[0].length; k++) {
            stateCityMap.put(stateCapital[0][k], stateCapital[1][k]);
        }

        //print out the map
        System.out.println("Here take a look at the map contents!\n");

        for (String key : stateCityMap.keySet()) {
            System.out.println("The capital of " + key + " is " + stateCityMap.get(key) + ".\n");

        }
        //message to indicate sorting
        System.out.println("It's looking a little messy, let's go ahead and sort out this map.");
        System.out.println("Check this out!\n");

        //TreeMap to sort the map
        //Will utilize a binary search tree to store the key-values
        TreeMap<String, String> sortedStateCityMap = new TreeMap<>(stateCityMap);
        for (String key : sortedStateCityMap.keySet()) {
            System.out.println("The capital of " + key + " is " + sortedStateCityMap.get(key) + ".\n");

        }
        //Prompts user to enter a state and then will display the capital for the state
        System.out.println("Let's try this, you enter a state and I will tell you the capital.");
        System.out.print("The states are case-sensitive so just remember to start it with capital letter. No pun intended.\n");
        System.out.print("If you get bored, gotta do errands, or just don't feel like playing anymore type in 'quit' and you can end the program!\n");
        System.out.println("Enter a State:");

        //create variable to start loop
        boolean stateLoop = false;

        while (!stateLoop) {

            String newUserAnswer = scanner.nextLine();
            //checks if user input is in TreeMap
            if (sortedStateCityMap.containsKey(newUserAnswer)) {
                System.out.println("The capital of " + newUserAnswer + " is " + sortedStateCityMap.get(newUserAnswer) + ".");

            }
            //If user answer is not a State
                else {
                    System.out.println("I can't seem to identify that state, try again!");
            }
            //allows user to quit program
            if (newUserAnswer.equalsIgnoreCase("quit")) {
                System.out.print("*********THANK YOU FOR PLAYING MY GAME, I HOPE YOU HAVE A WONDERFUL DAY!********");
                stateLoop = true;
            }
        }
    }
}


