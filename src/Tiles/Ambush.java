package Tiles;

import Player.Player;

public class Ambush extends Tile
{

    private boolean first = true;

    public Ambush(int x, int y)
    {
        super(x, y);
    }

    /**
     * function of ambush tile
     * @param x the player entering
     */
    @Override
    public void enterTile(Player x)
    {
        if (first)
        {
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            System.out.println("Ambush!");
            System.out.println("You got hurt but you gained battle experience. | hp -20 | atk +20");
            x.hp(-20);
            x.atk(20);
            first = false;
        }
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
     * changes if player is on tile or if player has visited before
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
