/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import irepository.IHoaDonRepository;
import irepository.IKhachHangRepository;
import irepository.INhanVienRepository;
import iservice.IHoaDonService;
import java.util.ArrayList;
import repositpry.HoaDonRepository;
import repositpry.KhachHangRepository;
import repositpry.NhanVienRepository;
import viewmodel.ViewModelHoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {

    public IHoaDonRepository iHoaDonRepository = new HoaDonRepository();
    public IKhachHangRepository iKhachHangRepository = new KhachHangRepository();
    public INhanVienRepository iNhanVienRepository = new NhanVienRepository();

    @Override
    public ArrayList<ViewModelHoaDon> getAll() {
        ArrayList<HoaDon> listHoaDon = iHoaDonRepository.getListHoaDon();
        ArrayList<ViewModelHoaDon> listViewModelHoaDon = new ArrayList<>();
        for (HoaDon hoaDon : listHoaDon) {
            String tenKH = iKhachHangRepository.getTenKhachHangByIdKhachHang(hoaDon.getIdKH());
            String tenNV = iNhanVienRepository.getTenNhanVienByIdNhanVien(hoaDon.getIdNV());
            ViewModelHoaDon viewModelHoaDon = new ViewModelHoaDon();
            viewModelHoaDon.setId(hoaDon.getId());
            viewModelHoaDon.setTenKH(tenKH);
            viewModelHoaDon.setTenNV(tenNV);
            viewModelHoaDon.setMa(hoaDon.getMa());
            viewModelHoaDon.setNgayTao(hoaDon.getNgayTao());
            viewModelHoaDon.setNgayThanhToan(hoaDon.getNgayThanhToan());
            viewModelHoaDon.setNgayShip(hoaDon.getNgayShip());
            viewModelHoaDon.setNgayNhan(hoaDon.getNgayNhan());
            viewModelHoaDon.setTinhTrang(hoaDon.getTinhTrang());
            viewModelHoaDon.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
            viewModelHoaDon.setDiaChi(hoaDon.getDiaChi());
            viewModelHoaDon.setSoDienThoai(hoaDon.getSoDienThoai());
            listViewModelHoaDon.add(viewModelHoaDon);

        }
        return listViewModelHoaDon;
    }

    @Override
    public String insert(ViewModelHoaDon viewModelHoaDon) {
        // check trung ma 
        if (iHoaDonRepository.kiemTraMaTrung(viewModelHoaDon.getMa())) {
            return "Mã không được trùng";
        }
        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKH(viewModelHoaDon.getTenKH());
        hoaDon.setIdNV(viewModelHoaDon.getTenNV());
        hoaDon.setMa(viewModelHoaDon.getMa());
        hoaDon.setNgayTao(viewModelHoaDon.getNgayTao());
        hoaDon.setNgayThanhToan(viewModelHoaDon.getNgayThanhToan());
        hoaDon.setNgayShip(viewModelHoaDon.getNgayShip());
        hoaDon.setNgayNhan(viewModelHoaDon.getNgayNhan());
        hoaDon.setTinhTrang(viewModelHoaDon.getTinhTrang());
        hoaDon.setTenNguoiNhan(viewModelHoaDon.getTenNguoiNhan());
        hoaDon.setDiaChi(viewModelHoaDon.getDiaChi());
        hoaDon.setDiaChi(viewModelHoaDon.getDiaChi());
        hoaDon.setSoDienThoai(viewModelHoaDon.getSoDienThoai());
        System.out.println("hoadon" + " " + hoaDon);

        if (iHoaDonRepository.insert(hoaDon)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại ";
        }

    }

    @Override
    public String delete(String id) {
        if (iHoaDonRepository.delete(id)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

//    @Override
//    public ArrayList<ViewModelHoaDon> getTenTinhTrang(int tenTinhTrang) {
//        return iHoaDonRepository.getTimKiemByTen(tenTinhTrang);
//    }
//    
//    @Override
//    public void updateTinhTrang(int so, String maHoaDon) {
//        iHoaDonRepository.updateHoaDon(so, maHoaDon);
//    }
//    
//    @Override
//    public int checkTinhTrang(String ma) {
//        return iHoaDonRepository.checkTinhTrang(ma);
//    }
    @Override
    public String update(String id, ViewModelHoaDon viewModelHoaDon) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKH(viewModelHoaDon.getTenKH());
        hoaDon.setIdNV(viewModelHoaDon.getTenNV());
        hoaDon.setMa(viewModelHoaDon.getMa());
        hoaDon.setNgayTao(viewModelHoaDon.getNgayTao());
        hoaDon.setNgayThanhToan(viewModelHoaDon.getNgayThanhToan());
        hoaDon.setNgayShip(viewModelHoaDon.getNgayShip());
        hoaDon.setNgayNhan(viewModelHoaDon.getNgayNhan());
        hoaDon.setTinhTrang(viewModelHoaDon.getTinhTrang());
        hoaDon.setTenNguoiNhan(viewModelHoaDon.getTenNguoiNhan());
        hoaDon.setDiaChi(viewModelHoaDon.getDiaChi());
        hoaDon.setDiaChi(viewModelHoaDon.getDiaChi());
        hoaDon.setSoDienThoai(viewModelHoaDon.getSoDienThoai());
        
        if (iHoaDonRepository.update(id, hoaDon)) {
            return "Update thành công";
        } else {
            return "Update thất bại ";
        }
    }

}
