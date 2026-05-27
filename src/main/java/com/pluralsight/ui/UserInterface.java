package com.pluralsight.ui;

import com.pluralsight.models.ChipsAndSalsa;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Taco;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner input = new Scanner(System.in);
    private Order newOrder;

    public void display() {
        boolean isRunning = true;
        displayMenu();
        while (isRunning) {
            System.out.print("""
                    \n
                    1. New Order
                    0. Exit
                    Please enter your choice:  """);
            String choice = readInput();
            switch (choice) {
                case "1" -> {
                    newOrder = new Order();
                    showOrderScreen();
                }
                case "0" -> {
                    System.out.println("\nThank you for coming Sunset Taco." +
                            "\nHave a nice day!");
                    isRunning = false;
                }
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
        input.nextLine();
    }

    public void showOrderScreen() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("""
                    \n
                                ORDER SCREEN
                    ====================================
                    1. Add Taco
                    2. Add Drink
                    3. Add Chips & Salsa
                    4. Checkout
                    Please choose: """);
            String choice = readInput();
            switch (choice) {
                case "1" -> addTaco();
                case "2" -> addDrink();
                case "3" -> addChipsAndSalsa();
                case "4" -> {
                    checkOut();
                    ordering = false;
                }
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }
    }

    public void addTaco() {
        boolean inTacoScreen = true;
        while (inTacoScreen) {
            inTacoScreen = false;
            System.out.println("""
                    \n
                            TACO SCREEN
                    ========================
                    """);
            String size = getTacoSize();
            if (size.equals("return")){
                return;
            }
            String shell = getTacoShell();
            if (shell.equals("restart")) {
                inTacoScreen = true;
                System.out.println("\nStarting over...");
                continue;
            }
            Taco taco = new Taco(size, shell);
            boolean restart = getTacoMeat(taco);
            if (restart) {
                inTacoScreen = true;
                System.out.println("\nStarting over...");
                continue;
            }
            restart = getTacoCheese(taco);
            if (restart) {
                inTacoScreen = true;
                System.out.println("\nStarting over...");
                continue;

            }
            getTacoToppings(taco);
            getTacoSauces(taco);
            getTacoSides(taco);
            getTacoCover(taco);
            newOrder.addItem(taco);
            System.out.println("\nTaco added successfully!");
        }
    }

    private boolean getTacoMeat(Taco taco) {
        String[] meats = {"", "Carne Asada", "Al Pastor", "Carnitas", "Pollo", "Chorizo", "Pescado"};
        int meatIndex = -1;
        while (meatIndex < 0) {
            System.out.print("""
                         \n
                             Meat
                    ========================
                    0. No meat
                    1. Carne Asada
                    2. Al Pastor
                    3. Carnitas
                    4. Pollo
                    5. Chorizo
                    6. Pescado
                    7. Restart taco screen
                    Enter your choice: """);
            try {
                int meatChoice = Integer.parseInt(readInput());
                if (meatChoice == 7) {
                    return true;
                } else if (meatChoice >= 0 && meatChoice <= 6) {
                    meatIndex = meatChoice;
                } else {
                    System.out.println("Invalid option. Please re-enter!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter a number.");

            }
            if (meatIndex == 0) {
                taco.setMeat("No meat");
                return false;
            }
            taco.setMeat(meats[meatIndex]);

            if (meatIndex != 0) {
                String extraMeatChoice = "";
                while (extraMeatChoice.isEmpty()) {
                    System.out.print("""
                                 \n
                                 Extra Meat?
                            ========================
                            Y. Yes
                            N. No
                            Enter your choice: """);
                    switch (readInput()) {
                        case "y" -> extraMeatChoice = "yes";
                        case "n" -> extraMeatChoice = "no";
                        default -> System.out.println("Invalid option. Please re-enter!");
                    }
                }
                if (extraMeatChoice.equals("yes")) {
                    taco.setExtraMeat(true);
                    int extraMeatIndex = -1;
                    while (extraMeatIndex < 0) {
                        System.out.print("""
                                     \n
                                         Meat
                                ========================
                                1. Carne Asada
                                2. Al Pastor
                                3. Carnitas
                                4. Pollo
                                5. Chorizo
                                6. Pescado
                                Enter your choice: """);
                        int extraMeatType = Integer.parseInt(readInput());
                        if (extraMeatType > 0 && extraMeatType <= 6) {
                            extraMeatIndex = extraMeatType;
                        } else if (extraMeatType == 7) {
                            break;
                        } else {
                            System.out.println("Invalid option. Please re-enter!");
                            break;
                        }
                        taco.setExtraMeatType(meats[extraMeatIndex]);
                    }
                }
            }
        }
        return false;
    }

    private static String getTacoShell() {
        String shell = "";
        while (shell.isEmpty()) {
            System.out.print("""
                         \n
                             Shell
                    ========================
                    1. Corn
                    2. Flour
                    3. Hard Shell
                    4. Bowl
                    R. Restart taco screen
                    Enter your choice: """);
            String shellChoice = readInput();
            switch (shellChoice) {
                case "1" -> shell = "Corn";
                case "2" -> shell = "Flour";
                case "3" -> shell = "Hard Shell";
                case "4" -> shell = "Bowl";
                case "r" -> shell = "restart";
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }
        return shell;
    }

    private static String getTacoSize() {
        String size = "";
        while (size.isEmpty()) {
            System.out.print("""
                         \n
                               Size
                    ========================
                    1. Single Taco     $3.50
                    2. 3-Taco Plate    $9.00
                    3. Burrito         $8.50
                    R. Return to Home Screen
                    Enter your choice: """);
            String sizeChoice = readInput();
            switch (sizeChoice) {
                case "1" -> size = "Single Taco";
                case "2" -> size = "3- Taco Plate";
                case "3" -> size = "Burrito";
                case "r" -> size = "return";
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }
        return size;
    }

    private boolean getTacoCheese(Taco taco) {
        String[] cheeses = {"", "Queso Fresco", "Oaxaca", "Cotija", "Cheddar"};
        int cheeseIndex = -1;
        while (cheeseIndex < 0) {
            System.out.print("""
                    \n
                           Cheese
                    ========================
                    0. No cheese
                    1. Queso Fresco
                    2. Oaxaca
                    3. Cotija
                    4. Cheddar
                    5. Restart taco screen
                    Enter your choice: """);
            try {
                int choice = Integer.parseInt(readInput());
                if (choice == 5) {
                    return true;
                } else if (choice >= 0 && choice <= 4) {
                    cheeseIndex = choice;
                } else System.out.println("  Invalid option. Please enter 0 through 5.");
            } catch (Exception e) {
                System.out.println("  Invalid option. Please enter a number.");
            }
        }

        if (cheeseIndex == 0) {
            taco.setCheese("No cheese");
            return false;
        }
        taco.setCheese(cheeses[cheeseIndex]);
        if (cheeseIndex != 0) {
            String extraCheeseChoice = "";
            while (extraCheeseChoice.isEmpty()) {
                System.out.print("""
                             \n
                             Extra Cheese?
                        ========================
                        Y. Yes
                        N. No
                        Enter your choice: """);
                switch (readInput()) {
                    case "y" -> extraCheeseChoice = "yes";
                    case "n" -> extraCheeseChoice = "no";
                    default -> System.out.println("Invalid option. Please re-enter!");
                }
            }
            if (extraCheeseChoice.equals("yes")) {
                taco.setExtraCheese(true);
                int extraCheeseIndex = -1;
                while (extraCheeseIndex < 0) {
                    System.out.print("""
                            \n
                                  Extra Cheese
                            ========================
                            1. Queso Fresco
                            2. Oaxaca
                            3. Cotija
                            4. Cheddar
                            5. Restart taco screen
                            Enter your choice: """);
                    int extraCheeseType = Integer.parseInt(readInput());
                    if (extraCheeseType > 0 && extraCheeseType <= 6) {
                        extraCheeseIndex = extraCheeseType;
                    } else if (extraCheeseType == 7) {
                        break;
                    } else {
                        System.out.println("Invalid option. Please re-enter!");
                        break;
                    }
                    taco.setExtraCheeseType(cheeses[extraCheeseIndex]);
                }
            }
        }
        return false;
    }

    private void getTacoToppings(Taco taco) {
        String[] toppings = {"", "Lettuce", "Cilantro", "Onions", "Tomatoes",
                "Jalapeños", "Radishes", "Pico de Gallo", "Guacamole", "Corn"};
        boolean validInput = false;
        while (!validInput) {
            System.out.print("""
                    \n
                       Toppings (included)
                    =========================
                    1. Lettuce        2. Cilantro
                    3. Onions         4. Tomatoes
                    5. Jalapeños      6. Radishes
                    7. Pico de Gallo  8. Guacamole
                    9. Corn
                    Enter numbers separated by commas, or Enter to skip: """);
            String toppingChoices = readInput();

            if (toppingChoices.isEmpty()) {
                return;
            }
            try {
                for (String toppingChoice : toppingChoices.split(",")) {
                    int choice = Integer.parseInt(toppingChoice.trim());
                    if (choice >= 1 && choice <= 9) {
                        taco.addRegularToppings(toppings[choice]);
                    }
                }
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter correct format.");
            }
        }
    }
    private void getTacoSauces(Taco taco){
        String[] sauces = {"", "Salsa Verde", "Salsa Roja", "Chipotle", "Habanero", "Mild"};
        boolean validInput = false;
        while (!validInput) {
            System.out.print("""
                    \n
                        Sauces (included)
                    ========================
                    1. Salsa Verde    2. Salsa Roja
                    3. Chipotle       4. Habanero
                    5. Mild
                    Enter numbers separated by commas, or Enter to skip: """);
            String sauceChoices = readInput();
            if (sauceChoices.isEmpty()){
                return;
            }
            try {
                for (String sauceChoice : sauceChoices.split(",")) {
                    int choice = Integer.parseInt(sauceChoice.trim());
                    if (choice >= 1 && choice <= 5) {
                        taco.addSauce(sauces[choice]);
                    }
                }
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter correct format.");
            }
        }
    }
    private void getTacoSides(Taco taco){
        String sideChoice = "";
        while (sideChoice.isEmpty()) {
            System.out.print("""
                    \n
                        Sides (included)
                    ========================
                    1. Lime Wedges
                    2. Crema
                    3. Both
                    Enter your choice, or Enter to skip: """);
            switch (readInput()) {
                case "" -> {
                    return;
                }
                case "1" -> {
                    sideChoice = "1";
                    taco.addSide("Lime Wedges");
                }
                case "2" -> {
                    sideChoice = "2";
                    taco.addSide("Crema");
                }
                case "3" -> {
                    sideChoice = "3";
                    taco.addSide("Lime Wedges");
                    taco.addSide("Crema");
                }
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }

    }
    private void getTacoCover(Taco taco){
        System.out.println("\nCover in salsa & queso?(y/n)");
        switch (readInput()){
            case "y" -> taco.setCoveredInSalsaAndQueso(true);
            case "n" -> taco.setCoveredInSalsaAndQueso(false);
            default  -> System.out.println("  Invalid option. Please enter y or n.");
        }

    }


    public void addDrink() {
        boolean inDrinkScreen = true;
        while (inDrinkScreen) {
            String size = "";
            System.out.print("""
                    \n
                         DRINK SCREEN
                    ========================
                    1. Small        $2.00
                    2. Medium       $2.50
                    3. Large        $3.00
                    R. Return to order screen
                    Enter your choice, or Enter to skip: """);
            String drinkChoice = readInput();
            switch (drinkChoice) {
                case "1" -> size = "Small";
                case "2" -> size = "Medium";
                case "3" -> size = "Large";
                case "r" -> inDrinkScreen = false;
                case "" -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please re-enter!");
            }
            if (!size.isEmpty()) {
                String flavor = "";
                while (flavor.isEmpty()) {
                    System.out.print("""
                            1. Coke
                            2. Horchata
                            3. Jamaica
                            Enter your choice: """);
                    flavor = readInput();
                    switch (flavor) {
                        case "1" -> flavor = "Coke";
                        case "2" -> flavor = "Horchata";
                        case "3" -> flavor = "Jamaica";
                        default -> {
                            System.out.println("Invalid option. Please re-enter!");
                        }
                    }
                    Drink drink = new Drink(size, flavor);
                    newOrder.addItem(drink);
                    System.out.println("\nDrink added successfully!");
                    return;
                }
            }
        }
    }

    public void addChipsAndSalsa() {
        boolean inChipsAndSalsaScreen = true;
        while (inChipsAndSalsaScreen) {
            System.out.print("""
                    \n
                      CHIPS & SALSA SCREEN
                    =========================
                    Add-on Chips & Salsa $1.50
                    Y. Yes
                    N. No
                    R. Return to order screen
                    Enter your choice, or Enter to skip: """);
            String chipsAndSalsaChoice = readInput();
            switch (chipsAndSalsaChoice) {
                case "y" -> {
                    String chipsChoice = "";
                    while (chipsChoice.isEmpty()) {
                        System.out.println("""
                                \n
                                Select your chips
                                1. Hot Cheetos
                                2. Sabrita
                                3. Chicharrones
                                4. Lays
                                Enter your choice: """);
                        String chips = readInput();
                        switch (chips) {
                            case "1" -> chips = "Hot Cheetos";
                            case "2" -> chips = "Sabrita";
                            case "3" -> chips = "Chicharrones";
                            case "4" -> chips = "Lays";
                            default -> {
                                System.out.println("Invalid option. Please re-enter!");
                                continue;
                            }
                        }
                        ChipsAndSalsa chipsAndSalsa = new ChipsAndSalsa(chips);
                        newOrder.addItem(chipsAndSalsa);

                        return;
                    }
                }
                case "n", "", "r" -> {
                    inChipsAndSalsaScreen = false;
                }
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }
    }
    public void checkOut() {
    }
}
