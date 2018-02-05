package com.spx.dev.persist;

import com.spx.dev.domain.JPersistData;

import java.io.IOException;
import java.util.List;

public interface IPersistence {
    void onPersist(String tipicName,String type,String subDirName,String id, String textContent, List<JPersistData> pictures) throws IOException;
}
