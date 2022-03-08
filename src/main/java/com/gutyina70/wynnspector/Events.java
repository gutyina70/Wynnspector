package com.gutyina70.wynnspector;

import com.gutyina70.wynnspector.entity_glower.EntityGlower;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class Events {

  public static Events instance = new Events();

  private EntityGlower entityGlower = new EntityGlower();

  @SubscribeEvent
  public void onClientTick(ClientTickEvent event) {
    entityGlower.onTick(event);
  }

}
