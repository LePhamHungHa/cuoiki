package com.example.bookingticket.Model;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class Theater {
    @SerializedName("theater_name")
    private String theater_name;
    @SerializedName("province")
    private String province;

    public Theater(String theater_name, String province) {
        this.theater_name = theater_name;
        this.province = province;
    }

    public String gettheater_name() {
        return theater_name;
    }

    public void settheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getprovince() {
        return province;
    }

    public void setprovince(String province) {
        this.province = province;
    }
}
