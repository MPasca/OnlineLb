package com.example.demo.Repos;

import com.example.demo.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, String> {
    List<Material> findAll();
    Material findMaterialById(Long id);
}
