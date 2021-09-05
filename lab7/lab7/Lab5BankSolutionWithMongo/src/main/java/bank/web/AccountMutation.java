package bank.web;

import bank.domain.Account;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMutation implements GraphQLMutationResolver {

    @Autowired
    private AccountService accountService;

    public Account createAccount(final int accountnumber, final String accountHolder, final String date, final float amount, final  String description,String operation) {
        return accountService.createAccount(accountnumber, accountHolder, date, amount, description,operation);
    }
}
