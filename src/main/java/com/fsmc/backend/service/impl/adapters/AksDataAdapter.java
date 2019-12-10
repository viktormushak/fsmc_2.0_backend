package com.fsmc.backend.service.impl.adapters;

public class AksDataAdapter extends AbsCompanyRawDataAdapter {
    public AksDataAdapter() {
        super("Акс");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон 0,25 №10 таб (ФАРМАК)")) {
            return "Амизон";
        } else if (sku.contains("Амизон 0,25 №20 таб (ФАРМАК)")) {
            return "Амизон";
        } else if (sku.contains("Амизон д/детей 0,125 №10 таб (ФАРМАК)")) {
            return "Амизон";
        } else if (sku.contains("Амизон Макс 0,5 №10 капс (ФАРМАК)")) {
            return "Амизон";
        } else if (sku.contains("Амизончик 100мл сироп (ФАРМАК)")) {
            return "Амизон";
        } else if (sku.contains("Гропивирин 500мг №20 таб (ФАРМАК)")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин 500мг №50 таб (ФАРМАК)")) {
            return "Гропивирин";
        } else if (sku.contains("Лактиале 1г №10 пак (ФАРМАК)")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале 230мг №30 капс (ФАРМАК)")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале Малыш 0,5г №14 пак (ФАРМАК)")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ 100мл сироп (ФАРМАК)")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито Исландский мох 50мл (ФАРМАК)")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц 100мл сироп (ФАРМАК)")) {
            return "Пектолван";
        } else if (sku.contains("Ринт")) {
            return "Ринт";
        } else if (sku.contains("Хепилор")) {
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
