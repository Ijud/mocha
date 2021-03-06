package mocha.game.world;

import java.util.Arrays;
import java.util.HashMap;

import mocha.gfx.Drawable;
import mocha.game.world.entity.Entity;
import mocha.game.world.tile.Tile;
import mocha.gfx.MochaCanvas;

public class Map implements Drawable {

  private Tile[][] tiles;
  private final int id;
  private HashMap<Integer, Entity> entities = new HashMap<>();

  public Map(int id, int columns, int rows) {
    this.id = id;

    tiles = new Tile[rows][columns];
    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        tiles[y][x] = new Tile(x, y);
      }
    }
  }

  public Tile[][] getTiles() {
    return tiles;
  }

  Tile getTile(int x, int y) {
    return tiles[y][x];
  }

  public int getId() {
    return id;
  }

  public void addEntity(Entity entity) {
    entities.put(entity.getId(), entity);
  }

  HashMap<Integer, Entity> getEntities() {
    return entities;
  }

  public int getColumnCount() {
    return tiles[0].length;
  }

  public int getRowCount() {
    return tiles.length;
  }

  @Override
  public void draw(MochaCanvas mochaCanvas) {
    Arrays.stream(tiles).forEach((row) -> Arrays.stream(row).forEach((tile) -> tile.draw(mochaCanvas)));
    getEntities().values().forEach((entity) -> entity.draw(mochaCanvas));
  }

  void tick() {
    getEntities().values().forEach(Entity::tick);
  }
}
