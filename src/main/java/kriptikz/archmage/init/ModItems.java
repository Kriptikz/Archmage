package kriptikz.archmage.init;

import kriptikz.archmage.item.ItemDecreaseArchmageXp;
import kriptikz.archmage.item.ItemDecreaseSpellXp;
import kriptikz.archmage.item.ItemGiveMana;
import kriptikz.archmage.item.ItemIncreasePlayerXp;
import kriptikz.archmage.item.ItemIncreaseSpellXp;
import kriptikz.archmage.item.ItemSpellNoteBlank;
import kriptikz.archmage.item.ItemWand;
import net.minecraft.item.Item;

/**
 * Creation of all mod items.
 * 
 * @author kriptikz
 *
 */
public class ModItems
{
	public static final Item[] ITEMS = {
			new ItemWand("wand"),
			new ItemSpellNoteBlank("spell_note_blank"),
			new ItemDecreaseArchmageXp("decrease_player_xp"),
			new ItemDecreaseSpellXp("decrease_spell_xp"),
			new ItemGiveMana("give_mana"),
			new ItemIncreasePlayerXp("increase_player_xp"),
			new ItemIncreaseSpellXp("increase_spell_xp")
	};
}
