/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iservice;

import java.util.List;
import domainmodel.NSX;
import viewmodel.ViewModelNSX;

/**
 *
 * @author Admin
 */
public interface INSXService {
    public List<ViewModelNSX> getAll();
    public String insert(ViewModelNSX viewModelNSX);
    public String delete(String ma);
    public String update(String ma ,ViewModelNSX viewModelNSX);
    public String getIdNSXByTen(String ten );
}
