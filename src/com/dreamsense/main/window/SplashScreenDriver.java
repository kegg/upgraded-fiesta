package com.dreamsense.main.window;

/**
 * Created by kegg on 2019-05-21 at 18:03.
 * Project: upgraded-fiesta
 */
public class SplashScreenDriver {
  
  private SplashScreen screen;
  
  public SplashScreenDriver() {
    screen = new SplashScreen(new Texture("splash"));
    screen.setLocationRelativeTo(null);
    screen.setMaxProgress(100);
    screen.setVisible(true);
  
    for (int i = 0; i < 100; i++) {
      screen.setProgress(i);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
    screen.setVisible(false);
  }
}
