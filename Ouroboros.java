public class Ouroboros extends Animate implements Fightable
{
    int hp;
    boolean left;
    int distance;
    int step;

    public Ouroboros()
    {
        hp = 15;
        left = false;
        distance = ((int)(Math.random()*4))+2;
        step = 0;
    }

    public String move()
    {
        if(step>distance)
        {
            step = 0;
            left = !left;
        }
        else
        {
            step++;
        }
        if(left) return "w1";
        else return "e1";
    }

    public String getArticle()
    {
        return "an ";
    }

    public String getName()
    {
        return "ouroboros";
    }

    public char getRep()
    {
        return 'O';
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

    public boolean changeHealth(int change)
    {
        hp += change;
        return (hp>0);
    }

    public Takable[] getDrops()
    {
        Takable[] toRet = {new Snakeskin()};
        return toRet;
    }

    public boolean isDead()
    {
        return !(hp>0);
    }

    public int[] takeTurn(Inventory inv)
    {
        int turn = (int) (Math.random()*6);
        int[] toRet = new int[2];
        if(turn<5)
        {
            toRet[1] = -3;
            System.out.println("The ouroboros unfurls momentarily, bites you, and quickly refurls.");
        }
        else
        {
            toRet[1] = -9;
            System.out.println("The ouroboros makes you ponder recursion and the universe!");
        }
        toRet[0] = 1;
        return toRet;
    }

    public boolean canFlee()
    {
        return true;
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
