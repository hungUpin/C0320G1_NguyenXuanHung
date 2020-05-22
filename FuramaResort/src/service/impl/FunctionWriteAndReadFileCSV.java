package service.impl;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunctionWriteAndReadFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR="\n";
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String FILE_HEADER_VILLA = "id,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,poolArea,floorNumber";
    private static final String FILE_HEADER_HOUSE = "id,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber";
    private static final String FILE_HEADER_ROOM = "id,serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded";
    public static void writeVillaToFileCSV(ArrayList<Villa> listVilla){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(PATH_FILE_VILLA);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Villa villa:listVilla){
                fileWriter.append(villa.getId());
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
        }catch (Exception e){
            System.out.println("Error in CSVFileWritter!!!");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("Error when flush or close");
            }
        }
    }
    public static ArrayList<Villa> getFileCsvToListVilla(){
        BufferedReader br = null;
        ArrayList<Villa> villalist = new ArrayList<Villa>();
        Path path = Paths.get(PATH_FILE_VILLA);
        if(!Files.exists(path)){
            try{
                //tao file
                Writer writer = new FileWriter(PATH_FILE_VILLA);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_VILLA));
            while ((line = br.readLine())!=null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("id")){
                    continue;
                }
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
                Villa villa = new Villa();
                villa.setId(splitData[0]);
                villa.setServiceName(splitData[1]);
                villa.setArea(Double.parseDouble(splitData[2]));
                villa.setRentFee(Double.parseDouble(splitData[3]));
                villa.setMaxNumOfPerson(Integer.parseInt(splitData[4]));
                villa.setTypeOfRent(splitData[5]);
                villa.setRoomStander(splitData[6]);
                villa.setOtherFacilities(splitData[7]);
                villa.setPoolArea(Integer.valueOf(splitData[8]));
                villa.setFloorNumber(Integer.valueOf(splitData[9]));
                villalist.add(villa);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                br.close();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            return villalist;
        }
    }
    public static void writeHouseToFileCSV(ArrayList<House> listHouse){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(PATH_FILE_HOUSE);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(House house:listHouse){
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
                fileWriter.append(house.getId());
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
        }catch (Exception e){
            System.out.println("Error in CSVFileWritter!!!");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
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
        try{
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_HOUSE));
            while ((line = br.readLine())!=null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("id")){
                    continue;
                }
                House house = new House();
                house.setId(splitData[0]);
                house.setServiceName(splitData[1]);
                house.setArea(Double.parseDouble(splitData[2]));
                house.setRentFee(Double.parseDouble(splitData[3]));
                house.setMaxNumOfPerson(Integer.parseInt(splitData[4]));
                house.setTypeOfRent(splitData[5]);
                house.setRoomStander(splitData[6]);
                house.setOtherFacilities(splitData[7]);
                house.setFloorNumber(Integer.parseInt(splitData[8]));
                houseList.add(house);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                br.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
      return houseList;
    }
    public static void writeRoomToCsvFile(ArrayList<Room> roomList){
        FileWriter fw = null;
        try{
            fw = new FileWriter(PATH_FILE_ROOM);
            fw.append(FILE_HEADER_ROOM);
            fw.append(NEW_LINE_SEPARATOR);
            for(Room room: roomList){
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded
                fw.append(room.getId());
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
        }catch (Exception e){
            System.out.println("Error in CSVFileWritter!!!");
        }finally {
            try{
                fw.flush();
                fw.close();
            }catch (Exception e){
                System.out.println("Error when flush or close");
            }
        }
    }
    public static ArrayList<Room> getFileCsvToRoomList(){
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<Room>();
        Path path = Paths.get(PATH_FILE_ROOM);
        if(!Files.exists(path)){
            try{
                Writer writer = new FileWriter(PATH_FILE_ROOM);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            br = new BufferedReader(new FileReader(PATH_FILE_ROOM));
            while ((line = br.readLine())!=null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("id")){
                    continue;
                }
                Room room = new Room();
                //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,freeServicesIncluded
                room.setId(splitData[0]);
                room.setServiceName(splitData[1]);
                room.setArea(Double.parseDouble(splitData[2]));
                room.setRentFee(Double.parseDouble(splitData[3]));
                room.setMaxNumOfPerson(Integer.parseInt(splitData[4]));
                room.setTypeOfRent(splitData[5]);
                room.setFreeServicesIncluded(splitData[6]);
                listRoom.add(room);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
      return listRoom;
    }
}

