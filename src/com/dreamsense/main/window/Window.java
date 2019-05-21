package com.dreamsense.main.window;

import com.dreamsense.main.Life;

import javax.swing.*;
import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Window {

  public Window(int width, int height, String title, Life life) {

    JFrame frame = new JFrame(title);

    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.add(life);
    frame.setVisible(true);
    life.start();
  }

}
