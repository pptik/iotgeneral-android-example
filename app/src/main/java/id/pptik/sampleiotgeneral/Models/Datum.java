package id.pptik.sampleiotgeneral.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("jenis_iot")
    @Expose
    private String jenisIot;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("data_1")
    @Expose
    private String data1;
    @SerializedName("data_2")
    @Expose
    private String data2;
    @SerializedName("data_3")
    @Expose
    private String data3;
    @SerializedName("data_4")
    @Expose
    private String data4;
    @SerializedName("timestamp_device")
    @Expose
    private String timestampDevice;
    @SerializedName("timestamp_rmq")
    @Expose
    private String timestampRmq;
    @SerializedName("kode_device")
    @Expose
    private String kodeDevice;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param kodeDevice
     * @param timestampDevice
     * @param jenisIot
     * @param data4
     * @param timestampRmq
     * @param _long
     * @param data3
     * @param data2
     * @param data1
     * @param id
     * @param lat
     */
    public Datum(String id, String jenisIot, String _long, String lat, String data1, String data2, String data3, String data4, String timestampDevice, String timestampRmq, String kodeDevice) {
        super();
        this.id = id;
        this.jenisIot = jenisIot;
        this._long = _long;
        this.lat = lat;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.timestampDevice = timestampDevice;
        this.timestampRmq = timestampRmq;
        this.kodeDevice = kodeDevice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenisIot() {
        return jenisIot;
    }

    public void setJenisIot(String jenisIot) {
        this.jenisIot = jenisIot;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getTimestampDevice() {
        return timestampDevice;
    }

    public void setTimestampDevice(String timestampDevice) {
        this.timestampDevice = timestampDevice;
    }

    public String getTimestampRmq() {
        return timestampRmq;
    }

    public void setTimestampRmq(String timestampRmq) {
        this.timestampRmq = timestampRmq;
    }

    public String getKodeDevice() {
        return kodeDevice;
    }

    public void setKodeDevice(String kodeDevice) {
        this.kodeDevice = kodeDevice;
    }

}
