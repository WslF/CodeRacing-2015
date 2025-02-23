
import model.Car;
import model.Game;
import model.Move;
import model.World;

import static java.lang.StrictMath.*;
import model.CarType;

public final class MyStrategy implements Strategy {

    private static int typeOfStrategy = 0;
    private static StrategyWslF myStrategy;

    @Override
    public void move(Car self, World world, Game game, Move move) {
        /*
         if (typeOfStrategy == 0) {
         if (world.getPlayers().length == 4) {//Buggy1x4 || Jeep1x4
         if (world.getCars()[0].getType() == CarType.BUGGY) {
         typeOfStrategy = 1;
         myStrategy = new StrategyBuggy1x4();
         } else {
         typeOfStrategy = 2;
         }
         } else {// Buggy and Jeep2x2
         typeOfStrategy = 3;
         }
         }*/
        Car[] cars = world.getCars();
        int k = 0;
        for (Car car : cars) {
            if (car.isTeammate()) {
                k++;
            }
        }
        if (k > 1) {
            return;
        }
        if (myStrategy == null) {
            myStrategy = new StrategyBuggy1x4();
        }
        if (world.getTick() <= 1) {
            myStrategy.initFirst(self, world, game, move);
        }

        myStrategy.move(self, world, game, move);
    }
}
