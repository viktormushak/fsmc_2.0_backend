package com.fsmc.backend.service.impl.adapters;

public class GammaDataAdapter extends AbsCompanyRawDataAdapter {

    public GammaDataAdapter() {
        super("Гамма");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if(sku.contains("Айдринк пор. д/орал. р-ра смородина 5,2г саше №1")){
            return "Айдринк";
        } else if(sku.contains("Айдринк пор. д/орал. р-ра лимон 4,8г саше №1")){
            return "Айдринк";
        } else if(sku.contains("Гропивирин табл. 500мг №10")){
            return "Гропивирин";
        } else if(sku.contains("Лактиале капс. 230мг №15")){
            return "Лактиале";
        } else if(sku.contains("Лактиале малыш формула пор. пак. 0,5г №1")){
            return "Лактиале";
        } else if(sku.contains("Лактиале пор. пак. 1г №1")){
            return "Лактиале";
        } else if(sku.contains("Лизак табл. д/рассас. анис+мята №10")){
            return "Лизак";
        } else if(sku.contains("Лизак табл. д/рассас. апельсин №10")){
            return "Лизак";
        } else if(sku.contains("Лизак табл. д/рассас. малина №10")){
            return "Лизак";
        } else if(sku.contains("Лизак табл. д/рассас. шоколад №10")){
            return "Лизак";
        } else if(sku.contains("Липстер крем 5% туба 5г")){
            return "Липстер";
        } else if(sku.contains("Милт кап. назал. фл. 10мл")){
            return "Милт";
        } else if(sku.contains("Назоферон кап. назал. 100000МЕ/мл фл. 5мл")){
            return "Назоферон";
        } else if(sku.contains("Назоферон спрей назал.100000МЕ/мл фл. 5мл")){
            return "Назоферон";
        } else if(sku.contains("Пектолван Плющ сироп фл. 100мл")){
            return "Пектолван";
        } else if(sku.contains("Пектолван Фито Исланд. мох экстр. жидк. фл. 50мл")){
            return "Пектолван";
        } else if(sku.contains("Ринт спрей назал. с ментолом 0,5мг/г фл. 10г")){
            return "Ринт";
        } else if(sku.contains("Ринт спрей назал. увлаж. 0.5мг/г фл. 10г")){
            return "Ринт";
        } else if(sku.contains("Эдем Рино спрей назал. р-р фл. 10мл")){
            return "Эдем Рино";
        } else if(sku.contains("Эдем табл. п/о 5мг №10")){
            return "Эдем";
        } else if(sku.contains("Эдем табл. п/о 5мг №30")){
            return "Эдем";
        } else {
            return "";
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        if(sku.contains("Айдринк пор. д/орал. р-ра смородина 5,2г саше №1")){
            return 0.1;
        } else if(sku.contains("Айдринк пор. д/орал. р-ра лимон 4,8г саше №1")){
            return 0.1;
        } else if(sku.contains("Лактиале капс. 230мг №15")){
            return 0.5;
        } else if(sku.contains("Лактиале малыш формула пор. пак. 0,5г №1")){
            return 0.07143;
        } else if(sku.contains("Лактиале пор. пак. 1г №1")){
            return 0.1;
        } else {
            return 1.0;
        }
    }
}
