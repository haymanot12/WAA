package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/calc")
    public ModelAndView calc( @RequestParam(value="num1") int num1,
                        @RequestParam(value="num2") int num2, @RequestParam(value="op") String op){

        String message="";

        if(op.equals("+")){
            message ="Number1 = " +num1 + "\n"+ "Operation = "+ " + "+"\n" +"Number2 = " +num2+"\n" + "Result = "+ (num2+num1);


        }
        else if(op.equals("*")){
            message ="Number1 = " +num1 + "\n"+ "Operation = "+ " * "+"\n" +"Number2 = " +num2+"\n" + "Result = "+ (num2*num1);

        }
        else if(op.equals("-")){
            message ="Number1 = " +num1 + "\n"+ "Operation = "+ " - "+"\n" +"Number2 = " +num2+"\n" + "Result = "+ (num1-num2);


        }
        else if(op.equals("/")){
            message ="Number1 = " +num1 + "\n"+ "Operation = "+ " / "+"\n" +"Number2 = " +num2+"\n" + "Result = "+ (float)num1/num2;


        }

        Map<String, Object> params = new HashMap<>();
        params.put("message", message);

        return new ModelAndView("hello",params);
    }
}

