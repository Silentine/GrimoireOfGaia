package gaia.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Set;

public class BiomeHelper {
	public static boolean matchesDictionary(String[] dictionaryTypes, ResourceKey<Biome> biomeKey) {
		for (String configTag : dictionaryTypes) {
			if (!matchesDictionary(configTag, biomeKey)) {
				return false;
			}
		}
		return true;
	}


	@SuppressWarnings("deprecation")
	public static boolean matchesDictionary(String configType, ResourceKey<Biome> biomeKey) {
		final Set<Type> types = BiomeDictionary.getTypes(biomeKey);
		boolean inverted = false;
		String typeName;
		if (configType.contains("!")) {
			inverted = true;
			typeName = configType.substring(1);
		} else {
			typeName = configType;
		}

		boolean matches = false;
		for (Type type : types) {
			if (type.getName().equals(typeName)) {
				matches = true;
				break;
			}
		}
		boolean result = inverted ? !matches : matches;
		return result;
	}
}
