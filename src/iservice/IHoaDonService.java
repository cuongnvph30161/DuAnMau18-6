/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import domainmodel.HoaDon;
import java.util.ArrayList;
import viewmodel.ViewModelHoaDon;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {

    public ArrayList<ViewModelHoaDon> getAll();

    public String insert(ViewModelHoaDon viewModelHoaDon);

    public String delete(String id);

 

    public String update(String id, ViewModelHoaDon viewModelHoaDon);
//    public ArrayList<ViewModelHoaDon> getTenTinhTrang(int tenTinhTrang);
//    public void updateTinhTrang(int so,String maHoaDon);
//    public int checkTinhTrang(String ma);
}
