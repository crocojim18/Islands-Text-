/*  PhysObject.java
 *  PhysObjects are obects that exist and take up a space in
 *  the world. Terrains are NOT PhysObjects, because they're
 *  the bottom layer of the space.
 */
public abstract class PhysObject implements Visible
{
    //Every PhysObject has two attributes:
    //Whether it can exist in water (nothing so far)
    //And what its move is when the game refreshes.
    public abstract boolean canSwim();
    public abstract String move();
    public abstract boolean flammable();
}