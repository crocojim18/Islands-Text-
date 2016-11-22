package UnderTheHood;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class Directions
{
    public static void list(boolean secret)
    {
        try
        {
            if(!secret)
            {
                Class p = Class.forName("Directions");
                Scanner input = new Scanner(p.getResourceAsStream("directions.txt"));
                String s;
                while(input.hasNext())
                {
                    s = input.nextLine();
                    System.out.println(s);
                }
            }
            else
            {
                Class p = Class.forName("Directions");
                Scanner input = new Scanner(p.getResourceAsStream("etsi k'etsi.txt"));
                String s;
                while(input.hasNext())
                {
                    s = input.nextLine();
                    System.out.println(s);
                }
            }
        }
        catch(NullPointerException a)
        {
            System.out.println("\"directions.txt\" not found!");
        }
        catch(ClassNotFoundException b)
        {
            System.out.println("If you see this message, I don't know what's happening.");
        }
    }
}