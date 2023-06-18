/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.HoaDonChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietRepository {
    public ArrayList<HoaDonChiTiet> getAll();
    public boolean insert(HoaDonChiTiet  hoaDonChiTiet);
    
}
