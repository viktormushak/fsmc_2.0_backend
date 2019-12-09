package com.fsmc.backend.service.impl.adapters;

public class ArnikaDataAdapter extends AbsCompanyRawDataAdapter {
    public ArnikaDataAdapter() {
        super("Арника");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("Амизон Макс")) {
            return "Амизон";
        } else if (sku.contains("Амізон 250мг №10 таб")) {
            return "Амизон";
        } else if (sku.contains("Амизон таб")) {
            return "Амизон";
        } else if (sku.contains("Гропивирин таб.500мг№10(2)")) {
            return "Гропивирин";
        } else if (sku.contains("Гропивирин таб.500мг№10(5)")) {
            return "Гропивирин";
        } else if (sku.contains("Лактиале капс. 230мг")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале МАЛЫШ")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале пак.№1")) {
            return "Лактиале";
        } else if (sku.contains("Лизак")) {
            return "Лизак";
        } else if (sku.contains("Милт")) {
            return "Милт";
        } else if (sku.contains("Назоферон")) {
            return "Назоферон";
        } else if (sku.contains("Пектолван Плющ сироп")) {
            return "Пектолван";
        } else if (sku.contains("Пектолван Фито экстр.жидк.исл")) {
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
        if (sku.contains("Гропивирин таб.500мг№10(5)")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
