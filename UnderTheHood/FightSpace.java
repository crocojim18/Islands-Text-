package UnderTheHood;

import Items.Living.Fightable;
import Items.Living.Player;

public class FightSpace
{
    Fightable f1;
    Fightable f2;
    public void setFighters(Fightable p, Fightable fi)
    {
        f1 = p; f2 = fi;
    }

    public void fight(Inventory inv)
    {
        Fightable first; Fightable second;
        first = f1; second = f2;
        int[] moves1; int[] moves2;
        System.out.println("THE EPIC BATTLE: "+first.getName()+" VS "+second.getName()+"!!");
        while(!first.isDead()&&!second.isDead())
        {
            System.out.println("\nIt's "+first.getName()+"'s turn!");
            moves1 = first.takeTurn(inv);
            if(moves1[0]==1)
            {
                System.out.println("It deals "+(-1*moves1[1])+" damage to "+second.getName()+"!");
                second.changeHealth(moves1[1]);
                System.out.println(first.getName()+"'s HP: "+first.getHp());
                System.out.println(second.getName()+"'s HP: "+second.getHp());
            }
            if(second.isDead()) break;
            System.out.println("\nIt's "+second.getName()+"'s turn!");
            moves2 = second.takeTurn(inv);
            if(moves2[0]==1)
            {
                System.out.println("It deals "+(-1*moves2[1])+" damage to "+first.getName()+"!");
                first.changeHealth(moves2[1]);
                System.out.println(first.getName()+"'s HP: "+first.getHp());
                System.out.println(second.getName()+"'s HP: "+second.getHp());
            }
        }
        if(first.isDead()) System.out.println(first.getName()+" is dead.");
        if(second.isDead()) System.out.println(second.getName()+" is dead.");
        first = null;second = null;
        if(f1 instanceof Player)
        {
            Player play = (Player) f1;
            Fightable f = f2;
            if(f.getDrops().length>0&&!play.isDead())
            {
                System.out.println(f.getName()+" dropped the following:");
                for(int smileyPoopEmoji = 0;smileyPoopEmoji<f.getDrops().length;smileyPoopEmoji++)
                {
                    if(inv.addObj(f.getDrops()[smileyPoopEmoji]))System.out.println(f.getDrops()[smileyPoopEmoji].getName());
                }
            }
            play.newFight = true;
        }
        else if(f2 instanceof Player)
        {
            Fightable f = f1;
            Player play = (Player) f2;
            if(f.getDrops().length>0&&!play.isDead())
            {
                System.out.println(f.getName()+" dropped the following:");
                for(int smileyPoopEmoji = 0;smileyPoopEmoji<f.getDrops().length;smileyPoopEmoji++)
                {
                    if(inv.addObj(f.getDrops()[smileyPoopEmoji]))System.out.println(f.getDrops()[smileyPoopEmoji].getName());
                }
            }
            play.newFight = true;
        }
        f1 = null; f2 = null;
    }
}