package by.tms.servlet.Web;

public class Validation {

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isNull(String value1, String value2, String action) {
        if (value1 == null || value2 == null || action == null) {
            return true;
        }
        return false;
    }

    public boolean isEmptyString(String value1, String value2, String action) {
        if (value1.equals("") || value2.equals("") || action.equals("")) {
            return true;
        }
        return false;
    }
}
