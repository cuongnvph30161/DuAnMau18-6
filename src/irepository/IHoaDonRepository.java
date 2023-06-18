/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irepository;

import domainmodel.HoaDon;
import java.util.ArrayList;
import viewmodel.ViewModelHoaDon;

/**
 *
 * @author Admin
 */
public interface IHoaDonRepository {
//    public ArrayList<HoaDon> getListHD();

    public ArrayList<HoaDon> getListHoaDon();

    public boolean insert(HoaDon hoaDon);

    public boolean delete(String id);

    public String getMaHoaDonByIdHoaDon(String id);

    public boolean kiemTraMaTrung(String ma);

    public String getIdHDCTByMaHDCT(String ma);

    public boolean update(String id, HoaDon hoaDon);
//    public ArrayList<ViewModelHoaDon> getTimKiemByTen(int tenTinhTrang);

//    public void updateHoaDon(int so,String maHoaDon );
//    public int  checkTinhTrang(String maHD);
}
