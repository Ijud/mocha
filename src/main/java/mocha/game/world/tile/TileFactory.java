package mocha.game.world.tile;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class TileFactory {

  private Map<String, TileType> typeByDescription = Maps.newHashMap();

  public TileFactory() {
    Arrays.stream(TileType.values())
        .forEach(tileType ->
            typeByDescription.put(tileType.getSymbol(), tileType));
  }

  public Tile newTile(String tileTypeSymbol) {
    return Tile.builder()
        .tileType(typeByDescription.get(tileTypeSymbol))
        .build();
  }
}
