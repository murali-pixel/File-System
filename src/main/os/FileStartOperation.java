package main.os;

import main.os.files.vars.DataBlock;
import main.os.files.vars.MetaData;
import main.os.files.implementation.DataBlock_Implementation;
import main.os.files.implementation.File_Implementation;
import main.os.files.implementation.DataBlockInterface;
import main.os.files.implementation.FileInterface;

import java.util.*;

public class FileStartOperation {
    private static final int MEMORY_SIZE = 100;
    private static DataBlockInterface memoryService;
    private static List<MetaData> metaDataList = Collections.synchronizedList(new ArrayList<MetaData>());

    static {
        try {
            memoryService = new DataBlock_Implementation(MEMORY_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static FileInterface fileService = new File_Implementation(memoryService);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       /* createFile(sc, "osdemo1.txt","yr");
        readFile(sc, "osdemo1.txt");
        updateFile(sc, "osdemo1.txt","1529");
        readFile(sc, "osdemo1.txt");*/
        fileOperation();
    }

    private static void fileOperation() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter File Operation");
            String operation = sc.nextLine();

            switch (operation){
                case "CREATE":
                    //create
                    createFile(sc, "yr1529_demo.txt","OS FILE SYSTEM DEMO");
                    break;
                case "READ":
                    //read
                    readFile(sc, "yr1529_demo.txt");
                    break;
                case "DELETE":
                    //delete
                    deleteFile(sc);
                    break;
                case "UPDATE":
                    //update
                    updateFile(sc,"yr1529_demo.txt","Updating new file");
                    break;

            }
        }
    }

    private static void updateFile(Scanner sc, String fileNameToRead, String newFileData) {
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
        //System.out.println("Enter File name");
        String fileNameToRead = sc.nextLine();
        for(MetaData metaData : metaDataList){
            if(!metaData.getFileName().equals(fileNameToRead)){
                continue;
            }
            fileService.delete(metaData.getDataBlockList());
        }
    }

    private static void readFile(Scanner sc, String fileNameToRead) {
        for(MetaData metaData : metaDataList){
            if(!metaData.getFileName().equals(fileNameToRead)){
                continue;
            }
            String fileData = fileService.read(metaData.getDataBlockList(), metaData.getSize());
            System.out.println("DEMO DATA IS-------- " + fileData);
        }
    }

    private static void createFile(Scanner sc, String fileName, String fileData) {
//        System.out.println("Enter File name");
//        String fileName = sc.nextLine();
//        System.out.println("Enter File data");
//        String fileData = sc.nextLine();
        List<DataBlock> dataBlocks = fileService.create(fileName, fileData);
        MetaData metaData = new MetaData(fileName, dataBlocks, fileData.getBytes().length);
        metaDataList.add(metaData);
        System.out.println("File created succesfully");
    }
}
