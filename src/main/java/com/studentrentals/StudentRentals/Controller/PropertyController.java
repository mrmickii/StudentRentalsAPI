package com.studentrentals.StudentRentals.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
	
	 @GetMapping("/{propid}")
	    public ResponseEntity<Resource> getImageByPropertyId(@PathVariable int propid) {
	        try {
	            byte[] imageBytes = propserv.getImageByPropertyId(propid);

	            if (imageBytes != null) {
	                // Assuming your images are in a directory named "images"
	                ByteArrayResource resource = new ByteArrayResource(imageBytes);

	                return ResponseEntity.ok()
	                        .contentLength(imageBytes.length)
	                        .header("Content-type", "image/png") // Adjust the content type based on your image type
	                        .header("Content-disposition", "inline; filename=image.png")
	                        .body(resource);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(500).build(); // Handle exceptions appropriately
	        }
	    }
	
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
	public PropertyEntity updateProperty(
	    @PathVariable int propid,
	    @RequestBody PropertyEntity newPropertyDetails) {
	    
	    // Extract data from newPropertyDetails object as needed
	    String name = newPropertyDetails.getName();
	    String address = newPropertyDetails.getAddress();
	    int price = newPropertyDetails.getPrice();
	    String type = newPropertyDetails.getType();
	    int size = newPropertyDetails.getSize();
	    int numbeds = newPropertyDetails.getNumbeds();

	    return propserv.updateProperty(propid, name, address, price, type, size, numbeds, newPropertyDetails);
	}


	@DeleteMapping("/deleteProperty/{propid}")
	public String deleteProperty(@PathVariable int propid) {
		return propserv.deleteProperty(propid);
	}
}
