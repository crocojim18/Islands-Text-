package Items.Takables;

import Items.PhysObject;

public class Snakeskin extends PhysObject implements Tradeable, Takable
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
        return "a ";
    }
    public String getName()
    {
        return "snakeskin";
    }
    public char getRep()
    {
        return 's';
    }
    public int getPrice()
    {
        return 5;
    }
    public String[] getAttackNames()
    {
        String[] toRet = {"hit","rub","sand"};
        return toRet;
    }
    public int[] getAttackDamages()
    {
        int[] toRet = {0,1,3};
        return toRet;
    }
    public boolean flammable()
    {
        return true;
    }
}