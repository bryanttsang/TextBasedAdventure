package Tiles;

import Game.Runner;
import Player.Player;

public class Boss extends Tile
{

    public Boss(int x, int y)
    {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterTile(Player x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the winning room! Ten points for Gryffindor.");
        Runner.gameOff();
    }

    @Override
    public String toString()
    {
        return "Ｂ ";
    }
}
