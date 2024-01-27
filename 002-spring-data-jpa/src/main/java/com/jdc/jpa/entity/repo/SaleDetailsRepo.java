package com.jdc.jpa.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.jpa.entity.SaleDetails;
import com.jdc.jpa.entity.SaleDetailsPk;

public interface SaleDetailsRepo extends JpaRepository<SaleDetails, SaleDetailsPk>{

}
