package com.aarshinkov.projects.pn;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Region {

    private String region;
    private Integer number;

    private Map<NumberRegion, String> regions;

    public Region(Integer number) {
        initializeRegions();
        this.number = number;
    }

    public String getRegion() {
        for (NumberRegion numberRegion : regions.keySet()) {
            if (numberRegion.isInRegion(number)) {
                region = regions.get(numberRegion);
            }
        }
        return region;
    }

    private void initializeRegions() {
        regions = new LinkedHashMap<>();
        regions.put(new NumberRegion(0, 43), "Благоевград");
        regions.put(new NumberRegion(44, 93), "Бургас");
        regions.put(new NumberRegion(94, 139), "Варна");
        regions.put(new NumberRegion(140, 169), "Велико Търново");
        regions.put(new NumberRegion(170, 183), "Видин");
        regions.put(new NumberRegion(184, 217), "Враца");
        regions.put(new NumberRegion(218, 233), "Габрово");
        regions.put(new NumberRegion(234, 281), "Кърджали");
        regions.put(new NumberRegion(282, 301), "Кюстендил");
        regions.put(new NumberRegion(302, 319), "Ловеч");
        regions.put(new NumberRegion(320, 341), "Монтана");
        regions.put(new NumberRegion(342, 377), "Пазарджик");
        regions.put(new NumberRegion(378, 395), "Перник");
        regions.put(new NumberRegion(396, 435), "Плевен");
        regions.put(new NumberRegion(436, 501), "Пловдив");
        regions.put(new NumberRegion(502, 527), "Разград");
        regions.put(new NumberRegion(528, 555), "Русе");
        regions.put(new NumberRegion(556, 575), "Силистра");
        regions.put(new NumberRegion(576, 601), "Сливен");
        regions.put(new NumberRegion(602, 622), "Смолян");
        regions.put(new NumberRegion(623, 721), "София - град");
        regions.put(new NumberRegion(722, 751), "София - окръг");
        regions.put(new NumberRegion(752, 789), "Стара загора");
        regions.put(new NumberRegion(790, 821), "Добрич");
        regions.put(new NumberRegion(822, 843), "Търговище");
        regions.put(new NumberRegion(844, 871), "Хасково");
        regions.put(new NumberRegion(872, 903), "Шумен");
        regions.put(new NumberRegion(904, 925), "Ямбол");
        regions.put(new NumberRegion(926, 999), "Друг");
    }
}
