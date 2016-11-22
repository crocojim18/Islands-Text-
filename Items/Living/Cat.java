package Items.Living;

import Items.Takables.Takable;
import Items.Immovables.Corpse;
import UnderTheHood.Inventory;
import Items.PhysObject;

public class Cat extends Animate implements Fightable
{
    int hp;
    
    public Cat()
    {
        hp = 35;
    }
    
    public String move()
    {
        return "r1";
    }
    
    public String getArticle()
    {
        return "a ";
    }
    
    public String getName()
    {
        return "cat";
    }
    
    public char getRep()
    {
        return 'C';
    }
    
    public boolean canSwim()
    {
        return false;
    }
    //fighting junk
    public int getHp()
    {
        return hp;
    }
    
    public boolean canFlee()
    {
        return true;
    }
    
    public boolean changeHealth(int change)
    {
        hp += change;
        return (hp>0);
    }
    
    public Takable[] getDrops()
    {
        return new Takable[0];
    }
    
    public boolean isDead()
    {
        return !(hp>0);
    }
    
    public int[] takeTurn(Inventory inv)
    {
        System.out.println("The cat scratches!");
        int[] toRet = new int[2];
        toRet[0] = 1; toRet[1] = -7;
        return toRet;
    }
    
    public PhysObject getReplacement()
    {
        return new Corpse();
    }
    
    public boolean flammable()
    {
        return true;
    }
}
