/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.List;
import domainmodel.SanPham;
import viewmodel.ViewModelSanPham;

/**
 *
 * @author Admin
 */
public interface ISanPhamService {

    public List<ViewModelSanPham> getAll(); // loadd 

    public String insert(ViewModelSanPham viewModelSanPham);

    public String update(String ma, ViewModelSanPham viewModelSanPham);

    public String deleteSanPhamAndChiTietSP(String ma);
//    public String  getByMa(String ma);

    public String idSanPhamByTen(String tenSP);

}
