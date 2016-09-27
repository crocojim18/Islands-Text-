/*  Candy.java
 *  The express objective of Candy is to be Eaten.
 *  All food descends from Candy, and the purpose of food
 *  is to restore HP.
 */
public abstract class Candy extends PhysObject implements Takable, Tradeable
{
    public boolean canSwim()
    {
        return false;
    }
    public abstract int returnGoodness();
}