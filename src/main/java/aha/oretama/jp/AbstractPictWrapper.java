package aha.oretama.jp;

/**
 * @author aha-oretama
 * @Date 2016/12/18
 */
abstract class AbstractPictWrapper {
    StringBuilder command;
    StringBuilder options = new StringBuilder();

    AbstractPictWrapper() {
        command = new StringBuilder("pict");
    }

    AbstractPictWrapper(String pictPath) {
        command = new StringBuilder(pictPath);
    }

    public AbstractPictWrapper orderOfCombinations(int order) {
        options.append(" /o:").append(order);
        return this;
    }

    public AbstractPictWrapper separatorForValues(String separator) {
        options.append(" /d:").append(separator);
        return this;
    }

    public AbstractPictWrapper separatorForAliases(String separator){
        options.append(" /a:").append(separator);
        return this;
    }

    public AbstractPictWrapper negativeValuePrefix(String prefix) {
        options.append(" /n:").append(prefix);
        return this;
    }

    public AbstractPictWrapper seeding(String filePath) {
        options.append(" /e:").append(filePath);
        return this;
    }

    public AbstractPictWrapper randomize() {
        options.append(" /r");
        return this;
    }

    public AbstractPictWrapper randomize(int seed) {
        options.append(" /r:").append(seed);
        return this;
    }

    public AbstractPictWrapper caseSensitive() {
        options.append(" /c");
        return this;
    }

    public AbstractPictWrapper modelStatics() {
        options.append(" /s");
        return this;
    }


}
