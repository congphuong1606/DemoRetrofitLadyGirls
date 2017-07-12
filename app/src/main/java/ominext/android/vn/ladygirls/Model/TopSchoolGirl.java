
package ominext.android.vn.ladygirls.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopSchoolGirl {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("HinhDaiDien")
    @Expose
    private String hinhDaiDien;
    @SerializedName("HoTen")
    @Expose
    private String hoTen;
    @SerializedName("NgaySinh")
    @Expose
    private String ngaySinh;
    @SerializedName("QueQuan")
    @Expose
    private String queQuan;
    @SerializedName("ChieuCao")
    @Expose
    private String chieuCao;
    @SerializedName("CanNang")
    @Expose
    private String canNang;
    @SerializedName("SoDoBaVong")
    @Expose
    private String soDoBaVong;
    @SerializedName("Sothich")
    @Expose
    private String sothich;
    @SerializedName("CauNoiYeuThich")
    @Expose
    private String cauNoiYeuThich;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHinhDaiDien() {
        return hinhDaiDien;
    }

    public void setHinhDaiDien(String hinhDaiDien) {
        this.hinhDaiDien = hinhDaiDien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    public String getSoDoBaVong() {
        return soDoBaVong;
    }

    public void setSoDoBaVong(String soDoBaVong) {
        this.soDoBaVong = soDoBaVong;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }

    public String getCauNoiYeuThich() {
        return cauNoiYeuThich;
    }

    public void setCauNoiYeuThich(String cauNoiYeuThich) {
        this.cauNoiYeuThich = cauNoiYeuThich;
    }

}
