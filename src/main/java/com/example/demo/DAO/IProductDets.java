package com.example.demo.DAO;

import com.example.demo.Model.Material;
import com.example.demo.Model.User;

import java.util.List;

/**
 * The interface Product dets.
 */
interface IProductDets {
    /**
     * Gets readers.
     *
     * @return the readers
     */
    List<User> getReaders();

    /**
     * Gets materials.
     *
     * @return the materials
     */
    List<Material> getMaterials();
}
