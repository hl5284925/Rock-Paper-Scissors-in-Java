import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<String> history = new ArrayList<>();

    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.");


        String input = s.nextLine();
        if (input.equals("play")) {
            System.out.println("Which way do you prefer to play with? human or computer?");
            String gameTypeChoice = s.nextLine();

            if (gameTypeChoice.equals("human")) {
                System.out.println("Player1 select: 'rock', 'paper', 'scissors':");
                String player1 = s.nextLine().toLowerCase();

                System.out.println("Player2 select: 'rock', 'paper', 'scissors':");
                String player2 = s.nextLine().toLowerCase();

                if (!player1.equals("rock") && !player1.equals("paper") && !player1.equals("scissors") && !player2.equals("rock") && !player2.equals("paper") && !player2.equals("scissors")) {
                    System.out.println("Player's choice is invalid, please type again!");
                } else {
                    System.out.println("Player1 picks: " + player1);
                    System.out.println("Player2 picks: " + player2);
                }


                if (player1 == player2) {
                    System.out.println("It's a tie!");
                    history.add("DRAW: Player1 picked " + player1 + ", Player2 picked " + player2);
                } else if ((player1.equals("rock") && player2.equals("scissors")) || (player1.equals("scissors") && player2.equals("paper")) || (player1.equals("paper") && player2.equals("rock"))) {
                    System.out.println("Congratulations, Player1 won!");
                    history.add("Player1 WIN: Player1 picked " + player1 +", Player2 picked " + player2);
                } else if ((player1.equals("rock") && player2.equals("paper")) || (player1.equals("scissors") && player2.equals("rock")) || (player1.equals("paper") && player2.equals("scissors"))) {
                    System.out.println("Congratulations, Player2 won!");
                    history.add("Player2 WIN: Player1 picked " + player1 +", Player2 picked " + player2);
                }
                main();
            } else if (gameTypeChoice.equals("computer")) {
                System.out.println("Type 'rock', 'paper', or 'scissors' to play: ");
                String myChoice = s.nextLine().toLowerCase();
                String computerChoice = "";
                if (!myChoice.equals("rock") && !myChoice.equals("paper") && !myChoice.equals("scissors")) {
                    System.out.println("Your choice is invalid, please type again!");
                } else {
                    System.out.println("You picked: " + myChoice);

                    int randomForComputer = (int) (Math.random() * 3);
                    if (randomForComputer == 0) {
                        computerChoice = "rock";
                    } else if (randomForComputer == 1) {
                        computerChoice = "paper";
                    } else if (randomForComputer == 2) {
                        computerChoice = "scissors";
                    }
                    System.out.println("Computer picked: " + computerChoice);
                }

                if (myChoice.equals(computerChoice)) {
                    System.out.println("It's a tie!");
                    history.add("DRAW: You picked " + myChoice + ", Computer picked " + computerChoice);
                } else if ((myChoice.equals("rock") && computerChoice.equals("scissors")) || (myChoice.equals("scissors") && computerChoice.equals("paper")) || (myChoice.equals("paper") && computerChoice.equals("rock"))) {
                    System.out.println("You won!");
                    history.add("YOU WIN: YOU picked " + myChoice +", Computer picked " + computerChoice);
                } else if ((myChoice.equals("rock") && computerChoice.equals("paper")) || (myChoice.equals("scissors") && computerChoice.equals("rock")) || (myChoice.equals("paper") && computerChoice.equals("scissors"))) {
                    System.out.println("Computer won!");
                    history.add("Computer WIN: YOU picked " + myChoice +", Computer picked " + computerChoice);
                }
                main();
            }

        } else if (input.equals("history")) {

            System.out.println("You can view your game history now:");
            for (int i=0;i<history.size();i++){
                System.out.println(history.get(i));
            }
            main();
        } else if (input.equals("quit")) {
            System.out.println("You have chosen to quit, thank you for playing.");
        }

    }
}




