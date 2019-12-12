package com.fsmc.backend.service.impl.adapters;

public class GammaDataAdapter extends AbsCompanyRawDataAdapter {

    public GammaDataAdapter() {
        super("Гамма");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон")) {
            return "Амизон";
        } else if (sku.contains("Гропивирин табл. 500мг №10(2)")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин табл. 500мг №10(5)")) {
            return "Гропивирин";
        } else if (sku.contains("Лактиале капс. 230мг №15(2)")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале малыш формула пор. пак. 0,5г №1(14)")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале пор. пак. 1г №1(10)")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ сироп фл. 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито Исланд. мох экстр. жидк. фл. 50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп фл. 100мл")) {
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
        if (sku.contains("Гропивирин табл. 500мг №10(2)")) {
            return 0.5d;
        } else if (sku.contains("Гропивирин табл. 500мг №10(5)")) {
            return 0.5d;
        } else if (sku.contains("Лактиале капс. 230мг №15(2)")) {
            return 0.5d;
        } else if (sku.contains("Лактиале малыш формула пор. пак. 0,5г №1(14)")) {
            return 0.7d;
        } else if (sku.contains("Лактиале пор. пак. 1г №1(10)")) {
            return 0.1d;
        } else {
            return 1d;
        }
    }
}
