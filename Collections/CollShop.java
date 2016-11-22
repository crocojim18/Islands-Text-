package Collections;

import Items.PhysObject;
import Items.Living.Shopkeeper;
import Items.Immovables.BrickWall;
import Items.Takables.Window;
import Terrains.Terrain;
import Terrains.TileTerr;

public class CollShop extends Collection
{
    
    public CollShop(int height, int length)
    {
        h = height;
        l = length;
        arr = new PhysObject[height][length];
        arr[h/2][l/2] = new Shopkeeper();
        for(int i = 0;i<height;i++)
        {
            for(int j = 0;j<length;j++)
            {
                if((j==0 || i==0 || i==height-1 || j==length-1)&&(j!=length/2 && i!=height/2)) arr[i][j] = new BrickWall();
                if(j==length/2 && i==0) arr[i][j] = new Window();
                if(i==height/2 && (j==0 || j==length-1))arr[i][j] = new Window();
            }
        }
        arr2 = new Terrain[height][length];
        for(int x = 0;x<height;x++)
        {
            for(int y = 0;y<length;y++)
            {
                arr2[x][y] = new TileTerr();
            }
        }
    }
}