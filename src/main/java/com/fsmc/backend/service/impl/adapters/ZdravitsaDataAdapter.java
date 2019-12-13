package com.fsmc.backend.service.impl.adapters;

public class ZdravitsaDataAdapter extends AbsCompanyRawDataAdapter {
    public ZdravitsaDataAdapter() {
        super("Здравица (Добрi лiки)");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.toLowerCase().contains("АМИЗОН".toLowerCase())) {
            return "Амизон";
        } else if (sku.contains("БАД ЛАКТИАЛЕ КАПС 230МГ №30 НДС")) {
            return "Лактиале";
        } else if (sku.contains("БАД ЛАКТИАЛЕ МАЛЫШ ФОРМУЛА ПАК 0,5Г №14 НДС")) {
            return "Лактиале";
        } else if (sku.contains("БАД ЛАКТИАЛЕ ПАК 1Г №10 НДС")) {
            return "Лактиале";
        } else if (sku.contains("ГРОПИВИРИН ТАБ 500МГ №20")) {
            return "Гропивирин";
        } else if (sku.contains("ГРОПИВИРИН таб 500мг №50")) {
            return "Гропивирин";
        } else if (sku.toLowerCase().contains("ЛИЗАК".toLowerCase())) {
            return "Лизак";
        } else if (sku.contains("МИЛТ КАП НАЗАЛ 10МЛ")) {
            return "Милт";
        } else if (sku.contains("НАЗОФЕРОН КАП НАЗАЛ 100000МЕ/МЛ 5МЛ")) {
            return "Назоферон";
        } else if (sku.contains("НАЗОФЕРОН СПРЕЙ НАЗАЛ 100000МЕ/МЛ 5МЛ")) {
            return "Назоферон";
        } else if (sku.contains("ПЕКТОЛВАН ПЛЮЩ СИРОП 35МГ/5МЛ 100МЛ")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН ФИТО ЭКСТ ЖИД 50МЛ")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН Ц СИРОП 100МЛ")) {
            return "Пектолван";
        } else if (sku.contains("РИНТ СПРЕЙ НАЗАЛ МЕНТОЛ 0,5МГ/Г С НАСОС-ДОЗАТ С РАСП 10Г")) {
            return "Ринт";
        } else if (sku.contains("РИНТ СПРЕЙ НАЗАЛ УВЛАЖ 0,5МГ/Г С НАСОС-ДОЗАТ С РАСП 10Г")) {
            return "Ринт";
        } else if (sku.contains("ХЕПИЛОР Р-Р Д/ПОЛОСК РОТ ПОЛОС 100МЛ")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР СПРЕЙ Д/РОТ ПОЛОС 20МЛ")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР СПРЕЙ Д/РОТ ПОЛОС 50МЛ")) {
            return "Хепилор";
        } else {
            return null;
        }
    }

    @Override
    protected double getIndexBySku(String sku) {
        if (sku.contains("ГРОПИВИРИН таб 500мг №50")) {
            return 2.5;
        } else {
            return 1;
        }
    }
}
