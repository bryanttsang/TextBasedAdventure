package Items;

import Player.Player;

public class Hoe implements Items
{
    @Override
    public void use(Player x)
    {
        x.atk(50);
    }
}
