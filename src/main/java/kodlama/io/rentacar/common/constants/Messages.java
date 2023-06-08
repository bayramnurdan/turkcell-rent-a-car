package kodlama.io.rentacar.common.constants;

public class Messages {
    public static class Car {
        public static final String NOT_EXISTS = "CAR_NOT_EXISTS";
        public static final String ALREADY_EXISTS = "CAR_ALREADY_EXISTS";
        public static final String NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
    }

    public static class Model {
        public static final String NOT_EXISTS = "MODEL_NOT_EXISTS";
        public static final String ALREADY_EXISTS = "MODEL_ALREADY_EXISTS";
    }

    public static class Brand {
        public static final String NOT_EXISTS = "BRAND_NOT_EXISTS";
        public static final String ALREADY_EXISTS = "BRAND_ALREADY_EXISTS";
    }

    public static class Maintenance {
        public static final String NOT_EXISTS = "MAINTENANCE_NOT_EXISTS";
        public static final String CAR_IS_CURRENTLY_UNDER_MAINTENANCE = "CAR_IS_CURRENTLY_UNDER_MAINTENANCE";
        public static final String NOT_REGISTERED_FOR_MAINTENANCE = "CAR_NOT_REGISTERED_FOR_MAINTENANCE";
        public static final String CAR_IS_RENTED = "CAR_IS_CURRENTLY_RENTED_AND_CANNOT_BE_SERVICED_FOR_MAINTENANCE";
    }

    public static class Rental {
        public static final String NOT_EXISTS = "RENTAL_NOT_EXISTS";
    }

    public static class Payment {
        public static final String PAYMENT_NOT_FOUND = "PAYMENT_NOT_FOUND";
        public static final String CARD_NUMBER_ALREADY_EXISTS = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String NOT_ENOUGH_MONEY = "NOT_ENOUGH_MONEY";
        public static final String NOT_A_VALID_PAYMENT = "NOT_A_VALID_PAYMENT";
        public static final String PAYMENT_FAILED = "PAYMENT_FAILED";
    }

    public static class Invoice {
        public static final String NOT_FOUND = "INVOICE_NOT_FOUND";
    }
}