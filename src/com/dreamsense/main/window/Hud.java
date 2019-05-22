package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 17:07.
 * Project: upgraded-fiesta
 */
public class Hud {
  
  public static int HEALTH = 100;
  private int greenValue = 0;
  private int redValue = 150;
  private int blueValue = 255 * HEALTH / 100;
  private int score = 0;
  private int level = 1;
  
  public void tick() {
    HEALTH = (int) Utils.clamp((float)HEALTH, 0, 100);
    greenValue = (int) Utils.clamp((float)greenValue, 0, 255);
    
    greenValue = HEALTH*2;
    score++;
  }
  
  public void render(Graphics g) {
    g.setColor(Color.gray);
    g.fillRect(15, 15, 200, 32);
    g.setColor(new Color(redValue, greenValue, blueValue));
    g.fillRect(15, 15, HEALTH * 2, 32);
    g.setColor(Color.white);
    g.drawRect(15, 15, 200, 32);
    
    g.drawString("Score: " + score, 15, 64);
    g.drawString("Level: " + level, 15, 80);
    //g.drawString("Health: " + HEALTH, 15, 96);
    g.drawString("FPS: " + Game.currentFrames, 15, 112);
  }
  
  public void setScore(int score) {
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
    HEALTH = health;
  }
  
  public void resetLevel() {
    setLevel(1);
    setScore(0);
    setHealth(100);
  }
}
