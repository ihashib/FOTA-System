package com.fota.fotaserver.ESP32;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@AllArgsConstructor
public class FOTA_ESP32_Controller {
    private final FOTA_ESP32_Service fotaEsp32Service;

    /*
    Hardware requests
        api/get/esp32/{model}/{deviceId}/{securityCode}/fota/version
        api/get/esp32/{model}/{deviceId}/{secrurityCode}/fota/update

    Front-end requests
        api/post/esp32/fota/create
        api/get/esp32/fota/readAll
        api/get/esp32/fota/readByMedel/{model}
        api/put/esp32/fota/update/{model}
        api/delete/esp32/fota/delete/{model}
     */

    //Hardware end
    @GetMapping(value = "api/get/esp32/{model}/{deviceId}/{securityCode}/fota/version")
    public ResponseEntity<FOTA_ESP32> version(@PathVariable(name = "model") String model,
                                              @PathVariable(name = "deviceId") String deviceId,
                                              @PathVariable(name = "securityCode") String securityCode) {
        return fotaEsp32Service.getVersion(model, deviceId, securityCode);
    }
    @GetMapping(value = "api/get/esp32/{model}/{deviceId}/{secrurityCode}/fota/update")     //may have issues
    public ResponseEntity<Resource> update(@PathVariable(name = "model") String model,
                                           @PathVariable(name = "deviceId") String deviceId,
                                           @PathVariable(name = "securityCode") String securityCode){
        return fotaEsp32Service.getUpdate(model, deviceId, securityCode);
    }

    //front end
    @PostMapping(value = "api/post/esp32/fota/create")
    public String create(@RequestBody FOTA_ESP32 fotaEsp32){
        return fotaEsp32Service.createFOTA(fotaEsp32);
    }
    @PostMapping(value = "api/get/esp32/fota/readAll")
    public List<FOTA_ESP32> readAll(){
        return fotaEsp32Service.readAllFOTA();
    }
    @PostMapping(value = "api/get/esp32/fota/readByModel/{model}")
    public FOTA_ESP32 readByModel(@PathVariable(name = "model") String model){
        return fotaEsp32Service.readFOTAByModel(model);
    }
    @PutMapping(value = "api/put/esp32/fota/update/{model}")
    public String update(@PathVariable(name = "model") String model, @RequestBody FOTA_ESP32 fotaEsp32){
        return fotaEsp32Service.updateFOTA(model, fotaEsp32);
    }
    @DeleteMapping(value = "api/delete/esp32/fota/delete/{model}")
    public String delete(@PathVariable(name = "model") String model){
        return fotaEsp32Service.deleteFOTA(model);
    }
}
