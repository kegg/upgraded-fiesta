package com.dreamsense.main.window;

import com.dreamsense.main.Game;
import com.dreamsense.main.entities.EntityId;
import com.dreamsense.main.entities.GoldCoin;
import com.dreamsense.main.entities.Handler;
import com.dreamsense.main.entities.SmartEnemy;

import java.util.Random;

/**
 * Created by kegg on 2019-05-21 at 22:16.
 * Project: upgraded-fiesta
 */
public class Spawn {
  
  private Handler handler;
  private Hud hud;
  private Game game;
  private int scoreKeep = 0;
  private Random r = new Random();
  
  public Spawn(Handler handler, Hud hud, Game game) {
    this.handler = handler;
    this.hud = hud;
    this.game = game;
  }
  
  public void tick() {
    scoreKeep = hud.getCoins();
    
    if (scoreKeep >= (20 * hud.getLevel())) {
      scoreKeep = 0;
      hud.setLevel(hud.getLevel() + 1);
      
      if (hud.getLevel() == 2) {
        handler.addEntity(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.SmartEnemy, handler));
        
        for (int i = 0; i < 20; i++) {
          handler.addEntity(new GoldCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.GoldCoin, handler));
        }
      } else if (hud.getLevel() == 3) {
        handler.addEntity(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.SmartEnemy, handler));
        handler.addEntity(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.SmartEnemy, handler));
  
        for (int i = 0; i < 20; i++) {
          handler.addEntity(new GoldCoin(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), EntityId.GoldCoin, handler));
        }
      }
    }
  }
}
