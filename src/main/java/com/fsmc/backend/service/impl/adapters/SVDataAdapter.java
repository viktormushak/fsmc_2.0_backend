package com.fsmc.backend.service.impl.adapters;

public class SVDataAdapter extends AbsCompanyRawDataAdapter {

    public SVDataAdapter() {
        super("СВ Медикал");
    }

    @Override
    protected String getBrandBySku(String sku) {
        if (sku.contains("АМИЗОН® МАКС капсулы по 0,5 г")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН® таблетки, п/о, по 0,125 г")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН® таблетки, п/о, по 0,25 г №10")) {
            return "Амизон";
        } else if (sku.contains("АМИЗОН® таблетки, п/о, по 0,25 г №20")) {
            return "Амизон";
        } else if (sku.contains("Лактиале капс. 230мг N30(15х2)")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале Малыш формула пак.0.5г N14")) {
            return "Лактиале";
        } else if (sku.contains("Лактиале пак. 1г N10")) {
            return "Лактиале";
        } else if (sku.contains("ГРОПИВИРИН таблетки по 500 мг №20 (10х2)")) {
            return "Гропивирин";
        } else if (sku.contains("ГРОПИВИРИН таблетки по 500 мг №50 (10х5)")) {
            return "Гропивирин";
        } else if (sku.contains("ЛИЗАК® таблетки д/сос. со вкус. аниса и мяты №10 (10х1)")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК® таблетки д/сос. со вкус. апельс. №10 (10х1)")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК® таблетки д/сос. со вкус. малины №10 (10х1)")) {
            return "Лизак";
        } else if (sku.contains("ЛИЗАК® таблетки д/сос. со вкус. шокол. №10 (10х1)")) {
            return "Лизак";
        } else if (sku.contains("Милт капли назал.10 мл во флак.")) {
            return "Милт";
        } else if (sku.contains("НАЗОФЕРОН™ капли наз. 100 000 мо/мл по 5 мл во флак. стекл.")) {
            return "Назоферон";
        } else if (sku.contains("НАЗОФЕРОН™ спрей наз. 100 000 мо/мл по 5 мл во флак. стекл.")) {
            return "Назоферон";
        } else if (sku.contains("ПЕКТОЛВАН® ПЛЮЩ сироп по 100 мл во флак.")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН® ФИТО  ИСЛАНДСКИЙ МОХ экстракт жид. по 50 мл во флак.")) {
            return "Пектолван";
        } else if (sku.contains("ПЕКТОЛВАН® Ц сироп по 100 мл во флак.")) {
            return "Пектолван";
        } else if (sku.contains("РИНТ НАЗАЛЬНЫЙ СПРЕЙ® С МЕНТОЛОМ спрей наз., 0,5 мг/г")) {
            return "Ринт";
        } else if (sku.contains("РИНТ НАЗАЛЬНЫЙ СПРЕЙ® УВЛАЖНЯЮЩИЙ спрей наз., 0,5 мг/г")) {
            return "Ринт";
        } else if (sku.contains("ХЕПИЛОР раствор д/полоск. рот. полос. по 100 мл во флак.")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР спрей д/рот. полос. по 20 мл во флак.")) {
            return "Хепилор";
        } else if (sku.contains("ХЕПИЛОР спрей д/рот. полос. по 50 мл во флак.")) {
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
