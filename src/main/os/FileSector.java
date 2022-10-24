package main.os;

public class FileSector extends DirectorySector {
    private static FileSector back;
    private static FileSector frwrd;

    private static FileSector filedata;

//    Iterator<Object>listiteratator = files.iterator();
//
//    public Iterator<Object> getListiteratator() {
//        return listiteratator;
//    }
public static void main(String[] args) {
    FileSector files[] = new FileSector[3];
    for (int i=0;i<100;i++){
        files[i]= new FileSector();
    }

    files[0]=back;
    files[1]=frwrd;
    files[2]=filedata;

}

}
