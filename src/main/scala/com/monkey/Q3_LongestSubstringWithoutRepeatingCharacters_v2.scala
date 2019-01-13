package com.monkey


/**
  * @author monkey.hu
  * @date created in 2019-01-13 15:32:31 
  */
object Q3_LongestSubstringWithoutRepeatingCharacters_v2 extends App {

  println(lengthOfLongestSubstringWithSet("dvdf"))

  def lengthOfLongestSubstringWithSet(s: String): Int ={
    //传入的string的长度
    var length = s.length
    //用set保存出现过的字符
    var elemSet: Set[Char] = Set()

    var begin, end = 0
    //用来保存当前所计算的最长长度
    var maxLength = 0
    while(begin < length && end < length){
      //如果set中不包含当前字符，则将当前字符添加入set，并向后移动给一个字符
      if(!elemSet.contains(s.charAt(end))){
        elemSet += s.charAt(end)
        end = end +1
        //更新maxLength，此处是重点：注意一定要用max函数比较 当前的不重复字符串长度 与 上一次出现重复字符时记录的最长不重复字符串长度
        maxLength = Math.max(maxLength , end - begin)
      } else{
        //如果set中包含当前字符，则利用循环将出现重复字符之前的字符全部从set中删除，保证set所留的都是需要重新计算长度的字符
        do {
          elemSet -= s.charAt(begin)
          begin = begin + 1
        } while(s.charAt(begin-1)!=s.charAt(end))
      }
    }

    maxLength
  }

  //use map to save char and location
  def lengthOfLongestSubstringWithMap(s: String): Int ={
    var length = s.length

    var map: Map[Char, Int] =Map()
    var begin, end = 0
    var maxLength = 0
    var i =0
   for(j <- 0 until(length)){
     if(map.contains(s.charAt(j))){
       i = Math.max(map.get(s.charAt(j)).get, i)
     }
     maxLength =Math.max(maxLength, j-i+1)
     map += (s.charAt(j) -> (j+1))
   }

    maxLength
  }

  //use array index to indicate character
  def lengthOfLongestSubstringWithArray(s: String): Int ={
    var length = s.length

    var index: Array[Int] = new Array[Int](128)
    var begin, end = 0
    var maxLength = 0
    var i =0
    for(j <- 0 until(length)){
      i = Math.max(index(s.charAt(j)), i)

      maxLength =Math.max(maxLength, j-i+1)
      index(s.charAt(j)) = j+1
    }

    maxLength
  }

}
