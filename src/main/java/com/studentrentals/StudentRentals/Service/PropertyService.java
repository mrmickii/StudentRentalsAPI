package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepository prepo;
	
	//Create or insert a property/dorm
	public PropertyEntity insertProperty(PropertyEntity property) {
		return prepo.save(property);
	}
	
	public List<PropertyEntity> getAllProperty(){
		return prepo.findAll();
	}
		
	//Update 
	@SuppressWarnings("finally")
	public PropertyEntity updateProperty(int propid, PropertyEntity newproperty) {
		
		PropertyEntity property = new PropertyEntity();
		
		try {
			property = prepo.findById(propid).get();
			
			property.setAddress(newproperty.getAddress());
			property.setPrice(newproperty.getPrice());
			property.setType(newproperty.getType());
			property.setPrice(newproperty.getPrice());
			property.setNumbeds(newproperty.getNumbeds());
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Property " +propid+ " does not exist!");
		}finally {
			return prepo.save(property);
		}
	}
	
	public String deleteProperty(int propid) {
		String msg = "";
		
		if(prepo.findById(propid) != null) {
			prepo.deleteById(propid);
			msg = "Property " +propid+ " is successfully deleted";
		}else {
			msg = "Property " +propid+ " does not exists";
		}
		return msg;
	}
}
