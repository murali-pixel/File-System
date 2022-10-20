package main.os;
public class Sector {
    private static int Back_Fixed;
    private static Sector  frwd;
    private static Sector free[];
    private static Sector filler;
    static char type;
    static String Name;
    static int link;
    static int size;


    public static void main(String args[]) {
        Sector sectors[] = new Sector[100];
        int free_count= sectors.length;
        for (int i = 0; i < 100; i++) {
            sectors[i] = new Sector();
        }
    /*Map<Object, ArrayList<Object>> multiMap = new HashMap<>();

    Map<String, List<String>> hm = new HashMap<String, List<String>>();
    List<String> type = new ArrayList<String>();*/


        int sub_fields[][] = new int[31][4];

        sub_fields[0][0] = type;
        sub_fields[0][1] = Integer.parseInt(Name);
        sub_fields[0][2] = link;
        sub_fields[0][3] = size;
        // check if sector is U or D by using isinstance()
        for (int sect=0;sect<100;sect++) {
            Back_Fixed = 0;
            frwd=sectors[sect+1];
            filler = null;
            for(int row=1;row<30;row++){
                for(int col=0;col<4;col++){
                    sub_fields[row][col]= Integer.parseInt("DATA TO BE FILLED FROM FILE INSIDE DIRECTORY");
                }

            }

        }

        }
}


