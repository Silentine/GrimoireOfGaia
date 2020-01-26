package gaia.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockVanilla extends BlockBase {

	public BlockVanilla(Material material, String blockName, float hardness, float resistance, SoundType soundType) {
		super(material, blockName);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(soundType);
	}
}