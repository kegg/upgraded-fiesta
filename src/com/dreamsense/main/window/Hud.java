package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 17:07.
 * Project: upgraded-fiesta
 */
public class Hud {
  
  private int HEALTH = 100;
  private int greenValue = 0;
  private int blueValue = 255 * HEALTH / 100;
  private int score = 0;
  private int level = 1;
  private int coins = 0;
  
  public void tick() {
    HEALTH = (int) Utils.clamp((float)HEALTH, 0, 100);
    greenValue = (int) Utils.clamp((float)greenValue, 0, 255);
    
    greenValue = HEALTH*2;
    score++;
  }
  
  public void render(Graphics g) {
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 32);
    int redValue = 150;
    g.setColor(new Color(redValue, greenValue, blueValue));
    g.fillRect(15, 15, HEALTH * 2, 32);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 32);
    
    g.drawString("Score: " + getScore(), 15, 64);
    g.drawString("Level: " + getLevel(), 15, 80);
    //g.drawString("Health: " + HEALTH, 15, 96);
    g.drawString("Coins: " + getCoins(), 15, 112);
    g.drawString("FPS: " + Game.currentFrames, 15, 128);
  }
  
  private void setScore(int score) {
    this.score = score;
  }
  
  private int getScore() {
    return score;
  }
  
  private void setLevel(int level) {
    this.level = level;
  }
  
  private int getLevel() {
    return level;
  }
  
  private void setHealth(int health) {
    HEALTH = health;
  }
  
  public int getCoins() {
    return coins;
  }
  
  public void setCoins(int coins) {
    this.coins = coins;
  }
  
  public void resetLevel() {
    setLevel(1);
    setScore(0);
    setCoins(0);
    setHealth(100);
  }
}
