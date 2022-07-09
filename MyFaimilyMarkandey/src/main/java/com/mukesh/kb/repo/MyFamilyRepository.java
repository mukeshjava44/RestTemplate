package com.mukesh.kb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukesh.kb.entity.MyFamily;

public interface MyFamilyRepository extends JpaRepository<MyFamily, Integer> {

}
