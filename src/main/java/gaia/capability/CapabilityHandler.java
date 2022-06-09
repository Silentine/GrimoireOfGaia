package gaia.capability;

import gaia.GrimoireOfGaia;
import gaia.capability.friended.FriendedCapability;
import gaia.capability.friended.IFriended;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class CapabilityHandler {
	public static final ResourceLocation FRIENDED_CAP = new ResourceLocation(GrimoireOfGaia.MOD_ID, "friended");

	public static final Capability<IFriended> CAPABILITY_FRIENDED = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static void register(RegisterCapabilitiesEvent event) {
		event.register(IFriended.class);
	}

	public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof LivingEntity livingEntity && livingEntity.getType().getRegistryName() != null &&
				livingEntity.getType().getRegistryName().getNamespace().equals(GrimoireOfGaia.MOD_ID)) {
			event.addCapability(CapabilityHandler.FRIENDED_CAP, new FriendedCapability());
		}
	}
}
