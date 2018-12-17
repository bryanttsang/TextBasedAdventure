package Tiles;

import Game.Runner;
import Player.Player;

import java.util.Scanner;

public class Item extends Tile
{

    public Item(int x, int y)
    {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);;
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
            return "？ ";
        }
        return "Ｘ ";
    }
}
