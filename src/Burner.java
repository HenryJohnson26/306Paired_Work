
public class Burner {
public enum Temperature{COLD, WARM, HOT, BLAZING};
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
	case OFF:
		mySetting = Setting.LOW;
		break;
	case LOW:
		mySetting = Setting.MEDIUM;
		break;
	case MEDIUM: 
		mySetting = Setting.HIGH;
		break;
	case HIGH:
		mySetting = Setting.HIGH;
		break;
	}
}

public void minusButton() {
	timer = TIME_DURATION;
	switch(mySetting) {
	case OFF: 
		mySetting = Setting.OFF;
		break;
	case LOW: 
		mySetting = Setting.OFF;
		break;
	case MEDIUM: 
		mySetting = Setting.LOW;
		break;
	case HIGH: 
		mySetting = Setting.MEDIUM;
		break;
	}
}

public void updateTemperature() {
	if(timer>1) {
		timer --;
	}
	else {
		switch(myTemperature) {
		case COLD: switch(mySetting) {
			case LOW: 
				heatUp();
				break;
			case MEDIUM: 
				heatUp();
				break;
			case HIGH: 
				heatUp();
				break;
		}
		break;
		case WARM: switch(mySetting) {
			case OFF: 
				coolDown();
				break;
			case MEDIUM: 
				heatUp();
				break;
			case HIGH: 
				heatUp();
				break;
			
			}
		break;
		case HOT: switch(mySetting) {
			case OFF: 
				coolDown();
				break;
			case LOW: 
				coolDown();
				break;
			case HIGH:
				heatUp();
				break;
			}
		break;
		case BLAZING: switch(mySetting) {
			case OFF: 
				coolDown();
				break;
			case LOW: 
				coolDown();
				break;
			case MEDIUM: 
				coolDown();
				break;
			}
		break;
		}
	}
}
private void heatUp() {
	switch(myTemperature) {
	case COLD:
		myTemperature = Temperature.WARM;
		break;
	case WARM: 
		myTemperature = Temperature.HOT;
		break;
	case HOT:
		myTemperature  = Temperature.BLAZING;
		break;
	}
}

private void coolDown() {
	switch(myTemperature) {
	case WARM: 
		myTemperature = Temperature.COLD;
		break;
	case HOT: 
		myTemperature = Temperature.WARM;
		break;
	case BLAZING:
		myTemperature = Temperature.HOT;
		break;
	}
}

public void printStatus() {
	switch(mySetting) {
		case OFF:
			System.out.print("[---]");
			break;
		case LOW: 
			System.out.print("[--+]");
			break;
		case MEDIUM: 
			System.out.print("[-++]");
			break;
		case HIGH: 
			System.out.print("[+++]");
			break;
	}
	switch(myTemperature) {
		case COLD:
			System.out.println("cool");
			break;
		case WARM: 
			System.out.println("Warm");
			break;
		case HOT: 
			System.out.println("Hot");
			break;
		case BLAZING:
			System.out.println("BLAZING");
			break;
	}
}


}
