package stackOverflow.zombie;

import java.io.*;
import java.util.stream.IntStream;

public class MathMethod {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        String Zombie = "Королевский зомби";
        String Slime = "Сточный слизень";
        String Spider = "Матка";
        String Cow = "Коровка из Коровёнки";
        String Yeti = "Йети";
        String Levik = "Левиафан";
        String Fish = "Хранитель подводного мира";
        String Ghast = "Небесный владыка";

        String ZOMBIE_BOSS = Zombie;
        String SLIME_BOSS = Slime;
        String SPIDER_BOSS = Spider;
        String COW_BOSS = Cow;
        String YETI_BOSS = Yeti;
        String LEVIK_BOSS = Levik;
        String FISH_BOSS = Fish;
        String GHAST_BOSS = Ghast;
        {
            String[] Bosses = new String[] {ZOMBIE_BOSS, SLIME_BOSS, SPIDER_BOSS, COW_BOSS, YETI_BOSS, LEVIK_BOSS, FISH_BOSS, GHAST_BOSS};

            String lineFromFile;
            String s = File.separator;
            String path = /*s+ "Users" +s+ "Арслан" +s+ "eclipse-workspace" +s+ "BossCheck" +s+ "src" +s+ "Boss" +s+*/ "Logs.txt";

            try (InputStreamReader inputStreamReader = new InputStreamReader
                    (new FileInputStream(path), "Windows-1251")) {
                try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    while (bufferedReader.ready()) {
                        lineFromFile = bufferedReader.readLine();
                        String finalLineFromFile = lineFromFile;
                        int bossIndex = IntStream.range(0, Bosses.length).filter(idx -> finalLineFromFile.contains(Bosses[idx])).findFirst().orElse(-1);
                        if (bossIndex != -1) {
                            String[] str2 = lineFromFile.split(Bosses[bossIndex] + " " + "был повержен за ");
                            if (str2.length > 1) {
                                str2 = str2[1].split(" ");
                                int time = Integer.parseInt(str2[0]);
                                int min = 60;
                                System.out.println(+time + 10 * min);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();{
                    }
                }
            }
        }
    }
}