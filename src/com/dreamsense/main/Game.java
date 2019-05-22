package com.dreamsense.main;

import com.dreamsense.main.entities.Handler;
import com.dreamsense.main.entities.KeyInput;
import com.dreamsense.main.window.Hud;
import com.dreamsense.main.window.Menu;
import com.dreamsense.main.window.Texture;
import com.dreamsense.main.window.Window;

import javax.swing.*;
import java.awt.*;

/**
 * @author kyle.eggleston
 */
public class Game extends JPanel implements Runnable {

  public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
  private Thread thread;
  private boolean running = false;
  public static boolean paused = false;
  
  public static Image fluffles;
  public static Image goldCoin;

  private Handler handler;
  private Hud hud;
  private Menu menu;
  
  public enum GameState {
    GAME,
    MENU,
    HELP,
    END;
  }
  
  public static GameState currentGameState = GameState.MENU;

  private Game() {
    handler = new Handler();
    hud = new Hud();
    menu = new Menu(this, handler, hud);
    this.addKeyListener(new KeyInput(handler, hud));
    this.addMouseListener(menu);
    new Window(WIDTH, HEIGHT, "Fluffles Revenge", this);
  }

  public synchronized void start() {
    if (running) return;

    thread = new Thread(this);
    thread.start();
    running = true;
  }

  private synchronized void stop() {
    try {
      thread.join();
      running = false;
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static int currentFrames = 0;
  
  private void init() {
    Texture tex = new Texture("fluffles");
    fluffles = tex.getImage();
    
    tex = new Texture("gold_coin");
    goldCoin = tex.getImage();
  }
  
  public void run() {
    init();
    this.requestFocus();

    int delay = 17;
    long sleep, timeDiff;
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;

    while (running) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;

      timeDiff = System.currentTimeMillis();
      sleep = delay - timeDiff;
      
      if (sleep < 0) {
        sleep = 2;
      }
  
      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        System.out.println("interrupted");
      }
      
      while(delta >= 1) {
        tick();
        delta--;
      }

      if(running)
        repaint();

      frames++;

      if(System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        System.out.println("FPS: " + frames);
        currentFrames = frames;
        frames = 0;
      }
    }

    stop();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.black);
    g.fillRect(0, 0, WIDTH, HEIGHT);
  
    handler.render(g);
  
    if (paused) {
      g.setColor(Color.white);
      g.drawString("PAUSED", 15, 96);
    }
    
    if (currentGameState == GameState.GAME) {
      hud.render(g);
    } else {
      menu.render(g);
    }
    
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
  }

  private void tick() {
    if (currentGameState == GameState.GAME) {
      if (!paused) {
        hud.tick();
        handler.tick();
      }
    }
  }

  public static void main(String[] args) {
    new Game();
  }
}
