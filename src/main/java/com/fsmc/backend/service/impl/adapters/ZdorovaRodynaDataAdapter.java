package com.fsmc.backend.service.impl.adapters;

public class ZdorovaRodynaDataAdapter extends AbsCompanyRawDataAdapter {

    public ZdorovaRodynaDataAdapter() {
        super("Здорова родина");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.toLowerCase().contains("Амізон".toLowerCase())) {
            return "Амизон";
        } else if (sku.contains("Лактіале капс. 230 мг №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале Малюк пакет №14")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале пак.1 г №10")) {
            return "Лактиале";
        } else if (sku.contains("Гропівірин таб.500мг№20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірин таб.500мг №50")) {
            return "Гропивирин";
        } else if (sku.toLowerCase().contains("Лізак".toLowerCase())) {
            return "Лизак";
        } else if (sku.toLowerCase().contains("Мілт".toLowerCase())) {
            return "Милт";
        } else if (sku.toLowerCase().contains("Назоферон".toLowerCase())) {
            return "Назоферон";
        } else if (sku.contains("Пектолван  Фіто 50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Плющ сироп фл.100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп 100 мл")) {
            return "Пектолван";
        } else if (sku.toLowerCase().contains("Ринт".toLowerCase())) {
            return "Ринт";
        } else if (sku.toLowerCase().contains("Хепілор".toLowerCase())) {
            return "Хепилор";
        } else {
            return null;
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        if (sku.contains("Гропівірин таб.500мг №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
