/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.ArrayList;
import viewmodel.ViewModelHoaDon;
import viewmodel.ViewModelHoaDonChiTiet;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietService {
    public ArrayList<ViewModelHoaDonChiTiet> getAll();
    public String insert(ViewModelHoaDonChiTiet viewModelHoaDonChiTiet);
    
}
