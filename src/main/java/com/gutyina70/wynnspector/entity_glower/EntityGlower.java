package com.gutyina70.wynnspector.entity_glower;

import java.util.List;

import com.gutyina70.wynnspector.Ref;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class EntityGlower {

  private static int triggerKey = Keyboard.KEY_NUMPAD3;

  private boolean lastKeyDown = false;
  private EntityGlowerState state = EntityGlowerState.None;

  public void onTick(ClientTickEvent event) {
    if (Ref.world() == null) {
      return;
    }

    state = getUpdatedState();
    applyGlowing();
  }

  private EntityGlowerState getUpdatedState() {
    EntityGlowerState newState = state;
    if (isTriggerKeyDown() && !lastKeyDown) {
      newState = state.next();
    }
    lastKeyDown = isTriggerKeyDown();
    return newState;
  }

  private boolean isTriggerKeyDown() {
    return Keyboard.isKeyDown(triggerKey);
  }

  private void applyGlowing() {
    List<Entity> entities = Ref.world().getEntities(Entity.class, x -> true);
    for (Entity entity : entities) {
      entity.setGlowing(false);
      if (shouldGlow(entity)) {
        entity.setGlowing(true);
      }
    }
  }

  private boolean shouldGlow(Entity entity) {
    switch (state) {
      case All:
        return true;
      case ArmorstandsOnly:
        return entity instanceof EntityArmorStand;
      case AllButArmorstands:
        return !(entity instanceof EntityArmorStand);
      default:
        return false;
    }
  }

}
