import java.util.HashMap;
import java.util.Map;

public class StringLib {

        public static Map<Character, Integer> countSymbols(String string){
            Map<Character, Integer> charCount = new HashMap<Character, Integer>();
            for(int i = 0; i<string.length(); i++){
                Character ch = string.charAt(i);
                Integer count = charCount.get(ch);
                if(count == null){
                    count = 0;
                }
                charCount.put(ch, ++count);
            }
            return charCount;
        }

        public static int countWords(String string){
            int count = 0;
            int j = 0;
            while(string.charAt(j) == ' ' || string.charAt(j) == '\n')
                j++;
            for(int i = j + 1; i<string.length(); i++){
                if(string.charAt(i-1) == ' ' || string.charAt(i-1) == '\n')
                    continue;
                if(string.charAt(i) == ' ' || string.charAt(i) == '\n'){
                    count++;
                }
            }
            if(string.charAt(string.length()-1) != ' ' &&
                    string.charAt(string.length()-1) != '\n')
                count++;

            return count;
        }


        public static char[][] splitIntoWords(char [] chars, int size, int wordsNumber){
            char [][] result = new char[wordsNumber][];
            int letterNumber = 0;
            int wordCount = 0;
            int i = 0;

            while(chars[i] == ' ' || chars[i] == '\n')
                i++;

            for (; i<size; i++) {
                letterNumber = 0;
                while (i + letterNumber < size && chars[i + letterNumber] != ' ' ) {
                    letterNumber++;
                }

                result[wordCount] = new char[letterNumber];
                for(int j = 0; j < letterNumber; j++){
                    result[wordCount][j] = chars[i++];
                }

                wordCount++;
            }
            return result;

        }

        public static String reverseSentence(char [] chars, int size){
            int wordsNumber = countWords(new String(chars));
            char [][] splitedWords = splitIntoWords(chars, size, wordsNumber);
            String res = "";
            for (int i = wordsNumber - 1; i>=0; i--){
                res += new String(splitedWords[i])+' ';
            }
            return res;


        }


        public static String reverseString(String string){

            char [] str = string.toCharArray();
            String endOfSentence = "";

            int len = string.length();
            int start = 0;
            int end = 0;
            String res = "";
            for(int i = 0; i<len; i++){
                endOfSentence="";
                if(str[i]=='\n'){
                    start = end+2;
                    end = start;
                    continue;
                }


                if(str[i] == '.' || str[i] == '!' || str[i]=='?'){
                    endOfSentence = String.valueOf(str[i]);

                    end = i;
                    int sentenceLength = end - start;
                    char [] sentence = new char[sentenceLength];
                    for(int j = 0; j<sentenceLength; j++){
                        sentence[j]=str[start+j];
                    }
                    res += reverseSentence(sentence, sentenceLength);
                    start = end + 2;
                    end = start;
                }
                res += endOfSentence;

            }
            return res;

        }

        public static Map<String, Integer> countEqualWords(String string){
            char [] charString = string.toCharArray();
            int wordNumber = StringLib.countWords(string);
            char [][] words = StringLib.splitIntoWords(charString, string.length(), wordNumber);
            Map<String, Integer> wordCount = new HashMap<String, Integer>();

            for (int i = 0; i<wordNumber; i++){
                if(words[i]==null)
                    continue;
                String str = new String(words[i]);
                Integer count = wordCount.get(str);
                if(count == null){
                    count = 0;
                }
                wordCount.put(str, ++count);
            }
           return wordCount;
    }

    }


