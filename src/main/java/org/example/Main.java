package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board(100,5 ,5);
        game.setBoard(board);
        game.setDice(new Dice());
        List<Player> playerList = new ArrayList<>();
        Player Ravi = new Player(1,"Ravi");
        Player Vishwajeet = new Player(2,"Vishwajeet");
        Player Sahil = new Player(3, "Sahil");
        Player Shubham = new Player(4, "Shubham");


        playerList.add(Ravi);
        playerList.add(Vishwajeet);
        playerList.add(Sahil);
        playerList.add(Shubham);

        game.setPlayers(playerList);

        game.startGame();

    }
}