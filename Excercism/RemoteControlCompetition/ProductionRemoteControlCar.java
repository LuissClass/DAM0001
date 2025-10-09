package Excercism.RemoteControlCompetition;

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{
    private final static int SPEED = 10;
    private int distance = 0;
    private int numberOfVictories = 0;

    public void drive() {
        distance+=SPEED;
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return numberOfVictories - o.numberOfVictories;
    }
}
