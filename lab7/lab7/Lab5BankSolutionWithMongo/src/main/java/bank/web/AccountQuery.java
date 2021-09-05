package bank.web;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountQuery implements GraphQLQueryResolver {

    @Autowired
    private AccountService accountService;

    public List<Account> getAccounts(final int count) {
        return accountService.getAllAccounts(count);
    }

    public Optional<Account> getAccount(final int accountnumber) {
        return accountService.getAccount(accountnumber);
    }

    /*public List<Account> getAccountWithEntry(String street, String city, String zip) {
        List<Customer> customerList  = customers.values().stream()
                .filter(c-> c.getAddress().getStreet().equals(street))
                .filter(c-> c.getAddress().getCity().equals(city))
                .filter(c-> c.getAddress().getZip().equals(zip))
                .collect(Collectors.toList());
        return customerList;
    }*/


}
