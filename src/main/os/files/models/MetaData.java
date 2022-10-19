package main.os.files.models;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class MetaData {
    private UUID uuid;
    private String fileName;
    private List<DataBlock> dataBlockList;
    private int size;
}
