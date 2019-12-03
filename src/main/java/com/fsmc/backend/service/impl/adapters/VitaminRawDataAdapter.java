package com.fsmc.backend.service.impl.adapters;

public class VitaminRawDataAdapter extends AbsCompanyRawDataAdapter {
    public VitaminRawDataAdapter() {
        super("Витамин");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("АМІЗОН МАКС")) {
            return "Амизон";
        } else if (sku.contains("АПСОРБІН")) {
            return "Апсорбин";
        } else if (sku.contains("ГРОПІВІРІН табл. 500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("ЕДЕМ сироп")) {
            return "Эдем";
        } else if (sku.contains("ЕДЕМ табл")) {
            return "Эдем";
        } else if (sku.contains("ЛІЗАК")) {
            return "Лизак";
        } else if (sku.contains("НАЗОФЕРОН")) {
            return "Назоферон";
        } else if (sku.contains("ХЕПІЛОР")) {
            return "Хепилор";
        } else return null;
    }

    @Override
    protected double getIndexBySku(String sku) {
        return 1;
    }
}
