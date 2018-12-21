package Tiles.ItemTiles;

import Items.Potion;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class PotionTile extends Tile
{

    private Potion potion = new Potion();

    private String contain;

    private boolean first = true;

    public PotionTile(int x, int y)
    {
        super(x, y);
        this.contain = "？ ";
    }

    /**
     * function of potion tile
     * if potion is drank, tile becomes normal
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
            System.out.println("You found a potion on this tile. Would you like to drink it? (Y/N)");
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
                System.out.println("You drank the potion.");
                System.out.println("unpoisoned");
                this.potion.use(x);
                contain = "█　";
                first = false;
            }
            if (input.equals("n"))
            {
                System.out.println("You left the potion.");
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
