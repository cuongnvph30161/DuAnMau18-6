/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.ChiTietSP;
import domainmodel.MauSac;
import irepository.IChiTietSPRepository;
import irepository.IDongSPRepository;
import irepository.IMauSacRepository;
import irepository.INSXRepository;
import irepository.ISanPhamRepository;
import java.util.ArrayList;
import repositpry.ChiTietSPRepository;
import repositpry.DongSPRepository;
import repositpry.MauSacRepository;
import repositpry.NSXRepository;
import repositpry.SanPhamRepository;
import viewmodel.ViewModelChiTietSP;
import iservice.IChiTietSPService;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChiTietSPService implements IChiTietSPService {

    private IChiTietSPRepository iChiTietSPRepository = new ChiTietSPRepository();
    private IMauSacRepository iMauSacRepository = new MauSacRepository();
    private ISanPhamRepository iSanPhamRepository = new SanPhamRepository();
    private INSXRepository iNSXRepository = new NSXRepository();
    private IDongSPRepository iDongSPRepository = new DongSPRepository();

    @Override
    public ArrayList<ViewModelChiTietSP> getAll() {
        // load
        ArrayList<ViewModelChiTietSP> listViewModelChiTietSPs = new ArrayList();
        ArrayList<ChiTietSP> listChiTietSPs = iChiTietSPRepository.getListChiTietSP();
        for (ChiTietSP chiTietSP : listChiTietSPs) {
            String tenSP = iSanPhamRepository.getTenSanPhamById(chiTietSP.getIdSP());
            String tenNSX = iNSXRepository.getTenNSXById(chiTietSP.getIdNSX());
            String tenMS = iMauSacRepository.getTenMauSacById(chiTietSP.getIdMauSac());
            String tenDongSP = iDongSPRepository.getTenDongSPById(chiTietSP.getIdDongSP());
            ViewModelChiTietSP viewModelChiTietSP = new ViewModelChiTietSP();
            viewModelChiTietSP.setId(chiTietSP.getId());

            viewModelChiTietSP.setSanPham(tenSP + "@@" + chiTietSP.getIdMauSac());
            viewModelChiTietSP.setNsx(tenNSX);
            viewModelChiTietSP.setMauSac(tenMS);
            viewModelChiTietSP.setDongDP(tenDongSP);
            viewModelChiTietSP.setNamBH(chiTietSP.getNamBH());
            viewModelChiTietSP.setMoTa(chiTietSP.getMoTa());
            viewModelChiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon());
            viewModelChiTietSP.setGiaNhap(chiTietSP.getGiaNhap());
            viewModelChiTietSP.setGiaBan(chiTietSP.getGiaBan());
            listViewModelChiTietSPs.add(viewModelChiTietSP);
        }
        return listViewModelChiTietSPs;
    }

    @Override
    public String insert(ViewModelChiTietSP viewModelChiTietSP) {
        ChiTietSP chiTietSP = new ChiTietSP();

        String idSP = iSanPhamRepository.idSanPhamByTen(viewModelChiTietSP.getSanPham());
        String idMS = iMauSacRepository.getIdMauSacByTenMauSac(viewModelChiTietSP.getMauSac());
        String idNSX = iNSXRepository.getIdNSXByTen(viewModelChiTietSP.getNsx());
        String idDongSP = iDongSPRepository.getIdDongSPByTen(viewModelChiTietSP.getDongDP());

        chiTietSP.setIdSP(idSP);
        chiTietSP.setIdNSX(idNSX);
        chiTietSP.setIdMauSac(idMS);
        chiTietSP.setIdDongSP(idDongSP);

        chiTietSP.setMoTa(viewModelChiTietSP.getMoTa());
        chiTietSP.setSoLuongTon(viewModelChiTietSP.getSoLuongTon());

        chiTietSP.setGiaNhap(viewModelChiTietSP.getGiaNhap());
        chiTietSP.setGiaBan(viewModelChiTietSP.getGiaBan());
        chiTietSP.setNamBH(viewModelChiTietSP.getNamBH());
      
       
        if (iChiTietSPRepository.insert(chiTietSP)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String id) {
       if(iChiTietSPRepository.delete(id)){
           return "Xoá thành công";
       }else{
           return "Xoá thất bại";
       }
               
    }

    @Override
    public String update(String id, ViewModelChiTietSP viewModelChiTietSP) {
        ChiTietSP chiTietSP = new ChiTietSP();
        String idSP = iSanPhamRepository.idSanPhamByTen(viewModelChiTietSP.getSanPham());
        String idMS = iMauSacRepository.getIdMauSacByTenMauSac(viewModelChiTietSP.getMauSac());
        String idNSX = iNSXRepository.getIdNSXByTen(viewModelChiTietSP.getNsx());
        String idDongSP = iDongSPRepository.getIdDongSPByTen(viewModelChiTietSP.getDongDP());
        chiTietSP.setIdSP(viewModelChiTietSP.getSanPham());
        chiTietSP.setIdSP(idSP);
        chiTietSP.setIdNSX(idNSX);
        chiTietSP.setIdMauSac(idMS);
        chiTietSP.setIdDongSP(idDongSP);
        chiTietSP.setMoTa(viewModelChiTietSP.getMoTa());
        chiTietSP.setSoLuongTon(viewModelChiTietSP.getSoLuongTon());
        chiTietSP.setGiaNhap(viewModelChiTietSP.getGiaNhap());
        chiTietSP.setGiaBan(viewModelChiTietSP.getGiaBan());
        chiTietSP.setNamBH(viewModelChiTietSP.getNamBH());
        if (iChiTietSPRepository.update(id, chiTietSP)) {
            return "Đã update thành công";
        } else {
            return "Update thất bại";
        }

    }

//    @Override
//    public ArrayList<ViewModelChiTietSP> getFindByTen(String tenSanPham) {
//        return iChiTietSPRepository.getFindByTen(tenSanPham);
//    }
//
//    @Override
//    public void updateSoLuongChiTietSP(int soLuong, String ma) {
//        iChiTietSPRepository.updateSoLuongChiTietSP(soLuong, ma);
//    }
//
//    @Override
//    public ViewModelChiTietSP getSanPhamByMaSP(String maSP) {
//        return iChiTietSPRepository.finByMaSP(maSP);
//    }
}
