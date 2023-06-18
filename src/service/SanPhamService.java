/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import iservice.ISanPhamService;
import java.util.List;
import domainmodel.SanPham;
import irepository.ISanPhamRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.SanPhamRepository;
import viewmodel.ViewModelSanPham;

/**
 *
 * @author Admin
 */
public class SanPhamService implements ISanPhamService {

    private ISanPhamRepository iSanPhamRepository = new SanPhamRepository();

    @Override
    public List<ViewModelSanPham> getAll() {
        ArrayList<SanPham> listSanPham = iSanPhamRepository.getListSanPham();
        ArrayList<ViewModelSanPham> listViewModelSanPham = new ArrayList();
        for (SanPham sanPham : listSanPham) {
            ViewModelSanPham viewModelSanPham = new ViewModelSanPham();
            viewModelSanPham.setId(sanPham.getId());
            viewModelSanPham.setMa(sanPham.getMa());
            viewModelSanPham.setTen(sanPham.getTen());
            listViewModelSanPham.add(viewModelSanPham);
        }
        return listViewModelSanPham;
    }

    @Override
    public String insert(ViewModelSanPham viewModelSanPham) {
        SanPham sanPham = new SanPham();
        sanPham.setMa(viewModelSanPham.getMa());
        sanPham.setTen(viewModelSanPham.getTen());
        // check rỗng 
        if (sanPham.getMa().trim().equals("") || sanPham.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }
        // check trùng mã 
        if (iSanPhamRepository.kiemTraMaTrung(viewModelSanPham.getMa())) {
            return " Mã đã trùng";
        }

        if (iSanPhamRepository.insert(sanPham)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String update(String ma, ViewModelSanPham viewModelSanPham) {
        SanPham sanPham = new SanPham();
        sanPham.setMa(viewModelSanPham.getMa());
        sanPham.setTen(viewModelSanPham.getTen());
        // check rỗng 
        if (sanPham.getMa().trim().equals("") || sanPham.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }

        if (iSanPhamRepository.update(ma, sanPham)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }

    }

    @Override
    public String deleteSanPhamAndChiTietSP(String ma) {
        iSanPhamRepository.getIdByMaSanPham(ma);
        
        if (iSanPhamRepository.deleteSanPhamAndChiTietSP(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

//    @Override
//    public String getByMa(String ma) {
//      return   sanPhamRepository.getByMa(ma);
//    }
    @Override
    public String idSanPhamByTen(String tenSP) {
        return iSanPhamRepository.idSanPhamByTen(tenSP);
    }

}
