package com.pluralsight.models;

import static org.junit.jupiter.api.Assertions.*;

class TacoTest {


    @org.junit.jupiter.api.Test
    void addRegularToppings() {
        //Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        String topping1 = "Lettuce";
        String topping2 = "Tomatoes";

        //Act
        taco.addRegularToppings(topping1);
        taco.addRegularToppings(topping2);

        //Assert
        assertEquals(2, taco.getRegularToppings().size());
        assertTrue(taco.getRegularToppings().contains(topping1));
        assertFalse(taco.getRegularToppings().contains("Onions"));

    }

    @org.junit.jupiter.api.Test
    void removeRegularTopping() {
        //Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        //Act
        taco.addRegularToppings("Lettuce");
        taco.addRegularToppings("Tomatoes");
        taco.removeRegularTopping("Lettuce");

        //Assert
        assertEquals(1, taco.getRegularToppings().size());
        assertFalse(taco.getRegularToppings().contains("Lettuce"));
    }

    @org.junit.jupiter.api.Test
    void removeRegularTopping_nonExistentDoesNotThrow() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        // Act & Assert
        assertDoesNotThrow(() -> taco.removeRegularTopping("Pepper"));
    }

    @org.junit.jupiter.api.Test
    void addSauce() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        // Act
        taco.addSauce("Chipotle");
        taco.addSauce("Mild");

        // Assert
        assertEquals(2, taco.getSauces().size());
        assertTrue(taco.getSauces().contains("Mild"));
    }

    @org.junit.jupiter.api.Test
    void removeSauce() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.addSauce("Chipotle");
        taco.addSauce("Mild");
        // Act
        taco.removeSauce("Chipotle");

        // Assert
        assertEquals(1, taco.getSauces().size());
        assertTrue(taco.getSauces().contains("Mild"));
        assertFalse(taco.getSauces().contains("Chipotle"));

    }

    @org.junit.jupiter.api.Test
    void addSide() {// Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        // Act & Assert
        assertDoesNotThrow(() -> taco.addSide("Rice"));
        assertDoesNotThrow(() -> taco.addSide("Beans"));
    }


    @org.junit.jupiter.api.Test
    void setMeat() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        // Act
        taco.setMeat("Pollo");

        // Assert
        assertEquals("Pollo", taco.meat);
    }


    @org.junit.jupiter.api.Test
    void isExtraMeat() { // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setExtraMeat(true);

        // Act
        boolean result = taco.extraMeat;

        // Assert
        assertTrue(result);

    }


    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_base() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(3.50, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_base() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Corn");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(9.00, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_burrito_baseO() {
        // Arrange
        Taco taco = new Taco("Burrito", "Bowl");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(8.50, result, 0.001);
    }


    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_withMeat() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setMeat("Pollo");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(4.50, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_withMeat() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Corn");
        taco.setMeat("Chorizo");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(11.00, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_burrito_withMeat() {
        // Arrange
        Taco taco = new Taco("Burrito", "Flour");
        taco.setMeat("Pescado");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(11.50, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_withMeatAndExtraMeat() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setMeat("Pollo");
        taco.setExtraMeat(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(5.00, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_withMeatAndExtraMeat() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Corn");
        taco.setMeat("Chorizo");
        taco.setExtraMeat(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(12.00, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_burrito_withMeatAndExtraMeat() {
        // Arrange
        Taco taco = new Taco("Burrito", "Flour");
        taco.setMeat("Pescado");
        taco.setExtraMeat(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(13.00, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_withCheese() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setCheese("Cheddar");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(4.25, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_withCheese() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Flour");
        taco.setCheese("Cheddar");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(10.50, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_burrito_withCheese() {
        // Arrange
        Taco taco = new Taco("Burrito", "Flour");
        taco.setCheese("Cheddar");

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(10.75, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_withCheeseAndExtraCheese() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(4.55, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_withCheeseAndExtraCheese() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Flour");
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(11.10, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_burrito_withCheeseAndExtraCheese() {
        // Arrange
        Taco taco = new Taco("Burrito", "Flour");
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(11.65, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_singleTaco_fullyLoaded() {
        // Arrange
        Taco taco = new Taco("Single Taco", "Flour");
        taco.setMeat("Pollo");
        taco.setExtraMeat(true);
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(6.05, result, 0.001);
    }
    @org.junit.jupiter.api.Test
    void getPrice_threeTacoPlate_fullyLoaded() {
        // Arrange
        Taco taco = new Taco("3-Taco Plate", "Corn");
        taco.setMeat("Pollo");
        taco.setExtraMeat(true);
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(14.10, result, 0.001);
    }

    @org.junit.jupiter.api.Test
    void getPrice_burrito_fullyLoaded() {
        // Arrange
        Taco taco = new Taco("Burrito", "Flour");
        taco.setMeat("Pollo");
        taco.setExtraMeat(true);
        taco.setCheese("Cheddar");
        taco.setExtraCheese(true);

        // Act
        double result = taco.getPrice();

        // Assert
        assertEquals(16.15, result, 0.001);
    }












}


