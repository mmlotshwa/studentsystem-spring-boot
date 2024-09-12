/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.RegistrationRepository;
import com.mandla.studentsystem_spring_boot.model.Registration;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    
    public Registration createRegistration(Registration registration){
        return registrationRepository.save(registration);
    }
    
    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll();
    }
    
    public Registration getRegistrationById(Integer registrationid){
        return registrationRepository.findById(registrationid).orElse(null);
    }
    
    public Registration updateRegistration(Integer registrationid, Registration registration){
        registration.setRegistrationid(registrationid);
        return registrationRepository.save(registration);
    }
    
    public void deleteRegistration(Integer registrationid){
        registrationRepository.deleteById(registrationid);
    }
}
