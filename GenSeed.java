
public class GenSeed
{
    String seed;
    int iter;
    
    public GenSeed(String temp)
    {
        String finals = "";
        for(int i = 0; i<temp.length();i++)
        {
            finals += Integer.toBinaryString((int)temp.charAt(i));
        }
        iter = 0;
        seed = finals;
    }
    
    public char iterate()
    {
        char toRet = seed.charAt(iter);
        if(iter<seed.length()-1) iter++;                //CHECK THIS
        else iter = 0;
        return toRet;
    }
    
    public boolean trueOrFalse()
    {
        return (iterate()=='1');
    }
    
    public int fromZeroTo(int stop)
    {
        char[] numz = new char[4];
        String dec = "0.";
        int thisCounts = 0;
        while(thisCounts<5)
        {
            int tryThis = 0;
            for(int i = 0; i<4; i++)
            {
                numz[i] = iterate();
            }
            if(numz[0]=='1')tryThis+=8;
            if(numz[1]=='1')tryThis+=4;
            if(numz[2]=='1')tryThis+=2;
            if(numz[3]=='1')tryThis+=1;
            if(tryThis<10)
            {
                dec += (""+tryThis);
                thisCounts++;
            }
        }
        return (int) (Double.parseDouble(dec)*stop);
    }
}
