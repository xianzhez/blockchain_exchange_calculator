package xianzhe.utils.common;

public class XUtils {
    public static double stringToDouble(String input){
        double output = 0;
        try {
            output = Double.parseDouble(input);

        } catch (Exception e){
            e.printStackTrace();
        }

        return output;
    }

    public static boolean isTextEmpty(String str){
        if (str == null || str.equals("")){
            return true;
        }

        return false;
    }

}
