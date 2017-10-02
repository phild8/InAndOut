package edu.orangecoastcollege.cs273.pdavis11.inandout;

/**
 * Order - OrderActivities Model. Preforms calculations and methods, such as: getters, setters,
 * calculateTax, calculateSubtotal, calculateTotal, getNumberOfItems.
 *
 * @author Phillip Davis
 * @version 1.0
 *
 * Created by pdavis11 on 9/28/2017.
 */
public class Order {

    public static final double PRICE_CHEESEBURGER = 2.15;
    public static final double PRICE_DOUBLE_DOUBLE = 3.60;
    public static final double PRICE_FRENCH_FRIES = 1.65;
    public static final double PRICE_LARGE_DRINK = 1.75;
    public static final double PRICE_MEDIUM_DRINK = 1.55;
    public static final double PRICE_SHAKE = 2.20;
    public static final double PRICE_SMALL_DRINK = 1.45;
    public static final double TAX_RATE = 0.08;

    private int mCheeseBurgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;

    /**
     * Creates an Order object and intializes mCheeseBurgers, mDoubleDoubles, mFrenchFies,
     * mLargeDrinks, mMediumDrinks, mShakes, and mSmallDrinks all to 0.
     */
    public Order() {
        mCheeseBurgers = 0;
        mDoubleDoubles = 0;
        mFrenchFries = 0;
        mLargeDrinks = 0;
        mMediumDrinks = 0;
        mShakes = 0;
        mSmallDrinks = 0;
    }

    /**
     * Calculates the Orders subtotal by multiplying the price by the items and adding them together.
     * @return the subtotal of the order.
     */
    public double calculateSubtotal()
    {
        return ((mCheeseBurgers * PRICE_CHEESEBURGER)
                + (mDoubleDoubles * PRICE_DOUBLE_DOUBLE)
                + (mFrenchFries * PRICE_FRENCH_FRIES)
                + (mLargeDrinks * PRICE_LARGE_DRINK)
                + (mMediumDrinks * PRICE_MEDIUM_DRINK)
                + (mShakes * PRICE_SHAKE)
                + (mSmallDrinks * PRICE_SMALL_DRINK));
    }

    /**
     * Calculates the tax amount of the order.
     * @return the amount taxed on the order
     */
    public double calculateTax()
    {
        return TAX_RATE * calculateSubtotal();
    }

    /**
     * Calculates the total by adding the subtotal to the taxed amount.
     * @return the total amount of the order
     */
    public double calculateTotal()
    {
        return calculateSubtotal() + calculateTax();
    }

    /**
     * Calculates the number of items ordered by adding them all together.
     * @return the number of items ordered
     */
    public int getNumberItemsOrdered()
    {
        return  (mCheeseBurgers
                + mDoubleDoubles
                + mFrenchFries
                + mLargeDrinks
                + mMediumDrinks
                + mShakes
                + mSmallDrinks);
    }

    // GETTERS
    /**
     * Gets the number of cheeseburgers.
     * @return an int value of cheeseburgers.
     */
    public int getCheeseBurgers() {return mCheeseBurgers;}
    /**
     * Gets the number of Double Doubles.
     * @return an int value of Double Double.
     */
    public int getDoubleDoubles() {return mDoubleDoubles;}
    public int getFrenchFries() {return mFrenchFries;}
    /**
     * Gets the number of Large Drinks.
     * @return an int value of Large Drinks.
     */
    public int getLargeDrinks() {return mLargeDrinks;}
    /**
     * Gets the number of Medium Drinks.
     * @return an int value of Medium Drinks.
     */
    public int getMediumDrinks() {return mMediumDrinks;}
    /**
     * Gets the number of Medium Drinks.
     * @return an int value of Medium Drinks.
     */
    public int getShakes() {return mShakes;}
    /**
     * Gets the number of Small Drinks.
     * @return an int value of Small Drinks.
     */
    public int getSmallDrinks() {return mSmallDrinks;}

    //SETTERS
    /**
     * Sets a new amount of mCheeseBurgers
     * @param cheeseBurgers the new int value of mCheeseBurgers
     */
    public void setCheeseBurgers(int cheeseBurgers) {mCheeseBurgers = cheeseBurgers;}
    /**
     * Sets a new amount of mDoubleDoubles
     * @param doubleDoubles the new int value of mDoubleDoubles
     */
    public void setDoubleDoubles(int doubleDoubles) {mDoubleDoubles = doubleDoubles;}
    /**
     * Sets a new amount of mFrenchFries
     * @param frenchFries the new int value of mFrenchFries
     */
    public void setFrenchFries(int frenchFries) {mFrenchFries = frenchFries;}
    /**
     * Sets a new amount of mLargeDrinks
     * @param largeDrinks the new int value of mLargeDrinks
     */
    public void setLargeDrinks(int largeDrinks) {mLargeDrinks = largeDrinks;}
    /**
     * Sets a new amount of mMediumDrinks
     * @param mediumDrinks the new int value of mMediumDrinks
     */
    public void setMediumDrinks(int mediumDrinks) {mMediumDrinks = mediumDrinks;}
    /**
     * Sets a new amount of mShakes
     * @param shakes the new int value of mShakes
     */
    public void setShakes(int shakes) {mShakes = shakes;}
    /**
     * Sets a new amount of mSmallDrinks
     * @param smallDrinks the new int value of mSmallDrinks
     */
    public void setSmallDrinks(int smallDrinks) {mSmallDrinks = smallDrinks;}
}
