
public class Burner {
private enum Temperature{COLD, WARM, HOT, BLAZING};
private Temperature myTemperature;
private enum Setting{OFF, LOW, MEDIUM, HIGH};
private Setting mySetting;
private int timer = 0;
public static final int TIME_DURATION = 2;

public Burner() {
	myTemperature = Temperature.COLD;
	mySetting = Setting.OFF;
}

public Temperature getTemperature() {
	return myTemperature;
}

public void plusButton() {
	timer = TIME_DURATION;
	switch(mySetting){
	case OFF: mySetting = Setting.LOW;
	case LOW: mySetting = Setting.MEDIUM;
	case MEDIUM: mySetting = Setting.HIGH;
	case HIGH: mySetting = Setting.HIGH;	
	}
}

public void minusButton() {
	timer = TIME_DURATION;
	switch(mySetting) {
	case OFF: mySetting = Setting.OFF;
	case LOW: mySetting = Setting.OFF;
	case MEDIUM: mySetting = Setting.LOW;
	case HIGH: mySetting = Setting.MEDIUM;
	}
}

public void updateTemperature() {
	if(timer>0) {
		timer --;
	}
	else {
		switch(myTemperature) {
		case COLD: switch(mySetting) {
			case LOW: heatUp();
			case MEDIUM: heatUp();
			case HIGH: heatUp();
			}
		case WARM: switch(mySetting) {
			case OFF: coolDown();
			case MEDIUM: heatUp();
			case HIGH: heatUp();
			}
		case HOT: switch(mySetting) {
			case OFF: coolDown();
			case LOW: coolDown();
			case HIGH: heatUp();
			}
		case BLAZING: switch(mySetting) {
			case OFF: coolDown();
			case LOW: coolDown();
			case MEDIUM: coolDown();
			}
		}
	}
}
private void heatUp() {
	switch(myTemperature) {
	case COLD: myTemperature = Temperature.WARM;
	case WARM: myTemperature = Temperature.HOT;
	case HOT: myTemperature  = Temperature.BLAZING;
	}
}

private void coolDown() {
	switch(myTemperature) {
	case WARM: myTemperature = Temperature.COLD;
	case HOT: myTemperature = Temperature.WARM;
	case BLAZING: myTemperature = Temperature.HOT;
	}
}

public void printStatus() {
	//print setting 
	switch(mySetting) {
	case OFF: System.out.print("(---)");
	case LOW: System.out.print("(--+)");
	}
	//pring temperature
	switch(myTemperature) {
	case COLD: System.out.println(" Cool");
	case WARM: System.out.println(" Warm");
	}
}

}
