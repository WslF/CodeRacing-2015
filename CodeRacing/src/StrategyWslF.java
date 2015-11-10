
import model.Car;
import model.Game;
import model.Move;
import model.TileType;
import model.World;

/**
 *
 * @author Wsl_F
 */
public class StrategyWslF {

    /**
     * convert tile to matrix 800x800 with margin 80
     */
    TileToMatrix tileToMatrix;
    /**
     * convert tile to matrix 80x80 with margin 8
     */
    TileToMatrix tileToMatrix80;

    Car self;
    World world;
    Game game;
    Move move;
    TileType[][] mapTiles;
    int curTileX;
    int curTileY;

    public void move(Car self, World world, Game game, Move move) {
        initAll(self, world, game, move);
        /*
        {
            //int[][] curTile = tileToMatrix.getMatrix(TileType.LEFT_TOP_CORNER);
            int[][] curTile = tileToMatrix80.getMatrix(TileType.CROSSROADS);
            for (int i= 0; i<80; i++)
            {
                for (int j= 0; j<80; j++)
                {
                    System.out.print(curTile[i][j]);
                }
                System.out.println();
            }
        }*/
        
        TileType[][] mapTiles = world.getTilesXY();
        curTileX = (int) (self.getX() / game.getTrackTileSize());
        curTileY = (int) (self.getY() / game.getTrackTileSize());

    }

    private void initAll(Car self, World world, Game game, Move move) {
        this.self = self;
        this.world = world;
        this.game = game;
        this.move = move;

        tileToMatrix = new TileToMatrix(world, game, move, self);
        tileToMatrix80 = new TileToMatrix(world, game, move, self, 80, 8);
    }
}
