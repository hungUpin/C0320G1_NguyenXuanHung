package controllers;


import model.*;
import service.*;
import service.impl.FunctionWriteAndReadFileCSV;
import service.impl.*;
import sort.CustomerNameComparator;


import java.util.*;

public class MainController {
    Scanner sc = new Scanner(System.in);
    private static ServiceInterface villaService = new VillaServiceImp();
    private static ServiceInterface houseService = new HouseServiceImp();
    private static ServiceInterface roomService = new RoomServiceImp();
    private static CustomerInterface customerInterface = new CustomerImp();
    private static Booking4DCinemaInterface booking4DCinemaInterface = new Booking4DCinemaImp();
    private static FilingCabinetsService filingCabinetsService = new FilingCabinetsImp();
    public void displayMainMenu(){
        //1.	 Add New Services
        //2.	Show Services
        //3.	Add New Customer
        //4.	Show Information of Customer
        //5.	Add New Booking
        //6.	Show Information of Employee
        //7.	Exit
        System.out.println("Menu: \n"+
                "1. Add New Service.\n"+
                "2. Show Services.\n"+
                "3. Add New Customer.\n"+
                "4. Show Information of Customer.\n"+
                "5. Add New Booking.\n"+
                "6. Show Information Of Employee.\n"+
                "7. Add Booking 4D Cinema.\n"+
                "8. Show Booking 4D Cinema.\n"+
                "9. Find employee by id. \n"+
                "10. Exit\n");
        System.out.println("Enter the function: ");
        String choose = sc.nextLine();
        switch (choose){
            case "1":
                addNewService();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInformationCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showAllEmployee();
                break;
            case "7":
                addBooking4dCinema();
                break;
            case "8":
                showBooking4DCinema();
                break;
            case "9":
                findEmployeeInFilingCabinets();
                break;
            case "10":
                System.exit(0);
            default:
                System.out.println("Invalid selection!!! Please choose again!!!Enter to continue!!!");
                sc.nextLine();
                displayMainMenu();
        }
    }

    private void findEmployeeInFilingCabinets() {
        System.out.println("Enter Id of employee: ");
        String id = sc.nextLine();
        Employee employee = filingCabinetsService.findEmployeeInFilingCabinets(id);
        if(employee==null){
            System.out.println("Can not find employee with id: "+id +" in the filing cabinets!!");
        }else {
            System.out.println("---------------------------");
            System.out.println(employee);
        }
        System.out.println("Enter to continue...");
        sc.nextLine();
        displayMainMenu();
    }

    private void showBooking4DCinema() {
        Queue<Customer> customerQueue = booking4DCinemaInterface.getAllCustomerBooked();
        System.out.println("List of booked customer: ");
        while (true){
            Customer customer = customerQueue.poll();
            if(customer == null){
                break;
            }
            System.out.println(customer);
        }
        System.out.println("Enter to continue...");
        sc.nextLine();
        displayMainMenu();
    }

    private void addBooking4dCinema() {
        System.out.println("How many tickets to sell: ");
        int tickets = Integer.parseInt(sc.nextLine());
        ArrayList<Customer> customerArrayList = FunctionWriteAndReadFileCSV.getFileCsvToCustomerList();
        for(int i=0;i<tickets;i++){
            System.out.println("Choose customer " +(i+1)+" to book ticket");
            for(int j=0;j<customerArrayList.size();j++){
                System.out.println((j+1) +": "+customerArrayList.get(j));
            }
            System.out.println("Enter customer number: ");
            Customer customer = customerArrayList.get(Integer.parseInt(sc.nextLine())-1);
            booking4DCinemaInterface.addCustomerBookCinema(customer);
        }
        System.out.println("Enter to continue...");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllEmployee() {
        EmployeeInterface employeeInterface = new EmployeeImp();
        Map<Integer, Employee> employeeMap =  employeeInterface.getEmployeeFromCsv();
        Set<Integer> keySet = employeeMap.keySet();
        System.out.println("List employee: ");
        for (Integer key:keySet){
            System.out.println("------------------------");
            System.out.println(key + ": "+employeeMap.get(key));
        }
        System.out.println("Enter to continue....");
        sc.nextLine();
        displayMainMenu();
    }

    private void addNewBooking() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers = FunctionWriteAndReadFileCSV.getFileCsvToCustomerList();
        System.out.println("\tMenu customer: ");
        Collections.sort(customers, new CustomerNameComparator());
        for(int i=0;i<customers.size();i++){
            System.out.println("Customer "+(i+1)+": "+customers.get(i).showInfor());
        }
        System.out.println("Enter the customer: ");
        int cus =Integer.parseInt(sc.nextLine())-1;
        Customer customer = customers.get(cus);
        System.out.println("\tMenu booking: \n"+
                "1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n"+
                "Enter the function: ");
        int choose = Integer.parseInt(sc.nextLine());
        System.out.println("List of service:");
        switch (choose){
            case 1:
                List<Villa> villaList;
                villaList = FunctionWriteAndReadFileCSV.getFileCsvToListVilla();
                for(int i=0;i<villaList.size();i++){
                    System.out.println("--------------------------------------------------");
                    System.out.println("Villa " +(i+1)+" of " +villaList.size());
                    System.out.println(villaList.get(i).showInfor());
                }
                System.out.println("Enter the villa want to book: ");
                int villaNumber = Integer.parseInt(sc.nextLine())-1;
                Villa villa = villaList.get(villaNumber);
                customer.setService(villa);
                break;
            case 2:
                List<House> houseList;
                houseList = FunctionWriteAndReadFileCSV.getFileCsvToListHouse();
                for(int i=0;i<houseList.size();i++){
                    System.out.println("--------------------------------------------------");
                    System.out.println("House " +(i+1)+" of" +houseList.size());
                    System.out.println(houseList.get(i).showInfor());
                }
                System.out.println("Enter the house want to book: ");
                House house = houseList.get(Integer.parseInt(sc.nextLine())-1);
                customer.setService(house);
                break;
            case 3:
                List<Room> roomList;
                roomList = FunctionWriteAndReadFileCSV.getFileCsvToRoomList();
                for(int i=0;i<roomList.size();i++){
                    System.out.println("--------------------------------------------------");
                    System.out.println("Room " +(i+1)+" of" +roomList.size());
                    System.out.println(roomList.get(i).showInfor());
                }
                System.out.println("Enter the room want to book: ");
                Room room = roomList.get(Integer.parseInt(sc.nextLine())-1);
                customer.setService(room);
                break;
            default:
                System.out.println("Invalid selection! Enter to continue...");
                sc.nextLine();
                displayMainMenu();
        }
        List<Customer> bookingList = new ArrayList<>();
        bookingList = FunctionWriteAndReadFileCSV.getFileCsvToBookingList();
        bookingList.add(customer);
        FunctionWriteAndReadFileCSV.writeBookingToFileCsv(bookingList);
        System.out.println("Book service completed!!!!");
        System.out.println("Enter to continue...");
        sc.nextLine();
        displayMainMenu();
    }

    private void showInformationCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers = FunctionWriteAndReadFileCSV.getFileCsvToCustomerList();
        Collections.sort(customers,new CustomerNameComparator());
        for(Customer customer:customers){
            System.out.println("---------------------------------");
            System.out.println(customer.showInfor());
            System.out.println("---------------------------------");
        }
        System.out.println("Enter to continue!!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void addNewCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers = FunctionWriteAndReadFileCSV.getFileCsvToCustomerList();
        System.out.println("Enter number of customer want to input:");
        int num = Integer.parseInt(sc.nextLine());
        for(int i=0;i<num;i++){
            System.out.println("Add Customer "+(i+1) +" of "+num);
            Customer customer = customerInterface.addNewCustomer();
            customers.add(customer);
        }
        FunctionWriteAndReadFileCSV.writeCustomerToCsvFile(customers);
        System.out.println("Add new customer complete!!Enter to continue!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void showServices() {
        System.out.println("Menu: \n"+
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n"+
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Room Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n" +
                "Enter function:");
        String choose = sc.nextLine();
        switch (choose){
            case "1":
                showAllVilla();
                break;
            case "2":
                showAllHouse();
                break;
            case "3":
                showAllRoom();
                break;
            case "4":
                showAllVillaNameNotDuplicate();
                break;
            case "5":
                showAllHouseNameNotDuplicate();
                break;
            case "6":
                showAllRoomNameNotDuplicate();
                break;
            default:
                System.out.println("Invalid selection!!! Please choose again!!!Enter to continue!!!");
                sc.nextLine();
                showServices();
        }

    }

    private void showAllRoomNameNotDuplicate() {
        String pathRoom = "src/data/Room.csv";
        Set<String> nameRoomSet = new TreeSet<>();
        nameRoomSet = FunctionWriteAndReadFileCSV.getServiceNameFromServiceSet(pathRoom);
        for(String name:nameRoomSet){
            System.out.println("-----------------------------");
            System.out.println("Room name: "+name);
        }
        System.out.println("Enter to continue....");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllHouseNameNotDuplicate() {
        String pathHouse = "src/data/House.csv";
        Set<String> nameHouseSet = new TreeSet<>();
        nameHouseSet = FunctionWriteAndReadFileCSV.getServiceNameFromServiceSet(pathHouse);
        for(String name:nameHouseSet){
            System.out.println("-----------------------------");
            System.out.println("House name: "+name);
        }
        System.out.println("Enter to continue....");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllVillaNameNotDuplicate() {
        String pathVilla = "src/data/Villa.csv";
        Set<String> villaNameSet = new TreeSet<>();
        villaNameSet=FunctionWriteAndReadFileCSV.getServiceNameFromServiceSet(pathVilla);
        for(String name:villaNameSet){
            System.out.println("--------------------------");
            System.out.println("Villa name: "+name);
        }
        System.out.println("Enter to continue...");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllRoom() {
        ArrayList<Room> listRoom = new ArrayList<Room>();
        listRoom = FunctionWriteAndReadFileCSV.getFileCsvToRoomList();
        for(Room room : listRoom){
            System.out.println("---------------------------------");
            System.out.println(room.showInfor());
            System.out.println("---------------------------------");
        }
        System.out.println("Enter to continue!!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllHouse() {
        ArrayList<House> listHouse = new ArrayList<House>();
        listHouse = FunctionWriteAndReadFileCSV.getFileCsvToListHouse();
        for(House house:listHouse){
            System.out.println("---------------------------------");
            System.out.println(house.showInfor());
            System.out.println("---------------------------------");
        }
        System.out.println("Enter to continue!!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void showAllVilla() {
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        listVilla = FunctionWriteAndReadFileCSV.getFileCsvToListVilla();
        for(Villa villa:listVilla){
            System.out.println("---------------------------------");
            System.out.println(villa.showInfor());
            System.out.println("---------------------------------");
        }
        System.out.println("Enter to continue!!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void addNewService() {
        System.out.println("Menu: \n"+
                "1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu\n" +
                "5.Exit\n"+
                "Enter the function:");
        String choose = sc.nextLine();
        switch (choose){
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Invalid selection! Enter to continue!");
                sc.nextLine();
                addNewService();
        }
    }

    private void addNewRoom() {
        ArrayList<Room> listRoom = new ArrayList<Room>();
        listRoom = FunctionWriteAndReadFileCSV.getFileCsvToRoomList();
        System.out.println("Enter the number of room want to input: ");
        int num = Integer.parseInt(sc.nextLine());
        for(int i=0;i<num;i++){
            Room room = (Room) roomService.addNewService();
            listRoom.add(room);
        }
        //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded
        FunctionWriteAndReadFileCSV.writeRoomToCsvFile(listRoom);
        System.out.println("Add new room complete!!Enter to continue!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void addNewHouse() {
        ArrayList<House> listHouse = new ArrayList<House>();
        listHouse = FunctionWriteAndReadFileCSV.getFileCsvToListHouse();
        System.out.println("Enter the number of house want to input: ");
        int num = Integer.parseInt(sc.nextLine());
        for(int i=0;i<num;i++){
            House house = (House) houseService.addNewService();
            listHouse.add(house);
        }
        FunctionWriteAndReadFileCSV.writeHouseToFileCSV(listHouse);
        System.out.println("Add new house complete!!Enter to continue!!");
        sc.nextLine();
        displayMainMenu();
    }

    private void addNewVilla() {
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        listVilla = FunctionWriteAndReadFileCSV.getFileCsvToListVilla();
        //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
        System.out.println("Enter number of Villa want to input: ");
        int num = Integer.parseInt(sc.nextLine());
        for(int i=0;i<num;i++){
            System.out.println("Add Villa "+(i+1) +" of "+num);
            Villa villa = (Villa) villaService.addNewService();
            listVilla.add(villa);
        }
        FunctionWriteAndReadFileCSV.writeVillaToFileCSV(listVilla);
        System.out.println("Add new villa complete!!Enter to continue!!");
        sc.nextLine();
        displayMainMenu();
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

}
