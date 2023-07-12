package banking;

public interface RBIBankInterface {
    public String depositMoney(int money);
    public String withdrawMoney(int money, String password);
    public String checkBalance(String password);
    public double calculateDoubleInterest(int time);
}
