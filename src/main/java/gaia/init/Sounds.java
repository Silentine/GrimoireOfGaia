package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**http://www.minecraftforge.net/forum/index.php/topic,38076.0.html**/
public class Sounds {
	
	static String MODID = GaiaReference.MOD_ID;
	
	public static SoundEvent passive_say;
	public static SoundEvent passive_hurt;
	public static SoundEvent passive_death;
	
	public static SoundEvent assist_say;
	public static SoundEvent assist_hurt;
	public static SoundEvent assist_death;
	
	public static SoundEvent aggressive_say;
	public static SoundEvent aggressive_hurt;
	public static SoundEvent aggressive_death;
	
	public static SoundEvent minotaur_say;
	public static SoundEvent minotaur_hurt;
	
	public static SoundEvent box_open1;
	public static SoundEvent box_open2;
	public static SoundEvent bag_open;
	public static SoundEvent book_hit;
	
	public static SoundEvent none;
	
	
	public static void Sounds_Init(){
		Gaia.logger.info("Registering Sounds");
		SoundsRegister();
		Gaia.logger.info("Sounds Finished");
	}
	
	public static void SoundsRegister(){
		
		passive_say = Reg("passive_say");
		passive_hurt = Reg("passive_hurt");
		passive_death = Reg("passive_death");
		
		assist_say = Reg("assist_say");
		assist_hurt = Reg("assist_hurt");
		assist_death = Reg("assist_death");
		
		aggressive_say = Reg("aggressive_say");
		aggressive_hurt = Reg("aggressive_hurt");
		aggressive_death = Reg("aggressive_death");
		
		minotaur_say = Reg("minotaur_say");
		minotaur_hurt = Reg("minotaur_hurt");
		
		box_open1 = Reg("box_open1");
		box_open2 = Reg("box_open2");
		bag_open = Reg("bag_open");
		book_hit = Reg("book_hit");
		
		none = Reg("none");
	}
	
	public static SoundEvent Reg(String name){
		ResourceLocation location = new ResourceLocation(MODID, name);
		
		return GameRegistry.register(new SoundEvent(location).setRegistryName(location));
		
	}
	
	
}
