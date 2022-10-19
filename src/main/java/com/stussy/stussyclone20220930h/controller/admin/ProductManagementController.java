package com.stussy.stussyclone20220930h.controller.admin;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/admin")
public class ProductManagementController {

    @GetMapping("/product/register")
    public String loadProductRegister(){
        return "admin/product_registration";
    }
}
