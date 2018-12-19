package Tiles.ItemTiles;

import Items.Spork;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class SporkTile extends Tile
{

    private Spork spork = new Spork();

    private String contain;

    public SporkTile(int x, int y)
    {
        super(x, y);
        this.spork = spork;
        this.contain = "？ ";
    }

    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a spork in this room. Would you like to equip it? (Y/N)");
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
            System.out.println("You equipped the spork.");
            System.out.println("atk +1");
            this.spork.use(x);
        }
        if (input.equals("n"))
        {
            System.out.println("You left the spork.");
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
