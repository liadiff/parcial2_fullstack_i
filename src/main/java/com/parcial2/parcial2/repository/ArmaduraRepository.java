package com.parcial2.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.model.Armadura;
@Repository
public interface ArmaduraRepository  extends JpaRepository<Armadura, Integer> {

}