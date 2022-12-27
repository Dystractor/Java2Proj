package com.example.springproject.Controller;

import com.example.springproject.Entity.Commits;
import com.example.springproject.service.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//@Controller
//@RequestMapping("/commits")
//public class CommitsController {
//    @Autowired
//    CommitsService commitsService;
//    @GetMapping("/findAll")
//    public String findAll(Model model){
//        List<Commits> commitsList = commitsService.findAll();
//        System.out.println(commitsList);
//        model.addAttribute("commitsList",commitsList);
//        return "commitsList";
//    }
//}
