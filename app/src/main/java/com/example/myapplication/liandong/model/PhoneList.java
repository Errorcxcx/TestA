package com.example.myapplication.liandong.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {
    public final List<PhoneBrand> list = new ArrayList<>();
    public static PhoneList phoneList = null;
    public static PhoneList getInstance(){
        if(phoneList == null){
            phoneList = new PhoneList();
        }
        return phoneList;
    }
    private  PhoneList(){
        PhoneBrand c1 = new PhoneBrand("小米");
        PhoneBrand c2 = new PhoneBrand("苹果");
        PhoneBrand c3 = new PhoneBrand("oppo");

        PhoneBrand c4 = new PhoneBrand("华为");

        PhoneBrand c5 = new PhoneBrand("三星");
        PhoneBrand c6 = new PhoneBrand("诺基亚");

        PhoneBrand c7 = new PhoneBrand("VIVO");

        PhoneBrand c8 = new PhoneBrand("MOTO");
        PhoneBrand c9 = new PhoneBrand("SONY");
        PhoneBrand c10 = new PhoneBrand("佳能");
        PhoneBrand c11 = new PhoneBrand("格力");

        Phone p1 = new Phone("Mi 10 Pro","1999");
        Phone p2 = new Phone("Mi 10 ","5282");
        Phone p3 = new Phone("Mi 9 Pro","5555");
        Phone p4 = new Phone("Mi 8 Pro","4444");
        Phone p5 = new Phone("Mi 7 Pro","1111");

        Phone p6 = new Phone("Apple 11 pro","2222");
        Phone p7 = new Phone("Apple 10 Pro","5399");
        Phone p8 = new Phone("Apple 9 Pro","5555");
        Phone p9 = new Phone("Apple 8 Pro","3333");
        Phone p10 = new Phone("Apple 6 Pro","1111");

        Phone p11 = new Phone("华为 mate Pro","4444");
        Phone p12 = new Phone("华为 mate Pro","7777");
        Phone p13 = new Phone("华为 mate Pro","9999");
        Phone p14 = new Phone("华为 p40 Pro","3333");
        Phone p15 = new Phone("华为 10 Pro","5555");

        Phone p16 = new Phone("三星 10 Pro","7777");
        Phone p17 = new Phone("三星 10 Pro","3333");
        Phone p18 = new Phone("三星 10 Pro","1111");
        Phone p19 = new Phone("三星 10 Pro","3333");
        Phone p20 = new Phone("三星 10 Pro","5555");




        List<Phone> phones = new ArrayList<>();
        List<Phone> phones1 = new ArrayList<>();
        List<Phone> phones2 = new ArrayList<>();
        List<Phone> phones3 = new ArrayList<>();

        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        phones.add(p5);

        phones1.add(p6);
        phones1.add(p7);
        phones1.add(p8);
        phones1.add(p9);
        phones1.add(p10);

        phones2.add(p11);
        phones2.add(p12);
        phones2.add(p13);
        phones2.add(p14);
        phones2.add(p15);

        phones3.add(p16);
        phones3.add(p17);
        phones3.add(p18);
        phones3.add(p19);
        phones3.add(p20);

        c1.setPhoneList(phones);
        c2.setPhoneList(phones1);
        c3.setPhoneList(phones2);
        c4.setPhoneList(phones3);
        c5.setPhoneList(phones);
        c6.setPhoneList(phones1);
        c7.setPhoneList(phones2);
        c8.setPhoneList(phones3);
        c9.setPhoneList(phones);
        c10.setPhoneList(phones1);
        c11.setPhoneList(phones2);


        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c9);
        list.add(c10);
        list.add(c11);
    }

}
