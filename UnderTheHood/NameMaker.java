package UnderTheHood;

public class NameMaker
{
    public static String giveName()
    {
        return upperName();
    }
    
    public static char giveVowel()
    {
        char hey = giveLetter();
        while(hey!='A'&&hey!='E'&&hey!='I'&&hey!='O'&&hey!='U')
        {
            hey = giveLetter();
        }
        return hey;
    }
    
    public static String upperName()
    {
        String bad = lowerName();
        String good = "";
        good += bad.charAt(0);
        for(int i = 1; i<bad.length();i++)
        {
            good += (char)((int)bad.charAt(i)+(97-65));
        }
        return good;
    }
    
    public static String lowerName()
    {
        String l = "";
        int numVow;
        char doubleChecker;
        int consnum = numOfCons();
        l += giveCons(false);
        if(l.equals("Q")) l+= "U";
        for(int i = 0;i<consnum-1;i++)
        {   
            numVow = numOfVowels();
            for(int j = 0;j<numVow;j++)
            {
                doubleChecker = giveVowel();
                while(doubleChecker==l.charAt(l.length()-1)&&(doubleChecker=='A'||doubleChecker=='I'||doubleChecker=='U')) doubleChecker = giveVowel();
                l += doubleChecker;
            }
            char newOne = giveCons(true);
            l += newOne;
            if(newOne == 'Q'&&i!=consnum-2) l+= "U";
        }
        return l;
    }
    
    public static char giveCons(boolean minusY)
    {
        char hey = giveLetter();
        while(hey=='A'||hey=='E'||hey=='I'||hey=='O'||hey=='U'||(minusY&&hey=='Y'))
        {
            hey = giveLetter();
        }
        return hey;
    }
    
    public static char giveLetter()
    {
        int num;
        num = randomInt(25);
        num += 65;
        return (char) num;
    }
    
    public static int numOfCons()
    {
        int x = randomInt(10);
        if(x==0) return 2;
        else if(x>=1&&x<=6) return 3;
        else return 4;
    }
    
    public static int numOfVowels()
    {
        int x = randomInt(10);
        if(x==0) return 1;
        else if(x>=1&&x<=6) return 1;
        else if(x>=7&&x<=9) return 2;
        else return 900;
    }
    
    public static int randomInt(int stop)
    {
        return (int)(Math.random()*stop);
    }
}