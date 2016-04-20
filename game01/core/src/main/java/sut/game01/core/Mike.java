package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.*;
import playn.core.*;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;
import sut.game01.core.sprite.*;

public class Mike{
  private Sprite sprite;
  private int spriteIndex = 0;
  private boolean hasLoaded = false;

  public enum State {
    IDLE
  };

  private State state = State.IDLE;

  private int e = 0;
  private int offset = 0;


  public Mike(final float x, final float y) {
    sprite = SpriteLoader.getSprite("images/mike.json");
    sprite.addCallback(new Callback<Sprite>(){
       @Override
       public void onSuccess(Sprite result){
        sprite.setSprite(spriteIndex);
        sprite.layer().setOrigin(sprite.width() / 2f,
                                  sprite.height() / 2f);
        sprite.layer().setTranslation(x, y +13f);
        hasLoaded = true;
       } 
       @Override
       public void onFailure(Throwable cause){
        PlayN.log().error("Error", cause);
       }
    });

  
  }

  public Layer layer(){
    return sprite.layer();
  }

  public void update(int delta) {
    if (!hasLoaded) return;
    e += delta;

    if(e > 150){

      switch(state){
        case IDLE: offset = 0;
                break;
      }
      spriteIndex = offset + ((spriteIndex + 1)%4);
      sprite.setSprite(spriteIndex);
      e = 0;
    }
  }

 

 
}
