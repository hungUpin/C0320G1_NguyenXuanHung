package service;

import model.Employee;

import java.util.Map;

public interface EmployeeInterface {
    Map<Integer, Employee> getEmployeeFromCsv();
}
