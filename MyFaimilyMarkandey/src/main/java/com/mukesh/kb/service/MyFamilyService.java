package com.mukesh.kb.service;

import java.util.List;

import com.mukesh.kb.entity.MyFamily;

public interface MyFamilyService {
	
	public List<MyFamily> getAllMyFamilies();
	
	public MyFamily getOneMyFamily(int id);
	
	public int saveMyFamily(MyFamily family);
	
	public String deleteFamily(int id);
	
	public void updateFamily(MyFamily family);

}
