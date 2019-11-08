package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private static final Scanner input = new Scanner(System.in);
    private static int matches = 11;

    public static void main(String[] args) {

        Player player1 = new Player(0, "player1");
        Player player2 = new Player(0, "player2");
        Player[] players = new Player[] { player1, player2};
        int i = 0;

        while (matches >= 0) {
            System.out.format("Игрок %s берет спички кол-во 1-3: \n", players[i].getName());
            int inputMatches =  inputMatches();
            players[i].setMatches(players[i].getMatches() + inputMatches);
            matches -= inputMatches;
            System.out.format("Осталось спичек: %s\n", matches);
            if (matches <= 0) {
                System.out.format("Игрок %s Выграл!\n", players[i].getName());
                break;
            }
            i = (i == 0)? 1 : 0;
        }
    }

    static int inputMatches() {
        int inputMatchesFromUser;
        do {
            inputMatchesFromUser = input.nextInt();
        }
        while ( inputMatchesFromUser > matches || inputMatchesFromUser < 1 || inputMatchesFromUser > 3);
        return inputMatchesFromUser;
    }
}
