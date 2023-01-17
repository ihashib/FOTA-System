package com.fota.fotaserver.ESP32;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Data
@Document(collection = "ESP32")
public class FOTA_ESP32 {
    @Id
    private String id;
    private String deviceModel;
    private String md5CheckSum;
    private String buildData;
    private String buildNum;
    private String fileSize;
    private String serverPath;
    private String updateStatus;
    private String updateCompleteTime;
    private String errorMessage;
    private Binary file;

    public FOTA_ESP32() {
    }

    public FOTA_ESP32(String deviceModel, String md5CheckSum, String buildData, String buildNum, String fileSize,
                              String serverPath, String updateStatus, String updateCompleteTime, String errorMessage, Binary file) {
        this.deviceModel = deviceModel;
        this.md5CheckSum = md5CheckSum;
        this.buildData = buildData;
        this.buildNum = buildNum;
        this.fileSize = fileSize;
        this.serverPath = serverPath;
        this.updateStatus = updateStatus;
        this.updateCompleteTime = updateCompleteTime;
        this.errorMessage = errorMessage;
        this.file = file;
    }

    public FOTA_ESP32 FOTAVersion(FOTA_ESP32 f){
        return new FOTA_ESP32(f.deviceModel, f.md5CheckSum, f.buildData, f.buildNum, f.fileSize, f.serverPath, f.updateStatus,
                f.updateCompleteTime, f.errorMessage, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getMd5CheckSum() {
        return md5CheckSum;
    }

    public void setMd5CheckSum(String md5CheckSum) {
        this.md5CheckSum = md5CheckSum;
    }

    public String getBuildData() {
        return buildData;
    }

    public void setBuildData(String buildData) {
        this.buildData = buildData;
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUpdateCompleteTime() {
        return updateCompleteTime;
    }

    public void setUpdateCompleteTime(String updateCompleteTime) {
        this.updateCompleteTime = updateCompleteTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FOTA_ESP32{" +
                "id='" + id + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", md5CheckSum='" + md5CheckSum + '\'' +
                ", buildData='" + buildData + '\'' +
                ", buildNum='" + buildNum + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", serverPath='" + serverPath + '\'' +
                ", updateStatus='" + updateStatus + '\'' +
                ", updateCompleteTime='" + updateCompleteTime + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

