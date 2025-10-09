package Excercism.RemoteControlCompetition;
import java.util.ArrayList;
import java.util.List;

public class TestTrack {
    private static List<RemoteControlCar> race = new ArrayList<>(List.of());

    public static void race(RemoteControlCar car) {
        race.add(car);
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        throw new UnsupportedOperationException("Please implement the (static) TestTrack.getRankedCars() method");
    }
}

