package com.acem.acemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.acem.acemanager.pojo.Member;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AcemController {
    
    @GetMapping("/addMember")
    public String getMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "addMember";
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        
        return "listMembers";
    }
    

    @PostMapping("/submitMember")
    public String postMethodName(@Valid Member member, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "addMember";
        
        return "redirect:/members";
    }
    
    
}
