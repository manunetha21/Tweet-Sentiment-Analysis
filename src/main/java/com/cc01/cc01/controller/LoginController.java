package com.cc01.cc01.controller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cc01.cc01.Repository.UserStatusRepository;
import com.cc01.cc01.config.Configuration;
import com.cc01.cc01.model.UserModel;
import com.cc01.cc01.model.UserReport;
import com.cc01.cc01.utils.Infomation;
import com.cc01.cc01.utils.ResponseMessage;

@Controller
@SessionAttributes({"um","ur"})
public class LoginController {

    @Autowired
   UserStatusRepository userStatusRepository;

   

    @PostMapping("/loginsubmit")
    public String userLogin(
        @RequestParam("emailid")String emailid,
        @RequestParam("password")String password,Model model,HttpSession session,HttpServletRequest request
    ) {

        UserModel um = new UserModel();
        um.setEmailId(emailid);
        um.setPassword(password);
        ResponseMessage rm = Configuration
            .getRestTemplate()
            .postForObject(Configuration.getIP()+"user/login", um, ResponseMessage.class);
        if(rm.getMessage().equalsIgnoreCase("success")){
           um=rm.getUserModel();

           UserReport ur=new UserReport();
           ur.setUserId(um.getUserId());ur.setLoginDateAndTime(LocalDate.now().toString());
           ur.setLoginStatus("1");
          ur= userStatusRepository.save(ur);
          model.addAttribute("suid",ur.getId());
           model.addAttribute("um", um);
           model.addAttribute("profile",null);
           return "index";
        }else{
              String info= Infomation.getErrorMessage("Emailid or password wrong");
              model.addAttribute("info", info);
              return "login";
        }
      
    }


    @GetMapping("/profile/{userid}")
   public String checkProfile(@PathVariable String userid,Model model ){
    
    ResponseMessage rm = Configuration
    .getRestTemplate()
    .getForObject(Configuration.getIP()+"user/profile/"+userid,  ResponseMessage.class);

    if(rm.getMessage().equalsIgnoreCase("success")){
       model.addAttribute("um", rm.getUserModel());
       model.addAttribute("profile", "profile");
        return "index";
    }else{
        model.addAttribute("error", "Error Occured ");
        model.addAttribute("profile", "profile");
        return "index";
    }

   } 

}
