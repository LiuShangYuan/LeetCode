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
    
+ Validate Binary Search Tree(判断一棵树是不是合法的二叉搜索树)  
    [第二种方法参考](https://www.cnblogs.com/grandyang/p/4298435.html)
    - [x] 中序遍历, 在判断是不是有序
    - [x] 二叉搜索树的性质, 节点的子树范围[low, root.val] or [root.val, hight]
    
+ Generate Parentheses  
    [参考](http://www.cnblogs.com/grandyang/p/4444160.html)
    - [x] 递归的方法
        > 从空串构造, 用left和right两个变量分别表示剩余左括号和右括号的数目
        > left==right==0是说明符合条件, left>right会出现)(这种串

### day5

+ Merge k Sorted Lists
    - [x] 两两merge (reduce)
    - [x] 使用PriorityQueue(小顶堆)存储每个链表的当前第一个节点, 堆顶为最小元素
    - [x] 使用PriorityQueue对元素排序, 在按照value还原成一个链表
    
+ Next Permutation  
    [参考](https://www.cnblogs.com/grandyang/p/4428207.html)
    - [x] 组合数学课程有将, 因为该后面的影响较小, 从后面扫描, 具体见代码注释
    

### day6

+ Longest Valid Parentheses
    - [x] 利用栈
    - [x] 动态规划
        > 从后向前, dp[i]表示以i开始的最长合法子串, dp[s.length()-1] = 0
        > 根据dp[i+1] 来求解 dp[i], 详细解释见代码注释
        
+ Search in Rotated Sorted Array  
    [参考](https://blog.csdn.net/Irving_zhang/article/details/78192831)
    - [x] 二分  
        > 每次二分之后有一半一定是有序的  
        注意 {3, 1} 这种情况, low == mid, 因为题目假定没有重复元素, 
        因此在nums[low]<=nums[mid]都可以认为low---mid部分是有序的
        
+ Find First and Last Position of Element in Sorted Array  
    - [x] 二分后分别向两边搜索  
    - [x] 用两个二分查找, 分别确定开始的索引和结束的索引
        > 需要在mid和target相等时进行特殊处理, 让最终的index在开始后结束的位置
        
        
+ Regular Expression Matching 正则表达式匹配
    + [x] 动态规划