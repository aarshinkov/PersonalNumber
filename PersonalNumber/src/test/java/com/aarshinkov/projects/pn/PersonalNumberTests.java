package com.aarshinkov.projects.pn;

import org.junit.Assert;
import org.junit.Test;

public class PersonalNumberTests {

    @Test (expected = Exception.class)
    public void test1() throws Exception {
        PersonalNumber pn = new PersonalNumber("9604216189");
        Assert.assertEquals("9604216188", pn.getPersonalNumber());
        Assert.assertEquals("21 Април 1996", pn.getDob());
        Assert.assertEquals("Смолян", pn.getRegion());
        Assert.assertEquals("Мъж", pn.getGender());
    }

    @Test
    public void test2() throws Exception {
        PersonalNumber pn = new PersonalNumber("1245191567");
        Assert.assertEquals("1245191567", pn.getPersonalNumber());
        Assert.assertEquals("19 Май 2012", pn.getDob());
        Assert.assertEquals("Велико Търново", pn.getRegion());
        Assert.assertEquals("Мъж", pn.getGender());
    }

    @Test
    public void test3() throws Exception {
        PersonalNumber pn = new PersonalNumber("0410296492");
        Assert.assertEquals("0410296492", pn.getPersonalNumber());
        Assert.assertEquals("29 Октомври 1904", pn.getDob());
        Assert.assertEquals("София - град", pn.getRegion());
        Assert.assertEquals("Жена", pn.getGender());
    }

    @Test
    public void test4() throws Exception {
        PersonalNumber pn = new PersonalNumber("0810231990");
        Assert.assertEquals("0810231990", pn.getPersonalNumber());
        Assert.assertEquals("23 Октомври 1908", pn.getDob());
        Assert.assertEquals("Враца", pn.getRegion());
        Assert.assertEquals("Жена", pn.getGender());
    }

    @Test
    public void test5() throws Exception {
        PersonalNumber pn = new PersonalNumber("9904302219");
        Assert.assertEquals("9904302219", pn.getPersonalNumber());
        Assert.assertEquals("30 Април 1999", pn.getDob());
        Assert.assertEquals("Габрово", pn.getRegion());
        Assert.assertEquals("Жена", pn.getGender());
    }

    @Test
    public void test6() throws Exception {
        PersonalNumber pn = new PersonalNumber("1050312500");
        Assert.assertEquals("1050312500", pn.getPersonalNumber());
        Assert.assertEquals("31 Октомври 2010", pn.getDob());
        Assert.assertEquals("Кърджали", pn.getRegion());
        Assert.assertEquals("Мъж", pn.getGender());
    }
}
