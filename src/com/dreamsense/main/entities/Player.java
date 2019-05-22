package com.dreamsense.main.entities;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Player extends Entity {

  public Player(float x, float y, EntityId entityId) {
    super(x, y, entityId);
  }

  @Override
  public void tick() {
    x += velX;
    y += velY;

    x = Utils.clamp(x, 0, Game.WIDTH - 32);
    y = Utils.clamp(y, 0, Game.HEIGHT - 61);
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.white);
    g.fillRect((int)getX(), (int)getY(), 32, 32);
  }
}
