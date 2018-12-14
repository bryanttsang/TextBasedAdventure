package Game;

import Player.Player;
import Tiles.Tile;
import Tiles.TeleportingTile;
import Tiles.WinningTile;
import Board.Board;

import java.util.Scanner;

public class Runner {

    public static Tile[][] building = new Tile[5][5];

    private static boolean gameOn = true;

    public static void main(String[] args)
    {

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Tile(x,y);
            }
        }

        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new WinningTile(x, y);

        //Create a random teleporting room.
        int xx = (int)(Math.random()*building.length);
        int yy = (int)(Math.random()*building.length);
        if (x == xx && y == yy)
        {
            while (x == xx && y == yy)
            {
                xx = (int)(Math.random()*building.length);
                yy = (int)(Math.random()*building.length);
            }
        }
        building[xx][yy] = new TeleportingTile(xx, yy);

        Board Board = new Board(building);


        //Setup player 1 and the input scanner
        Player player1 = new Player("FirstName", 0, 0);
        building[0][0].enterTile(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            if (player1.getxLoc() == x && player1.getyLoc() == y)
            {
                System.out.println("You found the winning room! Ten points for Gryffindor.");
                Runner.gameOff();
                break;
            }
            Board.print();
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player1, building))
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
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Player p, Tile[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
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
            case "e":
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

            case "w":
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

    public static int xy()
    {
        return (int)(Math.random()*building.length);

    }

}
