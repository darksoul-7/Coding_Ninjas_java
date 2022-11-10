/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOPS4;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class TicTacToe {

    private Player player1, player2;
    private Board board;

    public void startGame() {

        //Player Input
        Scanner s = new Scanner(System.in);
        player1 = takePlayerInput(1);
        player2 = takePlayerInput(2);
        while (player1.getsymbol() == player2.getsymbol()) {
            System.out.println("Symbol Already taken !! Pick Another Symbol !!");
            char symbol = s.next().charAt(0);
            player2.setsymbol(symbol);
        }
        //Create board
        board = new Board(player1.getsymbol(), player2.getsymbol());
        //conduct the game
        boolean player1turn = true;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE || status == Board.INVALID) {
            if (player1turn) {
                System.out.println("Player 1 - " + player1.getname() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();
                status = board.move(player1.getsymbol(), x, y);
                if (status != Board.INVALID) {
                    player1turn = false;
                    board.print();
                } else {
                    System.out.println("Invalid move !! Try Again !!");
                }
            } else {
                System.out.println("Player 2 - " + player2.getname() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();
                status = board.move(player2.getsymbol(), x, y);
                if (status == Board.INVALID) {
                    System.out.println("Invalid move !! Try Again !!");
                } else {
                    player1turn = true;
                    board.print();
                }
            }
        }

        if (status == Board.PLAYER_1_WINS) {
            System.out.println("Player 1 -" + player1.getname() + "wins !!");
        } else if (status == Board.PLAYER_2_WINS) {
            System.out.println("Player 2 -" + player2.getname() + "wins !!");
        } else {
            System.out.println("Game is Draw !!");
        }

    }

    private Player takePlayerInput(int num) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter player" + num + " name: ");
        String name = s.nextLine();
        System.out.println("Enter Player " + num + " symbol: ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }
}
