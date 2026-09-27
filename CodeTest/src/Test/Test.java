package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    protected static final List<String> defaultPermissionsList = new ArrayList<>(Arrays.asList("read", "write", "list", "delete"));

    public void read() {
        System.out.println(defaultPermissionsList);
    }
}
