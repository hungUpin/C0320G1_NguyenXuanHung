package controllers;


import model.House;
import model.Room;
import model.Villa;
import service.ServiceInterface;
import service.impl.FunctionWriteAndReadFileCSV;
import service.impl.*;


import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    private static ServiceInterface villaService = new VillaServiceImp();
    private static ServiceInterface houseService = new HouseServiceImp();
    private static ServiceInterface roomService = new RoomServiceImp();
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
                "6. Show Information Of Customer.\n"+
                "7. Exit\n");
        System.out.println("Enter the function: ");
        String choose = sc.nextLine();
        switch (choose){
            case "1":
                addNewService();
                break;
            case "2":
                showServices();
                break;
            case "7":
                System.exit(0);
            default:
                System.out.println("Invalid selection!!! Please choose again!!!Enter to continue!!!");
                sc.nextLine();
                displayMainMenu();
        }
    }

    private void showServices() {
        System.out.println("Menu: \n"+
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n"+
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
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
                break;
            default:
                System.out.println("Invalid selection!!! Please choose again!!!Enter to continue!!!");
                sc.nextLine();
                showServices();
        }

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
