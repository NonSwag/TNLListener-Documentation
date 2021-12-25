public final class CashMachine extends GUI {

    public CashMachine(@Nonnull TNLPlayer player) {
        super(4 /* rows */, "§8» §6§lCash§e§lMachine" /* title */);
        formatDefault(); // method to format the gui
        setOpenListener(player1 -> { // listen to the open event
            update(player1);
            return true; // allow or deny opening
        });
    }

    private void update(@Nonnull TNLPlayer player) {
        setItem(21, TNLItem.create(Material.GREEN_SHULKER_BOX).setName("§6100 Coins §8» §d1 Default Crate Key").setShiny(true).
                setLore("§8* §7Coins§8: §6$" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCoins(player)),
                        "§8* §7Keys§8: §6" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCrateKeys(player, Crate.Type.DEFAULT))).
                toGUIItem().addInteractions(new Interaction(player1 -> { // add a new interaction for all click types to this item
                    double coins = PlayerStorage.getInstance().getCoins(player1);
                    int price = 100;
                    if (coins >= price) {
                        PlayerStorage.getInstance().removeCoins(player1, price);
                        PlayerStorage.getInstance().addCrateKeys(player1, Crate.Type.DEFAULT, 1);
                        update(player1);
                    } else player1.sendMessage(Messages.NOT_ENOUGH_COINS, new Placeholder("price", StringUtil.format("#,##0.0", price)));
                })));
        setItem(22, TNLItem.create(Material.BROWN_SHULKER_BOX).setName("§6500 Coins §8» §d1 Extra Crate Key").setShiny(true).
                setLore("§8* §7Coins§8: §6$" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCoins(player)),
                        "§8* §7Keys§8: §6" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCrateKeys(player, Crate.Type.EXTRA))).
                toGUIItem().addInteractions(new Interaction(player1 -> {
                    double coins = PlayerStorage.getInstance().getCoins(player1);
                    int price = 500;
                    if (coins >= price) {
                        PlayerStorage.getInstance().removeCoins(player1, price);
                        PlayerStorage.getInstance().addCrateKeys(player1, Crate.Type.EXTRA, 1);
                        update(player1);
                    } else player1.sendMessage(Messages.NOT_ENOUGH_COINS, new Placeholder("price", StringUtil.format("#,##0.0", price)));
                })));
        setItem(23, TNLItem.create(Material.LIME_SHULKER_BOX).setName("§61000 Coins §8» §d1 Crystal Crate Key").setShiny(true).
                setLore("§8* §7Coins§8: §6$" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCoins(player)),
                        "§8* §7Keys§8: §6" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCrateKeys(player, Crate.Type.CRYSTAL))).
                toGUIItem().addInteractions(new Interaction(player1 -> {
                    double coins = PlayerStorage.getInstance().getCoins(player1);
                    int price = 1000;
                    if (coins >= price) {
                        PlayerStorage.getInstance().removeCoins(player1, price);
                        PlayerStorage.getInstance().addCrateKeys(player1, Crate.Type.CRYSTAL, 1);
                        update(player1);
                    } else player1.sendMessage(Messages.NOT_ENOUGH_COINS, new Placeholder("price", StringUtil.format("#,##0.0", price)));
                })));
        setItem(11, TNLItem.create(Material.SUNFLOWER).setName("§b250,000 diamonds §8» §61 Coin").
                setLore("§8* §7Coins§8: §6$" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCoins(player)),
                        "§8* §7Diamonds§8: §6" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getDiamonds(player))).
                toGUIItem().addInteractions(new Interaction(player1 -> {
                    double diamonds = PlayerStorage.getInstance().getDiamonds(player1);
                    int price = 250000;
                    if (diamonds >= price) {
                        PlayerStorage.getInstance().removeDiamonds(player1, price);
                        PlayerStorage.getInstance().addCoins(player1, 1);
                        update(player1);
                    } else player1.sendMessage(Messages.NOT_ENOUGH_DIAMONDS, new Placeholder("price", StringUtil.format("#,##0.0", price)));
                })));
        setItem(15, TNLItem.create(Material.DIAMOND).setName("§61 Coin §8» §b250,000 diamonds").
                setLore("§8* §7Coins§8: §6$" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getCoins(player)),
                        "§8* §7Diamonds§8: §6" + StringUtil.format("#,##0.0", PlayerStorage.getInstance().getDiamonds(player))).
                toGUIItem().addInteractions(new Interaction(player1 -> {
                    double coins = PlayerStorage.getInstance().getCoins(player1);
                    int price = 1;
                    if (coins >= price) {
                        PlayerStorage.getInstance().removeCoins(player1, price);
                        PlayerStorage.getInstance().addDiamonds(player1, 250000);
                        update(player1);
                    } else player1.sendMessage(Messages.NOT_ENOUGH_COINS, new Placeholder("price", StringUtil.format("#,##0.0", price)));
                })));
    }
}
