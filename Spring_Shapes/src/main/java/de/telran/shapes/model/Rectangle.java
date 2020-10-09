package de.telran.shapes.model;

public class Rectangle implements Shape {

    private char symbol;
    private int width;
    private int height;
    //private String rectangleString;

    public Rectangle(char symbol, int width, int height) {
        this.symbol = symbol;
        this.width = width;
        this.height = height;
       //this.rectangleString = initRectangleAsString(width,height);
    }

    /*private String initRectangleAsString(int width, int height) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res.append(j);
            }
            res.append("\n");
        }
        return res.toString();
    }*/


    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
