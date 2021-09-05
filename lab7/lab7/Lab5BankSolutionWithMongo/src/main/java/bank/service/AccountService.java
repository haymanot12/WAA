package bank.service;

import bank.data.AccountRepository;
import bank.domain.Account;
import bank.domain.AccountEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;


    public void add(AccountDTO accountDto){
        accountRepository.save(AccountAdapter.getAccount(accountDto));
    }

    public void update(AccountDTO accountDto){
        accountRepository.save(AccountAdapter.getAccount(accountDto));
    }

    public AccountDTO findByAccountNumber(int accountNumber){
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        if (accOptional.isPresent()){
            return AccountAdapter.getAccountDTO(accOptional.get());
        }
        else{
            return null;
        }
    }

    public void delete(int accountNumber){
        Account account = accountRepository.findById(accountNumber).get();
        accountRepository.delete(account);
    }

    public Collection<AccountDTO> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return AccountAdapter.getAccountDTOList(accounts);
    }

    public void deposit(int accountNumber, float amount){
        Account account = accountRepository.findById(accountNumber).get();
        account.deposit(amount);
        accountRepository.save(account);
    }

    public void withdraw(int accountNumber, float amount){
        Account account = accountRepository.findById(accountNumber).get();
        account.withdraw(amount);
        accountRepository.save(account);
    }

    public Account createAccount( int accountnumber,  String accountHolder,  String date,  float amount,  String description,String operation) {
        Account account = new Account(accountnumber,accountHolder);
        if(date!=null&&amount!=0.0&&operation.equals("deposit")){
            deposit(accountnumber,amount);
        }
        if(date!=null&&amount!=0.0&&operation.equals("withdraw")){
           withdraw(accountnumber,amount);
        }
        accountRepository.save(account);
        return account;
    }
    public List<Account> getAllAccounts(int count) {
        List<Account> accountList  = accountRepository.findAll().stream().collect(Collectors.toList());
        return accountList.subList(0,count);
    }
    public Optional<Account> getAccount(int accountnumber) {
        return  accountRepository.findById(accountnumber);
    }

        /*public List<Account> getAccountWithEntry(String street, String city, String zip) {
        List<Account> accountList  = accountRepository.findAll().stream()
                .filter(c-> c.getEntryList().stream().equals(street))
                .filter(c-> c.getAddress().getCity().equals(city))
                .filter(c-> c.getAddress().getZip().equals(zip))
                .collect(Collectors.toList());
        return customerList;
    }*/

}
