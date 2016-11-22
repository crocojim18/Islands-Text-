/*  BrickWall.java
 *  Windows are PhysObjects, but are not Takable.
 *  They have no purpose currently outside of decoration.
 *  BrickWalls are used to make houses in CollHouse.java.
 */
 
package Items.Immovables;
 
import Items.PhysObject;
 
public class BrickWall extends PhysObject
{
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
        return "brick wall";
    }
    public char getRep()
    {
        return '=';
    }
    public boolean flammable()
    {
        return false;
    }
}