package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.*;
import playn.core.*;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;

public class SettingScreen extends Screen{
  private final ScreenStack ss;
  private ImageLayer bg;
  private ImageLayer backButton;


  public SettingScreen(final ScreenStack ss)  {
    this.ss = ss;

    Image bgImage = assets().getImage("images/setting.png");
    this.bg = graphics().createImageLayer(bgImage);

    Image backButtonImage = assets().getImage("images/backButton.png");
    this.backButton = graphics().createImageLayer(backButtonImage);
    backButton.setTranslation(50, 50);

    backButton.addListener(new Mouse.LayerAdapter(){
      @Override
      public void onMouseUp(Mouse.ButtonEvent event){
        ss.remove(ss.top());
      }

    });

  
  }



  @Override
  public void update(int delta) {
  }

  @Override
  public void wasShown(){
    super.wasShown();
    this.layer.add(bg);
    this.layer.add(backButton);
    
  
  }

 
}
