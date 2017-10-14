package com.training.iqbaaaaalf.tasktutoryan001.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by iqbaaaaalf on 10/8/2017.
 */

public class DestinationResponse  {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DestinationModel> result;

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

    public List<DestinationModel> getResult() {
        return result;
    }

    public void setResult(List<DestinationModel> result) {
        this.result = result;
    }
}
