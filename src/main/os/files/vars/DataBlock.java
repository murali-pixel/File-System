package main.os.files.vars;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataBlock {
    private int start;
    private Boolean isOccupied;
}
