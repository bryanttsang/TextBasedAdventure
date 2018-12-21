package Game;

import Player.Player;
import Tiles.*;
import Board.Board;
import Tiles.ItemTiles.*;

import java.util.Scanner;

public class Runner {

    private static int x = (int)(Math.random() * 6) + 5;
    private static int y = (int)(Math.random() * 6) + 5;

    //random sized game board
    private static Tile[][] map = new Tile[y][x];

    private static int randomX()
    {
        return (int)(Math.random() * map[0].length);
    }
    private static int randomY()
    {
        return (int)(Math.random() * map.length);
    }

    private static void randomXY()
    {
        x = randomX();
        y = randomY();
    }

    /**
     * helper method generating random coordinate for new tile
     */
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

    //player and boss stats
    public static int bossHp;
    public static int bossAtk;
    public static int playerHp;
    public static int playerAtk;
    public static int playerPoison;
    public static int playerTurn;

    public static void main(String[] sendHelp)
    {
        //random boss tile
        randomXY();
        map[y][x] = new Boss(x, y);

        //random trap tiles n times
        int n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //5% treasure and trap tile spawn rate
            int r = (int)(Math.random() * 20);
            if (r == 0)
            {
                n++;
            }
        }
        int t = (int)(Math.random() * 4);
        //25% treasure tile spawn rate
        if (t == 0) { newTile(); map[y][x] = new TreasureTile(x, y); n--; }
        for (; n > 0; n--)
        {
            newTile();
            map[y][x] = new Trap(x, y);
        }

        //random item tiles n times
        n = 0;
        for (int i = 0; i < map.length * map[0].length; i++)
        {
            //20% item tile spawn rate
            int r = (int)(Math.random() * 5);
            if (r == 0)
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

        //game intro
        System.out.println("Welcome to Disboard! The outcome of your life will be decided here.");
        System.out.println("This board has different kind of tiles that you can explore to modify your personal stats (hp and atk).");
        System.out.println("Ｘ is you.　？ is an item tile.　Ｂ is the boss tile.　And Ｔ tiles are interesting tiles for you to explore.");
        System.out.println("Keep in mind that while you are moving around to get stronger, the boss is also getting stronger.");
        System.out.println("Let's begin!");
        System.out.println("");

        //setup player1
        System.out.println("What's your name? (You may enter nothing to play anonymously.)");
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

        //gender for exposition
        System.out.println("And your gender? (M/F) You may enter nothing.");
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
        playerTurn = turn;
        Board.print();
        System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
        System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
        System.out.println("Where would you like to move? (Choose W/A/S/D)");
        playerHp = player1.getHp();
        playerAtk = player1.getAtk();
        bossHp = 100;
        bossAtk = 5;
        while(gameOn)
        {
            String move = in.nextLine();
            if (validMove(move, player1, map))
            {
                if (Boss.rbossHp <= 0 || Boss.rplayerHp <= 0) { break; }
                turn++;
                playerTurn = turn;
                //boss hp +5 every turn
                bossHp += 5;
                //boss atk +5 every turn
                bossAtk += 5;
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
                playerHp = player1.getHp();
                playerAtk = player1.getAtk();
                if (player1.getHp() <= 0)
                {
                    turn++;
                    Board.print();
                    System.out.println("Your coordinates: (" + (player1.getxLoc() + 1) + ", " + (player1.getyLoc() + 1) + ")");
                    System.out.println("turn: " + turn + " | hp: " + player1.getHp() + " | atk: " + player1.getAtk() + " | poison: " + player1.isPoison());
                    System.out.println("");
                    System.out.println("You died on turn " + turn + ".");
                    Runner.gameOff();
                    break;
                }
            }
            else { System.out.println("Please enter a valid move."); }
        }
        in.close();
    }

    /**
     *
     * @param move W/A/S/D
     * @param player moving
     * @param map of tiles
     * @return true if move is allowed, false if not
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

    /**
     * trigger end of game
     */
    public static void gameOff()
    {
        gameOn = false;
    }
}
