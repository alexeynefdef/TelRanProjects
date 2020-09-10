package org.anefdef.task.office;

public class Employee {
    private final String name;
    private long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }
}
