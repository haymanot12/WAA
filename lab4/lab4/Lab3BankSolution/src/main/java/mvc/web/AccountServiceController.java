package mvc.web;


import mvc.domain.Account;
import mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountServiceController {
    @Autowired
    AccountService accountService;


	@GetMapping("/accounts/{accountnumber}")
    public ResponseEntity<?> getAccount(@PathVariable Long accountnumber) {
        Account account = accountService.findByAccountNumber(accountnumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Account with number= " + accountnumber + " is not available"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Account> (account, HttpStatus.OK);
    }

	@DeleteMapping("/accounts/{accountnumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountnumber) {
        Account account = accountService.findByAccountNumber(accountnumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Account with number= " + accountnumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        accountService.delete(accountnumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	

    @PostMapping("/accounts")
    public ResponseEntity<?> handlePost(@RequestParam(value="operation", required = false, defaultValue = "") String operation,
                                        @RequestParam(value="accountNumber", required = false) Long accountNumber,
                                        @RequestParam(value="amount", required = false) Double amount,
                                        @RequestParam(value="accountHolder", required = false)  String accountHolder,@RequestBody @Valid Account account, Errors errors) {

        account = new Account();

        if (errors.hasErrors()) {
            Map<String, Object> fieldError = new HashMap<>();
            List<FieldError> fieldErrors= errors.getFieldErrors();
            for(FieldError error : fieldErrors){
                fieldError.put(error.getField(), error.getDefaultMessage());
            }
            Map<String, Object> map = new HashMap<>();
            map.put("isSuccess", false);
            map.put("data", null);
            map.put("status", HttpStatus.BAD_REQUEST);
            map.put("fieldError", fieldError);
            return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
        }
        if (operation.equals("")){
            //create account
            if (accountNumber != 0 && accountHolder != null){
                String accountHolderName = accountHolder.substring(1, accountHolder.length()-1); //strip quotes
                account = new Account(accountNumber, accountHolderName);
                accountService.add(account);
            }
        }
        else{
            account = accountService.findByAccountNumber(accountNumber);//accounts.get(accountNumber);
            if(account==null){
                return new ResponseEntity<String> ("Account with " +accountNumber +" is not exist", HttpStatus.OK);
            }
            String operationName = operation.substring(1, operation.length()-1); //strip quotes
            if (operationName.equals("deposit")){
                System.out.println("yes");
                //account = accountService.findByAccountNumber(accountNumber);//accounts.get(accountNumber);
                account.deposit(amount);


            }
            else if (operationName.equals("withdraw")){
               // account = accountService.findByAccountNumber(accountNumber);//accounts.get(accountNumber);
                account.withdraw(amount);
            }
        }
        return new ResponseEntity<Account> (account, HttpStatus.OK);
    }

}


