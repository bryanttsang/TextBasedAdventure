package Items;

import Player.Player;

public class Berry implements Items
{
    @Override
    public void use(Player x)
    {
        x.hp(50);
        x.atk(20);
        x.poison(true);
        x.isPoison();
    }
}
