package com.dreamsense.main.entities;

import com.dreamsense.main.Game;

import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 20:22.
 * Project: upgraded-fiesta
 */
public class Coin extends Entity {
  
  private Handler handler;
  private Image coinImage;
  
  public Coin(float x, float y, EntityId entityId, Handler handler, Image coinImage) {
    super(x, y, entityId);
    this.handler = handler;
    this.coinImage = coinImage;
  }
  
  @Override
  public void tick() {
  
  }
  
  @Override
  public void render(Graphics g) {
    g.drawImage(coinImage, (int)x, (int)y, null);
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle((int)x, (int)y, 16, 16);
  }
}
