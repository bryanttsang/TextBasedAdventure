package Items;

import Player.Player;

public class Apple implements Items
{
    @Override
    public String getName()
    {
        return "Apple";
    }

    @Override
    public void eat(Player x)
    {
        x.hp(941);
        x.isPoison(true, 42);
    }
}
