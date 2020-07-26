import java.util.Scanner;

public class main
{

    public static void main(String[] args)
    {
        //var for the mode, 0 = gb and 1 = mb
        int mode = 0;
        int time;

        //This part handles the file type, all of this is redundant but i might need it later
        Scanner scan = new Scanner(System.in);
        System.out.println("GB or MB?");
        String type = scan.nextLine().toUpperCase();
        if (type.equals("MB"))
        {
            mode = 1;
        }
        else if (type.equals("GB"))
        {
            mode = 0;
        }
        else
        {
            System.out.println("Unknown file type..");
            System.out.println("Exiting..");
            System.exit(1);
        }

        System.out.println("Size");
        double size = scan.nextDouble();

        System.out.println("Speed");
        double speed = scan.nextDouble();

        /*
         switch(mode)
         {
             case 0:
                 time = gbCalc.calculate(size, speed);
                 break;
             case 1:
                 time = mbCalc.calculate((int) Math.round(size), speed);
                 break;
             default:
                 throw new IllegalStateException("Unexpected value: " + mode);
         }
         */

        //System.out.println(timeCalc.convert(time));
    }
}
