package com.dreamsense.main;

import com.dreamsense.main.entities.EntityId;
import com.dreamsense.main.entities.Handler;
import com.dreamsense.main.entities.KeyInput;
import com.dreamsense.main.entities.Player;
import com.dreamsense.main.window.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * @author kyle.eggleston
 */
public class Life extends Canvas implements Runnable {

  public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
  private Thread thread;
  private boolean running = false;

  private Handler handler;

  public Life() {
    handler = new Handler();
    this.addKeyListener(new KeyInput(handler));
    new Window(WIDTH, HEIGHT, "Fluffles Revenge", this);
    handler.addEntity(new Player(100, 100, EntityId.Player));
  }

  public synchronized void start() {
    if (running) return;

    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public synchronized void stop() {
    try {
      thread.join();
      running = false;
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void run() {
    this.requestFocus();

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

      while(delta >= 1) {
        tick();
        delta--;
      }

      if(running)
        render();

      frames++;

      if(System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        System.out.println("FPS: " + frames);
        frames = 0;
      }
    }

    stop();
  }

  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();

    g.setColor(Color.black);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    handler.render(g);

    bs.show();
    g.dispose();
  }

  private void tick() {
    handler.tick();
  }

  public static int clamp(int var, int min, int max) {
    if (var >= max) {
      return var = max;
    } else if (var <= min) {
      return var = min;
    } else {
      return var;
    }
  }

  public static void main(String[] args) {
    new Life();
  }
}
