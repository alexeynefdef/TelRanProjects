package tetris;

import model.Coordinates;
import model.Figure;
import ui.Window;

import javax.swing.*;

public class Tetris {
    public static void main(String[] args) {
        Window window = new Window();
        SwingUtilities.invokeLater(window);
        window.showFigure(Figure.Z1, new Coordinates(5,5),1);
    }
}
