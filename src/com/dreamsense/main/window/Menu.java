package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.Utils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author kyle.eggleston
 */
public class Menu extends MouseAdapter implements Screen {

  private Game game;
  
  public Menu(Game game) {
    this.game = game;
  }
  
  public void mousePressed(MouseEvent e) {
    int mx = e.getX();
    int my = e.getY();
    
    if (Game.currentGameState == Game.GameState.MENU) {
      // play
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 150, 200, 64)) {
        Game.currentGameState = Game.GameState.GAME;
      }
  
      // help
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 250, 200, 64)) {

      }
  
      // quit
      if (mouseOver(mx, my, (Game.WIDTH - 200) / 2, 350, 200, 64)) {
        System.exit(0);
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
    }
  }
}
