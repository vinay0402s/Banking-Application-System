package banking;

public class LoktakBank implements RBIBankInterface {

    private String accountNo;
    private String password;
    private Double balance;
    private double rateOfInterest = 7.5;

    public LoktakBank(String accountNo, String password, Double balance){
        this.accountNo=accountNo;
        this.password=password;
        this.balance=balance;
    }

    public String depositMoney(int money) {
        if(money > 0){
            balance = balance + money;
            return "Money :"+money+" has been added to your account. Total " + "balance is"+balance;
        }else{
            return "Money entered is negative";
        }
    }

    public String withdrawMoney(int money, String password) {
        if(password.equals(this.password)){
            if(balance>= money){
                balance=balance-money;
                return "Money :"+money+" has been withdraw. Remaining balance is "+balance;
            }else{
                return "Insufficient Balance. Min Balance that needs to be supported is "+balance;
            }
        }else {
            return "Wrong password entered";
        }
    }

    public String checkBalance(String password) {
        if(this.password.equals(password)){
            return "The balance is "+this.balance;
        }else{
            return "Wrong password entered";
        }
    }

    public double calculateDoubleInterest(int time) {
        Double simpleInterest = (balance*time*rateOfInterest)/100;

        return simpleInterest;
    }
}
