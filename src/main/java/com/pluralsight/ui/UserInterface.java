package com.pluralsight.ui;

import com.pluralsight.models.Taco;

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
                        Please enter your choice:  """);
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
        input.nextLine();
    }
    public void showOrderScreen(){
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
        switch (choice){
            case "1" -> addTaco();
            case "2" -> addDrink();
            case "3" -> addChipsAndSalsa();
            case "4" -> checkOut();
            default -> System.out.println("Invalid option. Please re-enter!");
        }
    }
    public void addTaco(){
        boolean inTacoScreen = true;
        while (inTacoScreen) {
            inTacoScreen = false;
            System.out.println("""
                        \n
                                TACO SCREEN
                        ========================
                        """);
            String size = getTacoSize();
            String shell = "";
            while(shell.isEmpty()){
                System.out.print("""
                             \n
                                 Shell
                        ========================
                        1. Corn
                        2. Flour
                        3. Hard Shell
                        4. Bowl
                        5. Restart taco screen
                        Enter your choice: """);
                String shellChoice = readInput();
                switch (shellChoice) {
                    case "1" -> shell = "Corn";
                    case "2" -> shell = "Flour";
                    case "3" -> shell = "Hard Shell";
                    case "4" -> shell = "Bowl";
                    case "5" -> {
                        inTacoScreen = true;
                        shell = "restart";
                    }
                    default -> System.out.println("Invalid option. Please re-enter!");
                }
            }
            Taco taco = new Taco(size,shell);
            String[] meats ={ "", "Carne Asada", "Al Pastor", "Carnitas", "Pollo", "Chorizo", "Pescado"};
            int meatIndex = -1;
            while(meatIndex < 0) {
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
                int meatChoice = Integer.parseInt(readInput());
                if (meatChoice >= 0 && meatChoice <= 6) {
                    meatIndex = meatChoice;
                } else if (meatChoice == 7) {
                    inTacoScreen = true;
                    break;
                }else {
                    System.out.println("Invalid option. Please re-enter!");
                }
                if (meatIndex >=1){
                    taco.setMeat(meats[meatIndex]);
                }

            }
            if(inTacoScreen){
                System.out.println("\nStarting over...");
                continue;
            }

        }
    }

    private static String getTacoSize() {
        String size = "";
        while(size.isEmpty()) {
            System.out.print("""
                         \n
                               Size
                    ========================
                    1. Single Taco     $3.50
                    2. 3-Taco Plate    $9.00
                    3. Burrito         $8.50
                    Enter your choice: """);
            String sizeChoice = readInput();
            switch (sizeChoice) {
                case "1" -> size = "Single Taco";
                case "2" -> size = "3- Taco Plate";
                case "3" -> size = "Burrito";
                default -> System.out.println("Invalid option. Please re-enter!");
            }
        }
        return size;
    }

    public void addDrink(){}
    public void addChipsAndSalsa(){}
    public void checkOut(){}
}
