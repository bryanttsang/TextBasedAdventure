package Tiles.ItemTiles;

import Items.Treasure;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class TreasureTile extends Tile
{

    private Treasure treasure = new Treasure();

    private String contain;

    private boolean first = true;

    public TreasureTile(int x, int y)
    {
        super(x, y);
        this.contain = "Ｔ ";
    }

    /**
     * function of treasure tile
     * if treasure is opened, tile becomes normal
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
            System.out.println("You found a treasure box on this tile. Would you like to equip the items in it? (Y/N)");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().toLowerCase().trim();
            if (!input.equals("y") && !input.equals(("n")))
            {
                while (!input.equals("y") && !input.equals(("n")))
                {
                    System.out.println("Please answer Y or N.");
                    in = new Scanner(System.in);
                    input = in.nextLine().toLowerCase().trim();
                }
            }
            if (input.equals("y"))
            {
                System.out.println("You equipped Excalibur. You received Guinevere's blessing.");
                System.out.println("atk +75 | hp +50 | unpoisoned");
                this.treasure.use(x);
                contain = "█　";
                first = false;
            }
            if (input.equals("n"))
            {
                System.out.println("You left the treasure box.");
            }
        }
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * player leaves tile
     * @param x the player leaving
     */
    @Override
    public void leaveTile(Player x)
    {
        occupant = null;
    }

    /**
     * changes if player is on tile or if item is used
     * @return tile on board
     */
    @Override
    public String toString()
    {
        if (occupant == null)
        {
            return contain;
        }
        return "Ｘ ";
    }
}
