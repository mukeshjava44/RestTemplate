package com.mukesh.kb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.kb.entity.MyFamily;
import com.mukesh.kb.exception.MyFamilyNotFoundException;
import com.mukesh.kb.repo.MyFamilyRepository;

@SuppressWarnings("unused")
@Service
public class MyFamilyServiceImpl implements MyFamilyService {
	
	@Autowired
	private MyFamilyRepository repo;

	

				@Override
				public List<MyFamily> getAllMyFamilies() {
					return repo.findAll();
				}

				@Override
				public MyFamily getOneMyFamily(int id) {
					return repo.findById(id).orElseThrow(
							() -> new MyFamilyNotFoundException("Family member not found with ID : "+id)
							);
				}

				@Override
				public int saveMyFamily(MyFamily family) {
					return repo.save(family).getId();
				}

				@Override
				public String deleteFamily(int id) {
					repo.delete(getOneMyFamily(id));
					return "One Member from family removed";
				}

				@Override
				public void updateFamily(MyFamily family) {
					Integer id = Integer.valueOf(family.getId());
					if(id!=null && repo.existsById(id)) {
					repo.save(family) ;
					}
					else {
						throw new MyFamilyNotFoundException("Family member not found with ID : "+id);
					}
					
				}

}
