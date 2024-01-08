
public class BattleShip {
	private boolean isSunk;
	private int shipSize;
	private int remainingHealth;

	public static int permisible = 0;

	public BattleShip(int size) {
		this.shipSize = size;
		remainingHealth = shipSize;
	}

//	Getter setter methods
	public boolean getIsSunk() {
		return isSunk;
	}

	public void setSunk(boolean isSunk) {
		this.isSunk = isSunk;
	}

	public int getShipSize() {
		return shipSize;
	}

	public void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}

	public int getRemainingHealth() {
		return remainingHealth;
	}

	public void setRemainingHealth(int i) {
		remainingHealth -= i;
	}

}
