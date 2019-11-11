package com.fsmc.backend.service.impl.adapters;

public class AstartaDataAdapter extends AbsCompanyRawDataAdapter {

    public AstartaDataAdapter() {
        super("Астарта");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон Макс табл. 0.5 г  №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон табл. 0.125 №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон табл. 0.25 г  №10")) {
            return "Амизон";
        } else if (sku.contains("Амизон табл. 0.25 г  №20")) {
            return "Амизон";
        } else if (sku.contains("Лактиале пак. №10")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале капс. №30")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале малыш пакет. №14")) {
            return "Лактиале";
        } else if (sku.contains("Гропивирин таб. 500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин таб. 500мг №50")) {
            return "Гропивирин";
        } else if (sku.contains("Лизак  табл. д/рассасыв. мята ,анис №10")) {
            return "Лизак";
        } else if (sku.contains("Лизак табл. 0.25мг N10 апельсин")) {
            return "Лизак";
        } else if (sku.contains("Лизак табл. 0.25мг N10 малина")) {
            return "Лизак";
        } else if (sku.contains("Лизак табл. 0.25мг N10 шоколад")) {
            return "Лизак";
        } else if (sku.contains("Милт капли назал. 10мл")) {
            return "Милт";
        } else if (sku.contains("Назоферон капли наз.100000МЕ/мл 5мл")) {
            return "Назоферон";
        } else if (sku.contains("Назоферон спрей наз.100000МЕ/мл 5мл")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван плющ сироп 100мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито Исланд.мох экстр.жидк.фл.50мл")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Ц сироп 100мл фл.")) {
            return "Пектолван";
        } else if (sku.contains("Ринт спрей назал. с мент. 0.5мг/г 10г")) {
            return "Ринт";
        } else if (sku.contains("Ринт спрей назал. увлаж. 0.5мг/г 10г")) {
            return "Ринт";
        } else if (sku.contains("Хепилор р-р д/полоск. ротовой полости 100мл")) {
            return "Хепилор";
        } else if (sku.contains("Хепилор спрей д/пол. рта 20мл")) {
            return "Хепилор";
        } else if (sku.contains("Хепилор спрей д/пол. рта 50мл")) {
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
