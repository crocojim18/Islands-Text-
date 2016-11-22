package UnderTheHood;

import Items.PhysObject;
import Terrains.GrassTerr;
import Terrains.WaterTerr;
import Terrains.Terrain;
import Collections.Collection;
import Items.Living.Conversatiable;
import Items.Living.Player;
import Items.Living.Fightable;
import Items.Takables.Takable;
import Items.Takables.Candy;

public class Island
{
    IslandSpace[][] arr;
    int size;
    FightSpace arena;
    TalkSpace forum;
    public Island(int size)
    {
        if(size%2==0) size+=1;
        arr = new IslandSpace[size][size];
        int currLayer = 0;
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                arr[i][j] = new IslandSpace();
            }
        }
        this.size = size;
        chooseInit(arr);
        for(int iter = 0; iter < ((size/2)-1); iter++)
            currLayer = genIterate(arr, currLayer);

        for(int ytur8 = 0; ytur8 < size; ytur8++)
        {
            for(int xterate = 0; xterate < size; xterate++)
            {
                if(arr[xterate][ytur8].isGenTerr()) arr[xterate][ytur8].changeTerr(new GrassTerr());
            }
        }
        arena = new FightSpace();
        forum = new TalkSpace();
    }

    public boolean addObj(PhysObject obj, int xCoord, int yCoord)
    {
        if(arr[yCoord][xCoord].isObjEmpty() && (!arr[yCoord][xCoord].isTerrWater() || obj.canSwim()))
        {
            arr[yCoord][xCoord].changeObj(obj);
            return true;
        }
        return false;
    }

    public boolean addCollection(Collection coll, int xCoord, int yCoord)
    {
        PhysObject[][] argh = coll.getArr();
        Terrain[][] argh2 = coll.getTerrArr();
        for(int k = 0;k<coll.getHeight();k++)
        {
            for(int l = 0;l<coll.getLength();l++)
            {
                if(!arr[yCoord+k][xCoord+l].isObjEmpty() || arr[yCoord+k][xCoord+l].isTerrWater()) return false;
            }
        }
        for(int i = 0;i<coll.getHeight();i++)
        {
            for(int j = 0;j<coll.getLength();j++)
            {
                addObj(argh[i][j],xCoord+j,yCoord+i);
                if(argh2[i][j]!=null) arr[yCoord+i][xCoord+j].changeTerr(argh2[i][j]);
            }
        }
        return true;
    }

    public int[] getPlayerCoordinates()
    {
        int[] toRet = new int[2];
        toRet[0] = -1; toRet[1] = -1;
        for(int i = 0;i<size;i++)
        {
            for(int j = 0;j<size;j++)
            {
                if(arr[j][i].getObj() instanceof Player)
                {
                    toRet[0] = i; toRet[1] = j;
                }
            }
        }
        return toRet;
    }

    public boolean moveObj(PhysObject obj, int curX, int curY, int toX, int toY)
    {
        if(arr[toY][toX].isObjEmpty() && (!arr[toY][toX].isTerrWater() || obj.canSwim()))
        {
            arr[toY][toX].changeObj(obj);
            arr[curY][curX].changeObj(null);
            return true;
        }
        return false;
    }

    //iteration functions
    public void iterate(Inventory inv)
    {
        PhysObject[] theseGottaMove = new PhysObject[arr.length*arr[0].length];
        String[] theseHereCommands = new String[arr.length*arr[0].length];
        int numWeOn = 0;
        String comm;
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0; j < arr[i].length;j++)
            {
                if(!arr[j][i].isObjEmpty())
                {
                    comm = arr[j][i].getObjCommand();
                    if(!comm.equals(""))
                    {
                        theseGottaMove[numWeOn] = arr[j][i].getObj();
                        theseHereCommands[numWeOn] = comm;
                        numWeOn++;
                    }
                }
            }
        }
        String comm2;
        int dir;
        PhysObject hyperRef;
        boolean kill = false;
        for(int d = 0;d<numWeOn;d++)
        {
            for(int b = 0;b<arr.length && !kill;b++)
            {
                for(int c = 0; c < arr[b].length && !kill;c++)
                {
                    if( theseGottaMove[d] == arr[c][b].getObj() ) 
                    {
                        hyperRef = theseGottaMove[d];
                        comm2 = theseHereCommands[d];
                        if(comm2.charAt(0) == 'r') dir = (int)(Math.random()*4);    //random
                        else if(comm2.charAt(0) == 'n') dir = 0;                    //North
                        else if (comm2.charAt(0) == 'w') dir = 1;                   //West
                        else if (comm2.charAt(0) == 's') dir = 2;                   //South
                        else if (comm2.charAt(0) == 'e')dir = 3;                    //East
                        else dir = -1;
                        if(dir !=-1)
                        {
                            int parson = Integer.parseInt(comm2.substring(1,2));
                            boolean done = false;
                            int newB = b;
                            int newC = c;
                            while(parson > 0 && !done)
                            {
                                if(dir == 0)
                                {   
                                    done = !moveObj(hyperRef, newB, newC, newB, newC-1);
                                    newC--;
                                }
                                else if(dir == 1)
                                {   
                                    done = !moveObj(hyperRef, newB, newC, newB-1, newC);
                                    newB--;
                                }
                                else if(dir == 2)
                                {
                                    done = !moveObj(hyperRef, newB, newC, newB, newC+1);
                                    newC++;
                                }
                                else if(dir == 3)
                                {
                                    done = !moveObj(hyperRef, newB, newC, newB+1, newC);
                                    newB++;
                                }
                                parson--;
                            }
                        }
                        if(comm2.charAt(0) == 'l')                                  //Look
                        {
                            if(comm2.charAt(1) == 'n') System.out.println("You look north and see "+arr[c-1][b].getObjArticle()+arr[c-1][b].getObjName()+".");
                            else if(comm2.charAt(1) == 'w') System.out.println("You look west and see "+arr[c][b-1].getObjArticle()+arr[c][b-1].getObjName()+".");
                            else if(comm2.charAt(1) == 's') System.out.println("You look south and see "+arr[c+1][b].getObjArticle()+arr[c+1][b].getObjName()+".");
                            else if(comm2.charAt(1) == 'e') System.out.println("You look east and see "+arr[c][b+1].getObjArticle()+arr[c][b+1].getObjName()+".");
                            else if(comm2.charAt(1) == 'd') System.out.println("You look down and see "+arr[c][b].getTerrName()+".");
                        }
                        else if(comm2.charAt(0) == 'm')
                        {
                            System.out.println(returnSmallMap());
                        }
                        else if(comm2.charAt(0) == 'f')
                        {
                            if(comm2.charAt(1) == 'n' && arr[c-1][b].getObj() instanceof Fightable)
                            {
                                arena.setFighters((Fightable)arr[c][b].getObj(), (Fightable)arr[c-1][b].getObj());
                                arena.fight(inv);
                                cleanTheDead();
                            }
                            else if(comm2.charAt(1) == 'e' && arr[c][b+1].getObj() instanceof Fightable)
                            {
                                arena.setFighters((Fightable)arr[c][b].getObj(), (Fightable)arr[c][b+1].getObj());
                                arena.fight(inv);
                                cleanTheDead();
                            }
                            else if(comm2.charAt(1) == 's' && arr[c+1][b].getObj() instanceof Fightable)
                            {
                                arena.setFighters((Fightable)arr[c][b].getObj(), (Fightable)arr[c+1][b].getObj());
                                arena.fight(inv);
                                cleanTheDead();
                            }
                            else if(comm2.charAt(1) == 'w' && arr[c][b-1].getObj() instanceof Fightable)
                            {
                                arena.setFighters((Fightable)arr[c][b].getObj(), (Fightable)arr[c][b-1].getObj());
                                arena.fight(inv);
                                cleanTheDead();
                            }
                            else System.out.println("Nothing is fightable in that direction!");
                        }
                        else if(comm2.charAt(0) == 'g')                              //Correlates with "Take", but stands for 'grab'
                        {
                            if(comm2.charAt(1) == 'n' && arr[c-1][b].getObj() instanceof Takable)
                            {
                                if(inv.addObj((Takable)arr[c-1][b].getObj()))
                                {
                                    String arti = arr[c-1][b].getObjArticle();
                                    String namzz = arr[c-1][b].getObjName();
                                    arr[c-1][b].changeObj(null);
                                    System.out.println("You added "+arti+namzz+" to your inventory.");
                                }
                            }
                            else if(comm2.charAt(1) == 's' && arr[c+1][b].getObj() instanceof Takable)
                            {
                                if(inv.addObj((Takable)arr[c+1][b].getObj()))
                                {
                                    String arti = arr[c+1][b].getObjArticle();
                                    String namzz = arr[c+1][b].getObjName();
                                    arr[c+1][b].changeObj(null);
                                    System.out.println("You added "+arti+namzz+" to your inventory.");
                                }
                            }
                            else if(comm2.charAt(1) == 'e' && arr[c][b+1].getObj() instanceof Takable)
                            {
                                if(inv.addObj((Takable)arr[c][b+1].getObj()))
                                {
                                    String arti = arr[c][b+1].getObjArticle();
                                    String namzz = arr[c][b+1].getObjName();
                                    arr[c][b+1].changeObj(null);
                                    System.out.println("You added "+arti+namzz+" to your inventory.");
                                }
                            }
                            else if(comm2.charAt(1) == 'w' && arr[c][b-1].getObj() instanceof Takable)
                            {
                                if(inv.addObj((Takable)arr[c][b-1].getObj()))
                                {
                                    String arti = arr[c][b-1].getObjArticle();
                                    String namzz = arr[c][b-1].getObjName();
                                    arr[c][b-1].changeObj(null);
                                    System.out.println("You added "+arti+namzz+" to your inventory.");
                                }
                            }
                            else if(comm2.charAt(1) == 'p')
                            {
                                System.out.println(inv);
                            }
                            else if(comm2.charAt(1) == 'd')
                            {
                                if(comm2.charAt(3) == 'n')
                                {
                                    if(arr[c-1][b].isObjEmpty())
                                    {
                                        int blehj = Integer.parseInt(comm2.substring(2,3));
                                        if(!inv.isSpotEmpty(blehj))arr[c-1][b].changeObj(inv.removeObj(blehj));
                                        else System.out.println("Inventory item #"+(blehj+1)+" is empty!");
                                    }
                                    else System.out.println("But there's already something to the north!");
                                }
                                else if(comm2.charAt(3) == 's')
                                {
                                    if(arr[c+1][b].isObjEmpty())
                                    {
                                        int blehj = Integer.parseInt(comm2.substring(2,3));
                                        if(!inv.isSpotEmpty(blehj))arr[c+1][b].changeObj(inv.removeObj(blehj));
                                        else System.out.println("Inventory item #"+(blehj+1)+" is empty!");
                                    }
                                    else System.out.println("But there's already something to the south!");
                                }
                                else if(comm2.charAt(3) == 'e')
                                {
                                    if(arr[c][b+1].isObjEmpty())
                                    {
                                        int blehj = Integer.parseInt(comm2.substring(2,3));
                                        if(!inv.isSpotEmpty(blehj))arr[c][b+1].changeObj(inv.removeObj(blehj));
                                        else System.out.println("Inventory item #"+(blehj+1)+" is empty!");
                                    }
                                    else System.out.println("But there's already something to the east!");
                                }
                                else if(comm2.charAt(3) == 'w')
                                {
                                    if(arr[c][b-1].isObjEmpty())
                                    {
                                        int blehj = Integer.parseInt(comm2.substring(2,3));
                                        if(!inv.isSpotEmpty(blehj))arr[c][b-1].changeObj(inv.removeObj(blehj));
                                        else System.out.println("Inventory item #"+(blehj+1)+" is empty!");
                                    }
                                    else System.out.println("But there's already something to the west!");
                                }
                                else System.out.println("Something has gone wrong internally.");
                            }
                            else if(comm2.charAt(1) == 'c')
                            {
                                Takable edi = inv.getByName(comm2.substring(2));
                                if(edi != null)
                                {
                                    if(edi instanceof Candy)
                                    {
                                        int ediPlace = inv.getIndex(edi);
                                        Candy toEat = (Candy) edi;
                                        int goodness = toEat.returnGoodness();
                                        Fightable estoyEater = (Fightable) arr[c][b].getObj();
                                        estoyEater.changeHealth(goodness);
                                        inv.removeObj(ediPlace);
                                        System.out.println("You ate the "+toEat.getName()+" which gave you "+goodness+" more HP!");
                                    }
                                    else
                                    {
                                        System.out.println("You can't eat that.");
                                    }
                                }
                                else
                                {
                                    System.out.println("There is no "+comm2.substring(2)+" in your inventory.");
                                }
                            }
                            else if(comm2.charAt(1) == 't')
                            {
                                if(comm2.charAt(2) == 'n' && arr[c-1][b].getObj() instanceof Conversatiable)
                                {
                                    forum.setTalkers((Player)arr[c][b].getObj(), (Conversatiable)arr[c-1][b].getObj());
                                    forum.talk((Player)arr[c][b].getObj(),inv);
                                }
                                else if(comm2.charAt(2) == 'e' && arr[c][b+1].getObj() instanceof Conversatiable)
                                {
                                    forum.setTalkers((Player)arr[c][b].getObj(), (Conversatiable)arr[c][b+1].getObj());
                                    forum.talk((Player)arr[c][b].getObj(),inv);
                                }
                                else if(comm2.charAt(2) == 's' && arr[c+1][b].getObj() instanceof Conversatiable)
                                {
                                    forum.setTalkers((Player)arr[c][b].getObj(), (Conversatiable)arr[c+1][b].getObj());
                                    forum.talk((Player)arr[c][b].getObj(),inv);
                                }
                                else if(comm2.charAt(2) == 'w' && arr[c][b-1].getObj() instanceof Conversatiable)
                                {
                                    forum.setTalkers((Player)arr[c][b].getObj(), (Conversatiable)arr[c][b-1].getObj());
                                    forum.talk((Player)arr[c][b].getObj(),inv);
                                }
                                else System.out.println("You can't talk to anyone in that direction!");
                            }
                            else System.out.println("You cannot take anything in that direction!");
                        }
                        kill = true;
                    }
                }
            }
            kill = false;
        }
    }

    public int[][] getNonWaterSpaces()
    {
        int[][] almost = new int[size*size][2];
        int counter = 0;
        for(int i = 0; i<size;i++)
        {
            for(int j = 0; j<size;j++)
            {
                if(!arr[j][i].isTerrWater())
                {
                    almost[counter][0] = i;
                    almost[counter][1] = j;
                    counter++;
                }
            }
        }
        int[][] returnable = new int[counter][2];
        for(int w = 0;w<counter;w++)
        {
            returnable[w][0] = almost[w][0];
            returnable[w][1] = almost[w][1];
        }
        return returnable;
    }

    public void placeVariousObjects(PhysObject[] toPlace)
    {
        int[][] available = getNonWaterSpaces();
        boolean kill;
        int[] coords;
        for(int i = 0;i<toPlace.length;i++)
        {
            kill = false;
            while(!kill)
            {
                coords = available[randRange(available.length)];
                kill = addObj(toPlace[i], coords[0], coords[1]);
            }
        }
    }

    public void placeVariousCollections(Collection[] toPlace)
    {
        int[][] available = getNonWaterSpaces();
        boolean kill;
        int[] coords;
        for(int i = 0;i<toPlace.length;i++)
        {
            kill = false;
            while(!kill)
            {
                coords = available[randRange(available.length)];
                kill = addCollection(toPlace[i], coords[0], coords[1]);
            }
        }
    }

    //island gen functions
    private int oneToTen()
    {
        return randRange(10)+1;
    }

    private int randRange(int cap)
    {
        return (int) (Math.random()*cap);
    }

    private boolean retProb(int num, int outOf)
    {
        if(num >= outOf) return true;
        else if(num == 0) return false;
        else
        {
            if(randRange(outOf)<num) return true;
            else return false;
        }
    }

    private void chooseInit(IslandSpace[][] arr)
    {
        int numOf = 3;
        int roll = oneToTen();
        if(roll == 1)
        {
            numOf = 1;
        }
        else if(roll > 1 && roll < 4)
        {
            numOf = 2;
        }
        for(int i = 0; i < numOf; i++)
        {
            int pickX = ((int)(Math.random()*3))+ ((size/2)-1);
            int pickY = ((int)(Math.random()*3))+ ((size/2)-1);
            arr[pickY][pickX].changeTerr(new GenSpace(0));
        }
    }

    private int genIterate(IslandSpace[][] arr, int layer)
    {
        layer += 1;
        for(int y = 0; y < arr.length; y++)
        {
            for(int x = 0; x < arr[y].length; x++)
            {
                if(arr[x][y].isGenTerr() && arr[x][y].getGenNum()==(layer-1))
                {
                    if(retProb( (size/2)-(size/10) -layer, (size/3)))
                    {
                        for(int j = 0; j < 8; j++)
                        {
                            if(arr[x-1][y].toString().equals("~"))
                                arr[x-1][y].changeTerr(new GenSpace(layer));
                            if(arr[x+1][y].toString().equals("~"))
                                arr[x+1][y].changeTerr(new GenSpace(layer));
                            if(arr[x][y+1].toString().equals("~"))
                                arr[x][y+1].changeTerr(new GenSpace(layer));
                            if(arr[x][y-1].toString().equals("~"))
                                arr[x][y-1].changeTerr(new GenSpace(layer));
                            if(arr[x-1][y-1].toString().equals("~"))
                                arr[x-1][y-1].changeTerr(new GenSpace(layer));
                            if(arr[x+1][y+1].toString().equals("~"))
                                arr[x+1][y+1].changeTerr(new GenSpace(layer));
                            if(arr[x-1][y+1].toString().equals("~"))
                                arr[x-1][y+1].changeTerr(new GenSpace(layer));
                            if(arr[x+1][y-1].toString().equals("~"))
                                arr[x+1][y-1].changeTerr(new GenSpace(layer));
                        }
                    }
                }
            }
        }
        return layer;
    }

    public void cleanTheDead()
    {
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0;j<arr[i].length;j++)
            {
                if(arr[j][i].getObj() instanceof Fightable && ((Fightable) (arr[j][i].getObj())).isDead())
                {
                    Fightable asFight = (Fightable) arr[j][i].getObj();
                    arr[j][i].changeObj(asFight.getReplacement());
                }
            }
        }
    }

    //toString
    public String toString()
    {
        return showPlayer();
    }

    public String returnSmallMap()
    {
        String[] cars = new String[4];
        String[][] big = new String[size/2][size/2];
        String finale;
        for(int i = 0;i<size-1;i+=2)
        {
            for(int j = 0;j<size-1;j+=2)
            {
                cars[0] = arr[j][i].toString();
                cars[1] = arr[j][i+1].toString();
                cars[2] = arr[j+1][i].toString();
                cars[3] = arr[j+1][i+1].toString();
                int[] howMany = new int[4];
                for(int k = 0;k<4;k++)
                {
                    for(int l = 0;l<4;l++)
                    {
                        if(cars[k].equals("@")) howMany[k] = 500;
                        else if(cars[k].equals(cars[l])) howMany[k]++;
                    }
                }
                int max = 0;int address = 0;
                for(int h = 0;h<4;h++)
                {
                    if(howMany[h]>max)
                    {
                        address = h;
                        max = howMany[h];
                    }
                }
                finale = cars[address];
                big[j/2][i/2] = finale;
            }
        }
        String beea = "";
        for(int i = 0; i < big.length; i++)
        {
            for(int j = 0; j < big.length; j++)
            {
                beea += big[i][j];// + " ";
            }
            beea += "\n";
        }
        return beea;
    }

    public String showPlayer()
    {
        int[] coords = getPlayerCoordinates();
        int topX = 0, topY = 0;
        if(coords[0]==-1)
        {
            return "You died. The game is over.";
        }
        if(coords[0]>13 && coords[0]<size-13) topX = coords[0] - 12;
        else if(coords[0]>size-13) topX = size-25;
        if(coords[1]>13 && coords[1]<size-13) topY = coords[1] - 12;
        else if(coords[1]>size-13) topY = size-25;
        String h = "";
        for(int i = 0; i < 25; i++)
        {
            for(int j = 0; j < 25; j++)
            {
                h += arr[topY+i][topX+j].toString() + " ";
            }
            h += "\n";
        }
        return h;
    }

    public String showTheWholeThing()
    {
        String h = "";
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                h += arr[i][j].toString() + " ";
            }
            h += "\n";
        }
        return h;
    }
}