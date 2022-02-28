package com.gutyina70.wynnspector;

public enum EntityGlowerState {
  
  None,
  All,
  ArmorstandsOnly,
  AllButArmorstands;

  public EntityGlowerState next() {
    return values()[(ordinal() + 1) % values().length];
  }
  
}
