package com.fsmc.backend.utils.csv;

import java.util.Map;
import java.util.function.Consumer;

public interface CsvRows {
    void put(String[] strings) throws Exception;
    void foreach(Consumer<Map<String, String>> consumer);
}
