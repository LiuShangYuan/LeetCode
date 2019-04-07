# LeetCode
leetcode刷题

### day1


### day2

+ 最长回文子串
    - [x] 暴力求解
    - [ ] 马拉车算法

+ 之字形转化并按行打印 

### day3

+ Container With Most Water
![示意图](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)
    - [x] 暴力
    - [x] 使用front和back两个指针, 分别指向开始和结束两个位置, 依据短板移动指针  

+ 3 Sum
    > 1)对数据排序  
    > 2)fix一个数, 得到一个target  
    > 3)用两个指针从前后查找  
    > [reference1](http://www.cnblogs.com/grandyang/p/4481576.html)

+ Letter Combinations of a Phone Number

  ![](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)
    - [x] 动态规划


### day4

+ Valid Parentheses(括号匹配)
    - [x] 两个栈, 一个存放所有字符, 一个只存放右括号(可以处理表达式)
    - [x] 题目中说明只包含括号字符, 可以有其他解法
    
+ Merge Two Sorted Lists
    - [x] 双指针(faster than 100%: 0ms, less than 97.90%)