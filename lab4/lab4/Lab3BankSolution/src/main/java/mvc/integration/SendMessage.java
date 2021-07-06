package mvc.integration;

import org.springframework.stereotype.Component;

@Component
public class SendMessage {
    public void sendMessage (String message, String accountHolder){
        System.out.println("Send email message '"+ message+"' to"+accountHolder);
    }
}
