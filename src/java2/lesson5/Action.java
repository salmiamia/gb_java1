package java2.lesson5;

public class Action extends Thread {

    public float[] array;
    public int h;
    public float[] arrNew;

    private float[] arrayModify;

    public float[] getArrayModify() {
        return arrayModify;
    }

    @Override
    public void run() {
        arrayModify = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayModify[i] = (float) (array[i] * Math.sin(0.2f + (h + i) / 5) * Math.cos(0.2f + (h + i) / 5) * Math.cos(0.4f + (h + i) / 2));
        }
    }
}