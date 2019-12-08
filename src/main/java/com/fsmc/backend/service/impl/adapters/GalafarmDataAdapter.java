package com.fsmc.backend.service.impl.adapters;

public class GalafarmDataAdapter extends AbsCompanyRawDataAdapter {
    public GalafarmDataAdapter() {
        super("Галафарм");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон Макс капс. 500мг №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб. 0.25 №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб. 125мг №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб. 250мг №20")) {
            return "Амизон";
        } else if (sku.contains("Лактиале д/дет пак. 1г №10")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале капс. 230мг №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале Малыш Формула пак.0,5г. №14")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Липстер")) {
            return "Липстер";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито Исландский мох")) {
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
        return 1;
    }
}
