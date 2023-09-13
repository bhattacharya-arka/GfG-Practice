<h2><a href="https://practice.geeksforgeeks.org/problems/find-the-string/1?page=2&difficulty[]=2&category[]=Strings&sortBy=submissions">Find the String</a></h2><h3>Difficulty Level : Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given two integers<strong> N</strong> and <strong>K</strong>. The task is to find the&nbsp;string S of minimum length such that it contains all possible strings of size N as a substring. The characters of the string can be from 0 to K-1.&nbsp;&nbsp;</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 2, K = 2
<strong>Output:</strong> 
00110
<strong>Explanation: 
</strong>There are 4 string possible of size N=2 
which contains characters 0,..K-1
(i.e "00", "01","10","11")
"00110" contains all possible string as a 
substring. It also has the minimum length</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 2, K = 3
<strong>Output: 
</strong>0010211220
<strong>Explanation: </strong>There are total 9 strings possible
of size N, given output string has the minimum
length that contains all those strings as substring.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function<strong>&nbsp;findString( )</strong>&nbsp;which takes the integer <strong>N</strong> and the integer <strong>K</strong>&nbsp;as input parameters and returns the string.<br>
<strong>Note:</strong> In case of multiple answers, return any string of minimum length which satisfies above condition. The driver will print the length of the&nbsp;string. In case of wrong answer it will print -1.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(K<sup>N</sup>logK)<br>
<strong>Expected Space Complexity: </strong>O(K<sup>N</sup>)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N&nbsp;≤ 4<br>
1 <u>&lt;</u> K <u>&lt;</u> 10<br>
1&nbsp;<u>&lt;</u> K<sup>N</sup>&nbsp;<u>&lt;</u> 4096</span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Graph</code>&nbsp;<code>Backtracking</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;