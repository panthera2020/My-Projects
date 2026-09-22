public class LongestSubstring {


    public int getLengthOfLongestSubstring(String word) {
        String[] words = word.split("");
        String subString = "";
        int length = 0;
        for(int index = 0, count = 1, counter = 2; index < words.length; index++, counter++,count++) {
            if(count < words.length && !words[index].equals(words[count])){
                subString = addStrings(words[index], words[count]);
                if(subString.length() > length){
                    length = subString.length();
                }
            }

            if(counter < words.length && isStringIn(subString, words[counter])){
                subString = words[count];
            } else if(counter < words.length){
                subString = addStrings(subString, words[counter]);
                if(subString.length() > length){
                    length = subString.length();
                }
            }
        }
        return length;
    }

    public String addStrings(String firstWord, String secondWord) {
        return firstWord + secondWord;
    }

    public boolean isStringIn(String word, String singleWord) {
        for(int index = 0; index < word.length(); index++){
            if(word.charAt(index) ==  singleWord.charAt(0)){
                return true;
            }
        }
        return false;
    }
}
