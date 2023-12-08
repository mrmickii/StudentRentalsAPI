package com.studentrentals.StudentRentals.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;
import com.studentrentals.StudentRentals.Repository.PropertyRepository;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImageController {

    // Assuming your images are stored in the database as byte arrays

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/{propid}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable int propid) {
        PropertyEntity property = propertyRepository.findById(propid).orElse(null);

        if (property != null && property.getImage() != null) {
            ByteArrayResource resource = new ByteArrayResource(property.getImage());
            return ResponseEntity.ok()
                    .contentLength(property.getImage().length)
                    .contentType(MediaType.IMAGE_JPEG) // Adjust the MediaType based on your image type
                    .body(resource);
        } else {
            // Return a placeholder image or handle the case where the image is not found
            return ResponseEntity.notFound().build();
        }
    }
}
