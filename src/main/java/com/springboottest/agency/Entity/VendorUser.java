package com.springboottest.agency.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "masterVendor")
public class VendorUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String vendorName;
      private String address;
      private String gstin_pan;
      private String contactNumber_email;
      private String bankDetails;
      private String defaultPaymentTerms;  

}
