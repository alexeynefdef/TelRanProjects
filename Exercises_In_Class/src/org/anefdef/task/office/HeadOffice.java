package org.anefdef.task.office;

import java.util.List;

public class HeadOffice {

    public long countLeaders(List<Department> departments, String prefix, int limit) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith(prefix))
                .flatMap(department -> department.getEmployees().stream().
                        filter(employee -> employee.getSalary() >= limit))
                .count();
    }
}
