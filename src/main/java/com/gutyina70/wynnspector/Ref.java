package com.gutyina70.wynnspector;

import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class Ref {

  public static Logger logger;
  public static Minecraft mc = Minecraft.getMinecraft();

  public static World world() {
    return mc.world;
  }

}
