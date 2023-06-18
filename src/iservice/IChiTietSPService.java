/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import domainmodel.ChiTietSP;
import java.util.ArrayList;
import viewmodel.ViewModelChiTietSP;

/**
 * public String getTenMauSacById(String id); public String
 * getTenSanPhamById(String id); public String getTenNSXById(String id); public
 * String getTenDongSPById(String id);
 *
 *
 * @author Admin
 */
public interface IChiTietSPService {

    public ArrayList<ViewModelChiTietSP> getAll();

    public String insert(ViewModelChiTietSP viewModelChiTietSP);

    public String delete(String id);

    public String update(String id, ViewModelChiTietSP viewModelChiTietSP);

//    public ArrayList<ViewModelChiTietSP> getFindByTen(String tenSanPham);
//
//    public void updateSoLuongChiTietSP(int soLuong, String ma);
//    
//    public ViewModelChiTietSP getSanPhamByMaSP(String maSP);
}
