
public class Account {

    private int accountId = 0;
    private float balance = 0f;
    private boolean isBlocked = false;

    public void addMoney(float sum){
        balance += sum;
    }

    public void getMoney(float sum){
        if (isBlocked) {
            System.out.println("Operation not permitted! Your account is blocked!");
            return;
        }
        if (balance >= sum) {
            balance -= sum;
        } else {
            System.out.println("Not enough money! You have " + balance +" uah on balance.");
        }
    }

    public void transferToAccount(Account toAccount, float summTransfer){
        if (isBlocked) {
            System.out.println("Operation not permitted! Your account is blocked!");
            return;
        }
        if (balance >= summTransfer) {
            balance -= summTransfer;
            toAccount.addMoney(summTransfer);
        } else {
            System.out.println("Not enough money! You have " + balance +" uah on balance.");
        }
    }

    public void printAccountInfo(){
        System.out.println("Account info: id " + accountId + ", balance " + balance);
    }

    public void setAccountId(int accountId){
        this.accountId = accountId;
    }

    public int getAccountId(){
        return accountId;
    }

    public float getAccountBalance(){
        return balance;
    }

    public void blockAccount(){
        isBlocked = true;
    }

    public void unblockAccount(){
        isBlocked = false;
    }

}