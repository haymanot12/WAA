package websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {

		String newMessage = message.getPayload();

		try {
			int num1 = Integer.parseInt(newMessage.substring(0, newMessage.length() - 2));
			String op = newMessage.substring(1, newMessage.length() - 1);
			int num2 = Integer.parseInt(newMessage.substring(2, newMessage.length()));
			double result =0.0;
			if (op.equals("+")) {
				result = num1 + num2;
			} else if(op.equals("-")){
				result=num1-num2;
			}else if(op.equals("*")){
				result=num1*num2;
			}
			else if(op.equals("/")){ result = (float)num1/num2;}
			session.sendMessage(new TextMessage("The result is =  " + result ));
		} catch (NumberFormatException nfe){

			session.sendMessage(new TextMessage("Wrong statement  " ));

		}

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("Connected");
		//send message back to the client
		session.sendMessage(new TextMessage("Connected !"));

		MyThread myThread = new MyThread(session);
		Thread t = new Thread(myThread);
		t.start();
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("Closed");
	}

}