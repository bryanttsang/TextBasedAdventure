package Tiles;

import Game.Runner;
import Player.Player;

import java.util.Scanner;

public class Trap extends Tile
{

    private String contain;

    private boolean first = true;

    public Trap(int x, int y)
    {
        super(x, y);
        this.contain = "Ｔ ";
    }

    private String input;

    /**
     * helper method for taking input
     */
    private void input()
    {
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        if (!input.equals("y") && !input.equals("n"))
        {
            while (!input.equals("y") && !input.equals("n"))
            {
                System.out.println("Please answer Y or N.");
                in = new Scanner(System.in);
                input = in.nextLine();
            }
        }
    }

    /**
     * function of trap tile
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
            int fate = (int)(Math.random() * 5);
            if (fate < 3)
            {
                System.out.println("Unlucky. You stepped on a trap.");
                System.out.println("Your stats will drop if you enter (N) to do nothing.");
                System.out.println("Or you can enter (Y) to try to escape. However, an unsuccessful attempt will result in a bigger stats drop.");
                input();
                if (input.equals("y"))
                {
                    fate = (int)(Math.random() * 100);
                    if (fate == 0)
                    {
                        System.out.println("You escaped the trap!");
                        first = false;
                    }
                    else
                    {
                        System.out.println("You failed. | hp -50");
                        x.hp(-50);
                        first = false;
                    }
                }
                if (input.equals("n"))
                {
                    System.out.println("You fell into the trap. | hp -10");
                    x.hp(-10);
                    first = false;
                }
            }
            if (fate == 3)
            {
                System.out.println("Do you like traps? (Y/N)");
                input();
                if (!input.equals("n") && !input.equals("y"))
                {
                    while (!input.equals("n") && !input.equals("y"))
                    {
                        System.out.println("Please enter Y/N");
                        input();
                    }
                }
                if (input.equals("n"))
                {
                    System.out.println("Unlucky. | hp -50 | atk -30 | poisoned");
                    x.hp(-50);
                    x.atk(-30);
                    x.poison(true);
                    x.isPoison();
                    first = false;
                }
                if (input.equals("y"))
                {
                    System.out.println("Lucky~ | hp +50 | atk +25 | unpoisoned");
                    x.hp(50);
                    x.atk(25);
                    x.poison(false);
                    x.isPoison();
                    first = false;
                }
            }
            if (fate == 4)
            {
                System.out.println("This trap is not even functioning...");
                first = false;
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
    public void leaveTile(Player x)
    {
        occupant = null;
        contain = "█　";
    }

    /**
     * changes if player is on tile or if player has visited before
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
