package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propserv;
	
	//Create
	@PostMapping("/insertProperty")
	public PropertyEntity insertProperty(@RequestBody PropertyEntity property) {
		return propserv.insertProperty(property);
	}
	
	//Read
	@GetMapping("/getAllProperty")
	public List<PropertyEntity> getAllProperty(){
		return propserv.getAllProperty();
	}
	
	//Update
	@PutMapping("/updateProperty")
	public PropertyEntity updateProperty(@RequestParam int propid, @RequestBody PropertyEntity newproperty) {
		return propserv.updateProperty(propid, newproperty);
	}
	
	//Delete
	@DeleteMapping("/deleteProperty/{propid}")
	public String deleteProperty(@PathVariable int propid) {
		return propserv.deleteProperty(propid);
	}
}
