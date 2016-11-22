/* Zombie.java
 * Hey, look at that! A monster!
 * Zombies are monsters that roam in squares.
*/
 
package Items.Living; //ironic, because it's dead
import Items.Takables.Takable;
import Items.Takables.Rock;
import Items.Immovables.Corpse;
import Items.PhysObject;
import UnderTheHood.Inventory;

public class Zombie extends Animate implements Fightable
{
    int hp; //health
    int direction; //which direction is it going?
    //DIRECTION TABLE:
    //-------------
    //| 0 | EAST  |
    //| 1 | SOUTH |
    //| 2 | WEST  |
    //| 3 | NORTH |
    //-------------
    int turn; //should the zombie turn?

    
    /* method Zombie()
     * ARGUMENTS:   none
     * RETURNS:     none
     * Constructor for zombie. Sets hp, direction, and the turn variable.
     */
    public Zombie()
    {
        hp = 30; //You got 30 chances to kill this guy
        direction = 0; //starts out going east
        turn = 0; //set to not yet turn
    }

    
    /* method move()
     * ARGUMENTS:   none
     * RETURNS:     string
     * Increments wheter or not to turn, then gives a direction accordingly
     */
    public String move()
    {
        if(turn<3) turn++; //if the zombie hasn't stepped enough, then keep on steppin'
        else //WHOA YOU STEPPED TOO MUCH
        {
            if(direction<3) //we want to stay in the turning boundaries
            {
                direction++; //Turn!
            }
            else
            {
                direction = 0; //start the turning over again!
            }
            turn = 0; //start the stepping over again
        }
        if(direction == 0) return "e1"; //send the east signal!
        else if (direction == 1)return "s1"; //send the south signal!
        else if (direction == 2) return "w1"; //send the west signal!
        else return "n1"; //send the north signal!
    }

    /* method getArticle()
     * ARGUMENTS:   none
     * RETURNS:     string
     * Gives the zombie an article for dialogue purposes.
     */
    public String getArticle()
    {
        return "a ";
    }

    /* method getName()
     * ARGUMENTS:   none
     * RETURNS:     string
     * Gives the zombie a name for dialogue purposes.
     */
    public String getName()
    {
        return "zombie";
    }

    public char getRep()
    {
        return 'Z';
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
        Takable[] toRet = {new Rock()};
        return toRet;
    }

    public boolean isDead()
    {
        return !(hp>0);
    }

    public int[] takeTurn(Inventory inv)
    {
        int turn = (int) (Math.random()*2);
        int[] toRet = new int[2];
        if(turn==1)
        {
            toRet[1] = -9;
            System.out.println("The zombie bites!");
        }
        else
        {
            toRet[1] = -2;
            System.out.println("The zombie scratches!");
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
