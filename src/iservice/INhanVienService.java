/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import domainmodel.NhanVien;
import java.util.ArrayList;
import viewmodel.ViewModelNhanVien;

/**
 *
 * @author Admin
 */
public interface INhanVienService {
    public ArrayList<ViewModelNhanVien> getAll();
    public String getIdNhanVienByTenNhanVien(String tenNhanVien);
    public String insert(ViewModelNhanVien viewModelNhanVien);
    public String delete(String ma);
    public String update(String ma, ViewModelNhanVien viewModelNhanVien);
}
