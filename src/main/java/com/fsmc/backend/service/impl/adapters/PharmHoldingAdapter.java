package com.fsmc.backend.service.impl.adapters;

public class PharmHoldingAdapter extends AbsCompanyRawDataAdapter {
    public PharmHoldingAdapter() {
        super("Фарм-Холднг");
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
