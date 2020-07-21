package com.aarshinkov.projects.pn;

import java.util.*;

public class PersonalNumber {

    private final String personalNumber;
    private final Integer[] pnArray = new Integer[10];
    private String region;
    private String gender;
    private Calendar dob;

    public PersonalNumber(String personalNumber) throws Exception {
        this.personalNumber = personalNumber;
        createPersonalNumberArray();
        if (!isControlNumberValid()) {
//            throw new Exception("This personal number is not valid. Control number does not match!");
            throw new Exception("Въведеното ЕГН е невалидно. Контролното число е невалидно!");
        }
        defineDOB();
        defineRegion();
        defineGender();
    }

    private void createPersonalNumberArray() throws Exception {
        String[] personalNumberArr = personalNumber.split("");

        int pnArrLength = personalNumber.length();

        if (pnArrLength != 10) {
//            throw new Exception("This personal number is not valid. It must consist of 10 digits!");
            throw new Exception("Въведеното ЕГН е невалидно. Трябва да съдържа 19 цифри!");
        }

        for (int i = 0; i < pnArrLength; i++) {
            int number = Integer.parseInt(personalNumberArr[i]);
            pnArray[i] = number;
        }
    }

    private void defineDOB() {
        int auxMonth = pnArray[2] * 10 + pnArray[3];

        int year;

        // Родените след 2000 година
        if (auxMonth >= 41 && auxMonth <= 52) {
            year = 2000 + pnArray[0] * 10 + pnArray[1];
        } else if (auxMonth >= 21 && auxMonth <= 32) {
            year = 1800 + pnArray[0] * 10 + pnArray[1];
        } else {
            year = 1900 + pnArray[0] * 10 + pnArray[1];
        }

        int month;
        if (year < 1900) {
            // Защото на родените predi 1900 година се добавя числото 20 към месеца
            month = pnArray[2] * 10 + pnArray[3] - 20;
        } else if (year >= 2000) {
            // Защото на родените след 2000 година се добавя числото 40 към месеца
            month = pnArray[2] * 10 + pnArray[3] - 40;
        } else {
            month = pnArray[2] * 10 + pnArray[3];
        }

        int date = pnArray[4] * 10 + pnArray[5];

        dob = new GregorianCalendar(year, month - 1, date);
    }

    private void defineRegion() {
        int result = pnArray[6] * 100 + pnArray[7] * 10 + pnArray[8];
        Region region = new Region(result);
        this.region = region.getRegion();
    }

    private void defineGender() {
        Gender gender = new Gender(pnArray[8]);
        this.gender = gender.getGender();
    }

    private boolean isControlNumberValid() {
        int sum = 0;
        for (int i = 0; i < pnArray.length; i++) {
            switch (i) {
                case 0:
                    sum += pnArray[i] * 2;
                    break;
                case 1:
                    sum += pnArray[i] * 4;
                    break;
                case 2:
                    sum += pnArray[i] * 8;
                    break;
                case 3:
                    sum += pnArray[i] * 5;
                    break;
                case 4:
                    sum += pnArray[i] * 10;
                    break;
                case 5:
                    sum += pnArray[i] * 9;
                    break;
                case 6:
                    sum += pnArray[i] * 7;
                    break;
                case 7:
                    sum += pnArray[i] * 3;
                    break;
                case 8:
                    sum += pnArray[i] * 6;
                    break;
            }
        }
        Integer controlNumber = sum % 11;

        if (controlNumber == 10) {
            controlNumber = 0;
        }

        return controlNumber.equals(pnArray[9]);
    }

    private String getMonth(Integer month) throws Exception {
        if (month < 1 || month > 12) {
//            throw new Exception("Invalid month. The month must be between 1 and 12 incl.");
            throw new Exception("Невалиден месец. Месецът трябва да е между 1 и 12 вкл.");
        }
        switch (month) {
            case 1:
                return "Януари";
            case 2:
                return "Февруари";
            case 3:
                return "Март";
            case 4:
                return "Април";
            case 5:
                return "Май";
            case 6:
                return "Юни";
            case 7:
                return "Юли";
            case 8:
                return "Август";
            case 9:
                return "Септември";
            case 10:
                return "Октомври";
            case 11:
                return "Ноември";
            case 12:
                return "Декември";
            default:
                return "";
        }
    }

    public void printInformation() throws Exception {
        System.out.println("Информация:");
        System.out.println("Дата на раждане: " + getDob());
        System.out.println("Област: " + getRegion());
        System.out.println("Пол: " + getGender());
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getDob() throws Exception {
        StringBuilder builder = new StringBuilder();

        String month = getMonth(dob.get(Calendar.MONTH) + 1);
        builder.append(dob.get(Calendar.DATE)).append(" ").append(month).append(" ").append(dob.get(Calendar.YEAR));
        return String.valueOf(builder);
    }

    public String getRegion() {
        return region;
    }

    public String getGender() {
        return gender;
    }
}
