//import java so it is usable

import java.util.*;


//class name 
public class NumberGuesser {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    //score board for the game
    public static void main(String[] args) {
        NumberGuesser methodChange = new NumberGuesser();
        methodChange.menu(scoreBoard);
    }


    //menu for the game
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuesser methodChange = new NumberGuesser();
        Scanner input = new Scanner(System.in);


        //The option sin the menu when you start the program
        System.out.println("--------------------");
        //play the game
        System.out.println("1) Play Game");
        //score board for the games played
        System.out.println("2) Score Board");
        //Exit the program
        System.out.println("3) Exit");
        System.out.println("--------------------");

        //Question for the User input on menu
        try {
            System.out.print("What would you like to do? ");
            int menuOption = input.nextInt();

            switch (menuOption) {
                case 1:
                //choose how big you want the game to be
                    System.out.print("\n"+"What would you like the range of the game to be? ");
                    int numberRange = input.nextInt();

                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                //show the scoreboard
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                //send message and exit the game
                    System.out.println("\n"+"Thanks for playing!");
                    System.exit(1);
                    break;
                default:
                //message for invalid option given
                    throw new InputMismatchException("Invalid entry. Please Try again");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;

        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);

        int userGuess;
        int guess = 0;

        do {
            //message to have user input for the game
            System.out.print("Enter your guess: ");
            userGuess = input.nextInt();
            guess++;

            //Game determines if user guess is correct or not and response for clue.
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }

        } while (randomNumber != userGuess);

        System.out.println(" ");

        //Message for getting number correct for if 1 try or multiple
        if (guess == 1) {
            System.out.println("You answered right in " + guess + " try!");
        } else {
            System.out.println("You answered right in " + guess + " tries!");
        }

        //Adds to teh score board so user can check after
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    //Display for the scoreboard
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");

        //Tells user their fastest guess
        System.out.println("Your fastest games today: " +"\n");
        Collections.sort(scoreBoard);

        for (Integer scores : scoreBoard) {
            System.out.println("Finished the game in " + scores + " tries");
        }

        System.out.println(" ");
        menu(scoreBoard);
    }
}