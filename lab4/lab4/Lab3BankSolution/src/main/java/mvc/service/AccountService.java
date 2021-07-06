package mvc.service;

import mvc.data.AccountRepository;
import mvc.domain.Account;
import mvc.integration.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SendMessage sendMessage;

    public void add(Account account){
        accountRepository.save(account);
        sendMessage.sendMessage(account.getAccountHolder(), "Welcome");
    }

    public void update(Account account){
        accountRepository.save(account);
    }

    public Account findByAccountNumber(Long accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public void delete(long accountNumber){
        Account account = accountRepository.findByAccountNumber(accountNumber);
        sendMessage.sendMessage(account.getAccountHolder(), "Good By");
        accountRepository.delete(accountNumber);
    }

    public Collection<Account> findAll(){
        return accountRepository.findAll();
    }
}
