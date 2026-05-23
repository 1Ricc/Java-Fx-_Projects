package model;

import model.bonus.LetterBonus;
import model.bonus.WordBonus;
import model.cell.*;
import java.util.*;

public class Game {

    public static int SIZE = 4;
    private static HashSet<String> dizionario = new HashSet<>();

    private CellInterface[][] grid = {
            {new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
            {new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
            {new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
            {new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
    };
    private int score;

    public Game(){
        Game.initialiseDizionario();
        this.initialiseGrid();
        this.score = 0;
    }

    private static void initialiseDizionario(){
        Game.dizionario = new HashSet<>(Arrays.asList(
                "ARE", "ERE", "REA", "REE",
                "ERRE", "ERRA", "AREA",
                "AEREE", "AEREA",
                "ERRARE", "AREARE"));
    }

    private void initialiseGrid(){
        Random rand = new Random();
        for (int rows = 0; rows < SIZE; rows++){
            for (int cols = 0 ; cols < SIZE; cols++){
                int n = rand.nextInt(3);
                switch (n){
                    case 0: {
                        this.grid[rows][cols] = new Cell_A();
                        break;
                    }
                    case 1: {
                        this.grid[rows][cols] = new Cell_E();
                        break;
                    }
                    case 2: {
                        this.grid[rows][cols] = new Cell_R();
                        break;
                    }
                }
            }
        }
        this.grid[0][0].setBns(new LetterBonus(rand.nextInt(4)+1));
        this.grid[0][3].setBns(new LetterBonus(rand.nextInt(4)+1));
        this.grid[3][0].setBns(new LetterBonus(rand.nextInt(4)+1));
        this.grid[3][3].setBns(new LetterBonus(rand.nextInt(4)+1));

        // setting only one of the middle ones
        int row = rand.nextInt(1)+1;
        int col = rand.nextInt(1)+1;
        int val = rand.nextInt(4)+1;
        this.grid[row][col].setBns(new WordBonus(val));
        System.out.println("Wordbonus in "+row+" "+col+" di valore "+val);
    }

    private boolean wordExists(Word w){
        return Game.dizionario.contains(w.toString());
    }

    public void addScore(Word w) throws InexistentWordException {
        if (this.wordExists(w)){
            this.score += w.getWordScore();
        }else{
            throw new InexistentWordException();
        }
    }

    public int getScore() {
        return this.score;
    }
    public CellInterface[][] getGrid(){
        return this.grid;
    }

    public void resetScore() {
        this.score = 0;
    }

    // needed for my tests
//    public void prettyPrint(){
//        for (int rows = 0; rows < SIZE; rows++) {
//            for (int cols = 0; cols < SIZE; cols++) {
//                System.out.print(this.grid[rows][cols].toString());
//            }
//            System.out.println();
//        }
//        for (int rows = 0; rows < SIZE; rows++) {
//            for (int cols = 0; cols < SIZE; cols++) {
//                System.out.println("Cell "+rows+" "+cols+":"+this.grid[rows][cols].getTotalValue());
//            }
//        }
//    }
}
