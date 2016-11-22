package Items.Living;

import java.util.Scanner;
import Items.Takables.Takable;
import Items.Immovables.Corpse;
import UnderTheHood.Directions;
import Items.PhysObject;
import UnderTheHood.Inventory;

public class Player extends Animate implements Fightable
{
    boolean swim;
    String name;
    String nextMove;
    int hp;
    String lastWeapon;
    int lastMove;
    public boolean newFight = true;
    int wallet;
    
    public Player(String nam)
    {
        name = nam;
        swim = false;
        nextMove = "";
        hp = 50;
        wallet = 20;
    }

    //A LARGE COMPENDIUM OF HOW TO ENCODE MOVES:
    //------------------------------------------
    //|KEY: '+' means a specificied direction  |
    //|     represented by n, s, e, & w        |
    //|     In addition, there is a direction r|
    //|     which represents a random direction|
    //|     There also exists a direction 'd'  |
    //|     used for "down" when applicable.   |
    //|     '#' represents a number            |
    //------------------------------------------
    //|INPUT               |ENCODING           |
    //------------------------------------------
    //|quit                |[none]             |
    //|move                |+1                 |
    //|look                |l+                 |
    //|fight               |f+                 |
    //|take                |g+                 |
    //|check inventory     |gp                 |
    //|check map           |m                  |
    //|directions          |[none]             |
    //|help                |[none]             |
    //|secret              |[none]             |
    //|place               |gd#+               |
    //|eat                 |gc[name of candy]  |
    //|talk                |gt+
    //------------------------------------------
    public int[] askForMove()
    {
        int[] toReturn = new int[2];
        nextMove = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Command: ");
        String temp = in.nextLine();
        if(temp.equalsIgnoreCase("quit")||isDead())
        {
            toReturn[0] = 1;
            return toReturn;
        }
        String[] wurds = temp.split(" ");
        String verb = wurds[0];
        if(verb.equalsIgnoreCase("move"))
        {
            if(wurds.length == 1){System.out.println("Move where?"); toReturn[0] = 0; return toReturn;}
            int parson = -1;
            if(wurds.length > 2)
            {
                try
                {
                    parson = Integer.parseInt(wurds[2]);
                }
                catch(NumberFormatException a)
                {
                    System.out.println("Move where?");
                    toReturn[0] = 0;
                    return toReturn;
                }
            }
            if(wurds[1].equalsIgnoreCase("north")) 
            {
                if(wurds.length > 2) toReturn[1] = parson;
                nextMove = "n1";
            }
            else if(wurds[1].equalsIgnoreCase("south"))
            {
                if(wurds.length > 2) toReturn[1] = parson;
                nextMove = "s1";
            }
            else if(wurds[1].equalsIgnoreCase("east"))
            {
                if(wurds.length > 2) toReturn[1] = parson;
                nextMove = "e1";
            }
            else if(wurds[1].equalsIgnoreCase("west"))
            {
                if(wurds.length > 2) toReturn[1] = parson;
                nextMove = "w1";
            }
            else {System.out.println("Move where?");}
        }
        else if(verb.equalsIgnoreCase("look"))
        {
            if(wurds.length == 1) System.out.println("Look where?");
            else if(wurds[1].equalsIgnoreCase("north")) nextMove = "ln";
            else if(wurds[1].equalsIgnoreCase("south")) nextMove = "ls";
            else if(wurds[1].equalsIgnoreCase("east")) nextMove = "le";
            else if(wurds[1].equalsIgnoreCase("west")) nextMove = "lw";
            else if(wurds[1].equalsIgnoreCase("down")) nextMove = "ld";
            else System.out.println("Look where?");
        }
        else if(verb.equalsIgnoreCase("fight"))
        {
            if(wurds.length == 1) System.out.println("Fight in which direction?");
            else if(wurds[1].equalsIgnoreCase("north")) nextMove = "fn";
            else if(wurds[1].equalsIgnoreCase("south")) nextMove = "fs";
            else if(wurds[1].equalsIgnoreCase("east")) nextMove = "fe";
            else if(wurds[1].equalsIgnoreCase("west")) nextMove = "fw";
            else System.out.println("Fight in which direction?");
        }
        else if(verb.equalsIgnoreCase("take"))
        {
            if(wurds.length == 1) System.out.println("Take in which direction?");
            else if(wurds[1].equalsIgnoreCase("north")) nextMove = "gn";
            else if(wurds[1].equalsIgnoreCase("south")) nextMove = "gs";
            else if(wurds[1].equalsIgnoreCase("east")) nextMove = "ge";
            else if(wurds[1].equalsIgnoreCase("west")) nextMove = "gw";
            else System.out.println("Take in which direction?");
        }
        else if(verb.equalsIgnoreCase("check"))
        {
            if(wurds.length == 1) System.out.println("Check what?");
            else if(wurds[1].equalsIgnoreCase("inventory"))nextMove = "gp"; //g for the grab function that represents the inventory, and p for 'print'
            else if(wurds[1].equalsIgnoreCase("map")) nextMove = "m";
            else System.out.println("Check what?");
        }
        else if(verb.equalsIgnoreCase("directions") || verb.equalsIgnoreCase("help"))
        {
            Directions.list(false);
        }
        else if(verb.equalsIgnoreCase("secret"))
        {
            Directions.list(true);
        }
        else if(verb.equalsIgnoreCase("place"))
        {
            if(wurds.length < 3){System.out.println("Place what where?"); toReturn[0] = 0; return toReturn;}
            int numnum = -1;
            try
            {
                numnum = Integer.parseInt(wurds[1]);
            }
            catch(NumberFormatException a)
            {
                System.out.println("Place what where?");
                toReturn[0] = 0;
                return toReturn;
            }
            if(numnum>=1 && numnum<=10)
            {
                nextMove = "gd"+(Integer.parseInt(wurds[1])-1); //g for the grab function that represents the inventory, and d for 'disperse'
                if(wurds[2].equalsIgnoreCase("north")) nextMove += "n";
                else if(wurds[2].equalsIgnoreCase("south")) nextMove += "s";
                else if(wurds[2].equalsIgnoreCase("east")) nextMove += "e";
                else if(wurds[2].equalsIgnoreCase("west")) nextMove += "w";
                else{nextMove = ""; System.out.println("Place what where?");}
            }
            else if(numnum<1 || numnum>10) System.out.println("That's not a valid item number.");
            else System.out.println("Place what?");
        }
        else if(verb.equalsIgnoreCase("eat"))
        {
            nextMove = "gc";
            String whatToEat = "";
            for(int i = 1; i<wurds.length;i++)
            {
                whatToEat += wurds[i];
                if(i!=wurds.length-1) whatToEat += " ";
            }
            nextMove += whatToEat;
        }
        else if(verb.equalsIgnoreCase("talk"))
        {
            nextMove = "gt";
            if(wurds.length == 1) System.out.println("Talk in which direction?");
            else if(wurds[1].equalsIgnoreCase("north")) nextMove += "n";
            else if(wurds[1].equalsIgnoreCase("south")) nextMove += "s";
            else if(wurds[1].equalsIgnoreCase("east")) nextMove += "e";
            else if(wurds[1].equalsIgnoreCase("west")) nextMove += "w";
            else System.out.println("Talk in which direction?");
        }
        else System.out.println("I don't understand that input.");
        toReturn[0] = 0;
        return toReturn;
    }

    public String move()
    {
        return nextMove;
    }

    public boolean canSwim()
    {
        return swim;
    }

    public String getName()
    {
        return name;
    }

    public String getArticle()
    {
        return "";
    }

    public char getRep()
    {
        return '@';
    }
    //fighting stuff
    public int[] takeTurn(Inventory inv)
    {
        int[] toret = new int[2];
        toret[0] = 1;
        Scanner in = new Scanner(System.in);
        while(1==1)
        {
            System.out.println("What is your move?");
            String temp = in.nextLine();
            String[] wurds = temp.split(" ");
            if(temp.equalsIgnoreCase("check inventory")) System.out.println(inv.toString());
            if(temp.equalsIgnoreCase("directions") || temp.equalsIgnoreCase("help"))
            {
                Directions.list(false);
            }
            if(wurds.length>=3&&!inv.isEmpty()&&wurds[1].equalsIgnoreCase("with"))
            {
                String totalWeapon = "";
                for(int i = 2; i<wurds.length;i++)
                {
                    totalWeapon += wurds[i];
                    if(i!=wurds.length-1) totalWeapon += " ";
                }
                boolean itemValid = inv.contains(totalWeapon);
                boolean attackValid = false;
                int index = -1;
                if(itemValid)
                {
                    Takable weapon = inv.getByName(totalWeapon);
                    lastWeapon = totalWeapon;
                    for(int u = 0;u<weapon.getAttackNames().length;u++)
                    {
                        if(wurds[0].equalsIgnoreCase(weapon.getAttackNames()[u]))
                        {
                            attackValid = true;
                            index = u;
                            lastMove = u;
                        }
                    }
                }
                if(itemValid && attackValid)
                {
                    toret[1] = -1*(inv.getByName(totalWeapon).getAttackDamages()[index]);
                    newFight = false;
                    return toret;
                }
            }
            else if(inv.isEmpty())
            {
                System.out.println("You have nothing in your inventory, and thus nothing to fight with.");
                System.out.println("You punch the enemy for lack of a better weapon.");
                toret[1] = -5;
                return toret;
            }
            else if(wurds[0].equals("") && !newFight)
            {
                toret[1] = -1*(inv.getByName(lastWeapon).getAttackDamages()[lastMove]);
                return toret;
            }
            else if(wurds.length>3 && wurds[0].equalsIgnoreCase("list")
            && wurds[1].equalsIgnoreCase("moves") && wurds[2].equalsIgnoreCase("for"))
            {
                String needsMoves = "";
                for(int i = 3; i<wurds.length;i++)
                {
                    needsMoves += wurds[i];
                    if(i!=wurds.length-1) needsMoves += " ";
                }
                if(inv.contains(needsMoves))
                {
                    String[] allTheseMoves = inv.getByName(needsMoves).getAttackNames();
                    System.out.println("\nMoves for "+needsMoves+":");
                    for(int i=0;i<allTheseMoves.length;i++)
                    {
                        System.out.println("\t"+allTheseMoves[i]);
                    }
                    System.out.println();
                }
                else System.out.println("Sorry, you don't have that in your inventory.");
            }
        }
    }

    public int getHp()
    {
        return hp;
    }

    public boolean canFlee()
    {
        return true;
    }
    
    public boolean changeHealth(int change)
    {
        hp += change;
        return (hp>0);
    }

    public boolean isDead()
    {
        return !(hp>0);
    }

    public Takable[] getDrops()
    {
        return new Takable[0];
    }

    public PhysObject getReplacement()
    {
        return new Corpse();
    }
    
    public boolean flammable()
    {
        return true;
    }
    
    public int getWallet()
    {
        return wallet;
    }
    
    public void changeWallet(int difference)
    {
        wallet += difference;
    }
}