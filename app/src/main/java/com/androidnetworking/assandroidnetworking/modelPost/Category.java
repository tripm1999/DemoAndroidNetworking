package com.androidnetworking.assandroidnetworking.modelPost;

public class Category {
    private int hinhAnh;
    private String nameCategory;
    private String soPhanTu;

    public Category(int hinhAnh, String nameCategory, String soPhanTu) {
        this.hinhAnh = hinhAnh;
        this.nameCategory = nameCategory;
        this.soPhanTu = soPhanTu;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getSoPhanTu() {
        return soPhanTu;
    }

    public void setSoPhanTu(String soPhanTu) {
        this.soPhanTu = soPhanTu;
    }
}
