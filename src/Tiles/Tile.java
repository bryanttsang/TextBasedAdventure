package Tiles;

import Player.Player;

public class Tile
{
    public Player occupant;
    public int xLoc,yLoc;

    public Tile(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * player enters tile
     * @param x the player entering
     */
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * player leaves tile
     * @param x the player leaving
     */
    public void leaveTile(Player x)
    {
        occupant = null;
    }

    /**
     * normal tile
     * @return tile on board
     */
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
