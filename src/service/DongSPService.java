/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import iservice.IDongSPService;
import java.util.List;
import domainmodel.DongSP;
import irepository.IDongSPRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.DongSPRepository;
import viewmodel.ViewModelDongSP;

/**
 *
 * @author Admin
 */
public class DongSPService implements IDongSPService {

    private IDongSPRepository iDongSPRepository = new DongSPRepository();

    @Override
    public ArrayList<ViewModelDongSP> getAll() {
        ArrayList<ViewModelDongSP> listViewModelDongSPs = new ArrayList<>();
        List<DongSP> listDongSP = iDongSPRepository.getListDongSP();
        for (DongSP dongSP : listDongSP) {
            ViewModelDongSP viewModelDongSP = new ViewModelDongSP();
            viewModelDongSP.setId(dongSP.getId());
            viewModelDongSP.setMa(dongSP.getMa());
            viewModelDongSP.setTen(dongSP.getTen());
            listViewModelDongSPs.add(viewModelDongSP);

        }
        return listViewModelDongSPs;
    }

    @Override
    public String insert(ViewModelDongSP viewModelDongSP) {
        DongSP dongSP = new DongSP();
        dongSP.setMa(viewModelDongSP.getMa());
        dongSP.setTen(viewModelDongSP.getTen());
        // check rỗng
        if (dongSP.getMa().trim().equals("") || dongSP.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }
        // check trùng mã 
        if (iDongSPRepository.getKiemTraMaTrung(viewModelDongSP.getMa())) {
            return "Mã không được trùng";
        }
        if (iDongSPRepository.insert(dongSP)) {
            return "Đã thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelDongSP viewModelDongSP) {
        DongSP dongSP = new DongSP();
        dongSP.setMa(viewModelDongSP.getMa());
        dongSP.setTen(viewModelDongSP.getTen());
// check rỗng
        if (dongSP.getMa().trim().equals("") || dongSP.getTen().trim().equals("")) {
            return "Mã và tên không được rỗng";
        }

       
        if (iDongSPRepository.update(ma, dongSP)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }

    }

    @Override
    public String delete(String ma) {
        if (iDongSPRepository.delete(ma)) {
            return "Đã xoá";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String getIdDongSPByTen(String tenDongSP) {
        return iDongSPRepository.getIdDongSPByTen(tenDongSP);
    }

}
