/*  WaterTerr.java
 *  Water is the thing that surrounds each island.
 */
public class WaterTerr extends Terrain
{ 
    public char getRep()
    {
        return '~';
    }
    public String getName()
    {
        return "water";
    }
    public String getArticle()
    {
        return "";
    }
}