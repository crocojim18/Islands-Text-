public class TalkSpace
{
    Player player;
    Conversatiable npc;
    public void setTalkers(Player p, Conversatiable np)
    {
        player = p;
        npc = np;
    }

    public void talk(Player pl, Inventory inven)
    {
        boolean convover = false;
        while(!convover)
        {
            convover = npc.respond(pl, inven);
        }
    }
}