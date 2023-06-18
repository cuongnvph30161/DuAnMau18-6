/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.ArrayList;
import viewmodel.ViewModelGioHang;
import viewmodel.ViewModelGioHangChucNang;

/**
 *
 * @author Admin
 */
public interface IGioHangService {
    public ArrayList<ViewModelGioHang> getAll();
    public String insert(ViewModelGioHang viewModelGioHang);
    
//    public ArrayList<ViewModelGioHangChucNang> getAllGioHangChucNang();
}
