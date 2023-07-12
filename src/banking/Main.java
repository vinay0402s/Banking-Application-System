package banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("Which bank you want to open the account");
        System.out.println("print 1 to create in Lotak and 2 to create in SBI");
        Scanner sc  =  new Scanner(System.in);
        int option = sc.nextInt();

        System.out.println("Enter password and intial deposit");
        String password = sc.next();
        Integer intialBalance = sc.nextInt();

        double account = Math.abs(Math.random()*Math.pow(10,9));
        String stringversion = String.valueOf(account);

       RBIBankInterface bankAccount;

       if(option==1){
           bankAccount= new LoktakBank(stringversion, password, (double)intialBalance);
       }else{
           bankAccount= new SBIBank(stringversion, password, (double)intialBalance);
       }

        //Inital balance : 95000

        //Withdraw money : 70000

        String result = bankAccount.withdrawMoney(70000, "vinay123");
        System.out.println(result);

        //Deposit money : 70000

        result =  bankAccount.depositMoney(70000);
        System.out.println(result);
        System.out.println(bankAccount.checkBalance("vinay123"));


        System.out.println(bankAccount.calculateDoubleInterest(3));
    }
}