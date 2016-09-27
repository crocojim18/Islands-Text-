/*  Window.java
 *  Windows are PhysObjects, and ARE Takable. That's a little
 *  gag from when this used to be in Python. Oh, the glory days.
 *  Anyway, they have no purpose currently outside of decoration.
 *  Windows are used to make houses in CollHouse.java.
 */
public class Window extends PhysObject implements Takable
{
    //Windows do not move.
    public String move()
    {
        return "";
    }
    //Windows cannot swim. Windows sink.
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
        return "window";
    }
    public char getRep()
    {
        return '-';
    }
    //use as a weapon
    public String[] getAttackNames()
    {
        String[] toRet = {"Defenestrate","Bop","Hit"};
        return toRet;
    }
    public int[] getAttackDamages()
    {
        int[] toRet = {10,2,6};
        return toRet;
    }
    public boolean flammable()
    {
        return false;
    }
}