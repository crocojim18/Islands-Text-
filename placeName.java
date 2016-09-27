import java.util.Scanner;
public class placeName
{
    GenSeed shade;
    public void main()
    {
        Scanner in = new Scanner(System.in);
        String temp = "";
        while(temp.length() <= 0)
        {
            System.out.println("Seed: ");
            temp = in.nextLine();
        }
        shade = new GenSeed(temp);
        
        for(int i = 0; i<50; i++)
        {
            String name = "";
            
            name+=firsts();
            
            if(randomInt(10)<6)
            {
                name+=middles();
                for(int toLoop = 4;randomInt(10)<toLoop;toLoop-=3)
                {
                    name+=middles();
                }
            }
            
            name+=lasts();
            
            System.out.println(name);
        }
    }
    
    public int randomInt(int stop)
    {
        return shade.fromZeroTo(stop);
    }
    
    public String firsts()
    {
        String[] names = {"Con","Ab","Ag","An","Pe",
                          "Hag","Eg","Eth","Zim","My",
                          "In","Ni","Ly","Le","Lan",
                          "Ser","No","Dem","Ha","Gal",
                          "Gos","Gra","Mo","Fi","F'",
                          "Ar","Wash","Te","Mi","Bi",
                          "Thy","Py","Pi","Bri","Ty",
                          "Dy","Di","Cap","A","Cru",
                          "Ge","En","P'","O","Nor",
                          "Pa","Per","Dra","Gol","Ka",
                          "Ap", "Su","Yen","Yem","Ter"};
        return names[randomInt(names.length)];
    }
    public String middles()
    {
        String[] names = {"ton","lin","i","ing","ter",
                          "em","fo","son","che","bu",
                          "ston","on","ver","tar","bec",
                          "ki","na","kon","co","an",
                          "a","o","ap","ni","so",
                          "gi","or","gai","jar","el",
                          "ri","mi","os","no","cer",
                          "ma","se","fi","ga","mer",
                          "syl","e","u"};
        return names[randomInt(names.length)];
    }
    public String lasts()
    {
        String[] names = {"ton","so","ia","ore","aire",
                          "ee","la","io","efs","al",
                          "mar","ron","on","a","ne",
                          "ter","oe","yn","ni","i",
                          "os","ma","vo","us","co",
                          "ra","un","um","tha","bul"};
        return names[randomInt(names.length)];
    }
}
