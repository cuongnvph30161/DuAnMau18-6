/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import domainmodel.CuaHang;
import java.util.ArrayList;
import viewmodel.ViewModelCuaHang;

/**
 *
 * @author Admin
 */
public interface ICuaHangService {

    public ArrayList<ViewModelCuaHang> getAll();

    public String insert(ViewModelCuaHang viewModelCuaHang);

    public String delete(String ma);

    public String update(String ma, ViewModelCuaHang viewModelCuaHang);
    
    public String getIdByTenCuaHang(String ten);
    
}
