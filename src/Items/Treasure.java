package Items;

import Player.Player;

public class Treasure implements Items
{
    @Override
    public void use(Player x)
    {
        x.atk(75);
        x.hp(50);
        x.poison(false);
        x.isPoison();
    }
}
