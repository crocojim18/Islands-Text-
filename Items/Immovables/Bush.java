/*  Bush.java
 *  Bushes are PhysObjects.
 *  They have no purpose currently outside of decoration.
 */
 
package Items.Immovables;

import Items.PhysObject;
 
public class Bush extends PhysObject
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
        return "bush";
    }
    public char getRep()
    {
        return 'b';
    }
    public boolean flammable()
    {
        return true;
    }
}