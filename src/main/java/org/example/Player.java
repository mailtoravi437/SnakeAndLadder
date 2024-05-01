package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private int currentPosition;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        this.currentPosition = 0;
    }
}
