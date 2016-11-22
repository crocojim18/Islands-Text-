package UnderTheHood;

import Items.Takables.Tradeable;

public class Stock
{
    Tradeable[] inv;

    public Stock(Tradeable t)
    {
        inv = new Tradeable[1];
        inv[0] = t;
    }

    public void addObj(Tradeable toAdd)
    {
        if(!contains(toAdd.getName()))
        {
            Tradeable[] newGuy = new Tradeable[inv.length+1];
            for(int i = 0; i < inv.length; i++)
            {
               newGuy[i] = inv[i];
            }
            newGuy[newGuy.length-1] = toAdd;
            inv = newGuy;
        }
    }

    public void removeObj(int index)
    {
        if(inv.length>0)
        {
            Tradeable[] newGuy = new Tradeable[inv.length-1];
            inv[index] = null;
            int newIndex = 0;
            for(int i = 0; i<inv.length; i++)
            {
                if(inv[i] != null)
                {
                    newGuy[newIndex] = inv[i];
                    newIndex++;
                }
            }
            inv = newGuy;
        }
    }

    public Tradeable getObj(int index)
    {
        if(index < inv.length)
        {
            return inv[index];
        }
        return null;
    }

    public boolean isEmpty()
    {
        return (inv.length==0);
    }

    public int getNumberOfItems()
    {
        return inv.length;
    }
    
    public boolean contains(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(s.equalsIgnoreCase(inv[i].getName())) return true;
        }
        return false;
    }
    
    public Tradeable getByName(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(s.equalsIgnoreCase(inv[i].getName())) return inv[i];
        }
        return null;
    }
    
    public int getPriceByName(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(s.equalsIgnoreCase(inv[i].getName())) return inv[i].getPrice();
        }
        return 0;
    }
    
    public int getIndex(String s)
    {
        for(int i = 0;i<inv.length;i++)
        {
            if(s.equalsIgnoreCase(inv[i].getName())) return i;
        }
        return -1;
    }
    
    public int length()
    {
        return inv.length;
    }

    public String toString()
    {
        String toRet = "Here are my prices!:\n";
        for(int i = 0; i < inv.length; i++)
        {
            toRet+=("\t"+inv[i].getName()+"\t\t"+inv[i].getPrice()+"\n");
        }
        return toRet;
    }

    public Tradeable[] toTradeableArray()
    {
        return inv;
    }

}