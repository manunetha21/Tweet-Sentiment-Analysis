package com.dm04.dm04.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dm04.dm04.config.Configuration;
import com.dm04.dm04.model.DiabatiesModel;
import com.dm04.dm04.services.DiabatiesService;
import com.dm04.dm04.utils.ResponseMessageForFile;

@Controller

public class DiabatiesController {

    @Autowired
    DiabatiesService diabatiesService;

    @PostMapping("/insertRecords")
    public String insertRecords(@RequestParam("pregnancies") String pregnancies,
    @RequestParam("glucose") String glucose,
    @RequestParam("blood_pressure") String blood_pressure,
    @RequestParam("skin_thickness") String skin_thickness,
    @RequestParam("insulin") String insulin,
    @RequestParam("bmi") String bmi,
    @RequestParam("diabetes_pedigree") String diabetes_pedigree,
    @RequestParam("age") String age,
    @RequestParam("userid") String userid,Model model){

        DiabatiesModel dm=new DiabatiesModel();
        dm.setPregnancies(Integer.parseInt(pregnancies));
        dm.setGlucose(Integer.parseInt(glucose));
        dm.setBlood_pressure(Integer.parseInt(blood_pressure));
        dm.setSkin_thickness(Integer.parseInt(skin_thickness));
        dm.setInsulin(Integer.parseInt(insulin));
        dm.setDiabetes_pedigree(Integer.parseInt(diabetes_pedigree));
        dm.setAge(Integer.parseInt(age));
        dm.setBmi(Integer.parseInt(bmi));
        dm.setUserid(Integer.parseInt(userid));

        DiabatiesModel dm2=diabatiesService.insertDiabeties(dm);
        if(dm2==null){

            model.addAttribute("msg", "Data not inserted");
            model.addAttribute("upload", "upload");
            return "index";

        }else{
            model.addAttribute("msg", "Data inserted");
            model.addAttribute("upload", "upload");
            return "index";
            
        }
       

    }

    @GetMapping("/view1/{userId}")
public String getFiles(@PathVariable String userId,Model model, HttpSession session){
  
   List<DiabatiesModel> dm= diabatiesService.getAllResultsOfOneUser(Integer.parseInt(userId));
   model.addAttribute("view", "view");
   model.addAttribute("results", dm);

    return "index";
}
    
}
