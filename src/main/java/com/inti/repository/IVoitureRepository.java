package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Voiture;

@Repository
public interface IVoitureRepository extends JpaRepository<Voiture, Integer> {

}
