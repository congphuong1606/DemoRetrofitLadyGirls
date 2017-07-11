package ominext.android.vn.ladygirls.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 10/07/2017.
 */

public class NuSinh {
    @SerializedName("Id")
    private int mId;
    @SerializedName("HinhDaiDien")
    private String mHinhDaiDien;
    @SerializedName("HoTen")
    private String mHoTen;
    @SerializedName("NgaySinh")
    private String mNgaySinh;
    @SerializedName("QueQuan")
    private String mQueQuan;
    @SerializedName("ChieuCao")
    private String mChieuCao;
    @SerializedName("CanNang")
    private String mCanNang;
    @SerializedName("SoDoBaVong")
    private String mSoDoBaVong;
    @SerializedName("Sothich")
    private String mSothich;
    @SerializedName("CauNoiYeuThich")
    private String mCauNoiYeuThich;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmHinhDaiDien() {
        return mHinhDaiDien;
    }

    public void setmHinhDaiDien(String mHinhDaiDien) {
        this.mHinhDaiDien = mHinhDaiDien;
    }

    public String getmHoTen() {
        return mHoTen;
    }

    public void setmHoTen(String mHoTen) {
        this.mHoTen = mHoTen;
    }

    public String getmNgaySinh() {
        return mNgaySinh;
    }

    public void setmNgaySinh(String mNgaySinh) {
        this.mNgaySinh = mNgaySinh;
    }

    public String getmQueQuan() {
        return mQueQuan;
    }

    public void setmQueQuan(String mQueQuan) {
        this.mQueQuan = mQueQuan;
    }

    public String getmChieuCao() {
        return mChieuCao;
    }

    public void setmChieuCao(String mChieuCao) {
        this.mChieuCao = mChieuCao;
    }

    public String getmCanNang() {
        return mCanNang;
    }

    public void setmCanNang(String mCanNang) {
        this.mCanNang = mCanNang;
    }

    public String getmSoDoBaVong() {
        return mSoDoBaVong;
    }

    public void setmSoDoBaVong(String mSoDoBaVong) {
        this.mSoDoBaVong = mSoDoBaVong;
    }

    public String getmSothich() {
        return mSothich;
    }

    public void setmSothich(String mSothich) {
        this.mSothich = mSothich;
    }

    public String getmCauNoiYeuThich() {
        return mCauNoiYeuThich;
    }

    public void setmCauNoiYeuThich(String mCauNoiYeuThich) {
        this.mCauNoiYeuThich = mCauNoiYeuThich;
    }
}
