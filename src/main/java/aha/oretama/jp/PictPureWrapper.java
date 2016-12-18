package aha.oretama.jp;

import aha.oretama.jp.mapper.IOPictMapper;
import aha.oretama.jp.model.Pict;

import java.io.IOException;

/**
 * @author aha-oretama
 * @Date 2016/12/18
 */
public class PictPureWrapper extends AbstractPictWrapper {

    public PictPureWrapper() {
        super();
    }

    public PictPureWrapper(String pictPath) {
        super(pictPath);
    }

    public Pict run(String filePath) throws IOException {
        Process process = Runtime.getRuntime().exec(getExecCommand(filePath));

        return new IOPictMapper(process.getInputStream(), process.getErrorStream()).getPict();
    }

    private String getExecCommand(String filePath) {
        return command.append(" ").append(filePath).append(options.toString()).toString();
    }
}
