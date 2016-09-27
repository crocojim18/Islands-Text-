/*  Corpse.java
 *  This class is used to represent dead things in the world. For example,
 *  if you kill a thing in battle, and it leaves behind a corpse (unlike
 *  a ghost or something), then this is the object it will be replaced by.
 *  Corpses are PhysObjects, but noticably NOT Animate. Those are Zombies.
 *  Corpses are also not Takable, so no stacking corpses.
 *  Fun fact: the word "corpse" comes from the Latin "corpus", meaning body.
 *  It comes through the Old French "cors", and is thus cognate to both English
 *  and French "corps".
 */
public class Corpse extends PhysObject
{
    //Corpses don't move. Thus, move returns an empty string.
    public String move()
    {
        return "";
    }
    //Corpses cannot stay afloat on water. They sink.
    public boolean canSwim()
    {
        return false;
    }
    //"a" corpse
    public String getArticle()
    {
        return "a ";
    }
    public String getName()
    {
        return "corpse";
    }
    //In the world, a corpse will show 'x'.
    public char getRep()
    {
        return 'x';
    }
    public boolean flammable()
    {
        return true;
    }
}