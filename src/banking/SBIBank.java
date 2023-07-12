package banking;

public class SBIBank implements RBIBankInterface {

    private String accNo;
    private String passCode;
    private Double balance;
    private double rateOfInterest = 6;
    private Integer minimumBalance = 500;

   //constructor
    public SBIBank (String accNo, String passCode, Double balance){
        this.accNo=accNo;
        this.balance=balance;
        this.passCode=passCode;
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

        if(password.equals(this.passCode)){
            if(balance-minimumBalance >= money){
                balance=balance-money;
                return "Money :"+money+" has been withdraw. Remaining balance is "+balance;
            }else{
                return "Insufficient Balance. Min Balance that needs to be supported is "+minimumBalance;
            }
        }else {
            return "Wrong password entered";
        }
    }

    public String checkBalance(String password) {
        if(this.passCode.equals(password)){
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
