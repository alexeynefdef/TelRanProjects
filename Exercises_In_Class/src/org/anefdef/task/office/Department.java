package org.anefdef.task.office;

import java.util.List;

public class Department {
    private String name;
    private String code;
    private List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
