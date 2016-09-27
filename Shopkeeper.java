import java.util.Scanner;
public class Shopkeeper extends NPC
{
    String name;
    int hp;
    Inventory inven;
    Stock toBuy;
    int bestPlace;
    int bestMove;
    Takable[] invTak;
    String gender;
    String nominative;
    String accusative;
    String genitive;

    public Shopkeeper()
    {
        name = NameMaker.giveName();
        inven = new Inventory();
        inven.addObj(new Snakeskin());
        inven.addObj(new Rock());
        inven.addObj(new Flower());
        toBuy = new Stock(new Snakeskin());
        toBuy.addObj(new Boots());
        invTak = getDrops();
        int[] t = findBestMove(invTak);
        bestPlace = t[0];
        bestMove = t[1];
        hp = 75;
        int genre = (int)(Math.random()*10);
        if(genre < 4)
        {
            nominative = "she";
            accusative = "her";
            genitive = "her";
        }
        else if (genre > 5)
        {
            nominative = "he";
            accusative = "him";
            genitive = "his";
        }
        else
        {
            nominative = "they";
            accusative = "them";
            genitive = "their";
        }
    }
    
    public String move()
    {
        return "";
    }

    public boolean canSwim()
    {
        return false;
    }

    public String getArticle()
    {
        return "a ";
    }

    public String getName()
    {
        return "shopkeeper";
    }

    public char getRep()
    {
        return 'S';
    }

    public PhysObject getReplacement()
    {
        return new Corpse();
    }

    public Takable[] getDrops()
    {
        return inven.toTakableArray();
    }

    public void setPersonalName(String nam)
    {
        name = nam;
    }

    public String getPersonalName()
    {
        return name;
    }

    public boolean isDead()
    {
        return !(hp>0);
    }

    public boolean changeHealth(int change)
    {
        hp += change;
        return (hp>0);
    }

    public int getHp()
    {
        return hp;
    }

    public int[] takeTurn(Inventory inv)
    {
        System.out.println("The shopkeeper uses "+genitive+" "+invTak[bestPlace].getName()+".");
        System.out.println(invTak[bestPlace].getAttackNames()[bestMove]+"!");
        int[] toRet = new int[2];
        toRet[0] = 1; toRet[1] = -1*invTak[bestPlace].getAttackDamages()[bestMove];
        return toRet;
    }
    
    public boolean canFlee()
    {
        return false;
    }
    
    public boolean respond(Player pl, Inventory plInventory)
    {
        System.out.println("My name is "+name+". I'm a shopkeeper!");
        System.out.println("Would you like to trade something?");
        System.out.println(toBuy);
        boolean end = false;
        Scanner in = new Scanner(System.in);
        while(!end)
        {
            String temp = in.nextLine();
            String[] wurds = temp.split(" ");
            String verb = wurds[0];
            if(verb.equalsIgnoreCase("buy"))
            {
                if(wurds.length > 1)
                {
                    String thing = "";
                    for(int i = 1; i < wurds.length; i++)
                    {
                        thing += wurds[i];
                        if(i!=wurds.length-1) thing += " ";
                    }
                    if(toBuy.contains(thing))
                    {
                        int funds = pl.getWallet();
                        int thisPrice = toBuy.getPriceByName(thing);
                        if(funds > thisPrice)
                        {
                            if(!plInventory.isFull())
                            {
                                plInventory.addObj((Takable) toBuy.getByName(thing));
                                pl.changeWallet((-1)*thisPrice);
                                System.out.println("Nice doin' business with ya!");
                            }
                            else System.out.println("You have no more room in your inventory!");
                        }
                        else System.out.print("Sorry, but you don't have the funds for it!");
                    }
                    else System.out.println("Sorry, I'm not selling that!");
                }
                else System.out.println("What do you want to buy?");
            }
            else if(verb.equalsIgnoreCase("sell"))
            {
                if(wurds.length > 1)
                {
                    String thing = "";
                    for(int i = 1; i < wurds.length; i++)
                    {
                        thing += wurds[i];
                        if(i!=wurds.length-1) thing += " ";
                    }
                    if(toBuy.contains(thing) && plInventory.contains(thing))
                    {
                        int thisPrice = toBuy.getPriceByName(thing);
                        plInventory.removeObj(plInventory.getIndexByName(thing));
                        pl.changeWallet(thisPrice);
                        System.out.println("Nice doin' business with ya!");
                    }
                    else System.out.println("Sorry, I'm not buying that!");
                }
                else System.out.println("What do you want to sell?");
            }
            else if(verb.equalsIgnoreCase("check"))
            {
                if(wurds.length == 2)
                {
                    if(wurds[1].equalsIgnoreCase("inventory"))
                    {
                        System.out.println(plInventory);
                    }
                    else if(wurds[1].equalsIgnoreCase("wallet"))
                    {
                        System.out.println("Your wallet has "+pl.getWallet()+" monies");
                    }
                    else if(wurds[1].equalsIgnoreCase("prices"))
                    {
                        System.out.println(toBuy);
                    }
                }
                else System.out.println("Check what?");
            }
            else if(verb.equalsIgnoreCase("leave") || verb.equalsIgnoreCase("quit") || verb.equalsIgnoreCase("exit"))
            {
                end = true;
                System.out.println("Come again!");
            }
            else if(verb.equalsIgnoreCase("directions") || verb.equalsIgnoreCase("help"))
            {
                Directions.list(false);
            }
            else
            {
                System.out.println("What was that? I'm afraid I don't understand.");
            }
        }
        return true;
    }
    
    public boolean flammable()
    {
        return true;
    }
}