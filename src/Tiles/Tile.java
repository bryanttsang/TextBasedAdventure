package Tiles;

import Player.Player;

public class Tile {
    Player occupant;
    int xLoc,yLoc;

    public Tile(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Player entering
     */
    public void enterTile(Player x)
    {
        System.out.println("You enter a plain old room");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveTile(Player x)
    {
        occupant = null;
    }

    @Override
    public String toString() {
        if (occupant == null)
        {
            return "R";
        }
        return "X";
    }
}
