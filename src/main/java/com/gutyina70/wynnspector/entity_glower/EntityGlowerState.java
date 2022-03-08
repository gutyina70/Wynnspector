package com.gutyina70.wynnspector.entity_glower;

public enum EntityGlowerState {

  None,
  All,
  ArmorstandsOnly,
  AllButArmorstands;

  public EntityGlowerState next() {
    return values()[(ordinal() + 1) % values().length];
  }

}
