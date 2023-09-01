package com.espe.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavbarController {

    public String index() {
        return "/index.xhtml";
    }

    public String contact() {
        return "/Contact.xhtml";
    }

}
