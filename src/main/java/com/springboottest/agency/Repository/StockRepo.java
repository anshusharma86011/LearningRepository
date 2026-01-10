package com.springboottest.agency.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboottest.agency.Entity.StockManagement;

@Repository
public interface StockRepo extends JpaRepository<StockManagement, Long>{


}
