package stackOverflow.convertListStream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConvertList {

    public List<Integer> convert(List<int[]> list) {
        /*List<Integer> result = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;*/

        return list.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(toList());
    }
}
