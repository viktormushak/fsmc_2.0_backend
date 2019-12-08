package com.fsmc.backend.service.impl.adapters;

public class Apteka36i6DataAdapter extends AbsCompanyRawDataAdapter {

    public Apteka36i6DataAdapter() {
        super("Аптека 36,6");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амізон 125мг №10 таб")) {
            return "Амизон";
        } else if (sku.contains("Амізон 250мг №10 таб")) {
            return "Амизон";
        } else if (sku.contains("Амізон 250мг №20 таб")) {
            return "Амизон";
        } else if (sku.contains("Амізон Макс 0,5 №10 таб")) {
            return "Амизон";
        } else if (sku.contains("Амізончик 100мл")) {
            return "Амизон";
        } else if (sku.contains("Лактіале капс. №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале Малюк 0,5г пак")) {
            return "Лактиале";
        } else if (sku.contains("Лактіале пак. №10")) {
            return "Лактиале";
        } else if (sku.contains("Лізак")) {
            return "Лизак";
        } else if (sku.contains("Мілт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Ісланд. мох")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Плющ сироп")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп")) {
            return "Пектолван";
        } else if (sku.contains("Ринт спрей назал. 10г")) {
            return "Ринт";
        } else if (sku.contains("Ринт спрей назал. зволожуючий 10г")) {
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
