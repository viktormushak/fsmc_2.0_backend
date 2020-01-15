package com.fsmc.backend.service.impl.adapters;

public class ShapiroDataAdapter extends AbsCompanyRawDataAdapter {

    public ShapiroDataAdapter() {
        super("Шапиро");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.toLowerCase().contains("Амизон".toLowerCase())) {
            return "Амизон";
        } else if (sku.contains("Гропивирин таб 500мг N20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин таб 500мг N50")) {
            return "Гропивирин";
        } else if (sku.contains("Лактиале капс N30")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале пакет N10")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале Малыш пак 0,5г N14")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван С сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито ислан мох 50мл")) {
            return "Пектолван";
        } else if (sku.contains("Ринт")) {
            return "Ринт";
        } else if (sku.contains("Хепи лор")) {
            return "Хепилор";
        } else {
            return null;
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        if (sku.contains("Гропивирин таб 500мг N50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
