package annette.godtland;

import com.godtsoft.diyjava.DIYWindow;
import java.util.Arrays;
import java.util.Random;

public class WordScramble extends DIYWindow {

  private final Random random;

  public WordScramble() {
    random = new Random();
    String[] words = {"Java", "Fullstack", "React"};
    Arrays.stream(words).map(this::scramble).forEach(this::print);
  }

  private String scramble(String word) {
    StringBuilder scrambled = new StringBuilder();

    while (!word.isEmpty()) {
      int length = word.length();
      int index = random.nextInt(length);
      String letter = word.substring(index, index + 1);

      String first = word.substring(0, index);
      String second = word.substring(index + 1);
      word = first + second;
      scrambled.append(letter);
    }
    return scrambled.toString();
  }

  public static void main(String[] args) {
    WordScramble wordScramble = new WordScramble();
    wordScramble.setFontSize(22);
  }
}