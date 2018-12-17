package Tiles;

import Player.Player;

import java.util.Scanner;

public class Trap extends Tile
{

    public Trap(int x, int y)
    {
        super(x, y);
    }

    private String input()
    {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase().trim();
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
            if (input().equals("y"))
            {
                fate = (int)(Math.random() * 100);
                if (fate == 0)
                {
                    System.out.println("You escaped the trap!");
                }
                else
                {
                    System.out.println("Unlucky :/");
                    x.hp(-10);
                }
            }
            else
            {
                x.hp(-5);
            }
        }
        if (fate == 4)
        {
            System.out.println("Do you like traps? (Y/N)");
            if (input().equals("n"))
            {
                x.hp(-10);
                x.atk(-10);
                x.isPoison(true);
            }
            else
            {
                System.out.println("Good...  hp +10  atk +10  poison recovery");
                x.hp(10);
                x.atk(10);
                x.isPoison(false);
            }
        }
        else
        {
            System.out.println("This trap isn't even functioning...");
        }
    }

    public void leaveTile(Player x)
    {
        occupant = null;
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
