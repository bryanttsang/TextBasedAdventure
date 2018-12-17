package Game;

import Player.Player;
import Tiles.*;
import Board.Board;
import Tiles.ItemTiles.HoeTile;

import java.util.Scanner;

public class Runner {

    private static int x = (int)(Math.random() * 6) + 5;
    private static int y = (int)(Math.random() * 6) + 5;

    private static Tile[][] map = new Tile[x][y];

    public static int randomX()
    {
        return (int)(Math.random() * map.length);
    }
    public static int randomY()
    {
        return (int)(Math.random() * map[0].length);
    }

    private static void randomXY()
    {
        x = randomX();
        y = randomY();
    }

    private static void newTile()
    {
        randomXY();
        if (map[x][y] != null)
        {
            while (map[x][y] != null)
            {
                randomXY();
            }
        }
    }

    private static boolean gameOn = true;

    public static void main(String[] sendHelp)
    {

        //random boss tile
        randomXY();
        map[x][y] = new Boss(x, y);

        //random teleport tiles n times
        int n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //5% item spawn rate
            int r = (int)(Math.random() * 100);
            if (r < 5)
            {
                n++;
            }
        }
        for (; n > 0; n--)
        {
            newTile();
            map[x][y] = new Teleport(x, y);
        }

        //random trap tiles n times
        n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //5% item spawn rate
            int r = (int)(Math.random() * 100);
            if (r < 5)
            {
                n++;
            }
        }
        for (; n > 0; n--)
        {
            newTile();
            map[x][y] = new Trap(x, y);
        }


        //random item tiles n times
        n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //15% item spawn rate
            int r = (int)(Math.random() * 100);
            if (r < 15)
            {
                n++;
            }
        }
        for (; n > 0; n--)
        {
            newTile();
            map[x][y] = new Item(x, y);
        }
        for (int i = 0; i < map.length; i++)
        {
            for (int ii = 0; ii < map[i].length; ii++)
            {
                if (map[i][ii].toString().equals("？ "))
                {
                    int item = (int)(Math.random() * 100);
                    if (item < 5)
                    {
                        map[i][ii] = new HoeTile(i, ii);
                    }
                    //map[i][ii]
                }
            }
        }

        //setup player1
        System.out.println("Thanks for downloading my game! What's your name?");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase().trim();
        String name = input;
        System.out.println("And your gender? (M/F)");
        in = new Scanner(System.in);
        input = in.nextLine().toLowerCase().trim();
        String gender = input;
        if (!input.equals("m") && !input.equals("f"))
        {
            while (!input.equals("m") && !input.equals("f"))
            {
                System.out.println("Please choose M or F");
                in = new Scanner(System.in);
                input = in.nextLine().toLowerCase().trim();
                gender = input;
            }
        }
        if (gender.equals("m"))
        {
            System.out.println("Once upon a time, when the world's unluckiest man was just trying to live his life,");
            System.out.println("he died and was reborn onto a game board. His name was " + name + ".");
        }
        else if (gender.equals("f"))
        {
            System.out.println("Once upon a time, when the world's unluckiest woman was just trying to live her life,");
            System.out.println("she died and was reborn onto a game board. Her name was " + name + ".");
        }
        newTile();
        int xLoc = x;
        int yLoc = y;
        Player player1 = new Player(name, xLoc, yLoc, 100, 10, false);

        //fill rest of map
        for (x = 0; x < map.length; x++)
        {
            for (y = 0; y < map[x].length; y++)
            {
                if (map[x][y] == null)
                {
                    map[x][y] = new Tile(x,y);
                }
            }
        }

        //make board
        Board Board = new Board(map);

        //player enters board
        map[xLoc][yLoc].enterTile(player1);


        while(gameOn)
        {
            if (player1.getxLoc() == x && player1.getyLoc() == y)
            {
                System.out.println("You found the boss tile! Ten points for Gryffindor.");
                Runner.gameOff();
                break;
            }
            Board.print();
            System.out.println("Where would you like to move? (Choose W, A, S, D)");
            String move = in.nextLine();
            if(validMove(move, player1, map))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            }
            else {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of tiles
     * @return
     */
    public static boolean validMove(String move, Player p, Tile[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "w":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveTile(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterTile(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "d":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveTile(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterTile(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveTile(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterTile(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "a":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveTile(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterTile(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
