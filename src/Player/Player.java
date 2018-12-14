package Player;

/**
 * Person represents the player as they move through the game.
 */
public class Player {
    public String name;
    public int xLoc;
    public int yLoc;
    public int hp;
    public boolean poison;

    public Player (String name, int xLoc, int yLoc, int hp, boolean poison)
    {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.hp = hp;
        this.poison = poison;
    }

    public static String getName(String name)
    {
        return name;
    }

    public int hp(int heal)
    {
        return hp += heal;
    }

    public int isPoison(boolean poison, int toxic)
    {
        if (poison)
        {
            return toxic;
        }
        return 0;
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
