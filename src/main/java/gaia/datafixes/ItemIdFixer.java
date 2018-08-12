package gaia.datafixes;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

import java.util.Map;

public class ItemIdFixer implements IFixableData {
	private final Map<String, String> mapping = new ImmutableMap.Builder<String, String>()
			.put("grimoireofgaia:accessorycursed", "grimoireofgaia:accessory_cursed")
			.put("grimoireofgaia:accessoryringhaste", "grimoireofgaia:accessory_ring_haste")
			.put("grimoireofgaia:accessoryringjump", "grimoireofgaia:accessory_ring_jump")
			.put("grimoireofgaia:accessoryringnight", "grimoireofgaia:accessory_ring_night")
			.put("grimoireofgaia:accessoryringspeed", "grimoireofgaia:accessory_ring_speed")
			.put("grimoireofgaia:accessorytrinketlevitation", "grimoireofgaia:accessory_trinket_levitation")
			.put("grimoireofgaia:accessorytrinketpoison", "grimoireofgaia:accessory_trinket_poison")
			.put("grimoireofgaia:accessorytrinketwither", "grimoireofgaia:accessory_trinket_wither")
			.put("grimoireofgaia:bagarrow", "grimoireofgaia:bag_arrow")
			.put("grimoireofgaia:bagbook", "grimoireofgaia:bag_book")
			.put("grimoireofgaia:bagore", "grimoireofgaia:bag_ore")
			.put("grimoireofgaia:bagrecord", "grimoireofgaia:bag_record")
			.put("grimoireofgaia:boxdiamond", "grimoireofgaia:box_diamond")
			.put("grimoireofgaia:boxgold", "grimoireofgaia:box_gold")
			.put("grimoireofgaia:boxiron", "grimoireofgaia:box_iron")
			.put("grimoireofgaia:boxold", "grimoireofgaia:box_old")
			.put("grimoireofgaia:foodcoalfish", "grimoireofgaia:food_coalfish")
			.put("grimoireofgaia:foodmandrake", "grimoireofgaia:food_mandrake")
			.put("grimoireofgaia:foodmeat", "grimoireofgaia:food_meat")
			.put("grimoireofgaia:foodnetherwart", "grimoireofgaia:food_nether_wart")
			.put("grimoireofgaia:foodpieapplegold", "grimoireofgaia:food_pie_apple_gold")
			.put("grimoireofgaia:foodpiemandrake", "grimoireofgaia:food_pie_mandrake")
			.put("grimoireofgaia:foodpiemeat", "grimoireofgaia:food_pie_meat")
			.put("grimoireofgaia:foodroot", "grimoireofgaia:food_root")
			.put("grimoireofgaia:foodrottenheart", "grimoireofgaia:food_rotten_heart")
			.put("grimoireofgaia:foodsmallapplegold", "grimoireofgaia:food_small_apple_gold")
			.put("grimoireofgaia:foodwither", "grimoireofgaia:food_wither")
			.put("grimoireofgaia:miscbook", "grimoireofgaia:misc_book")
			.put("grimoireofgaia:misccurrency", "grimoireofgaia:misc_currency")
			.put("grimoireofgaia:miscexperience", "grimoireofgaia:misc_experience")
			.put("grimoireofgaia:miscfur", "grimoireofgaia:misc_fur")
			.put("grimoireofgaia:miscfurnacefuel", "grimoireofgaia:misc_furnace_fuel")
			.put("grimoireofgaia:miscgigagear", "grimoireofgaia:misc_giga_gear")
			.put("grimoireofgaia:miscquill", "grimoireofgaia:misc_quill")
			.put("grimoireofgaia:miscring", "grimoireofgaia:misc_ring")
			.put("grimoireofgaia:miscsoulfiery", "grimoireofgaia:misc_soul_fiery")
			.put("grimoireofgaia:miscsoulfire", "grimoireofgaia:misc_soul_fire")
			.put("grimoireofgaia:shieldprop", "grimoireofgaia:shield_prop")
			.put("grimoireofgaia:spawncreepergirl", "grimoireofgaia:spawn_creeper_girl")
			.put("grimoireofgaia:spawnendergirl", "grimoireofgaia:spawn_ender_girl")
			.put("grimoireofgaia:spawnholstaurus", "grimoireofgaia:spawn_holstaurus")
			.put("grimoireofgaia:spawnslimegirl", "grimoireofgaia:spawn_slime_girl")
			.put("grimoireofgaia:spawntame", "grimoireofgaia:spawn_tame")
			.put("grimoireofgaia:spawntrader", "grimoireofgaia:spawn_trader")
			.put("grimoireofgaia:spawnweresheep", "grimoireofgaia:spawn_weresheep")
			.put("grimoireofgaia:weaponbook", "grimoireofgaia:weapon_book")
			.put("grimoireofgaia:weaponbookbattle", "grimoireofgaia:weapon_book_battle")
			.put("grimoireofgaia:weaponbookbuff", "grimoireofgaia:weapon_book_buff")
			.put("grimoireofgaia:weaponbookender", "grimoireofgaia:weapon_book_ender")
			.put("grimoireofgaia:weaponbookfreezing", "grimoireofgaia:weapon_book_freezing")
			.put("grimoireofgaia:weaponbookhunger", "grimoireofgaia:weapon_book_hunger")
			.put("grimoireofgaia:weaponbookmetal", "grimoireofgaia:weapon_book_metal")
			.put("grimoireofgaia:weaponbooknature", "grimoireofgaia:weapon_book_nature")
			.put("grimoireofgaia:weaponbooknightmare", "grimoireofgaia:weapon_book_nightmare")
			.put("grimoireofgaia:weaponbookwither", "grimoireofgaia:weapon_book_wither")
			.put("grimoireofgaia:weapondebug", "grimoireofgaia:weapon_debug")
			.put("grimoireofgaia:weaponfanfire", "grimoireofgaia:weapon_fan_fire")
			.put("grimoireofgaia:weaponfanice", "grimoireofgaia:weapon_fan_ice")
			.put("grimoireofgaia:weaponprop", "grimoireofgaia:weapon_prop")
			.put("grimoireofgaia:weaponpropenchanted", "grimoireofgaia:weapon_prop_enchanted")
			.put("grimoireofgaia:weaponpropprojectile", "grimoireofgaia:weapon_prop_projectile")
			.build();

	@Override
	public int getFixVersion() {
		return 1;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String oldId = compound.getString("id");
		if (mapping.containsKey(oldId)) {
			compound.setString("id", mapping.get(oldId));
		}
		return compound;
	}
}
