package com.acem.acemanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.acem.acemanager.pojo.Member;
import com.acem.acemanager.service.AcemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AcemController {

    @Autowired
    private AcemService acemService;

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMember(@PathVariable String id) {
        Member member = acemService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.valueOf(200));
    }

    @PostMapping("/member/create")
    public ResponseEntity<HttpStatus> createMember(@RequestBody Member member) {
        acemService.addMember(member);
        return new ResponseEntity<>(HttpStatus.valueOf(201));
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member member) {
        acemService.updateMember(acemService.getMemberIndex(id), member);

        return new ResponseEntity<>(member, HttpStatus.valueOf(200));
    }

    @GetMapping("/member/all")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = acemService.getMembers();

        return new ResponseEntity<>(members, HttpStatus.valueOf(200));
    }

    @GetMapping("/addMember")
    public String getMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "addMember";
    }

    @GetMapping("/editMember")
    public String editMember(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("member", acemService.getMemberById(id));
        return "addMember";
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute("members", acemService.getMembers());
        return "listMembers";
    }

    @PostMapping("/submitMember")
    public String submitMember(@Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addMember";
        acemService.submitForm(member);

        return "redirect:/members";
    }
}
