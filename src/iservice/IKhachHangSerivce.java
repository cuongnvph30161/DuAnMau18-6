/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import domainmodel.KhachHang;
import java.util.ArrayList;
import viewmodel.ViewModelKhachHang;

/**
 *
 * @author Admin
 */
public interface IKhachHangSerivce {

    public ArrayList<ViewModelKhachHang> getAll();

    public String insert(ViewModelKhachHang viewModelKhachHang);


    public String deleteByMa(String ma);

    public String update(String ma, ViewModelKhachHang viewModelKhachHang);
    public String getIdByTenKhachHang(String tenKhachHang);
}
