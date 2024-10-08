package com.acem.acemanager.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acem.acemanager.constants.Constants;
import com.acem.acemanager.pojo.Member;
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

    public void toAge(Member member, Date birthDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(birthDate);
        int age = Period.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now())
                .getYears();
        member.setAge(age);
    }

    public int getMemberIndex(String id) {
        for (int i = 0; i < getMembers().size(); i++) {
            if (getMembers().get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public Member getMemberById(String id) {
        int index = getMemberIndex(id);
        return index == Constants.NOT_FOUND ? new Member() : getMember(index);
    }

    public void submitForm(Member member) {
        toAge(member, member.getBirthDate());
        int index = getMemberIndex(member.getId());
        if (index == Constants.NOT_FOUND) {
            addMember(member);
        } else {
            updateMember(index, member);
        }
    }
}
