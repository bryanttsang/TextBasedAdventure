package Items;

import Player.Player;

public class Potion implements Items
{
    @Override
    public String getName()
    {
        return "Potion";
    }

    @Override
    public void use(Player x)
    {
        x.isPoison(false);
    }
}
