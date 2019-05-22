package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 17:07.
 * Project: upgraded-fiesta
 */
public class Hud {
  
  private int health = 100;
  private int greenValue = 0;
  private int blueValue = 255 * health / 100;
  private int score = 0;
  private int level = 1;
  private int coins = 0;
  
  public void tick() {
    health = (int) Utils.clamp((float)health, 0, 100);
    blueValue = (int) Utils.clamp((float)blueValue, 0, 255);
    
    blueValue = health*2;
    score++;
  }
  
  public void render(Graphics g) {
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 32);
    int redValue = 150;
    g.setColor(new Color(redValue, greenValue, blueValue));
    g.fillRect(15, 15, health * 2, 32);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 32);
    
    g.drawString("Score: " + getScore(), 15, 64);
    g.drawString("Level: " + getLevel(), 15, 80);
    //g.drawString("Health: " + getHealth(), 15, 96);
    g.drawString("Coins: " + getCoins(), 15, 112);
    g.drawString("FPS: " + Game.currentFrames, 15, 128);
  }
  
  private void setScore(int score) {
    this.score = score;
  }
  
  public int getScore() {
    return score;
  }
  
  public void setLevel(int level) {
    this.level = level;
  }
  
  public int getLevel() {
    return level;
  }
  
  public void setHealth(int health) {
    this.health = health;
  }
  
  public int getHealth() {
    return health;
  }
  
  public int getCoins() {
    return coins;
  }
  
  public void setCoins(int coins) {
    this.coins = coins;
  }
  
  public void resetLevel() {
    setScore(0);
    setLevel(1);
    setHealth(100);
    setCoins(0);
  }
}
