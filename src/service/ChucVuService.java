/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import iservice.IChucVuService;
import java.util.List;
import domainmodel.ChucVu;
import irepository.IChucVuRepository;
import irepository.INhanVienRepository;
import iservice.INhanVienService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.ChucVuRepository;
import repositpry.NhanVienRepository;
import viewmodel.ViewModelChucVu;

/**
 *
 * @author Admin
 */
public class ChucVuService implements IChucVuService {

    private IChucVuRepository iChucVuRepository = new ChucVuRepository();
    private INhanVienRepository iNhanVienRepository = new NhanVienRepository();

    @Override
    public List<ViewModelChucVu> getAll() {
        ArrayList<ChucVu> listChucVu = iChucVuRepository.getListChucVu();
        ArrayList<ViewModelChucVu> listViewModelChucVus = new ArrayList();
        for (ChucVu chucVu : listChucVu) {
            ViewModelChucVu viewModelChucVu = new ViewModelChucVu();
            viewModelChucVu.setMa(chucVu.getMa());
            viewModelChucVu.setTen(chucVu.getTen());
            listViewModelChucVus.add(viewModelChucVu);
        }
        return listViewModelChucVus;
    }

    @Override
    public String insert(ViewModelChucVu viewModelChucVu) {
        ChucVu chucVu = new ChucVu();
        chucVu.setMa(viewModelChucVu.getMa());
        chucVu.setTen(viewModelChucVu.getTen());
        if (chucVu.getMa().trim().equals("") || chucVu.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }
        // check mã trùng và tên trùng
        if (iChucVuRepository.kiemTraMaTrung(viewModelChucVu.getMa()) || iChucVuRepository.kiemTraTenTrung(viewModelChucVu.getTen())) {
            return "mã và tên không được trùng";
        }

        if (iChucVuRepository.insert(chucVu)) {
            return "Đã thêm";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String deleteChucVuAndNhanVien(String ma) {
        iNhanVienRepository.deleteChucVuAndNhanVien(iChucVuRepository.getIdChucVuByMa(ma));
        if (iChucVuRepository.delete(ma)) {
            return "Đã xoá";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelChucVu viewModelChucVu) {
        ChucVu chucVu = new ChucVu();
        chucVu.setMa(viewModelChucVu.getMa());
        chucVu.setTen(viewModelChucVu.getTen());
        if (chucVu.getMa().trim().equals("") || chucVu.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }
        
        if (iChucVuRepository.update(ma, chucVu)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }

    }

    @Override
    public String getIdByTen(String ten) {
        return iChucVuRepository.getIdChucVuByTen(ten);
    }

}
