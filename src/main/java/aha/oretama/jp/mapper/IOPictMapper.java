package aha.oretama.jp.mapper;

import aha.oretama.jp.model.Pict;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author aha-oretama
 * @Date 2016/12/18
 */
public class IOPictMapper {
    private List<String> ioString;
    private String errorString;

    private static final String ENCODING = "UTF-8";

    public IOPictMapper(InputStream ioStream, InputStream errorStream) {

        try {
            this.ioString = IOUtils.readLines(ioStream, ENCODING);
            this.errorString = IOUtils.toString(errorStream, ENCODING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Pict getPict() {

        List<String> titles = Arrays.asList(ioString.get(0).split("\\t"));
        List<Map<String, String>> testCases =
                ioString.stream().skip(1)
                        .map(s -> {
                            List<String> testParams = Arrays.asList(s.split("\\t"));

                            // タイトルとテストケースのMAP化
                            Map<String, String> testCase = new HashMap<>();
                            for (int i = 0; i < testParams.size(); i++) {
                                testCase.put(titles.get(i), testParams.get(i));
                            }
                            return testCase;
                        }).collect(Collectors.toList());

        return new Pict(titles, testCases);
    }
}
