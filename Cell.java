package Sapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cell extends JButton {

    private boolean isBomb;
    private int countOfBombsAround;
    private boolean flag;
    private int xCoordinate, yCoordinate;
    private int count;
    private boolean ENABLED = true;

    public Cell(int x, int y){
        setSizeOfCell(720/Game.SIZE,720/Game.SIZE);
        flag = false;
        xCoordinate = x;
        yCoordinate = y;

        setBackground(Color.lightGray);

        addMouseListener(new java.awt.event.MouseListener() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(Game.firstTouch){
                    Game.layMines();
                    Game.firstTouch = false;
                } else {
                    if(e.getButton() == 1){
                        if(isBomb) {
                            setBackground(Color.black);
                            new LoseWindow();
                        } else {
                            Controller.control(x, y);
                        }
                    } else if(e.getButton() == 3){
                        flag = !flag;
                        if(flag)
                            setBackground(Color.cyan);
                        else
                            setBackground(Color.lightGray);
                    }
                }
                Controller.checkOnWin();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public boolean getIsBomb(){
        return isBomb;
    }

    public Cell setIsBomb(boolean isBomb){
        this.isBomb = isBomb;
        return this;
    }

    public int getCountOfBombsAround() {
        return countOfBombsAround;
    }

    public void setCountOfBombsAround(int countOfBombsAround) {
        this.countOfBombsAround = countOfBombsAround;
    }

    private void setSizeOfCell(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        ENABLED = b;
    }

    public boolean getEnabled(){
        return ENABLED;
    }

    public void decorate(){
        if(!isBomb)
            setBackground(Colors.Color(countOfBombsAround));
    }

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean equals(Cell cell) {
        return ((cell.flag == flag && cell.isBomb == isBomb) || (cell.ENABLED == ENABLED && cell.isBomb != isBomb));
    }
}
