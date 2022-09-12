
public class Burner {
private enum Temperature{BLAZING, HOT, WARM, COLD};
private Temperature myTemperature = Temperature.COLD;
private enum Setting{OFF, LOW, MEDIUM, HIGH};
private Setting mySetting = Setting.OFF;
private int timer;
public static final int TIME_DURATION = 2;

public Temperature getTemperature() {
	return myTemperature;
}


}
