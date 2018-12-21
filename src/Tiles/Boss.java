package Tiles;

import Game.Runner;
import Player.Player;

import java.util.Scanner;

public class Boss extends Tile
{

    public Boss(int x, int y)
    {
        super(x, y);
    }

    private Scanner in;
    private String input;
    private int bossHp;
    private int bossAtk;
    private int playerHp;
    private int playerAtk;
    private int playerPoison;
    private String poison = "";
    private int playerTurn;
    public static int rbossHp = 100;
    public static int rplayerHp = 100;

    /**
     * function of boss tile
     * player either win or lose
     * @param x the player entering
     */
    @Override
    public void enterTile(Player x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You stepped on the boss tile.");
        System.out.println("Boss: Any last words?");
        in = new Scanner(System.in);
        String lastWord = in.nextLine();

        //fight calculations
        bossHp = Runner.bossHp;
        bossAtk = Runner.bossAtk;
        playerHp = Runner.playerHp;
        playerAtk = Runner.playerAtk;
        playerPoison = Runner.playerPoison;
        playerTurn = Runner.playerTurn;
        if (playerPoison == 1) { poison = " | poisoned"; }
        System.out.println("boss hp: " + bossHp + " | boss atk: " + bossAtk);
        System.out.println("player hp: " + playerHp + " | player atk: " + playerAtk + poison);
        while (bossHp > 0 && playerHp > 0)
        {
            System.out.println("(Enter anything to continue.)");
            in = new Scanner(System.in);
            input = in.nextLine();
            if (playerHp <= 0) { break; }
            System.out.println("You attacked.");
            bossHp -= playerAtk;
            if (bossHp < 0) { bossHp = 0; }
            rbossHp = bossHp;
            System.out.println("boss hp: " + bossHp + " | boss atk: " + bossAtk);
            System.out.println("(Enter anything to continue.)");
            in = new Scanner(System.in);
            input = in.nextLine();
            if (bossHp <= 0) { break; }
            System.out.println("Boss attacked.");
            playerHp -= bossAtk;
            if (playerHp < 0) { playerHp = 0; }
            rplayerHp = playerHp;
            if (playerPoison == 1) { playerHp -= 5;
                System.out.println("You are poisoned. (-5 hp)");}
            if (playerHp < 0) { playerHp = 0; }
            System.out.println("player hp: " + playerHp + " | player atk: " + playerAtk + poison);
        }

        //player loses
        if (playerHp <= 0)
        {
            System.out.println("");
            System.out.println("You died.");
            System.out.println("Your last words were: " + lastWord);
            Runner.gameOff();
        }
        //player wins
        if (bossHp <= 0)
        {
            System.out.println("Congratulation! You won! (" + playerTurn + " turns" + ")");
            System.out.println("The board suddenly lights up. It's so bright that you can't do anything but shut your eyes.");
            System.out.println("When you can finally see something, you see a dark shadow that represents a person.");
            System.out.println("Mysterious person: code 0");
            Runner.gameOff();
        }
    }

    /**
     * boss tile
     * @return tile on board
     */
    @Override
    public String toString()
    {
        return "Ｂ ";
    }
}
