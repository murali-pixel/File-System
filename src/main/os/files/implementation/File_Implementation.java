package main.os.files.implementation;

import main.os.files.vars.DataBlock;

import java.util.List;

public class File_Implementation implements FileInterface {
    private DataBlockInterface dataBlockInterface;
    public File_Implementation(DataBlockInterface dataBlockInterface) {
        this.dataBlockInterface = dataBlockInterface;
    }

    public List<DataBlock> create(String fileName, String fileData) {
        //write wrapper to encrypt
        List<DataBlock> dataBlocks =  dataBlockInterface.write(fileData);
        return dataBlocks;
    }

    public String read(List<DataBlock> dataBlocks, int size) {
        //write wrapper to decrypt
        String fileData = dataBlockInterface.read(dataBlocks, size);
        return fileData;
    }

    public void delete(List<DataBlock> dataBlockList) {
        dataBlockInterface.delete(dataBlockList);
    }

    public List<DataBlock> update(List<DataBlock> dataBlockList, int oldFileSize, String newFileData) {
        List<DataBlock> dataBlocks =  dataBlockInterface.update(dataBlockList, oldFileSize, newFileData);
        return dataBlocks;
    }

}
