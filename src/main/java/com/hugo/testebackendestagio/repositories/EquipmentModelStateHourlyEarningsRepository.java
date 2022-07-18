package com.hugo.testebackendestagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo.testebackendestagio.entities.EquipmentModelStateHourlyEarnings;
import com.hugo.testebackendestagio.entities.pk.EquipmentModelStateHourlyEarningsPK;

@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends 
    JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsPK>{
    
}