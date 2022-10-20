package main.os.files.implementation;

import main.os.files.vars.DataBlock;

import java.util.List;

public class File_Implementation implements main.os.files.implementation.IFileService {
    private main.os.files.implementation.IMemoryService memoryService;
    public File_Implementation(main.os.files.implementation.IMemoryService memoryService) {
        this.memoryService = memoryService;
    }

    public List<DataBlock> create(String fileName, String fileData) {
        //write wrapper to encrypt
        List<DataBlock> dataBlocks =  memoryService.write(fileData);
        return dataBlocks;
    }

    public String read(List<DataBlock> dataBlocks, int size) {
        //write wrapper to decrypt
        String fileData = memoryService.read(dataBlocks, size);
        return fileData;
    }

    public void delete(List<DataBlock> dataBlockList) {
        memoryService.delete(dataBlockList);
    }

    public List<DataBlock> update(List<DataBlock> dataBlockList, int oldFileSize, String newFileData) {
        List<DataBlock> dataBlocks =  memoryService.update(dataBlockList, oldFileSize, newFileData);
        return dataBlocks;
    }

}
