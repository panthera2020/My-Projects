package student;

public class Function {
    public boolean isInputValid(String number) {
        return number.length() == 1;
    }

    public boolean isNumberOfSubjectValid(String number) {
        boolean result = true;
        for(int index = 0; index < number.length(); index++){
            if(!Character.isDigit(number.charAt(index))){
                result = false;
                break;
            }
        }
        return result;
    }
}
