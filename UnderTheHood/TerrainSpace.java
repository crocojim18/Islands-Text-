package UnderTheHood;

import Terrains.Terrain;
import Terrains.WaterTerr;

public class TerrainSpace
{
    Terrain t;
    //constructors
    public TerrainSpace()
    {
        t = new WaterTerr();
    }
    public TerrainSpace(Terrain te)
    {
        t = te;
    }
    //terrain controls
    public void changeTerrain(Terrain newOne)
    {
        t = newOne;
    }
    public String getTerrName()
    {
        return t.getName();
    }
    public boolean isTerrWater()
    {
        return (t instanceof WaterTerr);
    }
    public boolean isGenTerr()
    {
        return (t instanceof GenSpace);
    }
    //toString
    public String toString()
    {
        return "" + t.getRep();
    }
}