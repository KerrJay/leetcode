package com.monkey

/**
  * @author monkey.hu
  * @date created in 2019-01-12 20:42:05 
  */
object Q3_LongestSubstringWithoutRepeatingCharacters extends App {

  println(lengthOfLongestSubstring("pwwkew"))

  def lengthOfLongestSubstringRecursion(s: String): Int = {

    if(s.length == 0 || s.length == 1) return s.length

    var set: Set[Char] = Set()
    var begin, end: Int = 0


    while(end < s.length && !set.contains(s.charAt(end)) ){
      set += s.charAt(end)
      end = end +1
    }
    if(end == s.length ) return s.length
    else return Math.max(lengthOfLongestSubstringRecursion(s.substring(0, end)),
      lengthOfLongestSubstringRecursion(s.substring(s.indexOf(s.charAt(end))+1, s.length)))

  }

  def lengthOfLongestSubstring(s: String): Int ={
    var length = s.length
    var elemSet: Set[Char] = Set()

    var begin, end = 0
    var maxLength = 0
    while(begin < length && end < length){
      if(!elemSet.contains(s.charAt(end))){
        elemSet += s.charAt(end)
        end = end +1
        maxLength = Math.max(maxLength , end - begin)
      } else{
        elemSet -= s.charAt(begin)
        begin = begin + 1
      }
    }

    maxLength
  }




}
