package UnderTheHood;

import Items.Takables.Takable;
import Items.PhysObject;

public class Inventory
{
    Takable[] inv;

    public Inventory()
    {
        inv = new Takable[10];
    }

    public boolean addObj(Takable toAdd)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]==null) {inv[i] = toAdd; return true;}
        }
        System.out.println("Your inventory is full!");
        return false;
    }

    public PhysObject removeObj(int index)
    {
        PhysObject l = (PhysObject) inv[index];
        inv[index] = null;
        return l;
    }

    public Takable getObj(int index)
    {
        return inv[index];
    }

    public boolean isEmpty()
    {
        int sum = 0;
        for(int i = 0;i<10;i++)
        {
            if(inv[i]==null) sum+=1;
        }
        return (sum==10);
    }

    public boolean isFull()
    {
        int sum = 0;
        for(int i = 0;i<10;i++)
        {
            if(inv[i]!=null) sum+=1;
        }
        return (sum==10);
    }
    
    public int getNumberOfItems()
    {
        int sum = 0;
        for(int i = 0;i<10;i++)
        {
            if(inv[i]!=null) sum+=1;
        }
        return (sum);
    }
    
    public boolean contains(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]!=null && s.equalsIgnoreCase(inv[i].getName())) return true;
        }
        return false;
    }

    public Takable getByName(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]!=null && s.equalsIgnoreCase(inv[i].getName())) return inv[i];
        }
        return null;
    }

    public Takable[] getUniqueItems()
    {
        Takable[] proto = new Takable[10];
        int jstate = 0;
        for(int i = 0;i<inv.length;i++)
        {
            boolean donut = true;
            for(int j = 0;j<proto.length;j++)
            {
                if(inv[i]!=null && proto[j]!=null && inv[i].getName()==proto[j].getName()) donut = false;
            }
            if(donut) {proto[jstate]=inv[i];jstate++;}
        }
        int sum = 0;
        for(int i = 0;i<10;i++)
        {
            if(proto[i]!=null) sum+=1;
        }
        Takable[] toRet = new Takable[sum];
        for(int i = 0;i<sum;i++)
        {
            toRet[i] = proto[i];
        }
        return toRet;
    }
    
    public int getIndex(Takable obj)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]==obj) return i;
        }
        return -1;
    }
    
    public int getIndexByName(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]!=null && s.equalsIgnoreCase(inv[i].getName())) return i;
        }
        return -1;
    }
    
    public boolean isSpotEmpty(int spot)
    {
        if(spot<10&&spot>-1)
        {
            return (inv[spot]==null);
        }
        return false;
    }

    public int length()
    {
        return inv.length;
    }

    public String toString()
    {
        String printee = "";
        for(int i = 0;i<inv.length;i++)
        {
            printee += "Item "+(i+1)+": ";
            if(inv[i]==null)printee += "EMPTY";
            else printee += inv[i].getName();
            printee += "\n";
        }
        return printee;
    }

    public Takable[] toTakableArray()
    {
        int num = 0;
        for(int i = 0;i<inv.length;i++)
        {
            if(inv[i]!=null) num++;
        }
        Takable[] toRet = new Takable[num];
        int newCount = 0;
        for(int x = 0;x<inv.length;x++)
        {
            if(inv[x]!=null)
            {
                toRet[newCount] = inv[x];
                newCount++;
            }
        }
        return toRet;
    }

}