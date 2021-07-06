package mvc;

import java.util.Collection;
import java.util.List;

public class Accounts {
    private Collection<Account> accounts;

    public Accounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
    public Collection<Account> getAccounts() {
        return accounts;
    }
    public void setContacts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
