/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Admin
 */
public class ViewModelChucVu {
    private String ma;
    private String ten;

    public ViewModelChucVu(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public ViewModelChucVu() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "ViewModelChucVu{" + "ma=" + ma + ", ten=" + ten + '}';
    }

}
