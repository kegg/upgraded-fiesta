package com.dreamsense.main.entities;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public abstract class Entity {

  protected float x, y;
  protected EntityId entityId;
  protected float velX, velY;

  public Entity(float x, float y, EntityId entityId) {
    this.x = x;
    this.y = y;
    this.entityId = entityId;
  }

  public abstract void tick();
  public abstract void render(Graphics g);
  public abstract Rectangle getBounds();

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public EntityId getEntityId() {
    return entityId;
  }

  public void setEntityId(EntityId entityId) {
    this.entityId = entityId;
  }

  public float getVelX() {
    return velX;
  }

  public void setVelX(float velX) {
    this.velX = velX;
  }

  public float getVelY() {
    return velY;
  }

  public void setVelY(float velY) {
    this.velY = velY;
  }
}
