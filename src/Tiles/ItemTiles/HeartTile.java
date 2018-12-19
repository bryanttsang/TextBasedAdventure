package Tiles.ItemTiles;

import Items.Heart;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class HeartTile extends Tile
{

    private Heart heart = new Heart();

    private String contain;

    public HeartTile(int x, int y)
    {
        super(x, y);
        this.heart = heart;
        this.contain = "？ ";
    }

    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a heart in this room. Would you like to eat it? (Y/N)");
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
            System.out.println("You ate the heart.");
            System.out.println("hp +25");
            this.heart.use(x);
        }
        if (input.equals("n"))
        {
            System.out.println("You left the heart.");
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
