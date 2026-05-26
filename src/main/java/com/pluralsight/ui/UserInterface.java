package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {
    private static Scanner input = new Scanner(System.in);

    public void display(){
        boolean isRunning = true;
        displayMenu();
        while (isRunning){
            System.out.print("""
                        1. New Order
                        0. Exit
                        Please enter your choice: """);
            String choice = readInput();
            switch (choice){
                case "1" -> showOrderScreen();
                default -> System.out.println("Invalid input. Please re-enter");
            }
        }
    }
    public static String readInput() {
        return input.nextLine().trim().toLowerCase();
    }


    private static void displayMenu() {
        System.out.println("""
                ====================================================
                                WELCOME TO SUNSET TACO
                ====================================================
                
                                BUILD YOUR OWN TACOS :)
                
                    Single Taco         3-Taco Plate        Burrito
                        $3.50               $9.00            $8.50
                1. SHELLS
                    Corn
                    Flour
                    Hard shell
                    Bowl
                2. MEAT
                   Carne Asada
                   Al Pastor                            Single: $1.00
                   Carnitas                             3-Taco Plate: $2.00
                   Pollo                                Burrito $3.00
                   Chorizo
                   Pescado
                     Extra Meat: Single +$0.50 | 3-Taco +$1.00 | Burrito +$1.50
                3. CHEESE
                   Queso Fresco                         Single: $0.75
                   Oaxaca                               3-Taco Plate: $1.50
                   Cotijia                              Burrito: $2.25
                   Cheddar
                     Extra Cheese: Single +$0.30 | 3-Taco +$0.60 | Burrito +$0.90
                
                4. TOPPINGS (included)
                    Lettuce  | Cilantro      | Onions    | Tomatoes | Corn
                    Radishes | Pico de Gallo | Guacamole | Jalapeños
               
                5. SAUCES (included)
                    Salsa Verde | Salsa Roja |  Chipotle | Habanero | Mild
                
                6. SIDES (included)
                    Lime Wedges | Crema
                
                7. OPTION
                    Covered in Salsa & Queso: available for REQUEST
                
                                      ~~  DRINKS  ~~
                    Small $2.00         Medium $2.50        Large $3.00
                                   ~~ CHIPS & SALSA  ~~
                    $1.50 - choice of any salsa
                
                Please press ENTER to start your order!
                """);
    }
    public void showOrderScreen(){
        System.out.println("""
                1. Add Taco
                2. Add Drink
                3. Add Chips & Salsa
                4. Checkout
                Please choose: """);
        String choice = readInput();
        switch (choice){
            case "1" -> addTaco();
            case "2" -> addDrink();
            case "3" -> addChipsAndSalsa();
            case "4" -> checkOut();
            default -> System.out.println("Invalid option. Please re-enter!");
        }
    }
    public void addTaco(){}
    public void addDrink(){}
    public void addChipsAndSalsa(){}
    public void checkOut(){}
}
