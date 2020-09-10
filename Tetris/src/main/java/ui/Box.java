package ui;

import javax.swing.*;

public class Box extends JPanel {

    public Box(int x, int y) {

        setBounds(x * Config.SIZE,y * Config.SIZE,
                Config.SIZE, Config.SIZE);
        setBackground(Config.BACKGROUND);
        setVisible(true);
    }

    public void setColor(int j) {
        if (j == 0)
            setBackground(Config.BACKGROUND);
        else
            setBackground(Config.FORE);
    }

}
