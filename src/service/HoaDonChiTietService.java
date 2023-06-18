/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.HoaDonChiTiet;
import irepository.IChiTietSPRepository;
import irepository.IHoaDonChiTietRepository;
import irepository.IHoaDonRepository;
import iservice.IHoaDonChiTietService;
import java.util.ArrayList;
import repositpry.ChiTietSPRepository;
import repositpry.HoaDonChiTietRepository;
import repositpry.HoaDonRepository;
import viewmodel.ViewModelHoaDon;
import viewmodel.ViewModelHoaDonChiTiet;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietService implements IHoaDonChiTietService {

    public IHoaDonChiTietRepository iHoaDonChiTietRepository = new HoaDonChiTietRepository();
    public IHoaDonRepository iHoaDonRepository = new HoaDonRepository();
    public IChiTietSPRepository iChiTietSPRepository = new ChiTietSPRepository();

    @Override
    public ArrayList<ViewModelHoaDonChiTiet> getAll() {
        ArrayList<HoaDonChiTiet> listHoaDonChiTiet = iHoaDonChiTietRepository.getAll();
        ArrayList<ViewModelHoaDonChiTiet> listViewModelHoaDonChiTiets = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet : listHoaDonChiTiet) {
            ViewModelHoaDonChiTiet viewModelHoaDonChiTiet = new ViewModelHoaDonChiTiet();
            String maHD = iHoaDonRepository.getMaHoaDonByIdHoaDon(hoaDonChiTiet.getIdHoaDon());
            viewModelHoaDonChiTiet.setMaHD(maHD);
            viewModelHoaDonChiTiet.setIdChiTietSP(hoaDonChiTiet.getIdChiTietSP());
            viewModelHoaDonChiTiet.setSoLuong(hoaDonChiTiet.getSoLuong());
            viewModelHoaDonChiTiet.setDonGia(hoaDonChiTiet.getDonGia());
            listViewModelHoaDonChiTiets.add(viewModelHoaDonChiTiet);
        }
        return listViewModelHoaDonChiTiets;
    }

    @Override
    public String insert(ViewModelHoaDonChiTiet viewModelHoaDonChiTiet) {
        String idHD = iHoaDonRepository.getIdHDCTByMaHDCT(viewModelHoaDonChiTiet.getMaHD());
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setIdHoaDon(idHD);
        hoaDonChiTiet.setIdChiTietSP(viewModelHoaDonChiTiet.getIdChiTietSP());
        hoaDonChiTiet.setSoLuong(viewModelHoaDonChiTiet.getSoLuong());
        hoaDonChiTiet.setDonGia(viewModelHoaDonChiTiet.getDonGia());
        if (iHoaDonChiTietRepository.insert(hoaDonChiTiet)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

}
