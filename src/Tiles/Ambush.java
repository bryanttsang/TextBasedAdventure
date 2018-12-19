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
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("Ambush!");
        System.out.println("You got hurt but you gained battle experience! | hp -20 | atk +20");
        x.hp(-20);
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
