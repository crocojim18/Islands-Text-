package UnderTheHood;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Reader
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new FileReader("etsi k'etsi.txt"));
        String s;
        while(input.hasNext())
        {
            s = input.nextLine();
            System.out.println(s);
        }
    }
}