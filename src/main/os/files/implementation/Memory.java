package main.os.files.implementation;

public class Memory {
    int start;
    int back;
    int frwrd;
    int data[];


    public Memory( int start,int back,int frwrd,int data[]) {
        this.start=start;
        this.back=back;
        this.frwrd=frwrd;
        this.data=data;

    }

    //    private int frwrd;
//    private int back;
//    private int free;
//    private int filler;
//    static char type;
//    public static String Name;
//    static int link;
//    static int size;
//    static int dir[];


//    public DataBlock(int start, boolean isOccupied) {
//
//    }

//    public DataBlock(int blockSize, boolean b, int[] dir) {
//
//    }

    //            dataBlock.getFrwrd();
//            dataBlock.getBack();
//            dataBlock.getFiller();
//            dataBlock.getFree();
//
//            ArrayList<DataBlock> db=new ArrayList<DataBlock>();


            /*for (int k=0;k<5;k++){
                dir[k]= dataBlock.getBack();
                dir[k+1]=dataBlock.getFrwrd();
                dir[k+2]=dataBlock.getFree();
                dir[k+3]=dataBlock.getFiller();
                int sub_fields[][] = new int[31][4];

                char type = 'D';
                int link = 0;
                int size = 0;
                String Name = null;
                for(int row=0;row<30;row++) {
                    for (int col = 0; col < 4; col++) {
                        sub_fields[row][col] = type;
                        sub_fields[row][col+1] = Integer.parseInt(Name);
                        sub_fields[row][col+2] = link;
                        sub_fields[row][col+3] = size;


                    }
                }
               // dir[k+4]=sub_fields;


            }*/
}
