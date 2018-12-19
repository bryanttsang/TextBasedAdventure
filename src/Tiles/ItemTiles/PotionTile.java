package Tiles.ItemTiles;

import Items.Potion;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class PotionTile extends Tile
{

    private Potion potion = new Potion();

    private String contain;

    public PotionTile(int x, int y)
    {
        super(x, y);
        this.potion = potion;
        this.contain = "？ ";
    }

    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a potion in this room. Would you like to drink it? (Y/N)");
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
        }
        if (input.equals("n"))
        {
            System.out.println("You left the potion.");
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
