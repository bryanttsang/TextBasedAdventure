package Tiles.ItemTiles;

import Items.Hoe;
import Player.Player;
import Tiles.Tile;

import java.util.Scanner;

public class HoeTile extends Tile
{
    public HoeTile(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a hoe in this room. Would you like to equip it? (Y/N)");
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
            System.out.println("You equipped hoe.");
            System.out.println("atk +50");
            //Hoe.use(x);
        }

    }


}
