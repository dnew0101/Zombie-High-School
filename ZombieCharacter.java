public class ZombieCharacter {
	static int difficulty;
	private int smarts;
	private int power;
	private int speed;
	private int diceRoll;
	private String name;
	private boolean isBoss;
	
	
	public int getSmarts() {
		return smarts;
	}
	public void setSmarts(int smarts) {
		this.smarts = smarts;
	}
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
	public boolean getIsBoss() {
		return isBoss;
	}
	public void setIsBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public ZombieCharacter(int power, int difficulty, int speed, int smarts, String name, boolean isBoss) {
		//Nothing too complex. Basically just padding and adjusting stats in conjunction with difficulty
		if(difficulty == 1) {
			this.power = power;
			this.speed = speed;
			this.smarts = smarts;
			if(this.isBoss == true) {
				this.power = power + 5; //Hard coding in the stats for the boss
			}
		}
		if(difficulty == 2) {
			this.power = power + difficulty;
			this.speed = speed + difficulty;
			this.smarts = smarts + difficulty;
			if(this.isBoss == true) {
				this.power = power + 5; //Hard coding in the stats for the boss
			}
		}
		if(difficulty == 3) {
			this.power = power + difficulty;
			this.speed = speed + difficulty;
			this.smarts = smarts + difficulty;
			if(this.isBoss == true) {
				this.power = power + 5; //Hard coding in the stats for the boss
			}
		}
	}
}
