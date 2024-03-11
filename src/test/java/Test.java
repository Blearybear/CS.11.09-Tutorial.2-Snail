public class Test {
    public static void main(String[] args) {
        int[] array = new int[64];
        for (int i = 0;i < array.length;i++){
            array[i] = i;
        }
        Snail.print2dArray(Snail.makeSnail(array));
    }
}
