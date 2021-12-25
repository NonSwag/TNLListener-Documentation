public class Pickaxes {

    @Nonnull
    public static final TNLItem TEST = TNLItem.create(Material.IRON_PICKAXE /* the item type */).
            setUnbreakable(true /* whether the item is unbreakable */).
            setShiny(true /* glowing item without a visible enchantment */).
            setName("§9Test Item" /* display name */).enchant(Enchantment.DIG_SPEED, 1000).
            hideFlags() /* hide all flags from the client */.amount(5) /* the amount */.
            setCustomModelData(6 /* custom model data (usefull for ressource packs) */);
}
