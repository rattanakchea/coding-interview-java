// https://www.interviewcake.com/question/java/bracket-validator?utm_source=weekly_email&utm_source=drip&utm_campaign=weekly_email&utm_campaign=Interview%20Cake%20Weekly%20Problem%20%23183:%202nd%20Largest%20Item%20in%20a%20Binary%20Search%20Tree&utm_medium=email&utm_medium=email

// Write an efficient method that tells us whether or not an input string's openers and closers are properly nested.

// Examples:

// "{ [ ] ( ) }" should return true
// "{ [ ( ] ) }" should return false
// "{ [ }" should return false

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public static boolean isValid(String code) {

    Map<Character, Character> openersToClosers = new HashMap<>();
    openersToClosers.put('(', ')');
    openersToClosers.put('[', ']');
    openersToClosers.put('{', '}');

    Set<Character> openers = openersToClosers.keySet();
    Set<Character> closers = new HashSet<>(openersToClosers.values());

    Stack<Character> openersStack = new Stack<>();

    for (char c : code.toCharArray()) {
        if (openers.contains(c)) {
            openersStack.push(c);
        } else if (closers.contains(c)) {
            if (openersStack.empty()) {
                return false;
            } else {
                char lastUnclosedOpener = openersStack.pop();

                // if this closer doesn't correspond to the most recently
                // seen unclosed opener, short-circuit, returning false
                if (openersToClosers.get(lastUnclosedOpener) != c) {
                    return false;
                }
            }
        }
    }
    return openersStack.empty();
}