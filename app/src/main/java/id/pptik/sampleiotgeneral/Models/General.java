package id.pptik.sampleiotgeneral.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class General {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("device_code")
    @Expose
    private String deviceCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public General() {
    }

    /**
     *
     * @param code
     * @param data
     * @param deviceCode
     * @param message
     * @param status
     */
    public General(Integer code, String status, String message, List<Datum> data, String deviceCode) {
        super();
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.deviceCode = deviceCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

}
