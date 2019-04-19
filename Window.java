package Sapper;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public int width;
    public int height;
    public Controller controller;

    public Window(){
        super("Сапер");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawWindow();
    }

    public void drawWindow(){
        getContentPane().removeAll();
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.NORTH;

        for(int i = 0; i < Game.SIZE; i++){
            constraints.gridy = i;
            for(int j = 0; j < Game.SIZE; j++){
                constraints.gridx = j;
                panel.add(Game.field[i][j], constraints);
            }
        }

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
