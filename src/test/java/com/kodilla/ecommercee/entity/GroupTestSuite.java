package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class GroupTestSuite {

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void testFindAllGroups() {
        //Given
        Group group;
        //When
        for(int i = 0; i < 5; i ++) {
            String name = "Group of products: " + i;
            group = new Group(name);
            groupRepository.save(group);
        }
        //Then
        assertEquals(5, groupRepository.count());
    }

    @Test
    public void testFindGroupById() {
        //Given
        Group group = new Group("RTV");
        //When
        groupRepository.save(group);
        Long groupId = group.getId();
        Optional<Group> testId = groupRepository.findById(groupId);
        //Then
        assertEquals(groupId, testId.get().getId());
    }

    @Test
    public void testFindGroupByName() {
        // Given
        Group group = new Group("Electronics");
        // When
        groupRepository.save(group);
        Optional<Group> groupName = groupRepository.findByName("Electronics");
        // Then
        assertEquals("Electronics", groupName.get().getName());
    }

    @Test
    public void testDeleteGroupByName() {
        // Given
        Group group1 = new Group("Electronics");
        Group group2 = new Group("RTV");

        groupRepository.save(group1);
        groupRepository.save(group2);
        // When
        groupRepository.deleteByName("RTV");
        // Then
        assertEquals(1 , groupRepository.findAll().size());
    }

    @Test
    public void testDeleteGroupById() {
        // Given
        Group group1 = new Group("Electronics");
        Group group2 = new Group("RTV");
        Group group3 = new Group("Toys");

        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        Long group1Id = group1.getId();

        // When
        groupRepository.deleteById(group1Id);
        // Then
        assertEquals(2 , groupRepository.findAll().size());
    }
}
