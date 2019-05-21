package com.dreamsense.main.window;

import java.awt.*;

/**
 * @author kyle.eggleston
 */
public interface Screen {

  public void tick();

  public void render(Graphics g);
}
