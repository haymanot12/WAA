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
public class ShoppinCartController {

        @PostMapping("/addcarts")
        public ModelAndView addcarts(HttpSession session, @ModelAttribute("cart") @Valid ShoppingCart cart, BindingResult bindingResult,RedirectAttributes redirectAttributes) {

            ModelAndView mav = new ModelAndView();
            if (bindingResult.hasErrors()) {
                mav.setViewName("addcart");
                return mav;
            }

            Map<String, Object> params = new HashMap<>();

            if (cart != null) {
                //get the carlist from the session

                Map<String, ShoppingCart> cartList = (Map<String, ShoppingCart>) session.getAttribute("cartList");
                Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");
                //if there is no carlist in the session, create one.
                if (cartList == null) {
                    cartList = new HashMap<String, ShoppingCart>();
                    session.setAttribute("cartList", cartList);
                }
                //add the car to the carlist
                // redirectAttributes.addFlashAttribute( product.getNumber(), product);
                cart= new ShoppingCart(productList.get(cart.getNumber()).getNumber(),
                        productList.get(cart.getNumber()).getName(),productList.get(cart.getNumber()).getPrice());

                cartList.put(cart.getNumber(), cart);
                double totalSum=0.0;
                    totalSum=ShoppingCart.total(cartList);
               // redirectAttributes.addFlashAttribute( "cartList", cartList.values());

                //productList.put(product.getNumber(), product);
               params.put("cartList", cartList.values());
               params.put("totalSum",totalSum);
            }
           // return new ModelAndView("redirect:carts", params);
            return new ModelAndView("carts", params);
        }


    @GetMapping("/carts")
        public ModelAndView init(HttpSession session) {
            //get the carlist from the session
            Map<String, ShoppingCart> cartList = (Map<String, ShoppingCart>) session.getAttribute("cartList");
            //if there is no carlist in the session, create one.
            if (cartList == null) {
                cartList = new HashMap<String, ShoppingCart>();
                session.setAttribute("cartList", cartList);
            }
            Map<String, Object> params = new HashMap<>();
            params.put("cartList", cartList.values());
            return new ModelAndView("carts", params);
        }

        @PostMapping("/addcart")
        public ModelAndView addcart(HttpSession session) {
            Map<String, Object> params = new HashMap<>();
            params.put("cart", new ShoppingCart());
            return new ModelAndView("addcart", params);
        }

        @PostMapping("/removecart")
        public ModelAndView removecart(@RequestParam("number") String number, HttpSession session, RedirectAttributes redirectAttributes) {
            Map<String, Object> params = new HashMap<>();
            if (number != null) {
                //get the carlist from the session
                Map<String, ShoppingCart> cartList = (Map<String, ShoppingCart>) session.getAttribute("cartList");
                //if there is no carlist in the session, create one.
                if (cartList == null) {
                    cartList = new HashMap<String, ShoppingCart>();
                    session.setAttribute("cartList", cartList);
                }
                //add the car to the carlist

                //redirectAttributes.addFlashAttribute( "name", name);
                //double totalSum=0.0;
                //totalSum=ShoppingCart.total(cartList);//-cartList.get(number).getPrice();
                cartList.remove(number);
                double totalSum=0.0;
                totalSum=ShoppingCart.total(cartList);
                //redirectAttributes.addFlashAttribute( "cartList", cartList.values());
                params.put("cartList", cartList.values());
                params.put("totalSum",totalSum);
            }
            //return new ModelAndView("redirect:carts", params);
            return new ModelAndView("carts", params);
        }
    }


