package service.impl;

import model.Employee;
import service.FilingCabinetsService;

import java.util.List;
import java.util.Stack;

public class FilingCabinetsImp implements FilingCabinetsService {
    @Override
    public Employee findEmployeeInFilingCabinets(String id) {
        Stack<Employee> employeeStack = new Stack<>();
        List<Employee> employeeList = FunctionWriteAndReadFileCSV.getFileCsvToEmployeeList();
        for(Employee e:employeeList){
            employeeStack.push(e);
        }
    while (true){
        if(employeeStack.size()==0){
            break;
        }
        Employee employee = employeeStack.pop();
        if(employee==null){
            break;
        }
        if(id.equals(employee.getIdEmployee())){
            return employee;
        }
    }
    return null;
    }
}
