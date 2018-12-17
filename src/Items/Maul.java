package Items;

import Player.Player;

public class Maul implements Items
{
    @Override
    public String getName()
    {
        return "Maul";
    }

    @Override
    public void use(Player x)
    {
        x.atk((int)(Math.random() * 3) + 1);
        x.isPoison(true);
    }
}
