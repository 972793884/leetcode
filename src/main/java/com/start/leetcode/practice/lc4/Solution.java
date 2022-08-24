package com.start.leetcode.practice.lc4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zzp
 * @Date 2022/8/24 11:30
 * @Describe
 *
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new java.util.ArrayList<>(Collections.emptyList());

        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }

        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
        } else {
            return list.get(size / 2);
        }

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, total / 2 + 1);
        }

    }
    public double findKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        }
        if (nums2.length == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int mid1 = k / 2;
        int mid2 = k - mid1;
        if (nums1[mid1 - 1] < nums2[mid2 - 1]) {
            return findKth(Arrays.copyOfRange(nums1, mid1, nums1.length), nums2, k - mid1);
        } else {
            return findKth(nums1, Arrays.copyOfRange(nums2, mid2, nums2.length), k - mid2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7};
        System.out.println(solution.findMedianSortedArrays2(nums1, nums2));
    }
}
