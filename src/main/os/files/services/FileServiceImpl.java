package main.os.files.services;

import main.os.files.models.DataBlock;

import java.util.List;

public class FileServiceImpl implements main.os.files.services.IFileService {
    private main.os.files.services.IMemoryService memoryService;
    public FileServiceImpl(main.os.files.services.IMemoryService memoryService) {
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
