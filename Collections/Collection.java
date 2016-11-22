package Collections;

import Items.PhysObject;
import Terrains.Terrain;

public abstract class Collection
{
    PhysObject[][] arr;
    Terrain[][] arr2;
    int h;
    int l;
    public PhysObject[][] getArr()
    {
        return arr;
    }
    public int getLength()
    {
        return l;
    }
    public int getHeight()
    {
        return h;
    }
    public Terrain[][] getTerrArr()
    {
        return arr2;
    }
}