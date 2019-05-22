package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;
import com.dreamsense.main.entities.EntityId;
import com.dreamsense.main.entities.Handler;
import com.dreamsense.main.entities.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author kyle.eggleston
 */
public class Menu extends MouseAdapter implements Screen {

  private Game game;
  private Handler handler;
  private Texture tex;
  private Image fluffles;
  
  public Menu(Game game, Handler handler) {
    this.game = game;
    this.handler = handler;
    tex = new Texture("fluffles");
    fluffles = tex.getImage();
  }
  
  public void mousePressed(MouseEvent e) {
    int mx = e.getX();
    int my = e.getY();
    
    if (Game.currentGameState == Game.GameState.MENU) {
      // play
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 150, 200, 64)) {
        Game.currentGameState = Game.GameState.GAME;
        handler.addEntity(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, EntityId.Player));
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
      // back
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
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
    Dimension d = new Dimension(Game.WIDTH, Game.HEIGHT);
  
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
    }
  }
}
