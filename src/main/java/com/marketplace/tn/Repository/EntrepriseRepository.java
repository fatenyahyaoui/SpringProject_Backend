/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.tn.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer>{

}
