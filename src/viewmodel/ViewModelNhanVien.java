/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.ChucVu;
import domainmodel.CuaHang;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ViewModelNhanVien {

    private String id;
    private String ma;
    private String ho;
    private String tenDem;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String matKhau;
    private String tenCuaHang;
    private String tenChucVu;
    private String idGuiBC;
    private int trangThai;

    public ViewModelNhanVien(String id, String ma, String ho, String tenDem, String ten, String gioiTinh, Date ngaySinh, String diaChi, String soDienThoai, String matKhau, String tenCuaHang, String tenChucVu, String idGuiBC, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.tenCuaHang = tenCuaHang;
        this.tenChucVu = tenChucVu;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public ViewModelNhanVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ViewModelNhanVien{" + "id=" + id + ", ma=" + ma + ", ho=" + ho + ", tenDem=" + tenDem + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", matKhau=" + matKhau + ", tenCuaHang=" + tenCuaHang + ", tenChucVu=" + tenChucVu + ", idGuiBC=" + idGuiBC + ", trangThai=" + trangThai + '}';
    }
    
   

}
