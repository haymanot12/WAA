package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;


@RestController
public class BankController {

    private Map<String, Account> accounts = new HashMap<String, Account>();

    public BankController() {
        accounts.put("A7474", new Account("A7474", "Brown", 23416));
        accounts.put("A627363", new Account("A627363", "Jones", 23416));
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountNumber,HttpSession session) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Account with accountNumber= "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
//        List<String> withdraw= new ArrayList<>();
//        List<String>deposit=new ArrayList<>();
//        Map<String, Object> result = new HashMap<String,Object>();
//        Map<String,List<String>>depositList = (Map<String,List<String>>)session.getAttribute("deposite");
//        if(depositList==null){
//            deposit= new ArrayList<>();
//        }
//        else deposit = depositList.get(accountNumber);
//       Map<String,List<String>>withdrawList = (Map<String,List<String>>)session.getAttribute("withdraw");
//        if(withdrawList==null){
//            withdraw =new ArrayList<>();
//        }
//        else withdraw = withdrawList.get(accountNumber);
//        result.put("account",account);
//        result.put("deposit",deposit);
//        result.put("withdraw",withdraw);

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    //HttpSession session, @ModelAttribute("product") @Valid Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes
    @PostMapping("/accounts/{accountNumber}/{accountHolder}")
    public ResponseEntity<?> createAccount(HttpSession session,@PathVariable  String accountNumber,@PathVariable  String accountHolder) {

        accounts.put(accountNumber, new Account(accountNumber,accountHolder,0.0));
        session.setAttribute(accountNumber, accounts.get(accountNumber));

       // accounts.put(account.getAccountNumber(), account);
        return new ResponseEntity<Account>(accounts.get(accountNumber), HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Account with AccountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        accounts.remove(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAllContacts() {
        Accounts allAccounts = new Accounts(accounts.values());
        return new ResponseEntity<Accounts>(allAccounts, HttpStatus.OK);
    }

    //public ModelAndView addcarts(HttpSession session, @ModelAttribute("cart") @Valid ShoppingCart cart, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
    @PutMapping("/accounts/deposit/{accountNumber}/{amount}")
    public ResponseEntity<?> deposit(HttpSession session, @PathVariable String accountNumber, @PathVariable double amount) {
        Account account = accounts.get(accountNumber);
        account.deposit(amount);
//        LocalDateTime now = LocalDateTime.now();
//        //Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
//        Map<String, List<String>>depositList = (Map<String,List<String>>)session.getAttribute("deposite");
//        if(depositList==null){
//            depositList = new HashMap<String, List<String>>();
//            session.setAttribute("deposite", depositList);
//        }
//        List<String>list = new ArrayList<>();
//        Account account = accounts.get(accountNumber);
//        account.deposit(amount);
//        depositList.put(accountNumber,list);
//        depositList.get(accountNumber).add("deposit Amount = " +amount+"  Time   "+" "+now);

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PutMapping("/accounts/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<?> withdraw(HttpSession session, @PathVariable String accountNumber, @PathVariable double amount) {
        Account account = accounts.get(accountNumber);
        account.withdraw(amount);
//        LocalDateTime now = LocalDateTime.now();
//        //Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
//        Map<String,List<String>>withdrawList = (Map<String,List<String>>)session.getAttribute("withdraw");
//        if(withdrawList==null){
//            withdrawList = new HashMap<String, List<String>>();
//            session.setAttribute("withdraw", withdrawList);
//        }
//        List<String>list= new ArrayList<>();
//        Account account = accounts.get(accountNumber);
 //       account.withdraw(amount);
//        withdrawList.put(accountNumber,list);
//        withdrawList.get(accountNumber).add( "withdraw Amount = "+amount+"  Time = "+" "+now);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
}
