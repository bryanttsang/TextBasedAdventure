package Items;

import Player.Player;

public class Hoe implements Items
{
    @Override
    public String getName()
    {
        return "Hoe";
    }

    @Override
    public void use(Player x)
    {
        x.atk(50);
    }
}
