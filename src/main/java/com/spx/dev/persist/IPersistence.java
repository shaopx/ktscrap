package com.spx.dev.persist;

import com.spx.dev.JPicture;
import com.spx.dev.domain.TopicResult;

import java.io.IOException;
import java.util.List;

public interface IPersistence {
    void onPersist(String tipicName,String type,String subDirName,String id, String textContent, List<JPicture> pictures) throws IOException;
}
