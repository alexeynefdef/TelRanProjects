package ui;

import model.Coordinates;
import model.Figure;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements Runnable{

    private Box[][] boxes;

    public Window() {
        this.boxes = new Box[Config.WIDTH][Config.HEIGHT];
        initForm();
        initBoxes();
        addKeyListener(new KeyAdapter());
    }

    private void initForm() {
        setSize(Config.WIDTH * Config.SIZE + 15,
                Config.HEIGHT * Config.SIZE +30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initBoxes() {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x,y);
                add(boxes[x][y]);
            }
        }
    }

    @Override
    public void run() {
        repaint();
    }

    public void showFigure(Figure figure, Coordinates at, int color) {
        for (Coordinates dot : figure.dots) {
            setBoxColor(at.x + dot.x, at.y + dot.y,color);
        }
    }

    void setBoxColor(int x, int y, int color) {
        if (x < 0 || x >= Config.WIDTH) return;
        if (y < 0 || y >= Config.HEIGHT) return;
        boxes[x][y].setColor(color);

    }

    class KeyAdapter implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            showFigure(Figure.Z2,new Coordinates(5,5),0);
            showFigure(Figure.Z2,new Coordinates(4,5),1);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
