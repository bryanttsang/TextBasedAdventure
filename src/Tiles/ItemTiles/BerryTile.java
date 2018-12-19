package Tiles.ItemTiles;

import Items.Berry;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class BerryTile extends Tile
{

    private Berry berry = new Berry();

    private String contain;

    public BerryTile(int x, int y)
    {
        super(x, y);
        this.berry = berry;
        this.contain = "？ ";
    }

    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a berry in this room. Would you like to eat it? (Y/N)");
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
        }
        if (input.equals("n"))
        {
            System.out.println("You left the berry.");
        }
    }

    @Override
    public void leaveTile(Player x)
    {
        occupant = null;
    }

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
