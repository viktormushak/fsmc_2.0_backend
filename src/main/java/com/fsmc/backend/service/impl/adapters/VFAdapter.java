package com.fsmc.backend.service.impl.adapters;

public class VFAdapter extends AbsCompanyRawDataAdapter {

    public VFAdapter() {
        super("Волиньфарм");
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
