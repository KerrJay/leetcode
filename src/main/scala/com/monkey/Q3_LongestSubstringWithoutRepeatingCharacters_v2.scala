package com.monkey


/**
  * @author monkey.hu
  * @date created in 2019-01-13 15:32:31 
  */
object Q3_LongestSubstringWithoutRepeatingCharacters_v2 extends App {

  println(lengthOfLongestSubstring2("dvdf"))

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
        do {
          elemSet -= s.charAt(begin)
          begin = begin + 1
        } while(s.charAt(begin-1)!=s.charAt(end))
      }
    }

    maxLength
  }

  def lengthOfLongestSubstring2(s: String): Int ={
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

  def lengthOfLongestSubstring3(s: String): Int ={
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
