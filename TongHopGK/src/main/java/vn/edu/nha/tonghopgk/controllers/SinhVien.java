package vn.edu.nha.tonghopgk.controllers;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class SinhVien {
    private String mssv;
    private String hoTen;
    private double diemTb;

    public SinhVien(String mssv, String hoTen, double diemTb) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemTb = diemTb;
    }
}