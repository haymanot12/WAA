package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class CarController {
    @PostMapping("/add")
    public ModelAndView add(HttpSession session, @ModelAttribute("product") @Valid Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("addproduct");
            return mav;
        }

        Map<String, Object> params = new HashMap<>();

        if (product != null) {
            //get the carlist from the session
            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
            //if there is no carlist in the session, create one.
            if (productList == null) {
                productList = new HashMap<String, Product>();
                session.setAttribute("productList", productList);
            }
            //add the car to the carlist
           // redirectAttributes.addFlashAttribute( product.getNumber(), product);
           redirectAttributes.addFlashAttribute( "productList", productList.values());

            productList.put(product.getNumber(), product);
            //params.put("productList", productList.values());
        }
       return new ModelAndView("redirect:products", params);
        //return new ModelAndView("products", params);
    }

    @GetMapping("/products")
    public ModelAndView init(HttpSession session) {
        //get the carlist from the session
        Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
        //if there is no carlist in the session, create one.
        if (productList == null) {
            productList = new HashMap<String, Product>();
            session.setAttribute("productList", productList);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("productList", productList.values());
        return new ModelAndView("products", params);
    }

    @PostMapping("/addproduct")
    public ModelAndView addproduct(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("product", new Product());
        return new ModelAndView("addproduct", params);
    }

    @PostMapping("/removeproduct")
    public ModelAndView removecar(@RequestParam("number") String number, HttpSession session, RedirectAttributes redirectAttributes) {
        Map<String, Object> params = new HashMap<>();
        if (number != null) {
            //get the carlist from the session
            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
            //if there is no carlist in the session, create one.
            if (productList == null) {
                productList = new HashMap<String, Product>();
                session.setAttribute("productList", productList);
            }
            //add the car to the carlist

            //redirectAttributes.addFlashAttribute( "name", name);



            productList.remove(number);
            redirectAttributes.addFlashAttribute( "productList", productList.values());
            //params.put("productList", productList.values());
        }
        return new ModelAndView("redirect:products", params);
        //return new ModelAndView("products", params);
    }
}
