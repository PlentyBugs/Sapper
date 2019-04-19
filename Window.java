package Sapper;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Controller controller;

    public Window(){
        super("Сапер");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawWindow();
    }

    public void drawWindow(){
        getContentPane().removeAll();

        JMenuBar menuBar = new JMenuBar();
        JSlider slider = new JSlider();
        slider.setMinimum(10);
        slider.setMaximum(80);
        JTextArea textArea = new JTextArea();
        textArea.setText("Size: " + String.valueOf(slider.getValue()) + "X" + String.valueOf(slider.getValue()));
        slider.addChangeListener(e -> textArea.setText("Size: " + String.valueOf(slider.getValue()) + "X" + String.valueOf(slider.getValue())));
        JMenu newGameMenu = new JMenu("New Game");
        JMenuItem difficultyEasyMenu = new JMenuItem("Easy");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.EASY));
        JMenuItem difficultyMediumMenu = new JMenuItem("Medium");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.MEDIUM));
        JMenuItem difficultyHardMenu = new JMenuItem("Hard");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.HARD));
        JMenuItem difficultyInsaneMenu = new JMenuItem("Insane");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.INSANE));
        JMenuItem difficultyHardCoreMenu = new JMenuItem("Hardcore");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.HARDCORE));
        JMenuItem difficultyNightMareMenu = new JMenuItem("Nightmare");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.NIGHTMARE));
        JMenuItem difficultyGodLikeMenu = new JMenuItem("Godlike");
        difficultyEasyMenu.addActionListener(e -> Game.newGame(slider.getValue(), Difficulty.GODLIKE));
        newGameMenu.add(difficultyEasyMenu);
        newGameMenu.add(difficultyMediumMenu);
        newGameMenu.add(difficultyHardMenu);
        newGameMenu.add(difficultyInsaneMenu);
        newGameMenu.add(difficultyHardCoreMenu);
        newGameMenu.add(difficultyNightMareMenu);
        newGameMenu.add(difficultyGodLikeMenu);
        menuBar.add(slider);
        menuBar.add(textArea);
        menuBar.add(newGameMenu);
        setJMenuBar(menuBar);

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
