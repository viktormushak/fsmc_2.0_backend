package com.fsmc.backend.service.impl.adapters;

public class LekfarmDataAdapter extends AbsCompanyRawDataAdapter {
    public LekfarmDataAdapter() {
        super("Лекфарм");
    }

    @Override
    protected String getBrandBySku(String sku) {
        return null;
    }

    @Override
    protected double getIndexBySku(String sku) {
        return 0;
    }
}
