package Excercism.RemoteControlCompetition;

class ProductionRemoteControlCar implements RemoteControlCar{
    private final static int SPEED = 20;
    private int distance = 0;

    public void drive() {
        distance+=SPEED;
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.getNumberOfVictories() method");
    }

    public void setNumberOfVictories(int numberOfVictories) {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.setNumberOfVictories() method");
    }
}
