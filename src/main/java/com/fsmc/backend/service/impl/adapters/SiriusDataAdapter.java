package com.fsmc.backend.service.impl.adapters;

public class SiriusDataAdapter extends AbsCompanyRawDataAdapter {
    public SiriusDataAdapter() {
        super("Сириус 95");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амізон 0,125 №10 табл.")) {
            return "Амизон";
        } else if (sku.contains("Амізон 0,25г №10 табл.")) {
            return "Амизон";
        } else if (sku.contains("Амізон 0,25г №20 табл.")) {
            return "Амизон";
        } else if (sku.contains("Амізон макс 0.5г №10 капс.")) {
            return "Амизон";
        } else if (sku.contains("Гропівірин 500мг №20 табл.")) {
            return "Гропивирин";
        } else if (sku.contains("Гропівірин 500мг №50 табл.")) {
            return "Гропивирин";
        } else if (sku.contains("Амізончик 10мг/мл 100мл сироп")) {
            return "Амизон";
        } else if (sku.contains("Лактіалє №10 пак.")) {
            return "Лактиале";
        } else if (sku.contains("Лактіалє №30 капс.")) {
            return "Лактиале";
        } else if (sku.contains("Лактіалє малюк 0,5г №14 пак.")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Мілт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван плющ 100мл сироп")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фіто іслан.мох")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц 100мл сироп")) {
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
        if (sku.contains("Гропівірин 500мг №50 табл.")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
