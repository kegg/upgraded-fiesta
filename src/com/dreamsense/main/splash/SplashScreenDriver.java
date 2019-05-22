package com.dreamsense.main.splash;

import com.dreamsense.main.window.Texture;

/**
 * Created by kegg on 2019-05-21 at 18:03.
 * Project: upgraded-fiesta
 */
public class SplashScreenDriver {
  
  public SplashScreenDriver() {
    SplashScreen screen = new SplashScreen(new Texture("splash"));
    screen.setLocationRelativeTo(null);
    screen.setMaxProgress(100);
    screen.setVisible(true);
  
    for (int i = 0; i < 100; i++) {
      screen.setProgress(i);
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
    screen.setVisible(false);
  }
}
