package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Service.PropertyService;

@RestController
@RequestMapping("/studentrentals")
@CrossOrigin
public class PropertyController {

	@Autowired
	PropertyService propserv;
	
	@PostMapping("/insertProperty")
	public ResponseEntity<PropertyEntity> insertProperty(@RequestParam("file") MultipartFile file,
	                                                    @RequestParam("address") String address,
	                                                    @RequestParam("price") int price,
	                                                    @RequestParam("type") String type,
	                                                    @RequestParam("size") int size,
	                                                    @RequestParam("numbeds") int numbeds) {
		try {
			byte[] image = file.getBytes();
			PropertyEntity property = new PropertyEntity(address, price, type, size, numbeds, file);
			PropertyEntity insertedProperty = propserv.insertProperty(property);
			return new ResponseEntity<>(insertedProperty, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllProperty")
	public List<PropertyEntity> getAllProperty(){
		return propserv.getAllProperty();
	}

	@PutMapping("/updateProperty/{propid}")
	public ResponseEntity<PropertyEntity> updateProperty(@PathVariable int propid,
	                                                     @RequestParam("file") MultipartFile file,
	                                                     @RequestParam("address") String address,
	                                                     @RequestParam("price") int price,
	                                                     @RequestParam("type") String type,
	                                                     @RequestParam("size") int size,
	                                                     @RequestParam("numbeds") int numbeds) {
		try {
			byte[] image = file.getBytes();
			PropertyEntity newproperty = new PropertyEntity(address, price, type, size, numbeds, file);
			PropertyEntity updatedProperty = propserv.updateProperty(propid, newproperty);
			return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteProperty/{propid}")
	public ResponseEntity<String> deleteProperty(@PathVariable int propid) {
		String msg = propserv.deleteProperty(propid);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
