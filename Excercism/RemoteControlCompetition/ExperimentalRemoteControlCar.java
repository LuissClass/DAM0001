package Excercism.RemoteControlCompetition;

public class ExperimentalRemoteControlCar implements RemoteControlCar{
    private final static int SPEED = 20;
    private int distance = 0;

    public void drive() {
        distance+=SPEED;
    }

    public int getDistanceTravelled() {
        return distance;
    }
}
