package service.impl;

import model.Employee;
import service.EmployeeInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeImpl implements EmployeeInterface {
    @Override
    public Map<Integer, Employee> getEmployeeFromCsv() {
        List<Employee> employeeList = FunctionWriteAndReadFileCSV.getFileCsvToEmployeeList();
        Map<Integer,Employee> employeeMap = new HashMap<>();
        for(int i=0;i<employeeList.size();i++){
            employeeMap.put(100+i,employeeList.get(i));
        }
        return employeeMap;
    }
}
