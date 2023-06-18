/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import iservice.INSXService;
import java.util.List;
import domainmodel.NSX;
import irepository.INSXRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositpry.NSXRepository;
import viewmodel.ViewModelNSX;

/**
 *
 * @author Admin
 */
public class NSXService implements INSXService {

    private INSXRepository iNSXRepository = new NSXRepository();

    @Override
    public List<ViewModelNSX> getAll() {
        ArrayList<NSX> listNSX = iNSXRepository.getListNSX();
        ArrayList<ViewModelNSX> listViewModelNSXs = new ArrayList();
        for (NSX nsx : listNSX) {
            ViewModelNSX viewModelNSX = new ViewModelNSX();
            viewModelNSX.setId(nsx.getId());
            viewModelNSX.setMa(nsx.getMa());
            viewModelNSX.setTen(nsx.getTen());
            listViewModelNSXs.add(viewModelNSX);
        }
        return listViewModelNSXs;
    }

    @Override
    public String insert(ViewModelNSX viewModelNSX) {
        NSX nsx = new NSX();
        nsx.setMa(viewModelNSX.getMa());
        nsx.setTen(viewModelNSX.getTen());
        // check rỗng 
        if (nsx.getMa().trim().equals("") || nsx.getTen().trim().equals("")) {
            return "Không được rỗng ";
        }

        // check trùng mã 
        if(iNSXRepository.kiemTraMaTrung(nsx.getMa())){
            return "Mã không được trùng";
        }
        
        
        if (iNSXRepository.insert(nsx)) {
            return "Đã thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String delete(String ma) {
        if (iNSXRepository.delete(ma)) {
            return "Đã xoá";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public String update(String ma, ViewModelNSX viewModelNSX) {
        NSX nsx = new NSX();
        nsx.setMa(viewModelNSX.getMa());
        nsx.setTen(viewModelNSX.getTen());
        // check rỗng 
        if (nsx.getMa().trim().equals("") || nsx.getTen().trim().equals("")) {
            return "Không được rỗng ";
        }

        
        
        if (iNSXRepository.update(ma, nsx)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }

    }

    @Override
    public String getIdNSXByTen(String ten) {
        return iNSXRepository.getIdNSXByTen(ten);
    }

}
