package com.fsmc.backend.service.impl.adapters;

public class ProvizorDataAdapter extends AbsCompanyRawDataAdapter {

    public ProvizorDataAdapter() {
        super("Провизор");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("АМИЗОН МАКС капс. по 0,5 г №10")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН табл. п.о. по 0,125 г №10 в бл.")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН табл. п.о. по 0,25 г №10 в бл.")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН табл. п.о. по 0,25 г №20 в бл.")) {
            return "Амизон";
        } else if (sku.contains("ЛАКТИАЛЕ капс. №30 (15х2) в бл. в пач.")) {
            return "Лактиале";
        } else if (sku.contains("ЛАКТИАЛЕ МАЛЫШ ФОРМУЛА пор. 0,5 г. №14")) {
            return "Лактиале";
        } else if (sku.contains("ЛАКТИАЛЕ ПАК. №10")) {
            return "Лактиале";
        } else if (sku.contains("Гропивирин таб. по 500мг №20")) {
            return "Гропивирин";
        } else if (sku.contains("ГРОПИВИРИН ТАБ.500МГ №50")) {
            return "Гропивирин";
        } else if (sku.contains("ЛИЗАК табл. д/рассас. со вкусом  малины №10 (10х1) в бл.")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК табл. д/рассас. со вкусом аниса и мяты №10 (10х1) в бл.")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК табл. д/рассас. со вкусом апельсина №10 (10х1) в бл.")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК табл. д/рассас. со вкусом шоколада №10  (10х1) в бл.")) {
            return "Лизак";
        } else if (sku.contains("МИЛТ НАЗ.КАП. ПО 10 МЛ ФЛ.№1")) {
            return "Милт";
        } else if (sku.contains("НАЗОФЕРОН® капл. назал. 100000 МЕ/мл по 5 мл во флак. стекл. №1")) {
            return "Назоферон";
        } else if (sku.contains("НАЗОФЕРОН® спрей назал. 100000 МЕ/мл по 5 мл во флак. стекл. №1")) {
            return "Назоферон";
        } else if (sku.contains("ПЕКТОЛВАН ПЛЮЩ сироп по 100 мл во фл. №1")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН ФИТО экстр. жидк. по 50 мл во фл. №1")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН Ц сироп по 100 мл во фл. №1")) {
            return "Пектолван";
        } else if (sku.contains("РИНТ СПРЕЙ НАЗАЛЬНИЙ  УВЛАЖНЯЮЩИЙ 0,5 МГ/Г 10 Г")) {
            return "Ринт";
        } else if (sku.contains("РИНТ СПРЕЙ НАЗАЛЬНИЙ ментол 0,5 МГ/Г 10 Г")) {
            return "Ринт";
        } else if (sku.contains("ХЕПИЛОР р-р д/полоскания рот. полости по 100 мл во фл. в пач.")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР спрей д/рот. полости по 20 мл во фл. №1")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР спрей д/рот. полости по 50 мл во фл. №1 в пач.")) {
            return "Хепилор";
        } else {
            return null;
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        if (sku.contains("ГРОПИВИРИН ТАБ.500МГ №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
