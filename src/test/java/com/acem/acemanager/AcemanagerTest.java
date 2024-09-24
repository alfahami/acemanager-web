package com.acem.acemanager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.acem.acemanager.constants.Constants;
import com.acem.acemanager.pojo.Member;
import com.acem.acemanager.repository.AcemRepository;
import com.acem.acemanager.service.AcemService;

@RunWith(MockitoJUnitRunner.class)
public class AcemanagerTest {
    // Tet all business

    @Mock
    private AcemRepository acemRepository;

    @InjectMocks
    private AcemService acemService;

    @Test
    public void getMembersFromRepoTest() {
        when(acemRepository.getMembers()).thenReturn(Arrays.asList(
                new Member("NBE388507", "Tupac", "Shakur", "altoihir@gmail.com", 20111473, true),
                new Member("NBE388597", "Notorius", "Biggie", "ntbig@gmail.com", 20115473, false)));

        List<Member> result = acemRepository.getMembers();

        assertEquals("NBE388507", result.get(0).getPassport());
        assertEquals(false, result.get(1).getIsMember());
    }

    @Test
    public void MemberIndexTest() {
        // 1. Mock the data of the service method
        Member tech = new Member("NBE388597", "Notorius", "Biggie", "ntbig@gmail.com", 20115473, false);
        when(acemRepository.getMembers()).thenReturn(Arrays.asList(
                tech));

        // 2. Act
        int valid = acemService.getMemberIndex(tech.getId());
        int notFound = acemService.getMemberIndex("123");

        // 3. Assert
        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);

    }

    @Test
    public void returnMemberByIdTest() {
        // 1. Mock the data of the service method
        Member tech = new Member("NBE388597", "Notorius", "Biggie", "ntbig@gmail.com", 20115473, false);
        when(acemRepository.getMembers()).thenReturn(Arrays.asList(
                tech));
        when(acemRepository.getMember(0)).thenReturn(tech);

        // 2. Act
        String id = tech.getId();
        Member result = acemService.getMemberById(id);

        //3. Assert
        assertEquals(tech, result);
    }

    @Test
    public void addMemberTest() {
        //1. Mock
        Member tech = new Member("NBE388597", "Notorius", "Biggie", "ntbig@gmail.com", 20115473, false);
        when(acemRepository.getMembers()).thenReturn(Arrays.asList(
                tech));
        
        Member newMember = new Member("NBE388597", "Tupac", "Shakur", "ntbig@gmail.com", 20115473, false);
        acemService.submitForm(newMember);
        verify(acemRepository, times(1)).addMember(newMember);
    }

    @Test
    public void updateMemberTest() {
        
    }

}
