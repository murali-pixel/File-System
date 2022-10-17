package main.os.files.services;

import main.os.files.models.DataBlock;

import java.util.List;

public interface IMemoryService {

    void createDataBlock() throws Exception;

    List<DataBlock> write(String fileData);

    String read(List<DataBlock> dataBlocks, int size);

    void delete(List<DataBlock> dataBlockList);

    List<DataBlock> update(List<DataBlock> dataBlockList, int oldFileSize, String newFileData);
}
