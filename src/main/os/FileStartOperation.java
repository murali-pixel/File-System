package main.os;

import main.os.files.vars.DataBlock;
import main.os.files.vars.MetaData;
import main.os.files.implementation.Memory_Implementation;
import main.os.files.implementation.File_Implementation;
import main.os.files.implementation.IMemoryService;
import main.os.files.implementation.IFileService;

import java.util.*;

public class FileStartOperation {
    private static final int MEMORY_SIZE = 100;
    private static IMemoryService memoryService;
    private static List<MetaData> metaDataList = Collections.synchronizedList(new ArrayList<MetaData>());

    static {
        try {
            memoryService = new Memory_Implementation(MEMORY_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static IFileService fileService = new File_Implementation(memoryService);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createFile(sc, "hello.txt","qwe");
        readFile(sc, "hello.txt");
        updateFile(sc, "hello.txt","12345678");
        readFile(sc, "hello.txt");
    }

    private static void fileOperation() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter File Operation");
            int operation = sc.nextInt(); //take input from the user

            switch (operation){
                case 0:
                    //create
                    createFile(sc, "yr1529_demo.txt","OS FILE SYSTEM DEMO");
                    break;
                case 1:
                    //read
                    readFile(sc, "yr1529_demo.txt");
                    break;
                case 2:
                    //delete
                    deleteFile(sc);
                    break;
                case 3:
                    //update
                    //updateFile(sc);
                    break;

            }
        }
    }

    private static void updateFile(Scanner sc, String fileNameToRead, String newFileData) {
//        System.out.println("Enter File name");
//        String fileNameToRead = sc.nextLine();
//        System.out.println("Enter File data");
//        String newFileData = sc.nextLine();
        //Assuming all the file he/she is searching
        //to handle multiple , display the file names, make user select one and then delete that
        for(MetaData metaData : metaDataList){
            if(!metaData.getFileName().equals(fileNameToRead)){
                continue;
            }
            List<DataBlock> dataBlocks = fileService.update(metaData.getDataBlockList(), metaData.getSize(), newFileData);
            metaData.setDataBlockList(dataBlocks);
            metaData.setSize(newFileData.getBytes().length);
            break;
        }
    }

    private static void deleteFile(Scanner sc) {
        System.out.println("Enter File name");
        String fileNameToRead = sc.nextLine();
        //Assuming all the file he/she is searching
        //to handle multiple , display the file names, make user select one and then delete that
        for(MetaData metaData : metaDataList){
            if(!metaData.getFileName().equals(fileNameToRead)){
                continue;
            }
            fileService.delete(metaData.getDataBlockList());
        }
    }

    private static void readFile(Scanner sc, String fileNameToRead) {
        //ystem.out.println("Enter File name");
        //String fileNameToRead = sc.nextLine();
        //Assuming all the file he/she is searching
        //to handle multiple , display the file names, make user select one and then read that
        for(MetaData metaData : metaDataList){
            if(!metaData.getFileName().equals(fileNameToRead)){
                continue;
            }
            String fileData = fileService.read(metaData.getDataBlockList(), metaData.getSize());
            System.out.println("--"+fileData);
        }
    }

    private static void createFile(Scanner sc, String fileName, String fileData) {
//        System.out.println("Enter File name");
//        String fileName = sc.nextLine();
//        System.out.println("Enter File data");
//        String fileData = sc.nextLine();
        List<DataBlock> dataBlocks = fileService.create(fileName, fileData);
        MetaData metaData = new MetaData(UUID.randomUUID(), fileName, dataBlocks, fileData.getBytes().length);
        metaDataList.add(metaData);
    }
}
