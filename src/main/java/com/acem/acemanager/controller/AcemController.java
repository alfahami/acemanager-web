package com.acem.acemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.acem.acemanager.pojo.Member;
import com.acem.acemanager.service.AcemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AcemController {

    @Autowired
    private AcemService acemService;
    
    @GetMapping("/addMember")
    public String getMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "addMember";
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute("members", acemService.getMembers());
        return "listMembers";
    }
    
    @PostMapping("/submitMember")
    public String postMethodName(@Valid Member member, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "addMember";
        acemService.toAge(member, member.getBirthDate());
       acemService.addMember( member);
        return "redirect:/members";
    }
    
    
}
