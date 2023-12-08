package com.studentrentals.StudentRentals.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Entity.StudentEntity;
import com.studentrentals.StudentRentals.Service.PropertyService;

@RestController
@RequestMapping("/studentrentals")
@CrossOrigin
public class PropertyController {

	@Autowired
	PropertyService propserv;
	
	@PostMapping("/insertProperty")
    public PropertyEntity insertProperty(@RequestParam String name,
    									 @RequestParam String address,
                                         @RequestParam int price,
                                         @RequestParam String type,
                                         @RequestParam int size,
                                         @RequestParam int numbeds,
                                         @RequestPart(value = "image", required = false) MultipartFile imageFile) throws IOException {
        return propserv.insertProperty(name, address, price, type, size, numbeds, imageFile);
    }

	@GetMapping("/getAllProperty")
	public List<PropertyEntity> getAllProperty(){
		return propserv.getAllProperty();
	}

	@PutMapping("/updateProperty/{propid}")
    public PropertyEntity updateProperty(@PathVariable int propid,
    									 @RequestParam String name,
                                         @RequestParam String address,
                                         @RequestParam int price,
                                         @RequestParam String type,
                                         @RequestParam int size,
                                         @RequestParam int numbeds,
                                         @RequestBody PropertyEntity newPropertyDetails) {
        return propserv.updateProperty(propid, name, address, price, type, size, numbeds, newPropertyDetails);
    }

	@DeleteMapping("/deleteProperty/{propid}")
	public String deleteProperty(@PathVariable int propid) {
		return propserv.deleteProperty(propid);
	}
}
