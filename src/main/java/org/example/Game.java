package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public void startGame(){
        while(true){
            for(Player player: players){
                int diceValue = dice.roll();
                int newPosition = player.getCurrentPosition() + diceValue;
                if(newPosition == board.getSize()){
                    System.out.println(player.getName() + " wins the game");
                    return;
                }
                if(newPosition > board.getSize()){
                    continue;
                }
                int finalPosition = board.getFinalPostion(newPosition);
                player.setCurrentPosition(finalPosition);
            }
        }
    }
}
