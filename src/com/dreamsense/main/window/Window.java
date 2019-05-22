package com.dreamsense.main.window;

import com.dreamsense.main.Life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author kyle.eggleston
 */
public class Window {

  public Window(int width, int height, String title, Life life) {
    new SplashScreenDriver();
    
    JFrame frame = new JFrame(title);
    frame.add(life);
    
    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    life.start();
  }

}
