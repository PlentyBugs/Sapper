package Sapper;

public class Controller {

    private static Window window;

    public Controller(Window window){
        this.window = window;
        window.setController(this);
    }

    public static void control(int x, int y){
        Cell[][] cells = Game.field;
        cells[y][x].setEnabled(false);
        cells[y][x].decorate();
        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(y+i >= 0 && x+j >= 0 && y+i < Game.SIZE && x+j < Game.SIZE){
                    if(cells[y+i][x+j].getEnabled() && cells[y+i][x+j].getCountOfBombsAround() == 0){
                        control(x+j, y+i);
                    } else if(cells[y+i][x+j].getCountOfBombsAround() != 0){
                        cells[y+i][x+j].setEnabled(false);
                        cells[y+i][x+j].decorate();
                    }
                }
            }
        }
    }

    public static void checkOnWin(){
        boolean isWin = true;
        for(int i = 0; i < Game.SIZE; i++){
            for(int j = 0; j < Game.SIZE; j++){
                if(!Game.field[i][j].equals(Game.fieldWin[i][j])){
                    isWin = false;
                }
            }
        }
        if(isWin){
            new WinWindow();
        }
    }
}
