package com.acem.acemanager.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acem.acemanager.repository.AcemRepository;

@Service
public class AcemService {
    
    @Autowired
    private AcemRepository acemRepository;

    public void addMember(Member member) {
        this.acemRepository.addMember(member);
    }

    public Member getMember(int index) {
        return this.acemRepository.getMember(index);
    }

    public void updateMember(int index, Member member) {
        this.acemRepository.updateMember(index, member);
    }

    public void deleteMember(int index) {
        this.acemRepository.deleteMember(index);
    }

    public List<Member> getMembers() {
        return this.acemRepository.getMembers();
    }
}
