package com.example.demo.Service;

import com.example.demo.Model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Admin service.
 */
@Service
public interface IAdminService {
    /**
     * Save admin admin.
     *
     * @param newAdmin the new admin
     * @return the admin
     */
    Admin saveAdmin(Admin newAdmin);

    /**
     * Gets admin list.
     *
     * @return the admin list
     */
    List<Admin> getAdminList();

    /**
     * Gets admin by id.
     *
     * @param findId the id of the Admin that needs to be found
     * @return the admin
     */
    Admin findAdminById(Long findId);

    /**
     * Update admin admin.
     *
     * @param toUpdate the to update
     * @param adminID  the admin id
     * @return the admin
     */
    Admin updateAdmin(Admin toUpdate, Long adminID);

    /**
     * Delete admin by id.
     *
     * @param toDelete the to delete
     */
    void deleteAdminById(Long toDelete);
}
