package Items;

import Player.Player;

public class Heart implements Items
{
    @Override
    public void use(Player x)
    {
        x.hp(25);
        x.poison(false);
        x.isPoison();
    }
}
