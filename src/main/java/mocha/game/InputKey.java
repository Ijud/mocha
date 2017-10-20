package mocha.game;

import java.util.Arrays;

public enum InputKey {

  UNBOUND,
  LEFT,
  RIGHT,
  UP,
  DOWN;

  private boolean isDown;
  private boolean pressed;
  private int clicks;
  private boolean isClicked;

  public boolean isDown() {
    return isDown;
  }

  public void down() {
    // TODO: perhaps down should be a noop if it's already down?
    // TODO: clicks should only increase if the key is not already down
    clicks++;
    pressed = true;
  }

  public void up() {
    pressed = false;
  }

  public void tick() {
    isDown = pressed || clicks > 0;
    isClicked = clicks > 0;
    clicks -= clicks > 0 ? 1 : 0;
  }

  public boolean isClicked() {
    return isClicked;
  }

  public static void tickAll() {
    Arrays.stream(InputKey.values()).forEach(InputKey::tick);
  }
}
