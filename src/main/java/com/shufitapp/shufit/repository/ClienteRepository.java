package com.shufitapp.shufit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shufitapp.shufit.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
