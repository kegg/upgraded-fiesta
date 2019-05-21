package com.dreamsense.main.window;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Menu implements Screen {


  @Override
  public void tick() {

  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.white);
    g.drawRect(100, 100, 100, 100);
    g.drawString("Hello World", 117, 150);
  }
}
