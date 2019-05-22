package com.dreamsense.main.window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kegg on 2019-05-21 at 17:34.
 * Project: upgraded-fiesta
 */
public class SplashScreen extends JWindow {

  private BorderLayout borderLayout;
  private JLabel imageLabel;
  private JPanel southPanel;
  private FlowLayout southFlow;
  private JProgressBar progressBar;
  private ImageIcon imageIcon;
  
  public SplashScreen(Texture texture) {
    this.imageIcon = new ImageIcon(texture.getImage());
    borderLayout = new BorderLayout();
    imageLabel = new JLabel();
    southPanel = new JPanel();
    southFlow = new FlowLayout();
    progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    
    try {
      init();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private void init() throws Exception {
    imageLabel.setIcon(imageIcon);
    getContentPane().setLayout(borderLayout);
    southPanel.setLayout(southFlow);
    southPanel.setBackground(Color.white);
    getContentPane().add(imageLabel, BorderLayout.CENTER);
    getContentPane().add(southPanel, BorderLayout.SOUTH);
    southPanel.add(progressBar, null);
    pack();
  }
  
  public void setMaxProgress(int maxProgress) {
    progressBar.setMaximum(maxProgress);
  }
  
  public void setProgress(int progress) {
    float percentage = ((float)progress / (float)progressBar.getMaximum()) * 100;
    
    SwingUtilities.invokeLater(new Runnable() {
  
      @Override
      public void run() {
        progressBar.setValue(progress);
        progressBar.setString(String.format("Loading " + (int)percentage) + "%");
      }
    });
  }
}
