package com.example.demo.DAO;

import com.example.demo.Model.Material;
import com.example.demo.Model.User;

import java.util.List;

interface IProductDets {
    List<User> getReaders();
    List<Material> getMaterials();
}
