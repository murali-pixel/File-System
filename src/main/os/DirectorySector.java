package main.os;
public class DirectorySector {
    private static int Back_Fixed;
    private static DirectorySector frwd;
    private static DirectorySector free[];
    private static DirectorySector filler;
    static char type;
    static String Name;
    static int link;
    static int size;


    public static void main(String args[]) {
        DirectorySector directorySectors[] = new DirectorySector[100];
        int free_count= directorySectors.length;
        for (int i = 0; i < 100; i++) {
            directorySectors[i] = new DirectorySector();
        }
    /*Map<Object, ArrayList<Object>> multiMap = new HashMap<>();

    Map<String, List<String>> hm = new HashMap<String, List<String>>();
    List<String> type = new ArrayList<String>();*/


        int sub_fields[][] = new int[31][4];
        // check if sector is U or D by using isinstance()
        for (int sect=0;sect<100;sect++) {
            Back_Fixed = 0;
            frwd= directorySectors[sect+1];
            filler = null;
            for(int row=0;row<30;row++){
                for(int col=0;col<4;col++){
                    sub_fields[row][col]= type;
                    sub_fields[row][col+1]= Integer.parseInt(Name);
                    sub_fields[row][col+2]= link;
                    sub_fields[row][col+3]= size;

                }

            }

        }

        }
}


