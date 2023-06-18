/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.GioHang;
import java.util.ArrayList;
import viewmodel.ViewModelGioHang;
import viewmodel.ViewModelGioHangChucNang;

/**
 *
 * @author Admin
 */
public interface IGioHangRepository {

    public ArrayList<GioHang> getAll();
    public boolean insert(GioHang gioHang);
//    public ArrayList<ViewModelGioHangChucNang> getListGioHangChucNang();
}
