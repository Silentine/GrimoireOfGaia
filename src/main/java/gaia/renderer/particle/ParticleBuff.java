package gaia.renderer.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * @param world
 * @param x
 * @param y 
 * @param z 
 * @param velocityX 
 * @param velocityY 
 * @param velocityZ 
 **/
public class ParticleBuff extends Particle {
	private final ResourceLocation TextureLocation = ParticleHandler.particleBuff;

	public ParticleBuff(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
		super(world, x, y, z, velocityX, velocityY, velocityZ);

		motionX = velocityX;
		motionY = velocityY + 0.075F;
		motionZ = velocityZ;

		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(TextureLocation.toString());
		setParticleTexture(sprite);
	}

	@Override
	public int getFXLayer() {
		return 1;
	}

	@Override
	public int getBrightnessForRender(float partialTick) {
		final int FULL_BRIGHTNESS_VALUE = 0xf000f0;
		return FULL_BRIGHTNESS_VALUE;
	}

	@Override
	public boolean isTransparent() {
		return false;
	}

	@Override
	public void onUpdate() {		
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		moveEntity(motionX, motionY, motionZ);

		if (isCollided) {
			this.setExpired();
		}

		if (this.particleMaxAge-- <= 0) {
			this.setExpired();
		}
	}

	@Override
	public void renderParticle(VertexBuffer vertexBuffer, Entity entity, float partialTick, float edgeLRdirectionX, float edgeUDdirectionY, float edgeLRdirectionZ, float edgeUDdirectionX, float edgeUDdirectionZ) {
		double minU = this.particleTexture.getMinU();
		double maxU = this.particleTexture.getMaxU();
		double minV = this.particleTexture.getMinV();
		double maxV = this.particleTexture.getMaxV();

		double scale = 0.1F * this.particleScale; 
		final double scaleLR = scale;
		final double scaleUD = scale;
		double x = this.prevPosX + (this.posX - this.prevPosX) * partialTick - interpPosX;
		double y = this.prevPosY + (this.posY - this.prevPosY) * partialTick - interpPosY;
		double z = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTick - interpPosZ;

		int combinedBrightness = this.getBrightnessForRender(partialTick);
		int skyLightTimes16 = combinedBrightness >> 16 & 65535;
		int blockLightTimes16 = combinedBrightness & 65535;

		vertexBuffer.pos(x - edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
				y - edgeUDdirectionY * scaleUD,
				z - edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
				.tex(maxU, maxV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		vertexBuffer.pos(x - edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
				y + edgeUDdirectionY * scaleUD,
				z - edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
				.tex(maxU, minV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		vertexBuffer.pos(x + edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
				y + edgeUDdirectionY * scaleUD,
				z + edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
				.tex(minU, minV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
		vertexBuffer.pos(x + edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
				y - edgeUDdirectionY * scaleUD,
				z + edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
				.tex(minU, maxV)
				.color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
				.lightmap(skyLightTimes16, blockLightTimes16)
				.endVertex();
	}
}