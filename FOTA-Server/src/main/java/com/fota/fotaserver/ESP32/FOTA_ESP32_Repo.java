package com.fota.fotaserver.ESP32;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FOTA_ESP32_Repo extends MongoRepository<FOTA_ESP32, String> {
    @Query("{deviceModel : ?0}")
    FOTA_ESP32 getFirmwareByModel(String model);
}
