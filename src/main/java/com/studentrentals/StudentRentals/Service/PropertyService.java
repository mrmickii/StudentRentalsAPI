package com.studentrentals.StudentRentals.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Repository.PropertyRepository;
import com.studentrentals.StudentRentals.Util.ImageUtil;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepository prepo;
	
	public PropertyEntity insertProperty(String address, int price, String type, int size, int numbeds, MultipartFile imageFile) throws IOException {
        PropertyEntity property = new PropertyEntity(address, price, type, size, numbeds, null);
        
        if (imageFile != null) {
            property.setImage(ImageUtil.compressImage(imageFile.getBytes()));
        }

        return prepo.save(property);
    }


	public List<PropertyEntity> getAllProperty(){
		return prepo.findAll();
	}

	public PropertyEntity updateProperty(int propid, String address, int price, String type, int size, int numbeds, PropertyEntity newproperty) {
        PropertyEntity property = prepo.findById(propid).orElseThrow(() -> new NoSuchElementException("Property " + propid + " does not exist!"));

        property.setAddress(address);
        property.setPrice(price);
        property.setType(type);
        property.setSize(size);
        property.setNumbeds(numbeds);

        // If new image is provided, update it
        if (newproperty.getImage() != null) {
            property.setImage(newproperty.getImage());
        }

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
