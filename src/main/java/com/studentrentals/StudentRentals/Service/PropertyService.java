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
	
	public PropertyEntity insertProperty(PropertyEntity property) {
		return prepo.save(property);
	}

	public List<PropertyEntity> getAllProperty(){
		return prepo.findAll();
	}

	public PropertyEntity updateProperty(int propid, PropertyEntity newproperty) {
		PropertyEntity property = prepo.findById(propid).orElseThrow(() -> new NoSuchElementException("Property " + propid + " does not exist!"));

		property.setAddress(newproperty.getAddress());
		property.setPrice(newproperty.getPrice());
		property.setType(newproperty.getType());
		property.setSize(newproperty.getSize());
		property.setNumbeds(newproperty.getNumbeds());
		property.setFile(newproperty.getFile());

		return prepo.save(property);
	}

	public String deleteProperty(int propid) {
		if(prepo.existsById(propid)) {
			prepo.deleteById(propid);
			return "Property " + propid + " is successfully deleted";
		} else {
			return "Property " + propid + " does not exist";
		}
	}
}
