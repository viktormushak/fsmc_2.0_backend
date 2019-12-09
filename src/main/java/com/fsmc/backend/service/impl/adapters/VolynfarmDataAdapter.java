package com.fsmc.backend.service.impl.adapters;

public class VolynfarmDataAdapter extends AbsCompanyRawDataAdapter {
    public VolynfarmDataAdapter() {
        super("Волыньфарм");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("ААмізон (дит) табл 0,125г №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон (дит) табл. 0,125г №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон Макс капс №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон Макс капс. №10 Фармак")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл 0,25г №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл 0,25г №20")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл. 0,25 г №10")) {
            return "Амизон";
        } else if (sku.contains("Амізон табл. 0,25 г №20")) {
            return "Амизон";
        } else if (sku.contains("Гропівірин табл. 500 мг №50")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірін табл 500мг №20")) {
            return "Гропивирин";
        }  else if (sku.contains("Гропівірін табл 500мг №50")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірін табл. 500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірін табл. 500мг №50")) {
            return "Гропивирин";
        } else if (sku.contains("Лактіале капс  д/дор №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале капс. д/дор. №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале малюк формула пак 0,5г №14")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале малюк формула пак. 0.5г №14")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале пак д/діт №10")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале пак. д/діт. №10")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Мілт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван плющ 100мл, Фармак")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фіто ісландський мох 50мл фл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фіто Ісландський мох 50мл, Фармак")) {
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
        if (sku.contains("Гропівірин табл. 500 мг №50")) {
            return 2.5;
        } else if (sku.contains("Гропівірін табл 500мг №50")) {
            return 2.5;
        } else if (sku.contains("Гропівірін табл. 500мг №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
