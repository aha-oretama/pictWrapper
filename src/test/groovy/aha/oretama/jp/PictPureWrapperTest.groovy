package aha.oretama.jp

import aha.oretama.jp.model.Pict
import spock.lang.Specification

/**
 * @author aha-oretama
 * @Date 2016/12/18
 */
class PictPureWrapperTest extends Specification {

    def "test"() {

        expect:
        Pict pict = new PictPureWrapper().run("/Users/sekineyasufumi/Desktop/sample.txt")

        pict.titles.stream().forEach {s -> System.out.println(s)}
        pict.testCases.stream().forEach { map -> map.each { key, value -> System.out.println("${key} ${value}") } }
    }
}
