package com.acem.acemanager.repository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AcemRepository {
    
    List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
    }

    public Member getMember(int index) {
        return this.members.get(index);
    }

    public void updateMember(int index, Member newMember) {
        this.members.set(index, newMember);
    }

    public void deleteMember(int index) {
        this.members.remove(index);
    }

    public List<Member> getMembers() {
        return this.members;
    }
}
