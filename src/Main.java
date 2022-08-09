import DungeonCharacter.Hero.Jirachi;
import DungeonCharacter.Hero.Magikarp;
import DungeonCharacter.Hero.Snorlax;
import DungeonCharacter.Hero.Gallade;
import GameView.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    private static JFrame jFrame;

    public static void main(String[] args) throws IOException {
        createJFrame();
        //CHARACTER SELECT VIEW - NOT FINISHED YET
        //CharacterQuizView characterQuizView = new CharacterQuizView(jFrame);

        GameView gameView = new GameView(jFrame, new Magikarp());
    }

    private static void createJFrame(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setTitle("Pokemon Mystery Dungeon Java");
        jFrame.setBackground(Color.BLACK);
        jFrame.isDoubleBuffered();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}