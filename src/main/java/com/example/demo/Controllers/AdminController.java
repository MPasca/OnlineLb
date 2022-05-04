package com.example.demo.Controllers;

import com.example.demo.Model.Admin;
import com.example.demo.Service.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * it connects the front end to the backend
 */
@RestController
public class AdminController {
    /**
     * singleton for service (we're taking the data from the DB)
     */
    @Autowired
    private IAdminService adminService;

    /**
     * Create reader admin.
     *
     * @param admin - takes the input from @RequestBody and sends it to the Service
     * @return the created reader to the front-end
     * @PostMapping - Create operation we mark it as /readers because it affects the readers DB
     */
    @PostMapping("/admins")
    public Admin createReader(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    /**
     * Fetch admin list list.
     *
     * @return - returns the list
     * @GetMappping - Read operation  fetches the existing admins list from the DB and sends it to the front end
     */
    @GetMapping("/admins")
    public List<Admin> fetchAdminList(){
        return adminService.getAdminList();
    }

    /**
     * Update reader admin.
     *
     * @param toUpdate - the new Admin object containing the new information
     * @param adminID  - the id of the object that needs to be updated
     * @return - returns the updated Admin object
     * @PutMapping - Update operation  modifies an existing admin (sent by id) with the sent data
     */
    @PutMapping("/admins/{id}")
    public Admin updateReader(@RequestBody Admin toUpdate, @PathVariable("id") Long adminID){
        return adminService.updateAdmin(toUpdate, adminID);
    }

    /**
     * Delete reader string.
     *
     * @param adminID - the id of the element to be deleted
     * @return - it returns the message that the admin with the id given has been deleted successfully
     * @DeleteMapping - Delete operation  delete an existing admin sent by id
     */
    @DeleteMapping("/admins/{id}")
    public String deleteReader(@PathVariable("id") Long adminID){
        adminService.deleteAdminById(adminID);

        return "Admin " + adminID + " deleted successfully!";
    }
}
