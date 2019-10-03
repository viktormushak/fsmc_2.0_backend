package com.fsmc.backend.service.impl.adapters;

public class UFHAdapter extends AbsCompanyRawDataAdapter {
    public UFHAdapter() {
        super("Украинский фармацевтический холдинг");
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
