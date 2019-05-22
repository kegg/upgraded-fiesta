package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;
import com.dreamsense.main.entities.EntityId;
import com.dreamsense.main.entities.Coin;
import com.dreamsense.main.entities.Handler;
import com.dreamsense.main.entities.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * @author kyle.eggleston
 */
public class Menu extends MouseAdapter implements Screen {

  private Game game;
  private Handler handler;
  private Hud hud;
  private Texture tex;
  private Image fluffles;
  private Random r;
  private int clickFluffles = 0;
  
  public Menu(Game game, Handler handler, Hud hud) {
    this.game = game;
    this.handler = handler;
    this.hud = hud;
    tex = new Texture("fluffles");
    fluffles = tex.getImage();
    r = new Random();
  }
  
  public void mousePressed(MouseEvent e) {
    int mx = e.getX();
    int my = e.getY();
    
    if (Game.currentGameState == Game.GameState.MENU) {
      // play
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 150, 200, 64)) {
        Game.currentGameState = Game.GameState.GAME;
        handler.addEntity(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, EntityId.Player, handler, hud));
        
        for (int i = 0; i < 20; i++) {
          handler.addEntity(new Coin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.BronzeCoin, handler, Game.bronzeCoin));
        }
      }
  
      // help
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 250, 200, 64)) {
        Game.currentGameState = Game.GameState.HELP;
      }
  
      // quit
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
        System.exit(0);
      }
    } else if (Game.currentGameState == Game.GameState.HELP) {
      // clicking on fluffles
      if (mouseOver(mx, my, (Game.WIDTH - 32) / 2, 100, 32, 32)) {
        clickFluffles++;
        
        if (clickFluffles == 10) {
          clickFluffles = 0;
          Game.currentGameState = Game.GameState.SPECIAL;
        }
        
      }
      
      // back
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
        Game.currentGameState = Game.GameState.MENU;
      }
    } else if (Game.currentGameState == Game.GameState.SPECIAL) {
      // back
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
        Game.currentGameState = Game.GameState.HELP;
      }
    } else if (Game.currentGameState == Game.GameState.END) {
      // try again
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
        hud.resetLevel();
        Game.currentGameState = Game.GameState.MENU;
      }
    }
  }
  
  public void mouseReleased(MouseEvent e) {
  
  }
  
  private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
    if (mx > x && mx < x + width) {
      if (my > y && my < y + height) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
  
  @Override
  public void tick() {

  }

  @Override
  public void render(Graphics g) {
    Font font = new Font("arial", Font.BOLD, 50);
    Font font2 = new Font("arial", Font.BOLD, 30);
    Font font3 = new Font("arial", Font.BOLD, 20);
    Font font4 = new Font("arial", Font.BOLD, 10);
    Dimension d = new Dimension(Game.WIDTH, Game.HEIGHT);
  
    if (g instanceof Graphics2D) {
      Graphics2D g2d = (Graphics2D) g;
      RenderingHints rh = new RenderingHints(
          RenderingHints.KEY_TEXT_ANTIALIASING,
          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g2d.setRenderingHints(rh);
    }
    
    if (game.currentGameState == Game.GameState.MENU) {
      g.setFont(font);
      g.setColor(Color.white);
      Utils.drawCenteredString("FLUFFLES REVENGE", d.width, d.height, g, 70);
    
      g.setFont(font2);
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 150, 200, 64);
      Utils.drawCenteredString("Play", d.width, d.height, g, 190);
    
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 250, 200, 64);
      Utils.drawCenteredString("Help", d.width, d.height, g, 290);
    
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 350, 200, 64);
      Utils.drawCenteredString("Quit", d.width, d.height, g, 390);
      
      g.setFont(font4);
      g.setColor(Color.gray);
      g.drawString("Version 0.1a", 10, 450);
    } else if (game.currentGameState == Game.GameState.HELP) {
      g.setFont(font);
      g.setColor(Color.white);
      Utils.drawCenteredString("HELP", d.width, d.height, g, 70);
      
      g.drawImage(fluffles, (Game.WIDTH - 32) / 2, 100, null);
      
      g.setFont(font3);
      g.setColor(Color.white);
      Utils.drawCenteredString("You are a sheep, save the world.", d.width, d.height, g, 190);
      Utils.drawCenteredString("WASD to move around, collect coins, have fun.", d.width, d.height, g, 290);
  
      g.setFont(font2);
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 350, 200, 64);
      Utils.drawCenteredString("Back", d.width, d.height, g, 390);
  
      g.setFont(font4);
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 350, 200, 64);
    } else if (game.currentGameState == Game.GameState.SPECIAL) {
      g.setFont(font);
      g.setColor(Color.white);
      Utils.drawCenteredString("FLUFFLES", d.width, d.height, g, 70);
  
      g.drawImage(fluffles, (Game.WIDTH - 32) / 2, 100, null);
  
      g.setFont(font3);
      g.setColor(Color.white);
      Utils.drawCenteredString("Fluffles is mad now.", d.width, d.height, g, 190);
  
      g.setFont(font2);
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 350, 200, 64);
      Utils.drawCenteredString("Back", d.width, d.height, g, 390);
    } else if (game.currentGameState == Game.GameState.END) {
      g.setColor(new Color(139, 0, 0));
      g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
      
      g.setFont(font);
      g.setColor(Color.white);
      Utils.drawCenteredString("GAME OVER", d.width, d.height, g, 70);
  
      g.setFont(font3);
      Utils.drawCenteredString("Score: " + hud.getScore(), d.width, d.height, g, 200);
      Utils.drawCenteredString("Coins: " + hud.getCoins(), d.width, d.height, g, 230);
      Utils.drawCenteredString("Level: " + hud.getLevel(), d.width, d.height, g, 260);
      
      g.setFont(font2);
      g.setColor(Color.white);
      g.drawRect((Game.WIDTH - 200) / 2, 350, 200, 64);
      Utils.drawCenteredString("Try Again", d.width, d.height, g, 390);
    }
  }
}
