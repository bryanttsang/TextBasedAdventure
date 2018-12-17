package Items;

import Player.Player;

public class Heart implements Items
{
    @Override
    public String getName()
    {
        return "Heart";
    }

    @Override
    public void use(Player x)
    {
        x.hp((int)(Math.random() * 11) + 20);
        x.isPoison(false);
    }
}
