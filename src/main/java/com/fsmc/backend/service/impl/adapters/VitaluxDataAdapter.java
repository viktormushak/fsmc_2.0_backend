package com.fsmc.backend.service.impl.adapters;

public class VitaluxDataAdapter extends AbsCompanyRawDataAdapter {
    public VitaluxDataAdapter() {
        super("Виталюкс");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амізон Макс табл. 500мг №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл. 125мг №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл. 250мг №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл. 250мг №20")) {
            return "Амизон";
        } else if (sku.contains("Гропівірін табл. 500 мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("Лактіале капс. №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале Малюк пак.0,5г №14")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале пак. №10")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Мілт")) {
            return "Милт";
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
