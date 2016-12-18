package aha.oretama.jp.model;

import lombok.Value;

import java.util.List;
import java.util.Map;

/**
 * @author aha-oretama
 * @Date 2016/12/18
 */
@Value
public class Pict {
    private List<String> titles;
    private List<Map<String,String>> testCases;

}
