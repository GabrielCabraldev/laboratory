package br.com.danilomr.guiadogs.enums;

public enum KindEnum {

    DOG, CAT;

    public static boolean contains(final String string) {
        KindEnum[] values = KindEnum.values();

        for (int i = 0; i < values.length; i++) {
            if (values[i].toString().equalsIgnoreCase(string)) {
                return true;
            }
        }

        return false;
    }
}
