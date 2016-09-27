/*  CementTerr.java
 *  Represents the terrain used to make roads.
 *  Where we're going, we don't need roads.
 */
public class CementTerr extends Terrain
{ 
    public char getRep()
    {
        return '*';
    }
    public String getName()
    {
        return "cement";
    }
    public String getArticle()
    {
        return "";
    }
}