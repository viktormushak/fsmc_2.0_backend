package com.fsmc.backend.service.impl.adapters;

public class LikyUkrDataAdapter extends AbsCompanyRawDataAdapter {

    public LikyUkrDataAdapter() {
        super("Ліки України");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.toLowerCase().contains("Амізон".toLowerCase())) {
            return "Амизон";
        } else if (sku.toLowerCase().contains("Гропівірін табл. 500 мг №20".toLowerCase())) {
            return "Гропивирин";
        } else if (sku.toLowerCase().contains("Гропівірін табл. 500 мг №50".toLowerCase())) {
            return "Гропивирин";
        } else if (sku.toLowerCase().contains("Лактіалє® капс".toLowerCase())) {
            return "Лактиале";
        } else if (sku.toLowerCase().contains("Лактіалє® Малюк".toLowerCase())) {
            return "Лактиале";
        } else if (sku.toLowerCase().contains("Лактіалє® пакет".toLowerCase())) {
            return "Лактиале";
        } else if (sku.toLowerCase().contains("Лізак".toLowerCase())) {
            return "Лизак";
        } else if (sku.toLowerCase().contains("Мілт".toLowerCase())) {
            return "Милт";
        } else if (sku.toLowerCase().contains("Назоферон".toLowerCase())) {
            return "Назоферон";
        } else if (sku.toLowerCase().contains("Пектолван® Плющ сироп".toLowerCase())) {
            return "Пектолван";
        } else if (sku.toLowerCase().contains("Пектолван® Фіто Ісланський мох".toLowerCase())) {
            return "Пектолван";
        } else if (sku.toLowerCase().contains("Пектолван® Ц сироп".toLowerCase())) {
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
        if (sku.toLowerCase().contains("Гропівірін табл. 500 мг №50".toLowerCase())) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
