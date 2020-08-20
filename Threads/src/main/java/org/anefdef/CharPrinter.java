package org.anefdef;

public class CharPrinter extends Thread {

    char ch;
    int times;

    public CharPrinter(char ch, int times) {
        this.ch = ch;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
