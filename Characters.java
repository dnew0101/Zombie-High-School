import java.util.Random;

public class Characters {
	private int power;
	private int speed;
	private int smarts;
	private String name;
	private int diceRoll;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSmarts() {
		return smarts;
	}
	public void setSmarts(int smarts) {
		this.smarts = smarts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiceRoll() {
		return diceRoll;
	}
	public void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}
	public Characters(String name, int power, int speed, int smarts) {
		
		//simple implicit params.
		this.name = name;
		this.power = power;
		this.speed = speed;
		this.smarts = smarts;
	}
	public int diceRoll(int diceRoll) {
		Random rand = new Random();
		int diceRollVal = rand.nextInt(diceRoll)+1;//***NEW***The +1 should be outside the parenthesis 
		this.diceRoll = diceRollVal;
		return diceRollVal;
		
	}
	public String toString() {
		String stats = new String ();
		stats = "Power: " + this.power + "\nSpeed: " + speed + "\nSmarts: " + smarts;
		return stats;
	}
}
