package com.assem;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static File bankInfoFile = new File("bankInfo.txt");


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BankList accntInfo = new BankList();

//        accntInfo.addAccount(new BankAccount(1234, 1111));
//        accntInfo.addAccount(new BankAccount(2345, 2222));
//        accntInfo.addAccount(new BankAccount(3456, 3333));
//        accntInfo.addAccount(new BankAccount(4567, 4444));
//        accntInfo.addSavingAccount(new SavingAccount(1234, 5000));
//        accntInfo.addSavingAccount(new SavingAccount(2345, 5000));
//        accntInfo.addSavingAccount(new SavingAccount(3456, 5000));
//        accntInfo.addSavingAccount(new SavingAccount(4567, 5000));
//        accntInfo.addCheckingAccount(new CheckingAccount(1234, 1000));
//        accntInfo.addCheckingAccount(new CheckingAccount(2345, 1000));
//        accntInfo.addCheckingAccount(new CheckingAccount(3456, 1000));
//        accntInfo.addCheckingAccount(new CheckingAccount(4567, 1000));
//
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(bankInfoFile))) {
//            out.writeObject(accntInfo);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("WELCOME TO THE NATIONAL AWESOME BANK" + "\n");


        try{
            boolean done1=false;//Always displays the enter pin
            while(!done1){
                FileInputStream inFile=new FileInputStream(bankInfoFile);
                ObjectInputStream in=new ObjectInputStream(inFile);
                System.out.println("Please enter your account number:  ");
                int accountNumUser=scanner.nextInt(); //User enters the accountNumber
                System.out.println("Please enter the pin:  ");
                int pinUser=scanner.nextInt(); //User enters pin

                BankList allInfo=(BankList) in.readObject();
                BankAccount userBank= allInfo.findBankAccount(accountNumUser);

                if(userBank.getAccountNumber()==accountNumUser && userBank.getPin()==pinUser) {
                    boolean done2 = false;//for Ssaving,Cheching account,or Q, or wrong choice
                    while (!done2) {

                        System.out.println("Enter (S) to select the SavingsAccount,(C) to select CheckingAccount OR (Q) to quit");
                        String userChoice1 = scanner.next();

                        if (userChoice1.equalsIgnoreCase("s")) {

                            boolean done3=false;//dor W,D,or wrong choice
                            while(!done3) {
                                System.out.println("Enter (W) to withdraw,(D) to depositt");
                                String userChoice2 = scanner.next();


                                SavingAccount userSaving = allInfo.findSavings(accountNumUser);//userSavingAccount

                                try {//if the user enters the wrong amount goes to the coressponding catch
                                    if (userChoice2.equalsIgnoreCase("w")) {
                                        System.out.println("Amount to withdraw:  ");
                                        double userAmountToWithdaw = scanner.nextDouble();

                                        userSaving.withdraw(userAmountToWithdaw);


                                        System.out.println("Your balance is:  "+ userSaving.getBalance());
                                        System.out.println("Are you done? Y/N");
                                        String userChoice3 = scanner.next();
                                        if (userChoice3.equalsIgnoreCase("y")) {//for yes im done
                                            done1 = true;
                                            done2=true;
                                            done3=true;
                                            System.out.println("Thank You for Banking with Assem's Bank");
                                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(bankInfoFile));
                                            out.writeObject(allInfo);
                                            out.close();

                                        } else if (userChoice3.equalsIgnoreCase("N")) {//for no, iam not done


                                        } else {
                                            System.out.println("Please select the right option!");
                                        }


                                    } else if (userChoice2.equalsIgnoreCase("d")) {
                                        System.out.println("Amount to depsoit:  ");
                                        double userAmountToDeposit=scanner.nextDouble();
                                        userSaving.deposit(userAmountToDeposit);
                                        System.out.println("Your balance is:  "+ userSaving.getBalance());
                                        System.out.println("Are you done? Y/N");

                                        String userOption = scanner.next();
                                        if (userOption.equalsIgnoreCase("y")) {
                                            done1=true;
                                            done2=true;
                                            done3=true;
                                            System.out.println("Thank You for Banking with Assem's Bank");
                                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(bankInfoFile));
                                            out.writeObject(allInfo);
                                            out.close();


                                        } else if (userOption.equalsIgnoreCase("n")) {

                                        }
                                        else{
                                            System.out.println("Please select the right option!");
                                        }


                                    } else {
                                        System.out.println("Please select the right choice");
                                    }

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                    System.out.println("Error in the amount entered, please try again");
                                    done3 = true;
                                }
                            }


                        } else if (userChoice1.equalsIgnoreCase("c")) {
                            CheckingAccount userChecking = allInfo.findChecking(accountNumUser);
                            boolean done4=false;
                            while (!done4) {
                                System.out.println("Enter (W) to withdraw,(D) to deposit to your checking account");
                                String userChoice2 = scanner.next();

                                if(userChoice2.equalsIgnoreCase("w")) {
                                    System.out.println("Amount to withdraw: ");
                                    double userAmountW = scanner.nextDouble();
                                    userChecking.withdraw(userAmountW);
                                    userChecking.deductFees();
                                    System.out.println("Your balance is:  " + userChecking.getBalance());
                                    System.out.println("Are you done? Y/N");
                                    String optionDone4 = scanner.next();

                                    if (optionDone4.equalsIgnoreCase("y")) {
                                        done1=true;
                                        done2 = true;
                                        done4 = true;
                                        System.out.println("Thank You for Banking with Assem's Bank");
                                        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(bankInfoFile));
                                        out.writeObject(allInfo);
                                        out.close();
                                    } else if (optionDone4.equalsIgnoreCase("n")) {


                                    }
                                    else{
                                        System.out.println("Please select the right choice");
                                    }
                                } else if (userChoice2.equalsIgnoreCase("d")) {
                                    System.out.println("Amount to deposit: ");
                                    double userAmountW = scanner.nextDouble();
                                    userChecking.deposit(userAmountW);

                                    System.out.println("Your balance is:  " + userChecking.getBalance());
                                    System.out.println("Are you done? Y/N");
                                    String optionDone4 = scanner.next();

                                    if (optionDone4.equalsIgnoreCase("y")) {
                                        done1=true;
                                        done2 = true;
                                        done4 = true;
                                        System.out.println("Thank You for Banking with Assem's Bank");
                                        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(bankInfoFile));
                                        out.writeObject(allInfo);
                                        out.close();
                                    } else if (optionDone4.equalsIgnoreCase("n")) {


                                    }
                                    else{
                                        System.out.println("Please select the right choice");
                                    }

                                }
                                else{
                                    System.out.println("Please select the right choice");
                                }

                            }

                        } else if (userChoice1.equalsIgnoreCase("q")) {
                            done1=true;
                            done2 = true;
                            System.out.println("Thank You for Banking with Assem's Bank");

                        } else {
                            System.out.println("Please select the right choice");
                        }

                    }
                }

                else {
                    System.out.println("Wrong passcode, try again!");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }






    }





}