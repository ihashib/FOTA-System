package com.fota.fotaserver.ESP32;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@AllArgsConstructor
public class FOTA_ESP32_Controller {
    private final FOTA_ESP32_Service fotaEsp32Service;

    /*
    Device requests
    Get
        api/get/esp32/{model}/{deviceId}/{securityCode}/fota/version
        api/get/esp32/{model}/{deviceId}/{secrurityCode}/fota/update

    Front-end requests
    POST
        api/post/esp32/fota/create
        api/post/esp32/fota/read
        api/post/esp32/fota/update
        api/post/esp32/fota/delete
     */

    //GET
    @GetMapping(value = "api/get/esp32/{model}/{deviceId}/{securityCode}/fota/version")
    public ResponseEntity<FOTA_ESP32> version(@PathVariable(name = "model") String model,
                                              @PathVariable(name = "deviceId") String deviceId,
                                              @PathVariable(name = "securityCode") String securityCode) {
        System.out.println(model);
        return fotaEsp32Service.getVersion(model, deviceId, securityCode);
    }

    //POST
    @GetMapping(value = "api/get/esp32/{model}/{deviceId}/{secrurityCode}/fota/update")
    public ResponseEntity<Resource> update(@PathVariable(name = "model") String model,
                                           @PathVariable(name = "deviceId") String deviceId,
                                           @PathVariable(name = "securityCode") String securityCode){
        return fotaEsp32Service.getUpdate(model, deviceId, securityCode);
    }
}
