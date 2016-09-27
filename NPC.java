public abstract class NPC extends Animate implements Fightable, Conversatiable
{
    public abstract String getPersonalName();
    public abstract void setPersonalName(String nam); 
    public int[] findBestMove(Takable[] invTak)
    {
        if(invTak.length==0)
        {
            int[] to = {-1,-1};
            return to;
        }
        int currBigg = invTak[0].getAttackDamages()[0];
        int[] currPos = {0,0};
        for(int i = 0;i<invTak.length;i++)
        {
            for(int j = 0;j<invTak[i].getAttackDamages().length;j++)
            {
                if(invTak[i].getAttackDamages()[j] > currBigg)
                {
                    currPos[0] = i;
                    currPos[1] = j;
                }
            }
        }
        return currPos;
    }
}
