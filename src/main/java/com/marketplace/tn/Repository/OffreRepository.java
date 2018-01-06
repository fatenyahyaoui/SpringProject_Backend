package com.marketplace.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.tn.model.Offre;
@Repository
public interface OffreRepository extends JpaRepository<Offre, Integer> {

	
}