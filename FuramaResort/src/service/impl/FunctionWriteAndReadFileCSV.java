package service.impl;

import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FunctionWriteAndReadFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/data/Customer.csv";
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";
    private static final String FILE_HEADER_VILLA = "id,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,poolArea,floorNumber";
    private static final String FILE_HEADER_HOUSE = "id,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber";
    private static final String FILE_HEADER_ROOM = "id,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded";
    private static final String FILE_HEADER_CUSTOMER = "id,customerName,dayOfBirth,gender,idNumber,phoneNumber,email,typeOfCustomer,address";
    private static final String FILE_HEADER_BOOKING = "id,customerName,dayOfBirth,gender,idNumber,phoneNumber,email,typeOfCustomer,address,idService,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent";
    private static final String FILE_HEADER_EMPLOYEE = "idEmployee,fullName,age,address";
    public static void writeVillaToFileCSV(ArrayList<Villa> listVilla) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH_FILE_VILLA);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Villa villa : listVilla) {
                fileWriter.append(villa.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getServiceIncluded());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getArea()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getRentFee()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getMaxNumOfPerson()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getTypeOfRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRoomStander());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getOtherFacilities());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getPoolArea()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getFloorNumber()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully!!!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWritter!!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static ArrayList<Villa> getFileCsvToListVilla() {
        BufferedReader br = null;
        ArrayList<Villa> villalist = new ArrayList<Villa>();
        Path path = Paths.get(PATH_FILE_VILLA);
        if (!Files.exists(path)) {
            try {
                //tao file
                Writer writer = new FileWriter(PATH_FILE_VILLA);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_VILLA));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
                Villa villa = new Villa();
                villa.setId(splitData[0]);
                villa.setServiceIncluded(splitData[1]);
                villa.setServiceName(splitData[2]);
                villa.setArea(Double.parseDouble(splitData[3]));
                villa.setRentFee(Double.parseDouble(splitData[4]));
                villa.setMaxNumOfPerson(Integer.parseInt(splitData[5]));
                villa.setTypeOfRent(splitData[6]);
                villa.setRoomStander(splitData[7]);
                villa.setOtherFacilities(splitData[8]);
                villa.setPoolArea(Double.valueOf(splitData[9]));
                villa.setFloorNumber(Integer.parseInt(splitData[10]));
                villalist.add(villa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return villalist;
        }
    }

    public static void writeHouseToFileCSV(ArrayList<House> listHouse) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH_FILE_HOUSE);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (House house : listHouse) {
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
                fileWriter.append(house.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getServiceIncluded());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getArea()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getRentFee()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getMaxNumOfPerson()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getTypeOfRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRoomStander());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getOtherFacilities());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getFloorNumber()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileWritter!!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static ArrayList<House> getFileCsvToListHouse() {
        BufferedReader br = null;
        ArrayList<House> houseList = new ArrayList<House>();
        Path path = Paths.get(PATH_FILE_HOUSE);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_HOUSE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_HOUSE));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                House house = new House();
                house.setId(splitData[0]);
                house.setServiceIncluded(splitData[1]);
                house.setServiceName(splitData[2]);
                house.setArea(Double.parseDouble(splitData[3]));
                house.setRentFee(Double.parseDouble(splitData[4]));
                house.setMaxNumOfPerson(Integer.parseInt(splitData[5]));
                house.setTypeOfRent(splitData[6]);
                house.setRoomStander(splitData[7]);
                house.setOtherFacilities(splitData[8]);
                house.setFloorNumber(Integer.parseInt(splitData[9]));
                houseList.add(house);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return houseList;
    }

    public static void writeRoomToCsvFile(ArrayList<Room> roomList) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH_FILE_ROOM);
            fw.append(FILE_HEADER_ROOM);
            fw.append(NEW_LINE_SEPARATOR);
            for (Room room : roomList) {
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded
                fw.append(room.getId());
                fw.append(COMMA_DELIMITER);
                fw.append(room.getServiceIncluded());
                fw.append(COMMA_DELIMITER);
                fw.append(room.getServiceName());
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(room.getArea()));
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(room.getRentFee()));
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(room.getMaxNumOfPerson()));
                fw.append(COMMA_DELIMITER);
                fw.append(room.getTypeOfRent());
                fw.append(COMMA_DELIMITER);
                fw.append(room.getFreeServicesIncluded());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileWritter!!!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static ArrayList<Room> getFileCsvToRoomList() {
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<Room>();
        Path path = Paths.get(PATH_FILE_ROOM);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_ROOM);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_ROOM));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Room room = new Room();
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded
                room.setId(splitData[0]);
                room.setServiceIncluded(splitData[1]);
                room.setServiceName(splitData[2]);
                room.setArea(Double.parseDouble(splitData[3]));
                room.setRentFee(Double.parseDouble(splitData[4]));
                room.setMaxNumOfPerson(Integer.parseInt(splitData[5]));
                room.setTypeOfRent(splitData[6]);
                room.setFreeServicesIncluded(splitData[7]);
                listRoom.add(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listRoom;
    }

    public static void writeCustomerToCsvFile(ArrayList<Customer> customers) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH_FILE_CUSTOMER);
            fw.append(FILE_HEADER_CUSTOMER);
            fw.append(NEW_LINE_SEPARATOR);
            for (Customer customer : customers) {
                //id,customerName,dayOfBirth,gender,idNumber,phoneNumber,email,typeOfCustomer,address
                fw.append(customer.getId());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getCustomerName());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getDayOfBirth());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getGender());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getIdNumber());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getPhoneNumber());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getEmail());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getTypeOfCustomer());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getAddress());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileWritter!!!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }

        }
    }

    public static ArrayList<Customer> getFileCsvToCustomerList() {
        BufferedReader bufferedReader = null;
        ArrayList<Customer> customers = new ArrayList<>();
        Path path = Paths.get(PATH_FILE_CUSTOMER);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH_FILE_CUSTOMER);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH_FILE_CUSTOMER));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                //id,customerName,dayOfBirth,gender,idNumber,phoneNumber,email,typeOfCustomer,address
                Customer customer = new Customer();
                customer.setId(splitData[0]);
                customer.setCustomerName(splitData[1]);
                customer.setDayOfBirth(splitData[2]);
                customer.setGender(splitData[3]);
                customer.setIdNumber(splitData[4]);
                customer.setPhoneNumber(splitData[5]);
                customer.setEmail(splitData[6]);
                customer.setTypeOfCustomer(splitData[7]);
                customer.setAddress(splitData[8]);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customers;
    }

    public static void writeBookingToFileCsv(List<Customer> customers) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH_FILE_BOOKING);
            fw.append(FILE_HEADER_BOOKING);
            fw.append(NEW_LINE_SEPARATOR);
            for (Customer customer : customers)
            {
                //idService,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent;
                fw.append(customer.getId());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getCustomerName());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getDayOfBirth());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getGender());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getIdNumber());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getPhoneNumber());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getEmail());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getTypeOfCustomer());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getAddress());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getService().getId());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getService().getServiceIncluded());
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getService().getServiceName());
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(customer.getService().getArea()));
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(customer.getService().getRentFee()));
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(customer.getService().getMaxNumOfPerson()));
                fw.append(COMMA_DELIMITER);
                fw.append(customer.getService().getTypeOfRent());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CSVFileWritter!!!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static List<Customer> getFileCsvToBookingList() {

        BufferedReader br = null;
        List<Customer> customers = new ArrayList<Customer>();
        Path path = Paths.get(PATH_FILE_BOOKING);
        try {
            if (!Files.exists(path)) {
                Writer writer = new FileWriter(PATH_FILE_BOOKING);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            br = new BufferedReader(new FileReader(PATH_FILE_BOOKING));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Customer customer = new Customer();
                //idService,serviceIncluded,serviceName,area,rentFee,maxNumOfPerson,typeOfRent;
                customer.setId(splitData[0]);
                customer.setCustomerName(splitData[1]);
                customer.setDayOfBirth(splitData[2]);
                customer.setGender(splitData[3]);
                customer.setIdNumber(splitData[4]);
                customer.setPhoneNumber(splitData[5]);
                customer.setEmail(splitData[6]);
                customer.setTypeOfCustomer(splitData[7]);
                customer.setAddress(splitData[8]);
//                List<Villa> villaList =FunctionWriteAndReadFileCSV.getFileCsvToListVilla();
//                List<House> houseList = FunctionWriteAndReadFileCSV.getFileCsvToListHouse();
//                List<Room> roomList = FunctionWriteAndReadFileCSV.getFileCsvToRoomList();
//                Services service = null;
//                if(splitData[9].contains("VL")){
//                    for(Villa villa:villaList){
//                        if(villa.getId().equals(splitData[9])){
//                            service = villa;
//                            break;
//                        }
//                    }
//                }else if(splitData[9].contains("HO")){
//                    for(House house:houseList){
//                        if(house.getId().equals(splitData[9])){
//                            service = house;
//                            break;
//                        }
//                    }
//                }else if(splitData[9].contains("RO")){
//                    for(Room room:roomList){
//                        if(room.getId().equals(splitData[9])){
//                            service = room;
//                            break;
//                        }
//                    }
//                }
                customer.setService(splitData[9], splitData[10], splitData[11], Double.parseDouble(splitData[12]), Double.parseDouble(splitData[13]), Integer.parseInt(splitData[14]), splitData[15]);
//              customer.setService(service);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customers;
    }

    public static Set<String> getServiceNameFromServiceSet(String path) {
        Set<String> serviceNameSet = new TreeSet<>();
        try {
            Path path1 = Paths.get(path);
            if (!Files.exists(path1)) {
                Writer writer = new FileWriter(path);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(COMMA_DELIMITER);
                serviceNameSet.add(splitData[2]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return serviceNameSet;
    }
    public static List<Employee> getFileCsvToEmployeeList(){
        BufferedReader bf = null;
        List<Employee> employeeList = new ArrayList<>();
        Path path = Paths.get(PATH_FILE_EMPLOYEE);
        try{
            if(!Files.exists(path)){
                Writer writer = new FileWriter(PATH_FILE_EMPLOYEE);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            bf = new BufferedReader( new FileReader(PATH_FILE_EMPLOYEE));
            String line = bf.readLine();
            while ((line=bf.readLine())!=null){
                String[] splitData = line.split(COMMA_DELIMITER);
                Employee employee = new Employee();
                employee.setIdEmployee(splitData[0]);
                employee.setFullName(splitData[1]);
                employee.setAge(Integer.parseInt(splitData[2]));
                employee.setAddress(splitData[3]);
                employeeList.add(employee);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                bf.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return employeeList;
    }
}


