package tf.qa.automation;


public enum Country {
    ITALY("Италия", true),
    NETHERLANDS("Нидерланды", false),
    KAZAKHSTAN("Казахстан", true),
    CHINA("Китай", false);

    //создаем конструктор
    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }


    public static void getByRuName(final String name) throws NoSuchCountryException {
        switch (name) {
            case "Италия":
                Country.status(Country.ITALY);
                break;
            case "Нидерланды":
                Country.status(Country.NETHERLANDS);
                break;
            case "Казахстан":
                Country.status(Country.KAZAKHSTAN);
                break;
            case "Китай":
                Country.status(Country.CHINA);
                break;
            default:
                throw new NoSuchCountryException(name);
        }


    }


    @Override
    public final String toString() {
        return this.name() + "(" + this.ruName + ")";
    }

    public static void status(final Country country) {
        if (country.isOpen) {
            System.out.println(country.name() + "(" + country.ruName + ")" + "открыта для посещения");
        } else {
            System.out.println(country.name() + "(" + country.ruName + ")" + "закрыта для посещения");
        }

    }


}



