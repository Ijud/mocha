package mocha.game.world.map;

import com.google.common.collect.Sets;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import mocha.game.world.tile.Tile;
import mocha.game.world.tile.TileType;

@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MapFactory {

  private static int mapId = 0;

  @Inject
  private MapReader mapReader;

  public Map newGrid() {
    return Map.builder()
      .id(mapId++)
      .tiles(createGridTiles(18, 12))
      .entities(Sets.newIdentityHashSet())
      .build();
  }

  public Map newRandomDefault() {
    return newRandomDefault(18, 12);
  }

  public Map newRandomDefault(int columns, int rows) {
    return Map.builder()
      .tiles(createRandomTiles(columns, rows))
      .entities(Sets.newIdentityHashSet())
      .id(mapId++)
      .build();
  }

  private Tile[][] createGridTiles(int columns, int rows) {
    Tile[][] tiles = new Tile[rows][columns];
    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        tiles[y][x] = Tile.builder().tileType(TileType.GRID).build();
      }
    }
    return tiles;
  }

  private Tile[][] createRandomTiles(int columns, int rows) {
    Tile[][] tiles = new Tile[rows][columns];

    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        tiles[y][x] = Tile.builder()
          .tileType(TileType.random())
          .build();
      }
    }
    return tiles;
  }
}
