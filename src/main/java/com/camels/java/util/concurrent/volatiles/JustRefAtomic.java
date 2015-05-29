package com.camels.java.util.concurrent.volatiles;

/**
 * @Todo {@code volatile} 仅对引用同步
 * Created by zhanggc on 2014/10/12.
 */
public class JustRefAtomic {
    private volatile int[] testArray;
    private TestObj testObj;
    {
        testArray = new int[]{0,0,0,0};
        testObj = new TestObj(0);
    }

    public void swap(){
        int val;
        /*{
            val = testArray[3];
            testArray[3] = val==0?1:0;
        }*/
        {
            val = testObj.getVal();
            testObj.setVal(val==0?1:0);
        }
    }

    public boolean unequal(){
        /*{
            if(testArray[3] != testArray[3]){
                return true;
            }else {
                return false;
            }
        }*/
        {
            if(testObj.getVal() != testObj.getVal()){
                return true;
            }else {
                return false;
            }
        }

    }



    private class TestObj{
        private int val;

        TestObj(int val){
            this.val = val;
        }
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
