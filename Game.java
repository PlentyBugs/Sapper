package Sapper;

public class Game {

    public static final int SIZE = 40;
    public static int COUNT = (SIZE*SIZE)/Difficulty.INSANE.getI();
    public static final Cell[][] field = new Cell[SIZE][SIZE];
    public static final Cell[][] fieldWin = new Cell[SIZE][SIZE];
    public static boolean firstTouch = true;

    public static void main(String[] args){
        generateField();
        new Controller(new Window());
    }

    private static void generateField(){
        for(int i = 0; i < Game.SIZE; i++){
            for(int j = 0; j < Game.SIZE; j++){
                Cell cell = new Cell(j, i);
                field[i][j] = cell;
                Cell c = new Cell(j, i);
                c.setEnabled(false);
                fieldWin[i][j] = c;
            }
        }
    }

    public static void layMines(){
        while (COUNT > 0){
            int y = (int)(Math.random()*SIZE);
            int x = (int)(Math.random()*SIZE);
            Cell cell = field[y][x];
            if(!cell.getIsBomb()){
                cell.setIsBomb(true);
                fieldWin[y][x].setIsBomb(true);
                fieldWin[y][x].setFlag(true);
                COUNT --;
            }
        }
        countCount();
    }

    private static void countCount(){
        for(int y = 0; y < SIZE; y++){
            for(int x = 0; x < SIZE; x++){

                int count = 0;

                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i == 0 && j == 0)
                            continue;

                        if(y+i >= 0 && x+j >= 0 && y+i < Game.SIZE && x+j < Game.SIZE){
                            if(field[y+i][x+j].getIsBomb()){
                                count += 1;
                            }
                        }
                    }
                }
                field[y][x].setCountOfBombsAround(count);
            }
        }
    }
}
