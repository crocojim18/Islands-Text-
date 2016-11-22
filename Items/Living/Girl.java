package Items.Living;

import UnderTheHood.Inventory;
import Items.Takables.Takable;
import Items.Takables.Flower;
import Items.Immovables.Corpse;
import Items.PhysObject;
import UnderTheHood.NameMaker;

public class Girl extends NPC
{
    String name;
    int hp;
    Inventory inven;
    int bestPlace;
    int bestMove;
    Takable[] invTak;

    public Girl()
    {
        name = NameMaker.giveName();
        inven = new Inventory();
        inven.addObj(new Flower());
        inven.addObj(new Flower());
        inven.addObj(new Flower());
        invTak = getDrops();
        int[] t = findBestMove(invTak);
        bestPlace = t[0];
        bestMove = t[1];
        hp = 75;
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
        return name;
    }

    public char getRep()
    {
        return 'G';
    }

    public PhysObject getReplacement()
    {
        return new Corpse();
    }

    public Takable[] getDrops()
    {
        return inven.toTakableArray();
    }

    public void setPersonalName(String nam)
    {
        name = nam;
    }

    public String getPersonalName()
    {
        return name;
    }

    public boolean isDead()
    {
        return !(hp>0);
    }

    public boolean changeHealth(int change)
    {
        hp += change;
        return (hp>0);
    }

    public int getHp()
    {
        return hp;
    }

    public int[] takeTurn(Inventory inv)
    {
        System.out.println("The girl uses her "+invTak[bestPlace].getName()+".");
        System.out.println(invTak[bestPlace].getAttackNames()[bestMove]+"!");
        int[] toRet = new int[2];
        toRet[0] = 1; toRet[1] = -1*invTak[bestPlace].getAttackDamages()[bestMove];
        return toRet;
    }
    
    public boolean canFlee()
    {
        return false;
    }
    
    public boolean respond(Player pl, Inventory playersInventory)
    {
        System.out.println("My name is "+name+".");
        return true;
    }
    
    public boolean flammable()
    {
        return true;
    }
}