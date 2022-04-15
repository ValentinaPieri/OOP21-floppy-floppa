package main.menu;

import main.menu.shop.Shop;

public class EOGMenu implements Menu {

	private int previousCoins;
	private Shop shop;

	/**
	 * @param metersTravelled The meters that the Character traveled during the game
	 * @param reducerTimes    How many times the character hit the CoinsReducer
	 *                        malus
	 * @param incrementTimes  How many times the character hit the CoinsIncrement
	 *                        booster
	 */
	public EOGMenu(int metersTravelled, int reducerTimes, int incrementTimes) {
		shop = new Shop();
		this.previousCoins = Shop.getCoins();
		this.updateCoins(metersTravelled, reducerTimes, incrementTimes);
	}

	/**
	 * @return the coins owned before the last game
	 */
	public int getPreviousCoins() {
		return previousCoins;
	}

	/**
	 * The method updates the owned coins considering the meters traveled during the
	 * last game, the CoinsReducer malus and the CoinsIncrement booster
	 * 
	 * @param meters         The meters that the Character traveled during the game
	 * @param reducerTimes   How many times the character hit the CoinsReducer malus
	 * @param incrementTimes How many times the character hit the CoinsIncrement
	 *                       booster
	 * @return the newly owned coins
	 */
	protected int updateCoins(int meters, int reducerTimes, int incrementTimes) {
		int newCoins = this.previousCoins + ((int) Math.floor(meters / 5) - this.updateCoinsReduce(reducerTimes)
				+ this.updateCoinsIncrease(incrementTimes));
		Shop.setCoins(newCoins);
		this.previousCoins = newCoins;
		return newCoins;
	}

	/**
	 * Calculates how many coins need to be subtracted
	 * 
	 * @param times How many times the character hit the CoinsReducer malus
	 * @return the sum of coins that need to be subtracted
	 */
	private int updateCoinsReduce(int times) {
		int sum;
		for (int i = 0; i < times; i++) {
			sum += CoinsReducer.changeState();
		}
		return sum;
	}

	/**
	 * Calculates how many coins need to be subtracted
	 * 
	 * @param times How many times the character hit the CoinsReducer malus
	 * @return the sum of coins that need to be subtracted
	 */
	private int updateCoinsIncrease(int times) {
		int sum;
		for (int i = 0; i < times; i++) {
			sum += CoinsIncrement.changeState();
		}
		return sum;
	}
}
