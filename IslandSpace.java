public class IslandSpace
{
    TerrainSpace terr;
    ObjectSpace obj;
    //constructors
    public IslandSpace()
    {
        terr = new TerrainSpace();
        obj = new ObjectSpace();
    }
    public IslandSpace(Terrain ter)
    {
        terr = new TerrainSpace(ter);
        obj = new ObjectSpace();
    }
    //space functions
    public void changeTerr(Terrain t)
    {
        terr.changeTerrain(t);
    }
    public void changeObj(PhysObject o)
    {
        obj.changeObject(o);
    }
    public boolean isObjEmpty()
    {
        return obj.isObjNull();
    }
    public int getGenNum()
    {
        if(isGenTerr())
        {
            return Integer.parseInt(terr.getTerrName());
        }
        return -1;
    }
    public boolean isTerrWater()
    {
        return terr.isTerrWater();
    }
    public boolean isGenTerr()
    {
        return terr.isGenTerr();
    }
    public String getTerrName()
    {
        return terr.getTerrName();
    }
    public String getObjCommand()
    {
        return obj.getObjCommand();
    }
    public PhysObject getObj()
    {
        return obj.getObj();
    }
    public String getObjName()
    {
        return obj.getObjName();
    }
    public String getObjArticle()
    {
        return obj.getObjArticle();
    }
    //toString
    public String toString()
    {
        if(obj == null || obj.toString().equals(""))
        {
            return terr.toString();
        }
        return obj.toString();
    }
}