package com.fsmc.backend.service.impl.adapters;

public class VitaluxDataAdapter extends AbsCompanyRawDataAdapter {
    public VitaluxDataAdapter() {
        super("Виталюкс");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амізон")) {
            return "Амизон";
        } else if (sku.contains("Едем")) {
            return "Эдем";
        } else if (sku.contains("Лактіале")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван фіто ІСЛАНДСЬКИЙ МОХ екстр.рідк. 50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван ц сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Ринт")) {
            return "Ринт";
        } else if (sku.contains("Хепілор")) {
            return "Хепилор";
        } else {
            return null;
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        return 1;
    }
}
