package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private int size;
    private int noOfSnakes;
    private int noOfLadders;
    private Cell[][] cell = new Cell[1000][1000];

    Board(int size,int noOfSnakes,int noOfLadders){
        this.size = size;
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        initializeBoard();
    }

    public void initializeBoard() {
        for(int i=1;i<getSize();i++){
            cell[generatorRow(i)][generatorCol(i)] = new Cell();
        }

        generateLadder(getNoOfLadders());
        generateSnake(getNoOfSnakes());
    }

    public void generateSnake(int noOfSnakes) {
        int count = 0;
        while(count<noOfSnakes){
            int start = (int) (Math.random()*getSize());
            int end = (int) (Math.random()*getSize());
            if(start>end){
                cell[generatorRow(start)][generatorCol(start)].setSnake(new Snake(start,end));
                count++;
            }
        }
    }

    public void generateLadder(int noOfLadders) {
        int count = 0;
        while (count<noOfLadders){
            int start = (int)(Math.random()*getSize());
            int end = (int)(Math.random()*getSize());
            if(end<start){
                cell[generatorRow(start)][generatorCol(start)].setLadder(new Ladder(start,end));
            }
            count++;
        }
    }

    public int generatorCol(int i) {
        return (int)((i-1)%Math.sqrt(getSize()));
    }

    public int generatorRow(int i) {
        return (int) ((i-1)/Math.sqrt(getSize()));
    }

    public int getFinalPostion(int currentPosition){
        if(cell[generatorRow(currentPosition)][generatorCol(currentPosition)].getSnake()!=null){
            return cell[generatorRow(currentPosition)][generatorCol(currentPosition)].getSnake().getEnd();
        }
        else if(cell[generatorRow(currentPosition)][generatorCol(currentPosition)].getLadder()!=null){
            return cell[generatorRow(currentPosition)][generatorCol(currentPosition)].getLadder().getEnd();
        }

        return currentPosition;
    }
}
