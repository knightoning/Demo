package com.knight.demo.algorithms;


/**
 *  input:
 *    P   A   H   N

      A P L S I I G

      Y   I   R
     output:

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */
public class Zigzag {

    public static void main(String[] args){

        String s = "PAYPALISHIRING";
        System.out.println(printZigzag(s,2));
    }

    public static String printZigzag(String s,int numRows){

        if (numRows == 1)
            return s;
        char[] cstr = s.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        int lengthOfGroup = 2 * numRows - 2;        // 如上图所示，每组的长度为4
        for (int row = 0; row < numRows; row++)      // 按从第0行到numRows-1行的顺序遍历
        {
            if (row == 0 || row == numRows - 1)        // 此处负责第0行和numRows-1行
            {
                for (int j = row; j < s.length(); j += lengthOfGroup)
                {
                    strBuilder.append(cstr[j]);
                }
            }
            else                   // 此处负责第0行和numRows-1行之间的所有行
            {
                int currentRow = row;           // 在当前行中向右移动（看上图）
                boolean flag = true;
                int childLenOfGroup1 = 2 * (numRows - 1 - row);                //  怎么说呢……中间行的各个索引吧
                int childLenOfGroup2 = lengthOfGroup - childLenOfGroup1;

                while (currentRow < s.length())
                {
                    strBuilder.append(cstr[currentRow]);
                    if (flag)
                        currentRow += childLenOfGroup1;
                    else
                        currentRow += childLenOfGroup2;
                    flag = !flag;
                }
            }
        }
        return strBuilder.toString();
    }

}
