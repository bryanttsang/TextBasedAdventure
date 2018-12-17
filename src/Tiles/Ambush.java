package Tiles;

import Player.Player;

public class Ambush extends Tile
{

    public Ambush(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void enterTile(Player x)
    {
        System.out.println("Ambush!");
        x.hp(-20);
        System.out.println("You gained battle experience! Attack +20");
        x.atk(20);
    }

    public void leaveTile(Player x)
    {
        occupant = null;
    }

    @Override
    public String toString()
    {
        if (occupant == null)
        {
            return "█　";
        }
        return "Ｘ ";
    }
}
