/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.List;
import domainmodel.DongSP;
import viewmodel.ViewModelDongSP;

/**
 *
 * @author Admin
 */
public interface IDongSPService {

    public List<ViewModelDongSP> getAll();

    public String insert(ViewModelDongSP viewModelDongSP);

    public String update(String ma, ViewModelDongSP viewModelDongSP);

    public String delete(String ma);

    public String getIdDongSPByTen(String tenDongSP);

}
