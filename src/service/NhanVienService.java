/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.ChucVu;
import domainmodel.CuaHang;
import domainmodel.NhanVien;
import irepository.IChucVuRepository;
import irepository.ICuaHangRepository;
import irepository.INhanVienRepository;
import iservice.INhanVienService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repositpry.ChucVuRepository;
import repositpry.CuaHangRepository;
import repositpry.NhanVienRepository;
import viewmodel.ViewModelNhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienService implements INhanVienService {

    private INhanVienRepository iNhanVienRepository = new NhanVienRepository();
    private IChucVuRepository iChucVuRepository = new ChucVuRepository();
    private ICuaHangRepository iCuaHangRepository = new CuaHangRepository();

    @Override
    public ArrayList<ViewModelNhanVien> getAll() {
        ArrayList<ViewModelNhanVien> listViewModelNhanViens = new ArrayList<>();
        ArrayList<NhanVien> listNhanViens = iNhanVienRepository.listGetNhanVien();

        for (NhanVien nhanVien : listNhanViens) {
            // gọi tên ra Cửa hàng và tên Chức vụ ra 
            String tenCuaHang = iCuaHangRepository.getTenCuaHangById(nhanVien.getIdCH());
            String tenChucVu = iChucVuRepository.getTenChucVuById(nhanVien.getIdCV());
            // add vào 
            ViewModelNhanVien viewModelNhanVien = new ViewModelNhanVien();
            viewModelNhanVien.setMa(nhanVien.getMa());
            viewModelNhanVien.setHo(nhanVien.getHo());
            viewModelNhanVien.setTenDem(nhanVien.getTenDem());
            viewModelNhanVien.setTen(nhanVien.getTen());
            viewModelNhanVien.setGioiTinh(nhanVien.getGioiTinh());
            viewModelNhanVien.setNgaySinh(nhanVien.getNgaySinh());
            viewModelNhanVien.setDiaChi(nhanVien.getDiaChi());
            viewModelNhanVien.setSoDienThoai(nhanVien.getSoDienThoai());
            viewModelNhanVien.setMatKhau(nhanVien.getMatKhau());
            viewModelNhanVien.setTenCuaHang(tenCuaHang);
            viewModelNhanVien.setTenChucVu(tenChucVu);
            viewModelNhanVien.setTrangThai(nhanVien.getTrangThai());
            listViewModelNhanViens.add(viewModelNhanVien);
        }
        return listViewModelNhanViens;
    }

    @Override
    public String getIdNhanVienByTenNhanVien(String tenNhanVien) {
        return iNhanVienRepository.getIdNhanVienByTen(tenNhanVien);
    }

    @Override
    public String insert(ViewModelNhanVien viewModelNhanVien) {
        // lấy ra id từ tên 
        String idCuaHang = iCuaHangRepository.getIdByTenCuaHang(viewModelNhanVien.getTenCuaHang());
        String idChucVu = iChucVuRepository.getIdChucVuByTen(viewModelNhanVien.getTenChucVu());

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(viewModelNhanVien.getMa());
        nhanVien.setTen(viewModelNhanVien.getTen());
        nhanVien.setTenDem(viewModelNhanVien.getTenDem());
        nhanVien.setHo(viewModelNhanVien.getHo());
        nhanVien.setGioiTinh(viewModelNhanVien.getGioiTinh());
        nhanVien.setNgaySinh(viewModelNhanVien.getNgaySinh());
        nhanVien.setDiaChi(viewModelNhanVien.getDiaChi());
        nhanVien.setSoDienThoai(viewModelNhanVien.getSoDienThoai());
        nhanVien.setMatKhau(viewModelNhanVien.getMatKhau());
        nhanVien.setIdCH(idCuaHang);
        nhanVien.setIdCV(idChucVu);
        nhanVien.setTrangThai(viewModelNhanVien.getTrangThai());

        if (nhanVien.getMa().equals("") || nhanVien.getTen().equals("") || nhanVien.getTenDem().equals("") || nhanVien.getHo().equals("") || nhanVien.getDiaChi().equals("") || nhanVien.getMatKhau().equals("") || nhanVien.getNgaySinh().equals("") || nhanVien.getSoDienThoai().equals("")) {
            return "Không được rỗng";
        }
        // check trùng mã
        if (iNhanVienRepository.kiemTraTrungMa(viewModelNhanVien.getMa())) {
            return "Mã không được trùng";
        }

        if (iNhanVienRepository.insert(nhanVien)) {
            return "thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (iNhanVienRepository.delete(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelNhanVien viewModelNhanVien) {
        // lấy ra id từ tên 
        String idCuaHang = iCuaHangRepository.getIdByTenCuaHang(viewModelNhanVien.getTenCuaHang());
        String idChucVu = iChucVuRepository.getIdChucVuByTen(viewModelNhanVien.getTenChucVu());
     
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(viewModelNhanVien.getMa());
        nhanVien.setTen(viewModelNhanVien.getTen());
        nhanVien.setTenDem(viewModelNhanVien.getTenDem());
        nhanVien.setHo(viewModelNhanVien.getHo());
        nhanVien.setGioiTinh(viewModelNhanVien.getGioiTinh());
        nhanVien.setNgaySinh(viewModelNhanVien.getNgaySinh());
        nhanVien.setDiaChi(viewModelNhanVien.getDiaChi());
        nhanVien.setSoDienThoai(viewModelNhanVien.getSoDienThoai());
        nhanVien.setMatKhau(viewModelNhanVien.getMatKhau());
        nhanVien.setIdCV(idChucVu);
        nhanVien.setIdCH(idCuaHang);
        nhanVien.setTrangThai(viewModelNhanVien.getTrangThai());
        if (iNhanVienRepository.update(ma, nhanVien)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
