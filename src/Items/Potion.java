package Items;

import Player.Player;

public class Potion implements Items
{
    @Override
    public void use(Player x)
    {
        x.poison(false);
        x.isPoison();
    }
}
