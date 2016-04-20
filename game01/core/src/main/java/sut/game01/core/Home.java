package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.*;
import playn.core.*;
import tripleplay.game.ScreenStack;
import tripleplay.game.Screen;

public class Home extends Screen{
  private final ScreenStack ss;
  private ImageLayer bg;
  private ImageLayer gameButton;
  private ImageLayer settingButton;
  private GameScreen game;
  private SettingScreen setting;

  public Home(final ScreenStack ss)  {
    this.ss = ss;
    this.game = new GameScreen(ss);
    this.setting = new SettingScreen(ss);

    Image bgImage = assets().getImage("images/home.png");
    this.bg = graphics().createImageLayer(bgImage);

    Image gameButtonImage = assets().getImage("images/gameButton.png");
    this.gameButton = graphics().createImageLayer(gameButtonImage);
    gameButton.setTranslation(50, 50);

    Image settingButtonImage = assets().getImage("images/settingButton.png");
    this.settingButton = graphics().createImageLayer(settingButtonImage);
    settingButton.setTranslation(500, 50);

    gameButton.addListener(new Mouse.LayerAdapter(){
      @Override
      public void onMouseUp(Mouse.ButtonEvent event){
        ss.push(game);
      }

    });

    settingButton.addListener(new Mouse.LayerAdapter(){
      @Override
      public void onMouseUp(Mouse.ButtonEvent event){
        ss.push(setting);
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
    this.layer.add(gameButton);
    this.layer.add(settingButton);
    PlayN.keyboard().setListener(new Keyboard.Adapter(){
      @Override
      public void onKeyUp(Keyboard.Event event){
        if(event.key() == Key.ENTER){
          ss.push(game);
        }
      }


    });
  }

 
}
