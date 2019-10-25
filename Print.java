public class Print {
    public static void print (int x){
        System.out.println("this is Integer "+ x);
    }
    public static void print (String s){
        System.out.println("this is String "+ s);
    }
    public static void print (int x,int y){
        for(int i=0;i<y;i++)
            System.out.print(x);
        System.out.println();
    }
    public static void print (int x,int y,int z) {
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++)
                System.out.print(x);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /**the main will try every method in the print methods*/
        print (5);
        print ("Hamza");
        print (5,2);
        print (1 ,5,3);
    }
}
