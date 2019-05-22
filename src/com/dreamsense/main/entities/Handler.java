package com.dreamsense.main.entities;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author kyle.eggleston
 */
public class Handler {

  public LinkedList<Entity> entities = new LinkedList<>();

  public void tick() {
    for (int i = 0; i < entities.size(); i++) {
      Entity entity = entities.get(i);
      entity.tick();
    }
  }

  public void render(Graphics g) {
    for (int i = 0; i < entities.size(); i++) {
      Entity entity = entities.get(i);
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
  
  public void clearEntities() {
    entities.clear();
  }
}
