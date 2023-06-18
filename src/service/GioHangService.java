/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.GioHang;
import irepository.IGioHangRepository;
import irepository.IKhachHangRepository;
import irepository.INhanVienRepository;
import iservice.IGioHangService;
import java.util.ArrayList;
import repositpry.GioHangRepository;
import repositpry.KhachHangRepository;
import repositpry.NhanVienRepository;
import viewmodel.ViewModelGioHang;
import viewmodel.ViewModelGioHangChucNang;
import viewmodel.ViewModelKhachHang;

/**
 *
 * @author Admin
 */
public class GioHangService implements IGioHangService {

    public IGioHangRepository iGioHangRepository = new GioHangRepository();
    public IKhachHangRepository iKhachHangRepository = new KhachHangRepository();
    public INhanVienRepository iNhanVienRepository = new NhanVienRepository();

    @Override
    public ArrayList<ViewModelGioHang> getAll() {
        ArrayList<GioHang> listGioHang = iGioHangRepository.getAll();
        ArrayList<ViewModelGioHang> listViewModelGioHang = new ArrayList<>();
        for (GioHang gioHang : listGioHang) {
            String maKH = iKhachHangRepository.getMaKhachHangByIdKhachHang(gioHang.getIdKH());
            String maNV = iNhanVienRepository.getMaNhanVienByIdNhanVien(gioHang.getIdNV());
          
            System.out.println("id"+" "+gioHang.getIdNV());
           
            ViewModelGioHang viewModelGioHang = new ViewModelGioHang();
            viewModelGioHang.setId(gioHang.getId());
            viewModelGioHang.setMaKH(maKH);
            viewModelGioHang.setMaNV(maNV);
            viewModelGioHang.setMa(gioHang.getMa());
            viewModelGioHang.setNgayTao(gioHang.getNgayTao());
            viewModelGioHang.setNgayThanhToan(gioHang.getNgayThanhToan());
            viewModelGioHang.setTenNguoiNhan(gioHang.getTenNguoiNhan());
            viewModelGioHang.setDiaChi(gioHang.getDiaChi());
            viewModelGioHang.setSoDienThoai(gioHang.getSoDienThoai());
            viewModelGioHang.setTinhTrang(gioHang.getTinhTrang());
            listViewModelGioHang.add(viewModelGioHang);

        }
        return listViewModelGioHang;
    }

//    @Override
//    public ArrayList<ViewModelGioHangChucNang> getAllGioHangChucNang() {
//        return iGioHangRepository.getListGioHangChucNang();
//    }

    @Override
    public String insert(ViewModelGioHang viewModelGioHang) {
        String idKH = iKhachHangRepository.getIdKhachHangByMaKhachHang(viewModelGioHang.getMaKH());
        String idNV = iNhanVienRepository.getIdNhanVienByMaNhanVien(viewModelGioHang.getMaNV());
        GioHang gioHang = new GioHang();
      
        gioHang.setMa(viewModelGioHang.getMa());
        gioHang.setIdKH(idKH);
        gioHang.setIdNV(idNV);
        gioHang.setNgayTao(viewModelGioHang.getNgayTao());
        gioHang.setNgayThanhToan(viewModelGioHang.getNgayThanhToan());
        gioHang.setTenNguoiNhan(viewModelGioHang.getTenNguoiNhan());
        gioHang.setDiaChi(viewModelGioHang.getDiaChi());
        gioHang.setSoDienThoai(viewModelGioHang.getSoDienThoai());
        gioHang.setTinhTrang(viewModelGioHang.getTinhTrang());
        if(iGioHangRepository.insert(gioHang)){
            return "Them thanh cong";
        }else{
            return "Them that bai";
        }
    }
}
