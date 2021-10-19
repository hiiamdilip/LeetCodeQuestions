public static void printString(int columnNumber)
    {
        StringBuilder columnName = new StringBuilder();
 
        while (columnNumber > 0) {
            int rem = columnNumber % 26;
 
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else 
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
        System.out.println(columnName.reverse());
    }


class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++)
        {
            result = result * 26;
            result = result + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
