package com.fsmc.backend.service.impl.adapters;

public class PharmHoldingDataAdapter extends AbsCompanyRawDataAdapter {
    public PharmHoldingDataAdapter() {
        super("ФармХолдинг");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амізон")) {
            return "Амизон";
        } else if (sku.contains("Гропівірін таб. 500мг N 20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірін таб. 500мг N 50")) {
            return "Гропивирин";
        } else if (sku.contains("Лактіалє 1г №10 пакет")) {
            return "Лактиале";
        } else if (sku.contains("Лактіалє 230мг капс.№30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіалє Малюк формула 0,5г №14 пакет")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Мілт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван фіто ісландск.мох 50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп 100мл")) {
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
        if (sku.contains("Гропивирин 500мг №50 таб (ФАРМАК)")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
