package Items;

import Player.Player;

public class Spork implements Items
{
    @Override
    public void use(Player x)
    {
        x.atk(1);
    }
}
