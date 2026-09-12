public class MyString {
    public int getOccurrenceOfCharacterIn(String word, String characater) {
        int numberOfOccurrences = 0;
        for(int index = 0; index < word.length(); index++){
            String eachCharacter = word.charAt(index) + "";
            if(eachCharacter.equalsIgnoreCase(characater)){
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }
}
