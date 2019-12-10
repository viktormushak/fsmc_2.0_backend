package com.fsmc.backend.service.impl.adapters;

public class NatalkaDataAdapter extends AbsCompanyRawDataAdapter {

    public NatalkaDataAdapter() {
        super("Наталка");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон д/детей таб. 0,125 №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон Макс капс.0,5г №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб. 0,25 №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб. 0,25 №20")) {
            return "Амизон";
        } else if (sku.contains("Гропивирин таб.500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин табл. 500мг №50")) {
            return "Гропивирин";
        }  else if (sku.contains("Лактиале капс.№30")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале малыш пак.0,5г №14")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале пак.1г №10")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито Исл.мох фл.50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп 100мл")) {
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
        if (sku.contains("Гропивирин табл. 500мг №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
