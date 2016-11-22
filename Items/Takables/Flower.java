/*  Flower.java
 *  Flowers are PhysObjects, and are Takable.
 *  Each flower has a color (default yellow), and they
 *  can be used as weapons, like all Takables.
 */
package Items.Takables;

import Items.PhysObject;
 
public class Flower extends PhysObject implements Takable
{
    String color; //this is the color of the flower

    //String co is the color of the flower, and a color is needed at instantiation.
    public Flower(String co)
    {
        color = co;
    }

    public Flower()
    {
        this("yellow");
    }
    
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
        return color+" flower";
    }

    public char getRep()
    {
        return 'f';
    }
    //use as weapon
    public String[] getAttackNames()
    {
        String[] toRet = {"Hit","Poke"};
        return toRet;
    }

    public int[] getAttackDamages()
    {
        int[] toRet = {0,1};
        return toRet;
    }
    
    public boolean flammable()
    {
        return true;
    }
}