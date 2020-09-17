package org.anefdef;

import org.anefdef.task.NewYorker;

public class Main {

    public static void main(String[] args) {
       NewYorker ny = new NewYorker();
       System.out.println(ny.showTimeIntersectionsWith("09:00:00","18:00:00","Europe/Berlin","08:00:00","17:00:00","America/Los_Angeles"));
    }
}
