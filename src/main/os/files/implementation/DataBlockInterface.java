package main.os.files.implementation;

import main.os.files.vars.DataBlock;

import java.util.List;

public interface DataBlockInterface {

    void createDataBlock() throws Exception;

    List<DataBlock> write(String fileData);

    String read(List<DataBlock> dataBlocks, int size);

    void delete(List<DataBlock> dataBlockList);

    List<DataBlock> update(List<DataBlock> dataBlockList, int oldFileSize, String newFileData);
}
