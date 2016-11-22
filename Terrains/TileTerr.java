/*  TileTerr.java
 *  Represents the terrain used inside houses, tile.
 *  Tile is used to make houses in CollHouse.java and
 *  CollShop.java.
 */
 
package Terrains;
 
public class TileTerr extends Terrain
{ 
    public char getRep()
    {
        return ' ';
    }
    public String getName()
    {
        return "tile";
    }
    public String getArticle()
    {
        return "";
    }
}