package alex.controller;

import alex.dao.EProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import alex.entity.EProductEntity;


import java.util.List;

@Controller
public class MainController {
    @Autowired
    EProductDAO eproductDAO;

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public String listProducts(Model model)
    {
        List<EProductEntity> list= eproductDAO.getProducts();
        model.addAttribute("list",list);
        return "listProducts";
    }
}

