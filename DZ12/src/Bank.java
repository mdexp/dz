import java.util.ArrayList;

public class Bank {

    static int accountIdGen = 34566794;
    ArrayList<Account> allAccounts = new ArrayList<Account>();

    public int createAccount() {
        Account account = new Account();
        account.setAccountId(accountIdGen);
        allAccounts.add(account);
        accountIdGen++;
        System.out.println("New account " + account.getAccountId() + " created");
        account.printAccountInfo();
        return account.getAccountId();
    }

    public void blockAccount(int accountId) {
        for (Account account : allAccounts) {
            if (account.getAccountId() == accountId) {
                account.blockAccount();
                System.out.println(accountId + " account has been blocked");
                return;
            }
        }
        System.out.println(accountId + " account not found");
    }

    public void unBlockAccount(int accountId) {
        for (Account account : allAccounts) {
            if (account.getAccountId() == accountId) {
                account.unblockAccount();
                System.out.println(accountId + " account has been unblocked");
                return;
            }
        }
        System.out.println(accountId + " account not found");
    }
}
