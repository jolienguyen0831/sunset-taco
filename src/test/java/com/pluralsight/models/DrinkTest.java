package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getPrice_smallDrink() {
        // Arrange
        Drink drink = new Drink("Small", "Cola");

        // Act
        double result = drink.getPrice();

        // Assert
        assertEquals(2.00, result, 0.001);
    }

    @Test
    void getPrice_mediumDrink() {
        // Arrange
        Drink drink = new Drink("Medium", "Cola");

        // Act
        double result = drink.getPrice();

        // Assert
        assertEquals(2.50, result, 0.001);
    }

    @Test
    void getPrice_largeDrink() {
        // Arrange
        Drink drink = new Drink("Large", "Cola");

        // Act
        double result = drink.getPrice();

        // Assert
        assertEquals(3.00, result, 0.001);
    }

    @Test
    void getPrice_flavorDoesNotAffectPrice() {
        // Arrange
        Drink drink1 = new Drink("Small", "Cola");
        Drink drink2 = new Drink("Small", "Lemonade");

        // Act
        double result1 = drink1.getPrice();
        double result2 = drink1.getPrice();

        // Assert
        assertEquals(result1, result2, 0.001);
    }
}