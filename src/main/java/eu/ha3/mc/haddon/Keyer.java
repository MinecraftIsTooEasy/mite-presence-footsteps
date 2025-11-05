package eu.ha3.mc.haddon;

import net.minecraft.KeyBinding;

/*
--filenotes-placeholder
*/

public interface Keyer
{
	public void addKeyBinding(KeyBinding bind);
	
	public void removeKeyBinding(KeyBinding bind);
}