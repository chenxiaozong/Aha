package com.company;

import org.junit.Test;


public class Main {

    public static void main(String[] args) {
    }


    //待排序数组
    int[] score = new int[]{9, 8, 7, 6, 5, 4};

    @Test
    public void test() {
        //2. 使用快速排序:
        quickSort(0, score.length - 1);
    }

    /**
     * 快速排序
     *
     * @param left
     * @param right
     */
    public void quickSort(int left, int right) {

        if (left >= right) {
            return;
        }

        int anchor = score[left];//定义一个基准
        int i = left;
        int j = right;
        while (i != j) {//移动游标
            while (i < j && anchor <= score[j]) {// 右侧游标左移,直到找到小于anchor的数据
                j--;
            }
            while (i < j && score[i] <= anchor) {//左侧游标右移,直到找到一个大于 anchor的数据
                i++;
            }

            if (i < j) {//即 i<j
                int temp = score[i];
                score[i] = score[j];
                score[j] = temp;
            }
        }
        score[left] = score[i];// 将
        score[i] = anchor;//将anchor归位

        for (int a:score){
            System.out.print(a+" ");
        }
        System.out.println("");

        quickSort(left, i - 1);//递归排序左侧
        quickSort(i + 1, right);//递归排序右侧




    }



    /**
     * 1. 简单'桶'排序
     * <p>
     * 班上只有 5 个同学，这 5 个同学分别考了 5 分、 3 分、
     * 5 分、 2 分和 8 分，哎考得真是惨不忍睹（满分是 10 分）。接下来将分数进行从大到小排序，
     * 排序后是 8 5 5 3 2。你有没有什么好方法编写一段程序，让计算机随机读入 5 个数然后将这
     * 5 个数从大到小输出？
     */
    @Test
    public void sort() {
        int[] arr = new int[11];
        int[] score = new int[]{5, 8, 9, 2, 5, 6};

        for (int i = 0; i < score.length; i++) {
            int index = score[i];
            arr[index]++;
        }
        //从小到大输出
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                System.out.print(i);
                arr[i]--;
            }
            System.out.print("-");
        }
    }


    /**
     * 2. 冒泡排序
     */
    @Test
    public void maoPaoSort() {
        int[] score = new int[]{9, 8, 7, 6, 5, 4};

        for (int j = 1; j < score.length; j++) {
            for (int i = 0; i < score.length - j; i++) {
                if (score[i + 1] < score[i]) {
                    int temp = score[i];
                    score[i] = score[i + 1];
                    score[i + 1] = temp;
                }
            }

            //第j轮交换后结果
            System.out.print("第" + j + "轮交换后结果:");
            for (int a : score) {
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }

}
