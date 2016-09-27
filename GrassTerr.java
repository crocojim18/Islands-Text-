/*  GrassTerr.java
 *  Grass is the main default terrain, making up most of the island.
 *  It's not special.
 */
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