package Test;

public class ReadOrTest extends Test {

    public void updateReadPermissionList() {
        defaultPermissionsList.clear();
        defaultPermissionsList.add("read");

        System.out.println(defaultPermissionsList);
    }

    public void updateWritePermissionList() {
        defaultPermissionsList.clear();
        defaultPermissionsList.add("write");

        System.out.println(defaultPermissionsList);
    }

    public static void main(String[] args) {
        ReadOrTest readTest = new ReadOrTest();
        readTest.updateReadPermissionList();
        readTest.read();
        readTest.updateWritePermissionList();
        readTest.read();
    }
}
