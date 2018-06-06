package petshelter;

public class OCat extends Organic {

	boolean litterBoxFull = false;

	public void setLitterBoxFull(boolean isFull) {
		litterBoxFull = isFull;
	}

	public OCat(String petName, String type) {
		super(petName, type);
	}

	public void litterBoxClean(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		changeWaste(wasteBefore);
		changeHealth(healthAmount);
		litterBoxFull = false;
	}

	public void napCat(int happinessAmount) {
		changeHappiness(happinessAmount);
	}

	public void organicCatTick() {
		changeHunger(getHungerTick());
		changeThirst(getThirstTick());
		changeHappiness(getHappinessTick());
		if (getHunger() > 70 || getThirst() > 70 || litterBoxFull || getHappiness() < 40) {
			changeHealth(getHealthDownTick());
		} else if (getHunger() < 40 && getThirst() < 40 && !litterBoxFull && getHappiness() > 60) {
			changeHealth(getHealthUpTick());
		}
	}

	@Override
	public String toString() {
		if (getIsAlive()) {
			return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |"
					+ getHunger() + "\t\t |" + getThirst() + "\t\t |";
		} else {
			return getPetName() + "\t\t |" + getType() + "\t |Died \t\t | \t\t | \t\t | \t\t |";
		}
	}
}
