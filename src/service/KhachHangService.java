/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.KhachHang;
import irepository.IKhachHangRepository;
import iservice.IKhachHangSerivce;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.KhachHangRepository;
import viewmodel.ViewModelKhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangService implements IKhachHangSerivce {

    private IKhachHangRepository iKhachHangRepository = new KhachHangRepository();

    @Override
    public ArrayList<ViewModelKhachHang> getAll() {
        ArrayList<ViewModelKhachHang> listViewModelKhachHangs = new ArrayList();
        ArrayList<KhachHang> listKhachHangs = iKhachHangRepository.getListKhachHang();
        for (KhachHang khachHang : listKhachHangs) {
            ViewModelKhachHang viewModelKhachHang = new ViewModelKhachHang();
            viewModelKhachHang.setMa(khachHang.getMa());
            viewModelKhachHang.setTen(khachHang.getTen());
            viewModelKhachHang.setTenDem(khachHang.getTenDem());
            viewModelKhachHang.setHo(khachHang.getHo());
            viewModelKhachHang.setNgaySinh(khachHang.getNgaySinh());
            viewModelKhachHang.setSoDienThoai(khachHang.getSoDienThoai());
            viewModelKhachHang.setDiaChi(khachHang.getDiaChi());
            viewModelKhachHang.setThanhPho(khachHang.getThanhPho());
            viewModelKhachHang.setQuocGia(khachHang.getQuocGia());
            viewModelKhachHang.setMatKhau(khachHang.getMatKhau());
            listViewModelKhachHangs.add(viewModelKhachHang);
        }
        return listViewModelKhachHangs;
    }

    @Override
    public String insert(ViewModelKhachHang viewModelKhachHang) {

      
        
        KhachHang khachHang = new KhachHang();
        khachHang.setMa(viewModelKhachHang.getMa());
        khachHang.setTen(viewModelKhachHang.getTen());
        khachHang.setTenDem(viewModelKhachHang.getTenDem());
        khachHang.setHo(viewModelKhachHang.getHo());
        khachHang.setNgaySinh(viewModelKhachHang.getNgaySinh());
        khachHang.setSoDienThoai(viewModelKhachHang.getSoDienThoai());
        khachHang.setDiaChi(viewModelKhachHang.getDiaChi());
        khachHang.setThanhPho(viewModelKhachHang.getThanhPho());
        khachHang.setQuocGia(viewModelKhachHang.getQuocGia());
        khachHang.setMatKhau(viewModelKhachHang.getMatKhau());
 
        if(iKhachHangRepository.kiemTraMaTrung(khachHang.getMa())){
            return "Ma khong duoc trung";
        }
        if (iKhachHangRepository.insert(khachHang)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

 

    @Override
    public String deleteByMa(String ma) {
        if (iKhachHangRepository.delete(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelKhachHang viewModelKhachHang) {

        KhachHang khachHang = new KhachHang();
        khachHang.setMa(viewModelKhachHang.getMa());
        khachHang.setTen(viewModelKhachHang.getTen());
        khachHang.setTenDem(viewModelKhachHang.getTenDem());
        khachHang.setHo(viewModelKhachHang.getHo());
        khachHang.setNgaySinh(viewModelKhachHang.getNgaySinh());
        khachHang.setSoDienThoai(viewModelKhachHang.getSoDienThoai());
        khachHang.setDiaChi(viewModelKhachHang.getDiaChi());
        khachHang.setThanhPho(viewModelKhachHang.getThanhPho());
        khachHang.setQuocGia(viewModelKhachHang.getQuocGia());
        khachHang.setMatKhau(viewModelKhachHang.getMatKhau());
        System.out.println("mat khau"+ khachHang);
        if (iKhachHangRepository.update(ma, khachHang)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }

    }

    @Override
    public String getIdByTenKhachHang(String tenKhachHang) {
        return iKhachHangRepository.getIdKhachHangByTen(tenKhachHang);
    }



}
