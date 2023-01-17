package com.fota.fotaserver.ESP32;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FOTA_ESP32_Service {
    private final FOTA_ESP32_Repo fotaEsp32Repo;

    //hardware end
    public ResponseEntity<FOTA_ESP32> getVersion(String model, String deviceId, String securityCode){
        Boolean deviceSecure = true;
        //check if device id matches with existing devices
        //check if security code of that device matches

        //find the latest firmware for given
        List<FOTA_ESP32> fList = fotaEsp32Repo.findAll();

        if(!deviceSecure)
            return new ResponseEntity("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);

        FOTA_ESP32 firmware = fotaEsp32Repo.getFirmwareByModel(model);

        System.out.println(fotaEsp32Repo.count());

        if(fotaEsp32Repo.count() > 0)
            return new ResponseEntity<FOTA_ESP32>(firmware.FOTAVersion(firmware), HttpStatus.OK);
        else
            return new ResponseEntity("NO_CONTENT", HttpStatus.OK);
    }

    public ResponseEntity<FOTA_ESP32> getUpdate(String model, String deviceId, String securityCode){
        Boolean deviceSecure = true;
        //check if device id matches with existing devices
        //check if security code of that device matches

        //find the latest firmware for given
        List<FOTA_ESP32> fList = fotaEsp32Repo.findAll();

        if(!deviceSecure)
            return new ResponseEntity("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);

        FOTA_ESP32 update = fotaEsp32Repo.getFirmwareByModel(model);

        if(fotaEsp32Repo.count() > 0)
            return new ResponseEntity<FOTA_ESP32>(update, HttpStatus.OK);
        else
            return new ResponseEntity("NO_CONTENT", HttpStatus.OK);
    }

    //Front end
    public String createFOTA(FOTA_ESP32 fotaEsp32){
        //insert data
        fotaEsp32Repo.insert((fotaEsp32));

        return "DONE";
    }
    public List<FOTA_ESP32> readAllFOTA(){
        return fotaEsp32Repo.findAll();
    }
    public FOTA_ESP32 readFOTAByModel(String model){
        return fotaEsp32Repo.getFirmwareByModel(model);
    }
    public String updateFOTA(String model, FOTA_ESP32 fotaEsp32){
        FOTA_ESP32 ins = fotaEsp32Repo.getFirmwareByModel(model);
        Optional<FOTA_ESP32> fotaEsp32Optional = fotaEsp32Repo.findById(ins.getId());
        if(fotaEsp32Optional.isPresent())
        {
            FOTA_ESP32 update = fotaEsp32Optional.get();
            update.setMd5CheckSum(fotaEsp32.getMd5CheckSum() != null ? fotaEsp32.getMd5CheckSum():update.getMd5CheckSum());
            update.setBuildData(fotaEsp32.getBuildData() != null ? fotaEsp32.getBuildData() : update.getBuildData());
            update.setBuildNum(fotaEsp32.getBuildNum() != null ? fotaEsp32.getBuildNum() : update.getBuildNum());
            update.setFileSize(fotaEsp32.getFileSize() != null ? fotaEsp32.getFileSize() : update.getFileSize());
            update.setFile(fotaEsp32.getFile() != null ? fotaEsp32.getFile() : update.getFile());

            fotaEsp32Repo.save(update);

            return "Updated, id: "+update.getId()+" model: "+update.getDeviceModel();
        }
        else
        {
            return "No matching model found";
        }
    }
    public String deleteFOTA(String model){
        try {
            FOTA_ESP32 ins = fotaEsp32Repo.getFirmwareByModel(model);
            fotaEsp32Repo.deleteById(ins.getId());
            return "Deleted model" + ins.getId() + " model: " + ins.getDeviceModel();
        }
        catch (Exception e){
            return "Delete Failed"+e;
        }
    }
}
