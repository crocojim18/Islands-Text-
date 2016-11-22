package Items.Takables;

import Items.PhysObject;

public class Boots extends PhysObject implements Tradeable, Takable
{
    public String move()
    {
        return "";
    }
    public boolean canSwim()
    {
        return false;
    }
    public String getArticle()
    {
        return "two ";
    }
    public String getName()
    {
        return "boots";
    }
    public char getRep()
    {
        return 'd';
    }
    public int getPrice()
    {
        return 3;
    }
    public String[] getAttackNames()
    {
        String[] toRet = {"hit","kick","stomp"};
        return toRet;
    }
    public int[] getAttackDamages()
    {
        int[] toRet = {2,5,7};
        return toRet;
    }
    public boolean flammable()
    {
        return true;
    }
}