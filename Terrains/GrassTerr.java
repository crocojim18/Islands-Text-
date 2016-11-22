/*  GrassTerr.java
 *  Grass is the main default terrain, making up most of the island.
 *  It's not special.
 */

package Terrains;
 
public class GrassTerr extends Terrain
{ 
    public char getRep()
    {
        return '\'';
    }
    public String getName()
    {
        return "grass";
    }
    public String getArticle()
    {
        return "";
    }
}