package com.dreamsense.main.entities;

import com.dreamsense.main.Game;

import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 22:12.
 * Project: upgraded-fiesta
 */
public class SmartEnemy extends Entity {
  
  private Handler handler;
  private Entity player;
  
  public SmartEnemy(float x, float y, EntityId entityId, Handler handler) {
    super(x, y, entityId);
    
    this.handler = handler;
    
    for (int i = 0; i < handler.getEntities().size(); i++) {
      if (handler.getEntities().get(i).getEntityId() == EntityId.Player) {
        player = handler.getEntities().get(i);
      }
    }
  }
  
  @Override
  public void tick() {
    x += velX;
    y += velY;
  
    float diffX = x - player.getX() - 8;
    float diffY = y - player.getY() - 8;
    float distance = (float) Math.hypot((double)(x - player.getX()), (double)(y - player.getY()));
  
    velX = (float) ((-1.0/distance) * diffX);
    velY = (float) ((-1.0/distance) * diffY);
  
    if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
    if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
  }
  
  @Override
  public void render(Graphics g) {
    g.setColor(Color.green);
    g.fillRect((int)x, (int)y, 16, 16);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle((int)x, (int)y, 16, 16);
  }
}
