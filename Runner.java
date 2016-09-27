public class Runner
{
    public static void main(String[] args)
    {
        Island i = new Island(80);
        Player playa = new Player("The Player");
        Inventory inv = new Inventory();
        Collection[] c = {new CollHouse(8,10), new CollShop(5,5)/*,new CollHouse(4,5),
        new CollHouse(4,5),new CollHouse(4,5),new CollHouse(4,5)}*/};
        PhysObject[] p = {playa, new Cat(), new Rock(),
                new Rock(), new Rock(), new Bush(),
                new Flower(), new Flower(), new Flower(),
                new Flower(), new Flower(), new Rock(),
                new Rock(), new Rock(), new Zombie(),
                new Zombie(), new Zombie(), new Ouroboros(),
                new Girl()};
        i.placeVariousCollections(c);
        i.placeVariousObjects(p);
        boolean kill = false;
        int[] frameCommands;
        System.out.println("ISLANDS 0.0.1.0");
        System.out.println("by Marty Taylor (crocojim18)\n");
        System.out.println("For directions, type \"help\" or \"directions\".");
        while(!kill)
        {
            System.out.println(i);
            frameCommands = playa.askForMove();
            if(frameCommands[1]<1) frameCommands[1] = 1;
            for(int inc = 0;inc<frameCommands[1];inc++)
                i.iterate(inv);
            if(frameCommands[0]==1) kill=true;
            if(playa.isDead()) kill = true;
        }
    }

    private static int randomSpace(int size)
    {
        int i = (int)(Math.random()*size);
        return i;
    }
}