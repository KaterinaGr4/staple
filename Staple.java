import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Staple {

    public static byte[] aSweatbox = {97, 98, 99, 100, 101, 102, 103};

    public static long mAppalling(String filename) {

        String filepath =
                "C:\\Users\\kater\\Desktop\\jarped\\ΑΣΚΗΣΕΙΣ"
                        + "\\EXERCISE8\\src\\" + filename;

        try (FileOutputStream file = new FileOutputStream(filepath)) {

            RandomAccessFile raf = new RandomAccessFile(filepath, "rw");
            long size = 1732;
            raf.setLength(size);
            int randomArrayPosition;
            long sum = 0;
            for (int i = 0; i < 1732; i++) {
                randomArrayPosition = ThreadLocalRandom.current().nextInt(0, 7);

                if (i < 1546) {
                    sum += (long) aSweatbox[randomArrayPosition];
                }
                raf.write(aSweatbox[randomArrayPosition]);
            }
            raf.close();
            file.close();
            Path path = Paths.get(filepath);
            long bytes = Files.size(path);
            System.out.println(Files.size(path));
            return sum;

        } catch (java.io.FileNotFoundException e) {
            System.err.println("Unable to open file ");
            System.exit(1);
        } catch (java.io.IOException e) {
            System.err.println("Error reading byte: " + e.getMessage());
            System.exit(1);
        }
        return 0;
    }

    public static int[] mKanari(String filename) {
        int[] array = {0, 0, 0, 0, 0, 0, 0, 0};
        int position;
        String filePath =
                "C:\\Users\\kater\\Desktop\\jarped\\ΑΣΚΗΣΕΙΣ"
                        + "\\EXERCISE8\\src\\" + filename;
        try {
            byte[] content = Files.readAllBytes(Paths.get(filePath));
            array[0] = content.length;
            for (int i = 0; i < content.length; i++) {
                position = (int) content[i] - 96;
                array[position]++;
            }
            System.out.println(Arrays.toString(array));
            return array;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}


