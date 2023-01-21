public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int ovenTime) {
        int remainingTime = expectedMinutesInOven() - ovenTime;
        return remainingTime;
    }

    public int preparationTimeInMinutes(int layer) {
        int minutes = layer * 2;
        return minutes;
    }

    public int totalTimeInMinutes(int layer, int minute) {
        int totalMinuteLayer = layer * 2;
        int totalMinute = totalMinuteLayer + minute;

        return totalMinute;
    }

    public static void main(String[] args) {

        Lasagna lasagna = new Lasagna();

        lasagna.expectedMinutesInOven();
        lasagna.remainingMinutesInOven(30);
        lasagna.preparationTimeInMinutes(2);
        lasagna.totalTimeInMinutes(3, 20);

    }
}
