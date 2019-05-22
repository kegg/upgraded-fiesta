package com.dreamsense.main.entities;

import com.dreamsense.main.Game;
import com.dreamsense.main.window.Hud;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author kyle.eggleston
 */
public class KeyInput extends KeyAdapter {

  private Handler handler;
  private Hud hud;
  private boolean[] keyDown = new boolean[4];

  public KeyInput(Handler handler, Hud hud) {
    this.handler = handler;
    this.hud = hud;

    keyDown[0]=false;
    keyDown[1]=false;
    keyDown[2]=false;
    keyDown[3]=false;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    for (Entity entity : handler.getEntities()) {
      if (entity.getEntityId() == EntityId.Player) {
        // key events
        if (key == KeyEvent.VK_W) {
          entity.setVelY(-5);
          keyDown[0] = true;
        }

        if (key == KeyEvent.VK_S) {
          entity.setVelY(5);
          keyDown[1] = true;
        }

        if (key == KeyEvent.VK_D) {
          entity.setVelX(5);
          keyDown[2] = true;
        }

        if (key == KeyEvent.VK_A) {
          entity.setVelX(-5);
          keyDown[3] = true;
        }
      }
    }

    if (key == KeyEvent.VK_Q) System.exit(0);

    if (Game.currentGameState == Game.GameState.GAME) {
      if (key == KeyEvent.VK_M) {
        handler.clearEntities();
        hud.resetLevel();
        Game.currentGameState = Game.GameState.MENU;
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    for (Entity entity : handler.getEntities()) {
      if (entity.getEntityId() == EntityId.Player) {
        // key events
        if (key == KeyEvent.VK_W) {
          keyDown[0] = false;
        }

        if (key == KeyEvent.VK_S) {
          keyDown[1] = false;
        }

        if (key == KeyEvent.VK_D) {
          keyDown[2] = false;
        }

        if (key == KeyEvent.VK_A) {
          keyDown[3] = false;
        }

        if (!keyDown[0] && !keyDown[1]) entity.setVelY(0);
        if (!keyDown[2] && !keyDown[3]) entity.setVelX(0);
      }
    }
  }
}
