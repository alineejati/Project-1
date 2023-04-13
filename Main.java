/**
 * Tic-Tac_Toe Game
 * Master : Dr.Shokoofeh_Bostan
 * Author : Ali_Nejati
 * @alineejati
 * March-2023
 * In This Project , X : 100, O : 110 and # : 120 are assumed ...
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        int aray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int command = 0;
        Scanner input = new Scanner(System.in);

        System.out.println(" Hello,welcome to my application.\n"+ " Are you ready for a fun game ??");
        System.out.println(" 1-Yes,let's gooo :)\n" + " 2-Sorry, I don't feel like playing now :(");
        System.out.println();

        while (true){

            System.out.print(" Please Select An Option : ");
            int Number = input.nextInt();

            if(Number == 1){

                for (int i = 0; i < 6; i++) {
                    System.out.println();
                }

                while (command != 3){

                    new ProcessBuilder("cmd" , "/c" , "cls").inheritIO().start().waitFor();

                    System.out.println("Now choose who you want to play with ?");
                    System.out.println(" 1-Play With Friends\n" + " 2-Play With Computer\n" + " 3-Exit");
                    System.out.print(" Please Select An Option : ");
                    command = input.nextInt();

                    if(command == 3)
                    {
                        System.out.println(" Goodbye but come back soon because I will miss you dear :(");
                        return;

                    }

                    else {

                        switch (command){

                            case 1:

                                aray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
                                System.out.println();
                                Two_Player_Game(aray);
                                break;

                            case 2:

                                aray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
                                Single_Player_Game(aray);
                                break;


                        }
                    }

                }

            }
            else if (Number == 2){

                System.out.println(" OK my friend, I will wait for you.\n" + " Goodbye...");
                break;

            }
            else{

                continue;

            }

        }

    }

    /**
     * This function randomly locks three houses of the array
     */

    public static void luckHome (int[] aray){

        Random rnd = new Random();
        int SaveRandom;

        for (int i = 0; i < 3; i++) {

            SaveRandom = rnd.nextInt(16);

            if (aray[SaveRandom] != 120){

                aray[SaveRandom] = 120;

            }
            else {

                i--;
            }
        }
    }

    /**
        This function scans the rows of the game table to find three similar shapes in a row
        and returns a integer value.
        1 : means player number one has won
        2 : means player number two has won
        3 : means that three similar shapes in one row were not found in any row of the game board.
     */

    public static int CheckRow(int [] aray){
        int flag = 3;

        for (int i = 0; i < 16; i = i + 4) {

            if (aray[i] == aray[i + 1] && aray[i + 1] == aray[i + 2]){

                if (aray[i] == 100)
                    flag = 1;
                else if (aray[i] == 110)
                    flag = 2;
            }

            else if (aray[i + 1] == aray[i + 2] && aray[i + 2] == aray[i + 3]) {
                if (aray[i + 1] == 100)
                    flag = 1;
                else if (aray[i + 1] == 110)
                    flag = 2;
            }
        }

        return flag;
    }


    /**
        This function scans the column of the game table to find three similar shapes in a column
        and returns a integer value.
        1 : means player number one has won
        2 : means player number two has won
        3 : means that three similar shapes in one column were not found in any column of the game board.
     */

    public static int CheckColumn(int [] aray){

        int flag = 3;

        for (int i = 0; i < 4; i++) {

            if(aray[i] == aray[i + 4] && aray[i + 4] == aray[i + 8]){

                if (aray[i] == 100) {
                    flag = 1 ;
                }
                else if (aray[i] == 110){
                    flag = 2 ;
                }
            }
            else if (aray[i + 4] == aray[i + 8] && aray[i + 8] == aray[i + 12]) {

                if (aray[i + 4] == 100) {
                    flag = 1;
                }
                else if (aray[i + 4] == 110){
                    flag = 2;
                }
            }
        }
        return flag;
    }

    /**
        This function scans the game board to find three similar shapes diagonally
        and returns an integer value.
        1 : means player number one has won
        2 : means player number two has won
        3 : This means that no three of the same shape can be found diagonally across the game board.
     */

    public static int CheckDiagonal(int [] aray){
        int flag = 3;

        if (aray[2] == aray[5] && aray[5] == aray[8]){

            if (aray[2] == 100)
                flag = 1;

            else if (aray[2] == 110)
                flag = 2;

        }

        if (aray[6] == aray[9] && aray[9] == aray[12]){

            if (aray[6] == 100)
                flag = 1;

            else if (aray[6] == 110)
                flag = 2;

        }

        if (aray[3] == aray[6] && aray[6] == aray[9]){

            if (aray[3] == 100)
                flag = 1;

            else if (aray[3] == 110)
                flag = 2;

        }

        if (aray[7] == aray[10] && aray[10] == aray[13]){

            if (aray[7] == 100)
                flag = 1;

            else if (aray[7] == 110)
                flag = 2;

        }

        if(aray[4] == aray[9] && aray[9] == aray[14]){

            if (aray[4] == 100)
                flag = 1 ;

            else if (aray[4] == 110)
                flag = 2 ;
        }

        if (aray[5] == aray[10] && aray[10] == aray[15]){

            if (aray[5] == 100)
                flag = 1;

            else if (aray[5] == 110)
                flag = 2;

        }

        if (aray[0] == aray[5] && aray[5] == aray[10]){

            if (aray[5] == 100)
                flag = 1;

            else if (aray[0] == 110)
                flag = 2;

        }

        if(aray[1] == aray[6] && aray[6] == aray[11]){

            if (aray[1] == 100)
                flag = 1 ;

            else if (aray[1] == 110)
                flag = 2 ;

        }

        return flag;
    }

    /**
        This variable is for when the user selects the two-player game,
        and we've defined it as a static type so that other classes know it.
    */

    static int player = 1;

    /**
     * This function fills the houses of the game table
     */

    public static int [] Fill_the_aray(int [] aray , int index , int player){

        if (aray[index] != 100 && aray[index] != 110 && aray[index] != 120){

            if (player == 1) {

                aray[index] = 100;

            }
            else {

                aray[index] = 110;

            }
        }

        else {

            player = player * (-1);

        }

        return aray;
    }

    /**
     * This function checks if there is an empty house left in the game board
     */

    public static boolean Check_the_table(int [] aray){

        boolean result = false;

        for (int i = 0; i < 16; i++) {

            if (aray[i] <= 16) {

                result = true;

            }
        }

        return result;
    }

    /**
     * This function is for when the user has selected the two-player game
     */

    public static void Two_Player_Game(int [] aray) throws IOException, InterruptedException {

        luckHome(aray);
        int NewCommand;
        String message = "";

        Scanner input = new Scanner(System.in);
        int flag = 1;
        int flag2 = 1 , flag3 = 1;

        while (Check_the_table(aray) == true){

            print(aray);

            if (CheckRow(aray) != 3){

                message = "Player (" + CheckRow(aray) + ") Win,Please Enter << R >> to Restarting Game ...";
                break;

            }

            if (CheckColumn(aray) != 3) {

                message = "Player (" + CheckColumn(aray) + ") Win,Please Enter << R >> to Restarting Game ...";
                break;

            }

            if (CheckDiagonal(aray) != 3) {

                message = "Player (" + CheckDiagonal(aray) + ") Win,Please Enter << R >> to Restarting Game ...";
                break;

            }

            System.out.println();

            if(flag == 1)
            {
                System.out.print("Player 1 (X), Please Enter Your Number : ");
                flag = 0;
            }
            else{
                System.out.print("Player 2 (O), Please Enter Your Number : ");
                flag = 1;
            }

            NewCommand = input.nextInt();
            Fill_the_aray(aray , NewCommand - 1 , player);
            player = player * (-1);
            System.out.println();

        }

        if (Check_the_table(aray) == false) {

            print(aray);
            message = "This Game Has Not Winner Please Enter << R >> To Restarting Game ... :/";

        }

        System.out.println();
        System.out.println(message);
        char restart;
        System.out.print("Enter your command : ");
        restart = input.next().charAt(0);

        while (restart != 'R'){

            if(flag3 == 1){

                System.out.print("Enter your command : ");
                restart = input.next().charAt(0);

                if(restart == 'R'){

                    System.out.println();
                    break;

                }

                flag3 = 0;
            }

            else{

                if(flag2 == 1){

                    System.out.println("Please Enter Only The Character << R >> ...");
                    System.out.print("Enter your command : ");
                    restart = input.next().charAt(0);
                    flag2 = 0;

                }
                else{
                    System.out.println("Dear Donkey are you kidding me ?? Only << R >> Character is allowed. Are you mentally ill :/ ???");
                    System.out.print("Enter your command : ");
                    restart = input.next().charAt(0);
                }
            }

        }
        System.out.println();

    }

    /**
     * This function is for when the user has selected the single player game
     */

    public static void Single_Player_Game(int [] aray) throws IOException, InterruptedException {

        luckHome(aray);
        String message = "";
        int NewCommand;
        Scanner input = new Scanner(System.in);
        System.out.println();

        while (Check_the_table(aray) == true){

            print(aray);

            if (CheckRow(aray) != 3){

                if (CheckRow(aray) == 2)
                    message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
                else
                    message = "Player (" + CheckRow(aray) + ") Win Please Enter << R >> To Restarting Game ...";
                    break;
            }

            else if (CheckColumn(aray) != 3) {

                if (CheckColumn(aray) == 2)
                    message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
                else
                    message = "Player (" + CheckColumn(aray) + ") Win Please Enter << R >> To Restarting Game ...";
                    break;
            }

            else if (CheckDiagonal(aray) != 3) {

                if (CheckDiagonal(aray) == 2)
                    message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
                else
                    message = "Player (" + CheckDiagonal(aray) + ") Win Please Enter R To Game ...";
                    break;
            }

            System.out.println();
            System.out.print("Please Enter Your Desired Number : ");
            NewCommand = input.nextInt();
            Fill_the_aray(aray,NewCommand - 1, 1);
            System.out.println();

            if (Check_the_table(aray) == true)
                Fill_the_aray(aray,Choosing_artificial_intelligence(aray),-1);

        }

        if (CheckRow(aray) != 3){

            if (CheckRow(aray) == 2)
                message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
            else
                message = "Player (" + CheckRow(aray) + ") Win Please Enter << R >> To Restarting Game ...";
        }

        else if (CheckColumn(aray) !=3) {

            if (CheckColumn(aray) == 2)
                message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
            else
                message = "Player (" + CheckColumn(aray) + ") Win Please Enter << R >> To Restarting Game ...";
        }

        else if (CheckDiagonal(aray) != 3) {

            if (CheckDiagonal(aray) == 2)
                message = "Artificial Intelligence Player Win Please Enter << R >> To Restarting Game ...";
            else
                message = "Player (" + CheckDiagonal(aray) + ") Win Please Enter << R >> To Restarting Game ...";
        }

        if (Check_the_table(aray) == false){
            print(aray);
            message = "This Game Has Not Winner Please Enter << R >> To Restarting Game ... :/";
        }



        System.out.println();
        System.out.println(message);
        System.out.print("Enter your command : ");
        char restart;
        int flag4 = 1 , flag5 = 1;
        restart = input.next().charAt(0);

        while (restart != 'R'){

            if(flag5 == 1){

                System.out.print("Enter your command : ");
                restart= input.next().charAt(0);

                if(restart == 'R'){

                    System.out.println();
                    break;
                }

                flag5 = 0;
            }
            else{

                if(flag4 == 1){
                    System.out.println("Please Enter Only The Character << R >> To Restarting Game ...");
                    System.out.print("Enter your command : ");
                    restart = input.next().charAt(0);
                    flag4 = 0;
                }
                else{
                    System.out.println("Dear Donkey are you kidding me ?? Only << R >> Character is allowed. Are you mentally ill :/ ???");
                    System.out.print("Enter your command : ");
                    restart = input.next().charAt(0);
                }
            }

        }

    }

    /**
       This function is actually the artificial intelligence that
       plays by generating random numbers instead of player number two
     */

    public static int Choosing_artificial_intelligence(int [] aray){

        int rnd = -1;
        Random chance = new Random();

        while (rnd == -1 || aray[rnd] == 100 || aray[rnd] == 110 || aray[rnd] == 120){

            rnd = chance.nextInt(16);

        }

        return rnd;
    }

    /**
     * This function draws the game table at each stage
     */

    public static void print(int aray[]) throws IOException, InterruptedException {

        new ProcessBuilder("cmd" , "/c" , "cls").inheritIO().start().waitFor();

        for (int i = 0; i < 16; i = i + 4) {

            for (int j = i; j < i + 4 ; j++) {

                if (aray[j] == 100) {

                    System.out.print("X\t");

                }
                else if (aray[j] == 110) {

                    System.out.print("O\t");

                }
                else if (aray[j] == 120) {

                    System.out.print("#\t");

                }
                else {

                    System.out.print(aray[j] + "\t");

                }
            }
            System.out.println();
        }
    }

}

/**
 *تو را من چشم در راهم شباهنگام
 * که می گیرند در شاخ تلاجن سایه ها رنگ سیاهی
 * وزان دلخستگانت راست اندهی فراهم
 * تو را من چشم در راهم...
 * شباهنگام، در آن دم که بر جا دره ها چون مرده ماران خفتگانند
 * در آن نوبت که بندد دست نیلوفر به پای سرو کوهی دام
 * گرم یادآوری یا نه، من از یادت نمی کاهم
 * تو را من چشم در راهم :)
 */