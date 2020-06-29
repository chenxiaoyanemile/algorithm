package sort;

public class QuickSort {
	
	public static void sort(int a[], int low, int hight) {
		int i, j, index;
		if(low > hight) {
			return;
		}
		i = low;
		j = hight;
		index = a[i];
		while(i < j) {
			while(i < j && a[j] >= index) {
				j--;
			}
			if(i < j)
				a[i++] = a[j];
			while(i < j && a[j] >= index)
				i++;
			if(i < j)
				a[j--] = a[i];
		}
		a[i] = index;
		sort(a, low, i-1);
		sort(a, i+1, hight);
	}

}
