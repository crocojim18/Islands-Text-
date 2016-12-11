package UnderTheHood;

import java.util.Scanner;
import java.io.File;
//import java.io.FileReader;
//import java.io.FileNotFoundException;
public class Directions
{
    public static void list(boolean secret)
    {
        try
        {
            if(!secret)
            {
				File dir = new File("UnderTheHood/directions.txt");
                Scanner input = new Scanner(dir);
                String s;
                while(input.hasNext())
                {
                    s = input.nextLine();
                    System.out.println(s);
                }
            }
            else
            {
				File sec = new File("UnderTheHood/etsi k'etsi.txt");
                Scanner input = new Scanner(sec);
                String s;
                while(input.hasNext())
                {
                    s = input.nextLine();
                    System.out.println(s);
                }
            }
        }
        catch(Exception a)
        {
            System.out.println("\"directions.txt\" not found!");
        }
        //catch(ClassNotFoundException b)
        //{
        //    System.out.println("If you see this message, I don't know what's happening.");
        //}
    }
}