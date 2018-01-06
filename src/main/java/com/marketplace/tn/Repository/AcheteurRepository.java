/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.tn.model.Acheteur;


public interface AcheteurRepository extends JpaRepository<Acheteur, Long> {
    
}
