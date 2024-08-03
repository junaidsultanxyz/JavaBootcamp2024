package yes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String start = "---------------- MENU ----------------" + "\n" +
                       "1 - Start"  + "\n" +
                       "0 - Close"  + "\n" +
                       "Enter here : ";

        Scanner input = new Scanner(System.in);

        boolean loop = true;
        boolean loop2 = true;

        while (loop) {
            System.out.print(start);  // printing start banner
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {

                    String team1Name;
                    while (true) {
                        System.out.print("Enter name of team 1 : ");
                        team1Name = input.nextLine();

                        if (!team1Name.trim().isEmpty()) { break; }
                        else {
                            System.out.println("Enter valid name");
                        }
                    }
                    Teams team1 = new Teams(team1Name);
                    System.out.println("Team 1 - " + team1.getName());
//here 11 is the number of players
                    for (int i = 0; i < 11; i++) {
                        System.out.print("Enter player " + (i + 1) + " name of team 1 : ");
                        String playerName = input.nextLine();

                        if (playerName.isEmpty()) {
                            System.out.println("enter valid name");
                            i--;
                        }
                        else {
                            team1.addPlayer(new Players(playerName));
                        }
                    }
                    String team2Name;
                    while (true) {
                        System.out.print("enter name of team 2 : ");
                        team2Name = input.nextLine();

                        if (!team2Name.trim().isEmpty()) {
                            break;
                        }
                        else {
                            System.out.println("enter valid name");
                        }
                    }
                    Teams team2 = new Teams(team2Name);
                    System.out.println("Team 2 - " + team2.getName());

                    for (int i = 0; i < 11; i++) {
                        System.out.print("Enter player " + (i + 1) + " name of team 2:");
                        String playerName = input.nextLine();

                        if (playerName.isEmpty()) {
                            System.out.println("Enter valid name");
                            i--;
                        }
                        else {
                            team2.addPlayer(new Players(playerName));
                        }
                    }

                    Match match = new Match(team1, team2);

                    while (loop2) {
                        System.out.println("\nMatch Menu:");
                        System.out.println("1 - Conduct Toss");
                        System.out.println("2 - Play Innings for " + team1Name);
                        System.out.println("3 - Play Innings for " + team2Name);
                        System.out.println("4 - Display Scorecard for " + team1Name);
                        System.out.println("5 - Display Scorecard for " + team2Name);
                        System.out.println("6 - Declare Winner");
                        System.out.println("7 - Exit");
                        System.out.print("Choose an option: ");

                        int choice2 = input.nextInt();
                        input.nextLine();

                        switch (choice2) {

                            case 1:
                            {
                                match.Toss();
                            }break;

                            case 2:
                            {
                                if (match.getBattingFirst() == null) {
                                    System.out.println("toss first!");
                                } else {
                                    match.playInnings(match.getBattingFirst());
                                }
                            }break;

                            case 3:
                            {
                                if (match.getBattingSecond() == null) {
                                    System.out.println("toss first!");
                                } else {
                                    match.playInnings(match.getBattingSecond());
                                }
                            }break;

                            case 4:
                            {
                                match.displayScorecard(team1);
                            }break;

                            case 5:
                            {
                                match.displayScorecard(team2);
                            }break;

                            case 6:
                            {
                                match.declareWinner();
                            }break;

                            case 7:
                            {
                                System.out.println("current game ending");
                                loop2 = false;

                            }break;

                            default:
                            {
                                System.out.println("enter valid choice");

                            }break;
                        }
                    }
                }

                case 0:
                {
                    System.out.println("ty for using this app :)");
                    loop = false;
                    System.exit(0);

                }break;

                default:
                {
                    System.out.println("enter valid choice");

                }break;
            }
        }
    }
}
