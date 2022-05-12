package com.example.demo.BLL;

import com.example.demo.BLL.Validators.BookValidators.ISBNValidator;
import com.example.demo.Model.Book;
import com.example.demo.Model.Material;
import com.example.demo.Model.Video;

/**
 * The type Material factory.
 */
public class MaterialFactory {
    private static final MaterialFactory materialFactory = new MaterialFactory();

    /**
     * Get instance material factory.
     *
     * @return the material factory
     */
    public static MaterialFactory getInstance(){
        return materialFactory;
    }
    private MaterialFactory(){}

    /**
     * Create material material.
     *
     * @param materialType the material type
     * @param title        the title
     * @param author       the author
     * @param ISBN         the isbn
     * @return the material
     */
    public Material createMaterial(MaterialType materialType, String title, String author, String ISBN){
        switch(materialType){
            case BOOK:
                ISBNValidator.getInstance().validate(ISBN);

                return new Book(title, author, "genre", ISBN, "publisher", 2012, "");
            case VIDEO:
                return new Video();
        }
        return null;
    }
}
