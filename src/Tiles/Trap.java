package Tiles;

import Player.Player;

import java.util.Scanner;

public class Trap extends Tile
{

    private String contain;

    public Trap(int x, int y)
    {
        super(x, y);
        this.contain = "█　";
    }

    private String input;

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
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterTile(Player x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        int fate = (int)(Math.random() * 5);
        if (fate < 3)
        {
            System.out.println("Unlucky, you thought this was a teleport tile?");
            System.out.println("Your stats will drop if you enter (N) to do nothing.");
            System.out.println("Or you can enter (Y) to try to escape. However, an unsuccessful attempt will result in a bigger stats drop.");
            input();
            if (input.equals("y"))
            {
                fate = (int)(Math.random() * 100);
                if (fate == 0)
                {
                    System.out.println("You escaped the trap!");
                }
                else
                {
                    System.out.println("Unlucky. | hp -50");
                    x.hp(-50);
                }
            }
            if (input.equals("n"))
            {
                System.out.println("You fell into the trap. | hp -10");
                x.hp(-10);
            }
        }
        if (fate == 3)
        {
            System.out.println("Do you like traps? (Y/N)");
            input();
            if (input.equals("n"))
            {
                System.out.println("Unlucky. | hp -100 | atk -30 | poisoned");
                x.hp(-100);
                x.atk(-30);
                x.poison(true);
                x.isPoison();
            }
            else
            {
                System.out.println("Lucky~ | hp +50 | atk +25 | unpoisoned");
                x.hp(50);
                x.atk(25);
                x.poison(false);
                x.isPoison();
            }
        }
        if (fate == 4)
        {
            System.out.println("This trap is not even functioning...");
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
            return "Ｔ ";
        }
        return "Ｘ ";
    }
}
