package com.gutyina70.wynnspector;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "wynnspector", name = "Wynnspector", version = "1.0.0")
public class Wynnspector {

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Ref.logger = event.getModLog();
    MinecraftForge.EVENT_BUS.register(Events.instance);
  }

}
