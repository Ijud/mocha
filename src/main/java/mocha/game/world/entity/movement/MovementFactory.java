package mocha.game.world.entity.movement;

import com.google.common.eventbus.EventBus;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

import mocha.game.world.tile.Tile;

@Component
public class MovementFactory {

  @Inject
  private EventBus eventBus;

  public VelocityMovement newVelocityMovement() {
    return new VelocityMovement();
  }

  public SimpleMovement newSimpleMovement() {
    return new SimpleMovement();
  }

  public SlidingMovement newSlidingMovement() {
    return new SlidingMovement(Tile.SIZE, 15);
  }

  public AccelerationMovement newAccelerationMovement() {
    return AccelerationMovement.builder()
        .accelerationRate(.1)
        .maxXVelocity(2.0)
        .maxYVelocity(2.0)
        .build();
  }
}