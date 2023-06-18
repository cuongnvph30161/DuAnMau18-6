/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.CuaHang;
import irepository.ICuaHangRepository;
import irepository.IKhachHangRepository;
import irepository.INhanVienRepository;
import iservice.ICuaHangService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.CuaHangRepository;
import repositpry.NhanVienRepository;
import viewmodel.ViewModelCuaHang;

/**
 *
 * @author Admin
 */
public class CuaHangService implements ICuaHangService {

    public ICuaHangRepository iCuaHangRepository = new CuaHangRepository();
    public INhanVienRepository iNhanVienRepository = new NhanVienRepository();
    @Override
    public ArrayList<ViewModelCuaHang> getAll() {
        ArrayList<CuaHang> listCuaHangs = iCuaHangRepository.listGetCuaHang();
        ArrayList<ViewModelCuaHang> listViewModelCuaHangs = new ArrayList();
        for (CuaHang cuaHang : listCuaHangs) {
            ViewModelCuaHang viewModelCuaHang = new ViewModelCuaHang();
            viewModelCuaHang.setMa(cuaHang.getMa());
            viewModelCuaHang.setTen(cuaHang.getTen());
            viewModelCuaHang.setDiaChi(cuaHang.getDiaChi());
            viewModelCuaHang.setThanhPho(cuaHang.getThanhPho());
            viewModelCuaHang.setQuocGia(cuaHang.getQuocGia());
            listViewModelCuaHangs.add(viewModelCuaHang);
        }
        return listViewModelCuaHangs;

    }

    @Override
    public String insert(ViewModelCuaHang viewModelCuaHang) {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(viewModelCuaHang.getMa());
        cuaHang.setTen(viewModelCuaHang.getTen());
        cuaHang.setDiaChi(viewModelCuaHang.getDiaChi());
        cuaHang.setThanhPho(viewModelCuaHang.getThanhPho());
        cuaHang.setQuocGia(viewModelCuaHang.getQuocGia());
        
        if (cuaHang.getMa().trim().equals("") || cuaHang.getTen().trim().equals("") || cuaHang.getDiaChi().trim().equals("") || cuaHang.getThanhPho().trim().equals("") || cuaHang.getQuocGia().trim().equals("")) {
            return "Không được rỗng";
        }
        // check mã trùng 
        if(iCuaHangRepository.kiemTraMaTrung(viewModelCuaHang.getMa())||iCuaHangRepository.kiemTraTenTrung(viewModelCuaHang.getTen())){
            return "Mã và tên không được trùng";
        }
        
        if (iCuaHangRepository.insert(cuaHang)) {
            return "Đã thêm";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        iNhanVienRepository.deleteCuaHangAndNhanVien(iCuaHangRepository.getIdByMa(ma));
        if (iCuaHangRepository.delete(ma)) {
            return "Đã xoá";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelCuaHang viewModelCuaHang) {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setMa(viewModelCuaHang.getMa());
        cuaHang.setTen(viewModelCuaHang.getTen());
        cuaHang.setDiaChi(viewModelCuaHang.getDiaChi());
        cuaHang.setThanhPho(viewModelCuaHang.getThanhPho());
        cuaHang.setQuocGia(viewModelCuaHang.getQuocGia());
        if (cuaHang.getMa().trim().equals("") || cuaHang.getTen().trim().equals("") || cuaHang.getDiaChi().trim().equals("") || cuaHang.getThanhPho().trim().equals("") || cuaHang.getQuocGia().trim().equals("")) {
            return "Không được rỗng";
        }
         if (!ma.equals(cuaHang.getMa())) {
            return "Mã sản phẩm không được thay đổi";
        }
        if (iCuaHangRepository.update(ma, cuaHang)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String getIdByTenCuaHang(String ten) {
        return iCuaHangRepository.getIdByTenCuaHang(ten);
    }

}
