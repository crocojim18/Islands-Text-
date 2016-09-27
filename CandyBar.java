/*  CandyBar.java
 *  Used to raise HP a decent amount
 */
public class CandyBar extends Candy
{
    private int goodness = 10;
    private int price = 3;
    public int returnGoodness()
    {
        return goodness;
    }
    public boolean flammable()
    {
        return true;
    }
    public String move()
    {
        return "";
    }
    public String getArticle()
    {
        return "a ";
    }
    public String getName()
    {
        return "candy bar";
    }
    public char getRep()
    {
        return 'c';
    }
    public String[] getAttackNames()
    {
        String[] toRet = {"Hit"};
        return toRet;
    }
    public int[] getAttackDamages()
    {
        int[] toRet = {1};
        return toRet;
    }
    public int getPrice()
    {
        return price;
    }
}
