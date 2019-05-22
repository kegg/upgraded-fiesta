package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.splash.SplashScreenDriver;

import javax.swing.*;
import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Window {

  public Window(int width, int height, String title, Game game) {
    new SplashScreenDriver();
    
    JFrame frame = new JFrame(title);
    frame.add(game);
    
    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    game.start();
  }

}
