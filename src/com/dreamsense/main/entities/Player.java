package com.dreamsense.main.entities;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Player extends Entity {

  private Handler handler;
  
  public Player(float x, float y, EntityId entityId, Handler handler) {
    super(x, y, entityId);
    this.handler = handler;
  }

  @Override
  public void tick() {
    x += velX;
    y += velY;

    x = Utils.clamp(x, 0, Game.WIDTH - 32);
    y = Utils.clamp(y, 0, Game.HEIGHT - 61);
    
    collision();
  }
  
  private void collision() {
  
    for (int i = 0; i < handler.getEntities().size(); i++) {
  
      Entity entity = handler.getEntities().get(i);
      
      if (getBounds().intersects(entity.getBounds())) {
        if (entity.getEntityId() == EntityId.GoldCoin) {
          handler.removeEntity(entity);
        }
      }
    }
  }

  @Override
  public void render(Graphics g) {
    g.drawImage(Game.fluffles, (int)x, (int)y, null);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle((int)x, (int)y, 32, 32);
  }
}
