package org.anefdef;

public class TextCutter {
    /**
     * Method witch cut given text
     * till first whitespace before given limit.
     *
     * Returns @null if text is empty or limit = 0.
     * @param text String text
     * @param limit positive int
     * @return String text
     */
    public String cutTheText(String text,int limit) {
        if (text.isEmpty() || limit == 0)
            return null;
        if (text.charAt(limit) == ' ')
            return text.substring(0,limit);
        //get section of text to the given limit
        StringBuilder sb = new StringBuilder(text.substring(0,limit));
        int lastIndex = limit-1;
        //cutting text till whole word
        while (sb.charAt(lastIndex) != ' ') {
            sb.deleteCharAt(lastIndex);
            lastIndex--;
        }
        sb.trimToSize();
        //cutting off point or comma
        if (sb.charAt(lastIndex - 1) == ',' || sb.charAt(lastIndex - 1) == '.')
            sb.deleteCharAt(lastIndex-1);
        return sb.toString().trim();
    }
}
