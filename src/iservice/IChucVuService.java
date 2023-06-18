/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.List;
import domainmodel.ChucVu;
import viewmodel.ViewModelChucVu;

/**
 *
 * @author Admin
 */
public interface IChucVuService {
    public List<ViewModelChucVu> getAll();
    public String insert(ViewModelChucVu viewModelChucVu);
    public String deleteChucVuAndNhanVien(String ma);
    public String update(String ma, ViewModelChucVu viewModelChucVu);
    public String getIdByTen(String ten);

}
