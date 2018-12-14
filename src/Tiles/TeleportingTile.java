package Tiles;

import Game.Runner;
import Player.Player;

import java.util.Scanner;

public class TeleportingTile extends Tile
{
    public TeleportingTile(int x, int y)
    {
        super(x, y);
    }

    /**
     * Asks where player wishes to move to
     * @param x the Player entering
     */
    @Override
    public void enterTile(Player x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You entered the teleporting room! Would you like to teleport? (Choose Y/N)");
        Scanner in = new Scanner(System.in);
        String go = in.nextLine();
        if (!go.toLowerCase().trim().equals("n") && !go.toLowerCase().trim().equals("y"))
        {
            while (!go.toLowerCase().trim().equals("n") && !go.toLowerCase().trim().equals("y"))
            {
                System.out.println("Please choose Y/N");
                in = new Scanner(System.in);
                go = in.nextLine();
            }
        }
        if (go.toLowerCase().trim().equals("n"))
        {
            System.out.print("");
        }
        if (go.toLowerCase().trim().equals("y"))
        {
            System.out.println("Where would you like to go? Enter C for a coordinate or R for random.");
            in = new Scanner(System.in);
            go = in.nextLine();
            if (!go.toLowerCase().trim().equals("c") && !go.toLowerCase().trim().equals("r"))
            {
                while (!go.toLowerCase().trim().equals("c") && !go.toLowerCase().trim().equals("r"))
                {
                    System.out.println("Please choose C/R");
                    in = new Scanner(System.in);
                    go = in.nextLine();
                }
            }
            if (go.toLowerCase().trim().equals("r"))
            {
                x.setxLoc(Runner.xy());
                x.setyLoc(Runner.xy());
                occupant = null;
            }
            if (go.toLowerCase().trim().equals("c"))
            {
                System.out.println("Enter the X coordinate.");
                in = new Scanner(System.in);
                int xLoc = in.nextInt();
                System.out.println("Enter the Y coordinate.");
                in = new Scanner(System.in);
                int yLoc = in.nextInt();
                x.setxLoc(xLoc);
                x.setyLoc(yLoc);
                occupant = null;
            }
        }
    }

    public void leaveTile(Player x)
    {
        occupant = null;
    }


    @Override
    public String toString() {
        if (occupant == null)
        {
            return "T";
        }
        return "X";
    }
}