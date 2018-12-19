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

    Scanner in;
    String input;
    int bossHp;
    int bossAtk;
    int playerHp;
    int playerAtk;
    int playerPoison;
    String poison = "";

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterTile(Player x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You stepped on the boss tile.");
        System.out.println("Boss: Ready to die?");
        in = new Scanner(System.in);
        input = in.nextLine();

        //fight calculations
        bossHp = Runner.bossHp;
        bossAtk = Runner.bossAtk;
        playerHp = Runner.playerHp;
        playerAtk = Runner.playerAtk;
        playerPoison = Runner.playerPoison;
        if (playerPoison == 1)
        {
            poison = " | poisoned";
        }
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
            System.out.println("boss hp: " + bossHp + " | boss atk: " + bossAtk);
            System.out.println("(Enter anything to continue.)");
            in = new Scanner(System.in);
            input = in.nextLine();
            if (bossHp <= 0) { break; }
            System.out.println("Boss attacked.");
            playerHp -= bossAtk;
            if (playerPoison == 1) { playerHp -= 5;
                System.out.println("You are poisoned. (-5 hp)");}
            System.out.println("player hp: " + playerHp + " | player atk: " + playerAtk + poison);
        }
        if (playerHp <= 0)
        {
            System.out.println("You died.");
            System.out.println("Your last words were :" + input);
            Runner.gameOff();
        }
        if (bossHp <= 0)
        {
            System.out.println("Congratulation! You won!");
            System.out.println("The board suddenly lights up. It's so bright that you can't do anything but shut your eyes.");
            System.out.println("When you can finally see something, you saw a dark shadow that represents a person.");
            System.out.println("Mysterious person: code 0");
            Runner.gameOff();
        }
    }

    @Override
    public String toString()
    {
        return "Ｂ ";
    }
}
