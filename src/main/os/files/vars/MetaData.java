package main.os.files.vars;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class MetaData {
    private String fileName;
    private List<DataBlock> dataBlockList;
    private int size;
}
