package com.monkey

/**
  * @author monkey.hu
  * @date created in 2019-01-12 20:42:05 
  */
object Q3_LongestSubstringWithoutRepeatingCharacters extends App {

  println(lengthOfLongestSubstring("pwwkew"))

  def lengthOfLongestSubstring(s: String): Int = {

    if(s.length == 0 || s.length == 1) return s.length

    var set: Set[Char] = Set()
    var begin, end: Int = 0


    while(end < s.length && !set.contains(s.charAt(end)) ){
      set += s.charAt(end)
      end = end +1
    }
    if(end == s.length ) return s.length
//    else return max(lengthOfLongestSubstring(s.substring(0, s.indexOf(s.charAt(end))+1)),
//      lengthOfLongestSubstring(s.substring(s.indexOf(s.charAt(end)) , end)),
//      lengthOfLongestSubstring(s.substring(end, s.length)))
    else return max(lengthOfLongestSubstring(s.substring(0, end)),
//      lengthOfLongestSubstring(s.substring(s.indexOf(s.charAt(end)) , end)),
      lengthOfLongestSubstring(s.substring(s.indexOf(s.charAt(end))+1, s.length)))

  }

  def max(a: Int, b: Int): Int = {
    if(a>=b) a else b
  }


}
