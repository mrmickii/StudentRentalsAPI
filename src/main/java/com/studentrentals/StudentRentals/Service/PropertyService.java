package com.studentrentals.StudentRentals.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Repository.PropertyRepository;
import com.studentrentals.StudentRentals.Util.ImageUtil;

@Service
@CrossOrigin
public class PropertyService {
	
	@Autowired
	PropertyRepository prepo;
	
	public byte[] getImageByPropertyId(int propid) {
        PropertyEntity property = prepo.findById(propid).orElseThrow(() -> new NoSuchElementException("Property " + propid + " does not exist!"));

        // Assuming your image is stored as a byte array in the 'image' field of PropertyEntity
        byte[] imageBytes = property.getImage();

        return imageBytes;
    }
	
	public PropertyEntity insertProperty(String name, String address, int price, String type, int size, int numbeds, MultipartFile imageFile) throws IOException {
        PropertyEntity property = new PropertyEntity(name, address, price, type, size, numbeds, null);
        
        if (imageFile != null) {
            property.setImage(ImageUtil.compressImage(imageFile.getBytes()));
        }

        return prepo.save(property);
    }	


	public List<PropertyEntity> getAllProperty(){
		return prepo.findAll();
	}
	
	public PropertyEntity getPropertyById(int propid) {
	    return prepo.findById(propid)
	            .orElse(null);
	}

	public PropertyEntity updateProperty(int propid, String name, String address, int price, String type, int size, int numbeds, PropertyEntity newproperty) {
        PropertyEntity property = prepo.findById(propid).orElseThrow(() -> new NoSuchElementException("Property " + propid + " does not exist!"));

        property.setName(name);
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
