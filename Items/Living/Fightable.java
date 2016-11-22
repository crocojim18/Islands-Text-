package Items.Living;

import Items.Takables.Takable;
import UnderTheHood.Inventory;
import Items.PhysObject;

public interface Fightable
{
    public abstract int[] takeTurn(Inventory inv);
    public abstract int getHp();
    public abstract boolean changeHealth(int change);
    public abstract boolean isDead();
    public abstract Takable[] getDrops();
    public abstract PhysObject getReplacement();
    public abstract String getName();
    public abstract boolean canFlee();
}