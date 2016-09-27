/*  Rock.java
 *  Rocks are PhysObjects, Takable, and pretty good weapons.
 */
public class Rock extends PhysObject implements Takable
{
    public char getRep()
    {
        return 'r';
    }
    public String getName()
    {
        return "rock";
    }
    public String getArticle()
    {
        return "a ";
    }
    public boolean canSwim()
    {
        return false;
    }
    public String move()
    {
        return "";
    }
    //use as weapon
    public String[] getAttackNames()
    {
        String[] toRet = {"Stone","Hit","Pummel"};
        return toRet;
    }
    public int[] getAttackDamages()
    {
        int[] toReturn = {8,4,7};
        return toReturn;
    }
    public boolean flammable()
    {
        return false;
    }
}