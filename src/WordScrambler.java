public class WordScrambler {
    private String[] scrambledWords;

    /**
     * Write the WordScrambler method recombine. This method returns a String created from its two String
     * parameters as follows. Take the first half of word1 Take the second half of word2 Concatenate the
     * two halves and return the new string
     *
     * For example, the following table shows some results of calling recombine. Note that if a word has
     * an odd number of letters, the second half of the word contains the extra letter.
     */
    private String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);

    }

    /**
     * Write the WordScrambler method mixedWords. This method creates and returns a new array of String
     * objects as follows.
     *
     * It takes the first pair of strings in words and combines them to produce a pair of strings to be
     * included in the array returned by the method. If this pair of strings consists of w1 and w2, the
     * method should include the result of calling recombine with w1 and w2 as arguments and should also
     * include the result of calling recombine with w2 and w1 as arguments. The next two strings, if they
     * exist, would form the next pair to be processed by this method. The method should continue until
     * all the strings in words have been processed in this way and the new array has been filled. For
     * example, if the array words contains the following elements:
     *
     * {“apple”, “pear”, “this”, “cat”}
     *
     * then the call mixedWords(words) should return the following array.
     *
     * {“apar”, “peple”, “that”, “cis”}
     *
     * In writing mixedWords, you should call recombine.
     */
    private String[] mixedWords(String[] words) {
        String[] array = new String[words.length];
        for (int i = 0; i < words.length; i+=2) {
            String word1 = words[i];
            String word2 = words[i+1];
            array[i] = recombine(word1, word2);
            array[i+1] = recombine(word2, word1);
        }
        return array;
    }

    public WordScrambler(String[] wordArr) {
        if (wordArr.length % 2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }

        for (String str: wordArr) {
            if (str.contains(" ")) {
                throw new IllegalArgumentException("Word Array must contain single words only! " + str + " contains more than one word!");
            }
        }
        scrambledWords = mixedWords(wordArr);
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
