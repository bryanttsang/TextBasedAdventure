package Tiles.ItemTiles;

import Items.Berry;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class BerryTile extends Tile
{

    private Berry berry = new Berry();

    private String contain;

    private boolean first = true;

    public BerryTile(int x, int y)
    {
        super(x, y);
        this.contain = "？ ";
    }

    /**
     * function of berry tile
     * if berry is eaten, tile becomes normal
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
            System.out.println("You found a berry on this tile. Would you like to eat it? (Y/N)");
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
                System.out.println("You ate the berry.");
                System.out.println("hp +50 | atk +20 | poisoned");
                this.berry.use(x);
                contain = "█　";
                first = false;
            }
            if (input.equals("n"))
            {
                System.out.println("You left the berry.");
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
