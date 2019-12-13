package com.fsmc.backend.service.impl.adapters;

public class PervotsvetDataAdapter extends AbsCompanyRawDataAdapter {

    public PervotsvetDataAdapter() {
        super("Первоцвет");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.toLowerCase().contains("Амизон".toLowerCase())) {
            return "Амизон";
        } else if (sku.contains("Гропивирин таб. 500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин таб. 500мг №50")) {
            return "Гропивирин";
        } else if (sku.toLowerCase().contains("Лактиале капс".toLowerCase())) {
            return "Лактиале";
        } else if (sku.toLowerCase().contains("Лактиале малыш".toLowerCase())) {
            return "Лактиале";
        } else if (sku.toLowerCase().contains("Лактиале пак".toLowerCase())) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван плющ")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Плющ")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц")) {
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
        if (sku.contains("Гропивирин таб. 500мг №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
