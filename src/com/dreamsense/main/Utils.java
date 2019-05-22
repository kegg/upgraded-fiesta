package com.dreamsense.main;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Utils {

  public static float clamp(float var, float min, float max) {
    if (var >= max) {
      return var = max;
    } else if (var <= min) {
      return var = min;
    } else {
      return var;
    }
  }
  
  public static void drawCenteredString(String s, int w, int h, Graphics g, int y) {
    FontMetrics fm = g.getFontMetrics();
    int x = (w - fm.stringWidth(s)) / 2;
    //int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
    g.drawString(s, x, y);
  }
}
