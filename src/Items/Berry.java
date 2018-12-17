package Items;

import Player.Player;

public class Berry implements Items
{
    @Override
    public String getName()
    {
        return "Berry";
    }

    @Override
    public void use(Player x)
    {
        x.hp((int)(Math.random() * 21) + 40);
        x.atk((int)(Math.random() * 3) + 4);
        x.isPoison(true);
    }
}
