package com.example.demo.Service;

import com.example.demo.Model.Admin;
import com.example.demo.Repos.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * The type Admin service.
 */
@Service
public class AdminService implements IAdminService{
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin saveAdmin(Admin newAdmin) {
        return adminRepo.save(newAdmin);
    }

    @Override
    public List<Admin> getAdminList() {
        return (List<Admin>) adminRepo.findAll();
    }

    @Override
    public Admin findAdminById(Long foundId){
        return adminRepo.findById(foundId).get();
    }

    @Override
    public Admin updateAdmin(Admin toUpdate, Long adminID) {
        Admin updatedAdmin = adminRepo.findById(adminID).get();

        if(Objects.nonNull(toUpdate.getFirstName())
                && !"".equalsIgnoreCase(toUpdate.getFirstName())){
            updatedAdmin.setFirstName(toUpdate.getFirstName());
        }

        if(Objects.nonNull(toUpdate.getLastName())
                && !"".equalsIgnoreCase(toUpdate.getLastName())){
            updatedAdmin.setLastName(toUpdate.getLastName());
        }

        if(Objects.nonNull(toUpdate.getEmail())
                && !"".equalsIgnoreCase(toUpdate.getEmail())){
            updatedAdmin.setEmail(toUpdate.getEmail());
        }

        if(Objects.nonNull(toUpdate.getPassword())
                && !"".equalsIgnoreCase(toUpdate.getPassword())){
            updatedAdmin.setEmail(toUpdate.getPassword());
        }

        return adminRepo.save(updatedAdmin);
    }

    @Override
    public void deleteAdminById(Long toDelete) {
        adminRepo.deleteById(toDelete);
    }
}
