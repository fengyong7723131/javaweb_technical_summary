package com.test.se;

import org.junit.Test;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/17 下午4:54.
 */
public class ArraySort {
    int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    @Test
    public void xuanzepaixu() {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ".");
        }
        System.out.println("");

    }

    @Test
    public void quickSortMethod() {
        quick_sort(a, 0, a.length - 1);
        xuanzepaixu();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ".");
        }
    }

    void quick_sort(int s[], int l, int r) {
        if(l<r){
            int i=l,j=r,v=s[l];
            while (i<j){
                while (i<j && s[j]>=v)
                    j--;
                if(i<j)
                    s[i++]=s[j];
                while (i<j && s[i]<v)
                    i++;
                if(i<j)
                    s[j--]=s[i];
            }
            s[i]=v;
            quick_sort(s,l,i-1);
            quick_sort(s,i+1,r);
        }
    }

}
