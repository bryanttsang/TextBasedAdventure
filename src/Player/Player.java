package Player;

/**
 * Person represents the player as they move through the game.
 */
public class Player {
    public String name;
    public int xLoc;
    public int yLoc;
    public int hp;
    public int atk;
    public boolean poison;

    public Player (String name, int xLoc, int yLoc, int hp, int atk, boolean poison)
    {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.hp = hp;
        this.atk = atk;
        this.poison = poison;
    }

    public Player (int xLoc, int yLoc, int hp, int atk, boolean poison)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.hp = hp;
        this.atk = atk;
        this.poison = poison;
    }

    public int hp(int heal)
    {
        return hp += heal;
    }

    public void isPoison(boolean poison)
    {
        if (poison)
        {
            hp -= 5;
        }
    }

    public int atk(int str)
    {
        return atk += str;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

}
