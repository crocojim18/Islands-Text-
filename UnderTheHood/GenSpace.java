/*  GenSpace.java
 *  GenSpace is only used in island generation. Each space
 *  has a number that is used to tell it where to be. It should
 *  be replaced by grass before the world beccomes playable.
 */
 
package UnderTheHood;
import Terrains.Terrain;
 
public class GenSpace extends Terrain
{
    int layer;
    
    public GenSpace(int l)
    {
        layer = l;
    }
    public String getName()
    {
        return "" + layer;
    }
    public char getRep()
    {
        return 'g';
    }
    public String getArticle()
    {
        return "";
    }
}