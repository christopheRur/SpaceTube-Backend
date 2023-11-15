package com.codelab.spaceTube.services;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface SpaceTubeService {
    public JsonObject retrieveNasaData() throws IOException;
}
