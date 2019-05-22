package com.dreamsense.main.entities;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;
import com.dreamsense.main.window.Texture;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Player extends Entity {

  private Texture tex;
  private Image image;
  
  public Player(float x, float y, EntityId entityId) {
    super(x, y, entityId);
    tex = new Texture("fluffles");
    image = tex.getImage();
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
    g.drawImage(image, (int)x, (int)y, null);
  }
}
