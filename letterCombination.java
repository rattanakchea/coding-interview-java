//Given a digit string, return all possible letter combinations that the number could represent.

//A mapping of digit to letters (just like on the telephone buttons).

//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.

public List<String> letterCombinations(String digits) {
      List<String> bags = new ArrayList<>();

      Map<Character, String> keys = new HashMap<>();
      keys.put('2', "abc");
      keys.put('3', "def");
      keys.put('4', "ghi");
      keys.put('5', "jkl");
      keys.put('6', "mno");
      keys.put('7', "pqrs");
      keys.put('8', "tuv");
      keys.put('9', "wxyz");

      lc(digits, 0, bags, "", keys);
      return bags;
  }

  private void lc(String digits, int digitsPosition, List<String> bags, String combination, Map<Character, String> keys){
      // out of range
      if (digitsPosition >= digits.length()) return;

      String keyString = keys.get( digits.charAt(digitsPosition) );
      for( int j = 0; j < keyString.length(); j++ ){
          // if last digit, start adding combination to bags
          if (digitsPosition == digits.length() - 1){
              bags.add(combination + keyString.charAt(j));
          } else {
              lc(digits, digitsPosition + 1, bags, combination + keyString.charAt(j), keys);
          }

      }

  }
