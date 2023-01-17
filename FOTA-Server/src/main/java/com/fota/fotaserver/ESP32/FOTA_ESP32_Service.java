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

@AllArgsConstructor
@Service
public class FOTA_ESP32_Service {
    private final FOTA_ESP32_Repo fotaEsp32Repo;

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

    public ResponseEntity<Resource> getUpdate(String model, String deviceId, String securityCode){
        Boolean deviceSecure = true;
        //check if device id matches with existing devices
        //check if security code of that device matches

        //find the latest firmware for given
        List<FOTA_ESP32> fList = fotaEsp32Repo.findAll();

        if(!deviceSecure)
            return new ResponseEntity("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);

        FOTA_ESP32 update = fotaEsp32Repo.getFirmwareByModel(model);

        if(fotaEsp32Repo.count() > 0)
            return new ResponseEntity<Resource>((Resource) update, HttpStatus.OK);  //-----could cause issues
        else
            return new ResponseEntity("NO_CONTENT", HttpStatus.OK);
    }
}
