package Tiles;

import Game.Runner;
import Player.Player;

import java.util.Scanner;

public class Teleport extends Tile
{

    private String contain;

    public Teleport(int x, int y)
    {
        super(x, y);
        this.contain = "Ｔ ";
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
        String input = in.nextLine();
        if (!input.toLowerCase().trim().equals("n") && !input.toLowerCase().trim().equals("y"))
        {
            while (!input.toLowerCase().trim().equals("n") && !input.toLowerCase().trim().equals("y"))
            {
                System.out.println("Please choose Y/N");
                in = new Scanner(System.in);
                input = in.nextLine();
            }
        }
        if (input.toLowerCase().trim().equals("n"))
        {
            System.out.print("");
        }
        if (input.toLowerCase().trim().equals("y"))
        {
            System.out.println("Where would you like to go? Enter C for a coordinate or R for random.");
            in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.toLowerCase().trim().equals("c") && !input.toLowerCase().trim().equals("r"))
            {
                while (!input.toLowerCase().trim().equals("c") && !input.toLowerCase().trim().equals("r"))
                {
                    System.out.println("Please choose C/R");
                    in = new Scanner(System.in);
                    input = in.nextLine();
                }
            }
            if (input.toLowerCase().trim().equals("r"))
            {
                x.setxLoc(Runner.randomX());
                x.setyLoc(Runner.randomY());
                occupant = null;
            }
            if (input.toLowerCase().trim().equals("c"))
            {
                System.out.println("Enter the X coordinate.");
                in = new Scanner(System.in);
                int xLoc = in.nextInt() - 1;
                System.out.println("Enter the Y coordinate.");
                in = new Scanner(System.in);
                int yLoc = in.nextInt() - 1;
                x.setxLoc(xLoc);
                x.setyLoc(yLoc);
                occupant = null;
            }
        }
    }

    public void leaveTile(Player x)
    {
        occupant = null;
        contain = "█　";
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