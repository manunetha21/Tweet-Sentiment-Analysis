package com.cc01.cc01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cc01.cc01.Exceptions.MyException;
import com.cc01.cc01.config.Configuration;
import com.cc01.cc01.model.AdminResponse;

@Controller
public class AdminContorller {

    @GetMapping("/adminHome")
    public String adminHome(Model model) throws MyException {
        model.addAttribute("home", "home");
        return "Admin";

    }

    @GetMapping("/users")
    public String usersRecords(Model model) throws MyException {

        AdminResponse rm = null;
        try {
            rm = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getUsers", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }

        model.addAttribute("userspage", "users");
        model.addAttribute("users", rm.getUserModels());

        return "Admin";

    }

    @GetMapping("/files")
    public String userFiles(Model model) throws MyException {

        AdminResponse rm = null;
        try {
            rm = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getFiles", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }

        model.addAttribute("filespage", "filespage");
        model.addAttribute("files", rm.getFileModels());

        return "Admin";

    }

    @GetMapping("/harmFiles")
    public String harmFiles(Model model) throws MyException {

        AdminResponse rm = null;
        try {
            rm = Configuration
                    .getRestTemplate()
                    .getForObject(Configuration.getIP() + "admin/getHarmFiles", AdminResponse.class);
        } catch (Exception e) {
            throw new MyException("your server is not reachable");
        }

        model.addAttribute("filespage", "filespage");
        model.addAttribute("files", rm.getFileModels());

        return "Admin";

    }

}
