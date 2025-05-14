package com.shufitapp.shufit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Rutina;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Integer> {


}
