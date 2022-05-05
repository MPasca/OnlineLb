package com.example.demo.BLL;

import com.example.demo.BLL.Validators.MaterialsValidators.ISBNValidator;
import com.example.demo.Model.Book;
import com.example.demo.Model.Material;
import com.example.demo.Model.Video;

public class MaterialFactory {
    private static final MaterialFactory materialFactory = new MaterialFactory();
    public static MaterialFactory getInstance(){
        return materialFactory;
    }
    private MaterialFactory(){}

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
