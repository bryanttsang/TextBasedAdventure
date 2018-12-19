package Game;

import Player.Player;
import Tiles.*;
import Board.Board;
import Tiles.ItemTiles.*;

import java.util.Scanner;

public class Runner {

    private static int x = (int)(Math.random() * 6) + 5;
    private static int y = (int)(Math.random() * 6) + 5;

    private static Tile[][] map = new Tile[y][x];

    public static int randomX()
    {
        return (int)(Math.random() * map[0].length);
    }
    public static int randomY()
    {
        return (int)(Math.random() * map.length);
    }

    private static void randomXY()
    {
        x = randomX();
        y = randomY();
    }

    private static void newTile()
    {
        randomXY();
        if (map[y][x] != null)
        {
            while (map[y][x] != null)
            {
                randomXY();
            }
        }
    }

    private static boolean gameOn = true;

    public static int bossHp;
    public static int bossAtk;
    public static int playerHp;
    public static int playerAtk;
    public static int playerPoison;
    public static String playerName;

    public static void main(String[] sendHelp)
    {
        //random boss tile
        randomXY();
        map[y][x] = new Boss(x, y);

        //random teleport and trap tiles n times
        int n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //7.5% teleport and trap tile spawn rate
            int r = (int)(Math.random() * 200);
            if (r < 15)
            {
                n++;
            }
        }
        int t;
        for (; n > 0; n--)
        {
            newTile();
            t = (int)(Math.random() * 5);
            //3% trap tile spawn rate
            if (t == 0 || t == 1) { map[y][x] = new Trap(x, y); }
            //4.5% teleport tile spawn rate
            if (t == 2 || t == 3 || t == 4) { map[y][x] = new Teleport(x, y); }
        }

        //random item tiles n times
        n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //15% item tile spawn rate
            int r = (int)(Math.random() * 100);
            if (r < 15)
            {
                n++;
            }
        }
        int r;
        for (; n > 0; n--)
        {
            newTile();
            r = (int)(Math.random() * 15);
            //6.667% hoe spawn rate
            if (r == 0) { map[y][x] = new HoeTile(x, y); }
            //13.333% heart spawn rate
            if (r == 1 || r == 2) { map[y][x] = new HeartTile(x, y); }
            //20.000% potion spawn rate
            if (r == 3 || r == 4 || r == 5) { map[y][x] = new PotionTile(x, y); }
            //26.667% berry spawn rate
            if (r == 6 || r == 7 || r == 8 || r == 9) { map[y][x] = new BerryTile(x, y); }
            //33.333% spork spawn rate
            if (r == 10 || r == 11 || r == 12 || r == 13 || r == 14) { map[y][x] = new SporkTile(x, y); }
        }

        //random ambush tiles n times
        n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //10% ambush tile spawn rate
            r = (int)(Math.random() * 100);
            if (r < 10)
            {
                n++;
            }
        }
        for (; n > 0; n--)
        {
            newTile();
            map[y][x] = new Ambush(x, y);
        }

        //setup player1
        System.out.println("Thanks for downloading my game! What's your name? (You may enter nothing to play anonymously.)");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase().trim();
        String name = input;
        newTile();
        int xLoc = x;
        int yLoc = y;
        Player player1;
        if (name.equals(""))
        {
            player1 = new Player(xLoc, yLoc, 100, 5, false);
        }
        else
        {
            player1 = new Player(name, xLoc, yLoc, 100, 5, false);
        }
        System.out.println("And your gender? (M/F) Enter nothing for others.");
        in = new Scanner(System.in);
        input = in.nextLine().toLowerCase().trim();
        String gender = input;
        if (!gender.equals("m") && !gender.equals("f") && !gender.equals(""))
        {
            while (!gender.equals("m") && !gender.equals("f") && !gender.equals(""))
            {
                System.out.println("Please choose M/F or enter nothing.");
                in = new Scanner(System.in);
                input = in.nextLine().toLowerCase().trim();
                gender = input;
            }
        }
        if (gender.equals("m") && name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest man was just trying to live his life,");
            System.out.println("he died and was reborn onto a game board.");
        }
        if (gender.equals("m") && !name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest man was just trying to live his life,");
            System.out.println("he died and was reborn onto a game board. His name was " + player1.getName() + ".");
        }
        if (gender.equals("f") && name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest woman was just trying to live her life,");
            System.out.println("she died and was reborn onto a game board.");
        }
        if (gender.equals("f") && !name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest woman was just trying to live her life,");
            System.out.println("she died and was reborn onto a game board. Her name was " + player1.getName() + ".");
        }
        if (gender.equals("") && name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest person was just trying to live that person's life,");
            System.out.println("that person died and was reborn onto a game board.");
        }
        if (gender.equals("") && !name.equals(""))
        {
            System.out.println("Once upon a time, when the world's unluckiest person was just trying to live that person's life,");
            System.out.println("that person died and was reborn onto a game board. That person's name was " + player1.getName() + ".");
        }

        //fill rest of map
        for (y = 0; y < map.length; y++)
        {
            for (x = 0; x < map[y].length; x++)
            {
                if (map[y][x] == null)
                {
                    map[y][x] = new Tile(x, y);
                }
            }
        }

        //make board
        Board Board = new Board(map);

        //player enters board
        map[yLoc][xLoc].enterTile(player1);

        //gameplay
        int turn = 1;
        Board.print();
        System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
        System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
        System.out.println("Where would you like to move? (Choose W/A/S/D)");
        while(gameOn)
        {
            String move = in.nextLine();
            if(validMove(move, player1, map))
            {
                turn++;
                Board.print();
                System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
                System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
                System.out.println("Where would you like to move? (Choose W/A/S/D)");
                if (player1.isPoison().equals("true"))
                {
                    player1.poison(true);
                    playerPoison = 1;
                }
                if (player1.isPoison().equals("false")) { playerPoison = 0; }
                bossHp = player1.getHp() - 15 + (int)(Math.random() * 31);
                bossAtk = player1.getAtk() - 10 + (int)(Math.random() * 21);
                if (bossAtk < 1)
                {
                    while (bossAtk < 1)
                    {
                        bossAtk = player1.getAtk() - 10 + (int)(Math.random() * 21);
                    }
                }
                playerHp = player1.getHp();
                playerAtk = player1.getAtk();
                if (player1.getHp() <= 0)
                {
                    if (name.equals(""))
                    {
                        turn++;
                        Board.print();
                        System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
                        System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
                        System.out.println("You died.");
                        Runner.gameOff();
                        break;
                    }
                    if (!name.equals(""))
                    {
                        turn++;
                        Board.print();
                        System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
                        System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
                        System.out.println(player1.getName() + " died.");
                        Runner.gameOff();
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Please choose a valid move");
            }
        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param player person moving
     * @param map the 2D array of tiles
     * @return
     */
    private static boolean validMove(String move, Player player, Tile[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "w":
                if (player.getyLoc() > 0)
                {
                    map[player.getyLoc()][player.getxLoc()].leaveTile(player);
                    map[player.getyLoc() - 1][player.getxLoc()].enterTile(player);
                    return true;
                }
                else
                {
                    return false;
                }
            case "a":
                if (player.getxLoc() > 0)
                {
                    map[player.getyLoc()][player.getxLoc()].leaveTile(player);
                    map[player.getyLoc()][player.getxLoc() - 1].enterTile(player);
                    return true;
                }
                else
                {
                    return false;
                }
            case "s":
                if (player.getyLoc() < map.length - 1)
                {
                    map[player.getyLoc()][player.getxLoc()].leaveTile(player);
                    map[player.getyLoc() + 1][player.getxLoc()].enterTile(player);
                    return true;
                }
                else
                {
                    return false;
                }
            case "d":
                if (player.getxLoc() < map[0].length - 1)
                {
                    map[player.getyLoc()][player.getxLoc()].leaveTile(player);
                    map[player.getyLoc()][player.getxLoc() + 1].enterTile(player);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;
        }
        return false;
    }

    public static void gameOff()
    {
        gameOn = false;
    }
}
