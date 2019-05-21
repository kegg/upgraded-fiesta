package com.dreamsense.main.entities;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author kyle.eggleston
 */
public class Handler {

  private LinkedList<Entity> entities = new LinkedList<>();

  public void tick() {
    for (Entity entity : entities) {
      entity.tick();
    }
  }

  public void render(Graphics g) {
    for (Entity entity : entities) {
      entity.render(g);
    }
  }

  public void addEntity(Entity entity) {
    entities.add(entity);
  }

  public void removeEntity(Entity entity) {
    entities.remove(entity);
  }

  public LinkedList<Entity> getEntities() {
    return entities;
  }

}
