package alex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    //product/listProducts/?categoryId=1&categoryName=computer
    @GetMapping("/listProducts")
    public String getProductByCategory(@RequestParam String categoryId,
                                       @RequestParam(value = "categoryName", required = false, defaultValue = "laptop") String name){

        System.out.println("Id: " + categoryId +", Name: "+name);
        return "welcome";
    }

    //product/categoryId/2/categoryName/computer
    @GetMapping("categoryId/{cateId}/categoryName/{cateName}")
    public  String getProducts(@PathVariable String cateId,@PathVariable("cateName") String name){
        System.out.println("cateId: "+cateId+", cateName: " + name);
        return "welcome";
    }



    @PostMapping("/save")
    public String saveUser(){
        return "result";
    }
}
