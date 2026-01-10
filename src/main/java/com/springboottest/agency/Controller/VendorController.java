package com.springboottest.agency.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboottest.agency.Entity.VendorUser;
import com.springboottest.agency.Service.InventoryService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<VendorUser> addVendor(@RequestBody VendorUser vendor) {
        return ResponseEntity.ok(inventoryService.addVendor(vendor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<VendorUser>> getAllVendors() {
        return ResponseEntity.ok(inventoryService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVendorById(@PathVariable Long id) {
        VendorUser vendor = inventoryService.getVendorById(id);
        return vendor != null ? ResponseEntity.ok(vendor)
                : ResponseEntity.status(404).body("Vendor Not Found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVendor(
            @PathVariable Long id,
            @RequestBody VendorUser vendor
    ) {
        VendorUser updated = inventoryService.updateVendor(id, vendor);

        return updated != null ?
                ResponseEntity.ok(updated) :
                ResponseEntity.status(404).body("Vendor Not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        boolean deleted = inventoryService.deleteVendor(id);

        return deleted
                ? ResponseEntity.ok("Vendor Deleted Successfully")
                : ResponseEntity.status(404).body("Vendor Not Found");
    }
}
